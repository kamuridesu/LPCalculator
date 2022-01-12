import java.util.ArrayList;


public class Main {
	static void print(Object ...args) {
		for(Object arg : args) {
			System.out.print(arg);
		}
		System.out.println();
	}

	static int verifyExitConditions(int[] data, AppGui iface) {
		for (int d : data) {
			if (d <= 0) {
				iface.showMessage("Error! No value can be empty, zero, less than zero or a letter!");
				return 1;
			}
		}
		return 0;
	}


	public static void main(String[] args) {
		while(true) {
			AppGui iface = new AppGui();
			int[] game_data = iface.inputBox("Enter the game data: ");
			if (!(verifyExitConditions(game_data, iface) == 1)) {
				Game game = new Game(game_data[0], game_data[1]);
				print(game.status());
				while(!(game.checkGameOver())) {
					game.players.get(0).sub(500);
					game.players.get(1).add(500);
					print(game.status());
				}
				print(game.status());
			}
		}
	}
}
