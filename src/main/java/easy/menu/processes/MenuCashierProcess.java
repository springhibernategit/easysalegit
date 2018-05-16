package easy.menu.processes;

import javax.swing.JOptionPane;

import easy.users.UserRepository;

public class MenuCashierProcess {

	private UserRepository userRepository;

	public boolean MenuCashierProcess(int menuCashier){

	

	public MenuCashierProcess(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public boolean process(int menuCashier) {

		switch (menuCashier) {
		case 0:
			JOptionPane.showMessageDialog(null, "RAZ");
			break;
		case 1:
			JOptionPane.showMessageDialog(null, "Dwa");
			
			return true;
		}
		
		
	}

}

}
