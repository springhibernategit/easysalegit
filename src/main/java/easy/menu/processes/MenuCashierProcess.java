package easy.menu.processes;

import javax.swing.JOptionPane;

import easy.sell.SellProccess;
import easy.users.UserRepository;

public class MenuCashierProcess {

	private UserRepository userRepository;
	private SellProccess sellProccess;

	public boolean menuCashierProcess;

	public MenuCashierProcess(UserRepository userRepository) {
		this.userRepository = userRepository;
		sellProccess = new SellProccess();
	}

	public boolean process(int menuCashier) {

		switch (menuCashier) {
		case 0:
			sellProccess.sellProccess();
			break;
		case 1:
			JOptionPane.showMessageDialog(null, "Dwa");

		case 2:

		case 3:

			break;
		case 4:

			System.exit(0);

		}
		return true;
	}

}
