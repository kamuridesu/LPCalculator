public class Player {
	public String playername;
	public int lifepoints;
	private int playerid;
	public String status;

	public Player(int life_points, String player_name, int player_id) {
		lifepoints = life_points;
		playername = player_name;
		playerid = player_id;
		status = "Player: " + playername + "\n" + "Lifepoints: " + String.valueOf(lifepoints) + "\n";
	}

	public void updateStatus() {
		status = "Player: " + playername + "\n" + "Lifepoints: " + String.valueOf(lifepoints) + "\n";
	}

	public void add(int value) {
		lifepoints = lifepoints + value;
		updateStatus();
	}

	public void sub(int value) {
		lifepoints = lifepoints - value;
		updateStatus();
	}	
}
