import java.util.ArrayList;

public class Game {
	public int n_of_players;
	public int base_lifepoints;
	public ArrayList<Player> players = new ArrayList<Player>();

	public Game(int nb_of_players, int lifepoints_base) {
		n_of_players = nb_of_players;
		base_lifepoints = lifepoints_base;
	}

	private Player createNewPlayer(String pname, int lpoints, int id) {
		return new Player(lpoints, pname, id);
	}

	public void createPlayers() {
		for(int i = 0; i < n_of_players; i++) {
			players.add(createNewPlayer(String.valueOf(i), base_lifepoints, i));
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

	public String gameStatus() {
		String status = "";
		for (Player player : players) {
			status = status + player.status;
		}
		return status;
	}
}

