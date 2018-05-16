package easy.main;

import java.awt.Menu;

import javax.swing.JOptionPane;

import easy.menu.processes.MenuAdministratorProcess;
import easy.menu.processes.MenuCashierProcess;
import easy.users.Role;
import easy.users.UserRepository;
import easy.view.JOptionPaneView;

public class Main {

	private UserRepository userRepository;

	public static void main(String[] args) {
		Main main = new Main();

	}

	public Main() {
		boolean endOfProgram = true;
		userRepository = new UserRepository();
		userRepository.openEntityManagerFactory();

		userRepository.inItData();
		String input = JOptionPaneView.logInScreen();
		Role role = userRepository.findRoleByUserPassword(input);
		do {
			if (role == Role.ADMINISTRATOR) {
				int menuAdministrator = JOptionPaneView.menu(new String[] { "Start selling", "File Paths",
						"Employee managment", "Export of receipts", "Update Prices", "Exit" },
						"Easy-Sale Administrator Panel");
				MenuAdministratorProcess menuAdministratorProcess = new MenuAdministratorProcess(userRepository);
				endOfProgram = menuAdministratorProcess.process(menuAdministrator);

			} else if (role == Role.CASHIER) {
				int menuCashier = JOptionPaneView.menu(new String[] { "Start selling", "Update prices",
						"Export of receipts", "Finish the sale", "Exit", }, "Easy-Sale Cashier Module");
				MenuCashierProcess menuCashierProcess = new MenuCashierProcess(userRepository);
				endOfProgram = menuCashierProcess.process(menuCashier);
			} else {
				JOptionPane.showMessageDialog(null, "Incorrect username or password");
				endOfProgram = false;
			}
		} while (endOfProgram);

		userRepository.closeEntityManagerFactory();

	}
}
