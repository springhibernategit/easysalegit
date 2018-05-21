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
	}

	public boolean process(int menuCashier) {

		switch (menuCashier) {
		case 0:
			break;
		case 1:
			JOptionPane.showMessageDialog(null, "Dwa");

		}
		return true;
	}

}
