package easy.menu.processes;

import java.math.BigDecimal;

import javax.swing.JOptionPane;

import easy.cashDeclaration.CashDeclaration;
import easy.cashDeclaration.CashDeclarationRepository;
import easy.receipts.Receipt;
import easy.sell.SellProccess;
import easy.users.UserRepository;
import easy.view.JOptionPaneView;

public class MenuAdministratorProcess {

	private UserRepository userRepository;
	private SellProccess sellProccess;
	private CashDeclarationRepository cashDeclarationRepository;
	Receipt receipt = new Receipt();

	public MenuAdministratorProcess(UserRepository userRepository) {
		this.userRepository = userRepository;
		sellProccess = new SellProccess();
	}

	public boolean process(int menuAdministrator) {

		switch (menuAdministrator) {
		case 0:
			boolean czyKoniec = false;
			while (!czyKoniec) {
				int process = sellProccess.sellProccess();
				switch (process) {
				case 0:
					sellProccess.addProduct();
					break;
				case 1:
					sellProccess.checkCurrentListOfProducts();
					break;
				case 2:
					sellProccess.removeListOfProducts();
					break;
				case 3:
					sellProccess.payment();
					break;
				case 4:
					czyKoniec = true;

				}
			}

		case 1:

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

			case 5:
				return false;

			}

			break;

		case 3:

			break;

		case 4:
			cashDeclarationRepository.openEntityManagerFactory();
			JOptionPane.showMessageDialog(null, "Are you sure you want finish your sale?");
			cashDeclarationRepository.createCashDeclaration(receipt.getListOfProducts());
			cashDeclarationRepository.closeEntityManagerFactory();

			break;
		case 5:
			System.exit(0);
			userRepository.closeEntityManagerFactory();
			break;

		}

		return true;
	}

}
