package easy.menu.processes;

import javax.swing.JOptionPane;

import easy.sell.SellProccess;
import easy.users.UserRepository;
import easy.view.JOptionPaneView;

public class MenuAdministratorProcess {

	private UserRepository userRepository;
	private SellProccess sellProccess;

	public MenuAdministratorProcess(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public boolean process(int menuAdministrator) {

		switch (menuAdministrator) {
		case 0:
			sellProccess.sellProccess();
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
				userRepository.updateUser();
				break;

			case 4:
				break;
			case 5:
				return false;

			}

			break;

		case 3:

			break;

		case 4:

			JOptionPane.showInputDialog("Update prices");
			break;
		case 5:
			System.exit(0);
			userRepository.closeEntityManagerFactory();
			break;
		}

		return true;
	}

}
