public class Main {
	static void print(Object ...args) {
		for(Object arg : args) {
			System.out.print(arg);
		}
		System.out.println();
	}

	static void verifyExitConditions(int[] data, AppGui iface) {
		for (int d : data) {
			if (d <= 0) {
				iface.showMessage("Error! No value can be empty, zero, less than zero or a letter!");
				System.exit(-1);
			}
		}
	}


	public static void main(String[] args) {
		AppGui iface = new AppGui();
		int[] game_data = iface.inputBox("Enter the game data: ");
		verifyExitConditions(game_data, iface);
		Game game = new Game(game_data[0], game_data[1]);
		print(game.status());
	}
}
