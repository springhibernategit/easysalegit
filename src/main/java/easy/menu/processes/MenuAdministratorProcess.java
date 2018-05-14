package easy.menu.processes;

import javax.swing.JOptionPane;

import easy.users.UserRepository;
import easy.view.JOptionPaneView;

public class MenuAdministratorProcess {

	private UserRepository userRepository;

	public MenuAdministratorProcess(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public boolean process(int menuAdministrator) {

		switch (menuAdministrator) {
		case 0:
			JOptionPane.showMessageDialog(null, "RAZ");
			break;

		case 1:
			JOptionPane.showMessageDialog(null, "DWA!!!!!!!");
			break;

		case 2:
			int optionsOfEmployeeManagment = JOptionPaneView.administratorPanel(
					new String[] { "Add User", "Search User", "Delete User", "Update User", "Return" },
					"Choose option:");

			switch (optionsOfEmployeeManagment) {

			case 0:
				userRepository.addUserToDataBase();
				break;

			case 1:
				userRepository.searchUser();
				break;

			case 2:

				userRepository.deleteUser();
				break;

			case 3:
				JOptionPane.showMessageDialog(null, "test3");
				break;

			case 4:
				JOptionPane.showMessageDialog(null, "test4");
				break;
			case 5:
				return false;

			}

			break;

		case 3:
			JOptionPane.showMessageDialog(null, "Cztery");
			break;

		case 4:

			System.exit(0);
			break;

		}

		return true;
	}

}
