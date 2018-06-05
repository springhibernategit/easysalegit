package easy.sell;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.NoResultException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import easy.cashDeclaration.CashDeclarationRepository;
import easy.products.Product;
import easy.products.ProductRepository;
import easy.receipts.Receipt;
import easy.receipts.ReceiptRepository;
import easy.users.Role;

public class SellProccess {
	ProductRepository productRepository = new ProductRepository();
	Receipt receipt = new Receipt();
	private boolean isStarted = false;
	private JTextField textField;
	private int result;
	private List<Product> listOfProducts = new ArrayList<>();
	String[] buttons = { "add product", "check current list of products", "remove list of product", "payment",
			"return", };
	ReceiptRepository receiptRepository = new ReceiptRepository();
	CashDeclarationRepository cashDeclarationRepository = new CashDeclarationRepository();

	public int sellProccess() {

		if (!isStarted) {
			cashDeclarationRepository.CashDeposit();

		}
		isStarted = true;

		JPanel panel = new JPanel();
		panel.add(new JLabel("Enter bar code:"));
		panel.add(new JLabel("\n"));
		textField = new JTextField(30);
		panel.add(textField);

		result = JOptionPane.showOptionDialog(null, panel, "EasySale", JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, buttons, null);
		return result;

	}

	public void addProduct() {
		productRepository.openEntityManagerFactory();

		String barCode = textField.getText();
		Product product = productRepository.doesProductExistInBase(barCode);
		if (product != null)
			listOfProducts.add(product);

		// Date date = new Date();

		productRepository.closeEntityManagerFactory();

	}

	public void checkCurrentListOfProducts() {
		if (listOfProducts.isEmpty()) {
			JOptionPane.showMessageDialog(null, "Lista produktów jest pusta!");
		} else {
			JOptionPane.showMessageDialog(null, "Aktualna lista produktów" + listOfProducts);
		}

	}

	public void removeListOfProducts() {
		listOfProducts.clear();
		JOptionPane.showMessageDialog(null, "Lista produktów usuniêta!");
	}

	public void giveDiscount() {
		JOptionPane.showMessageDialog(null, "zni¿ka");
	}

	public void payment() {
		receiptRepository.openEntityManagerFactory();
		String[] chooseMethodsOfPayment = new String[3];
		chooseMethodsOfPayment[0] = "Credit Card";
		chooseMethodsOfPayment[1] = "Cash";
		chooseMethodsOfPayment[2] = "Mixed Transaction";

		Object questionAboutMethodOfPayment = JOptionPane.showInputDialog(null, "Choose Payment Method:",
				"Payment Methods", JOptionPane.QUESTION_MESSAGE, null, chooseMethodsOfPayment, null);

		if (questionAboutMethodOfPayment == chooseMethodsOfPayment[0]) {
			JOptionPane.showMessageDialog(null, "CreditCard");
			Receipt receipt = receiptRepository.createReceipt(listOfProducts);
			JOptionPane.showMessageDialog(null, receipt);

		} else if (questionAboutMethodOfPayment == chooseMethodsOfPayment[1]) {
			JOptionPane.showMessageDialog(null, "cash");
		} else if (questionAboutMethodOfPayment == chooseMethodsOfPayment[2]) {
			JOptionPane.showMessageDialog(null, "Mixed Transaction");
		}
		receiptRepository.closeEntityManagerFactory();

	}
}
