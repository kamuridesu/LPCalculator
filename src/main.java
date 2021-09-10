public class main {
	static void print(Object ...args) {
		for(Object arg : args) {
			System.out.print(arg);
		}
		System.out.println();
	}

	public static void main(String[] args) {
		Game game = new Game(3, 8000);
		game.createPlayers();
		Player p1;
		p1 = game.getPlayer("1");
		p1.sub(3999);
		print(game.gameStatus());
	}
}
