package easy.sell;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SellProccess {

	private boolean isStarted = false;
	private int cashDeposit;
	private JTextField textField;
	private int result;
	String[] buttons = { "add product", "check current list of products", "remove list of product", "give a discount",
			"payment", "return", };

	public int sellProccess() {

		if (!isStarted) {
			String askAboutCashDeposit = JOptionPane.showInputDialog("Enter cash deposit:");
			cashDeposit = Integer.parseInt(askAboutCashDeposit);
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

		JOptionPane.showMessageDialog(null, "dodaj produkt");

	}

	public void checkCurrentListOfProducts() {
		JOptionPane.showMessageDialog(null, "sprawdzenie aktualnej listy");

	}

	public void removeListOfProducts() {
		JOptionPane.showMessageDialog(null, "Usuniêcie listy produktów");
	}

	public void giveDiscount() {
		JOptionPane.showMessageDialog(null, "zni¿ka");
	}

	public void payment() {
		JOptionPane.showMessageDialog(null, "zap³ata");
	}

}
