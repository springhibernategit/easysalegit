package easy.sell;

import javax.swing.JOptionPane;

import easy.view.JOptionPaneView;

public class SellProccess {

	public static int sellProccess(){
		String askAboutCashDeposit =JOptionPane.showInputDialog("Enter cash deposit:");
		int cashDeposit = Integer.parseInt(askAboutCashDeposit);
		
		
	int menuSales =	JOptionPaneView.menuSales(new String[]{"add product","remove list od products","payment","check price","return"},"WiadomoscTestowa");
	return menuSales;
		
		
	}
	
}
