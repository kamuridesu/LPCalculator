import javax.swing.*;
import java.lang.Integer;


public class AppGui {
	public void showMessage(String message) {
		JOptionPane.showMessageDialog(null, message);
	}

	public String getUserInput(String msg) {
		String input = JOptionPane.showInputDialog(null, msg);
		return input;
	}

	private boolean checkIfValidNumberFromString(String str) {
		for(char c : str.toCharArray()) {
			if ((int)c < (int)'0' || (int)c > (int)'9') {
				if ((int) c == 45) {
					continue;
				} else {
					return false;
				}
			}
		}
		return true;
		
	}

	public int[] inputBox(String msg) {
		JTextField n_of_players_field = new JTextField(10);
		JTextField life_points_field = new JTextField(10);
		JPanel panel = new JPanel();
		panel.add(new JLabel("Number of players: "));
		panel.add(n_of_players_field);
		panel.add(Box.createHorizontalStrut(15));
		panel.add(new JLabel("Base lifepoints: "));
		panel.add(life_points_field);

		double res = JOptionPane.showConfirmDialog(null, panel, msg, JOptionPane.OK_CANCEL_OPTION);

		int[] infos = {0, 0};
		if(res == JOptionPane.OK_OPTION) {
			String n_of_players = n_of_players_field.getText();
			String life_points = life_points_field.getText();
			
			if (!n_of_players.equals("") && !life_points.equals("")) {
				if(checkIfValidNumberFromString(n_of_players + life_points)){
					infos[0] = Integer.parseInt(n_of_players);
					infos[1] = Integer.parseInt(life_points);
				}
			}
		} else {
			System.exit(0);
		}
		return infos;
	}
}
