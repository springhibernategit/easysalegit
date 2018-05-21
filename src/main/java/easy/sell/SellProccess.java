package easy.sell;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SellProccess {

	public static int sellProccess() {

		String askAboutCashDeposit = JOptionPane.showInputDialog("Enter cash deposit:");
		int cashDeposit = Integer.parseInt(askAboutCashDeposit);

		Object[] buttons = { "add product","check current list of products", "remove list of product", "payment", "return" };

		JPanel panel = new JPanel();
		panel.add(new JLabel("Enter bar code:"));
		panel.add(new JLabel("\n"));
		JTextField textField = new JTextField(30);
		panel.add(textField);

		int result = JOptionPane.showOptionDialog(null, panel, "EasySale", JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.PLAIN_MESSAGE, null, buttons, null);
		return result;

	}

}
