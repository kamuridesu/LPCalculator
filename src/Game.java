import java.util.ArrayList;

public class Game {
	public int n_of_players;
	public int base_lifepoints;
	public ArrayList<Player> players = new ArrayList<Player>();
	private AppGui input = new AppGui();

	public Game(int nb_of_players, int lifepoints_base) {
		n_of_players = nb_of_players;
		base_lifepoints = lifepoints_base;
		createPlayers();
	}

	public Game(int nb_of_players) {
		n_of_players = nb_of_players;
		base_lifepoints = 8000;
		createPlayers();
	}


	private Player createNewPlayer(String pname, int lpoints, int id) {
		return new Player(lpoints, pname, id);
	}

	private void createPlayers() {
		for(int i = 0; i < n_of_players; i++) {
			String playername = input.getUserInput("Enter the player name: ");
			if (playername.equals((""))) {
				playername = "anon";
			}
			players.add(createNewPlayer(playername, base_lifepoints, i));
		}
	}

	public Player getPlayer(String playername) {
		boolean found = false;
		for(Player player : players) {
			if (player.playername.equals(playername)) {
				found = true;
				return player;
			}
		}
		Player player = new Player(0, "guest", -1);
		return player;
	}

	public ArrayList getPlayers() {
		return players;
	}

	public String status() {
		String status = "";
		for (Player player : players) {
			status = status + player.status;
		}
		return status;
	}

	public boolean checkGameOver() {
		for (Player player : players) {
			if (player.lifepoints <= 0) {
				gameOver();
				return true;
			}
		}
		return false;
	}

	public void gameOver() {
		String winner = "";
		for (Player player : players) {
			if (player.lifepoints > 0) {
				winner = player.playername;
			}
		}
		System.out.println("Game over! " + winner + " won!");
	}

	// public gameOver() {
	// 	for (Player player : players) {
	// 		if (player.lifepoints <= 0) {
	// 			return player.playername;
	// 		}
	// 	}
	// 	return "";
	// }
}

