package easy.cashDeclaration;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import easy.products.Product;
import easy.products.ProductRepository;

public class CashDeclarationRepository {
	private ProductRepository productRepository = new ProductRepository();
	private CashDeclaration cashDeclaration = new CashDeclaration();
	private EntityManagerFactory entityManagerFactory;

	public void openEntityManagerFactory() {
		entityManagerFactory = Persistence.createEntityManagerFactory("easyDataBase");
	}

	public void closeEntityManagerFactory() {
		entityManagerFactory.close();
	}

	public BigDecimal sumAllPricesCreditCard(List<Product> listOfProducts) {

		BigDecimal prices = productRepository.getPricesFromProduct(listOfProducts);
		BigDecimal sumOfCreditsCards = cashDeclaration.getSumOfCreditCards();
		sumOfCreditsCards = prices;

		return sumOfCreditsCards;

	}

	public BigDecimal sumAllPricesCash(List<Product> listOfProducts) {

		BigDecimal prices = productRepository.getPricesFromProduct(listOfProducts);
		BigDecimal sumOfCash = cashDeclaration.getSumOfCash();
		sumOfCash = prices;

		return sumOfCash;
	}

	public BigDecimal CashDeposit() {

		String askAboutCashDeposit = JOptionPane.showInputDialog("Enter cash deposit:");
		BigDecimal askAboutCashDepositConvert = new BigDecimal(askAboutCashDeposit);

		return askAboutCashDepositConvert;
	}

	public CashDeclaration createCashDeclaration(List<Product> listOfProducts) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		BigDecimal cash = sumAllPricesCash(listOfProducts);
		BigDecimal creditCard = sumAllPricesCreditCard(listOfProducts);
		BigDecimal cashDeposit = CashDeposit();
		JOptionPane.showMessageDialog(null,
				"gotówka:" + cash + "karty" + creditCard + "pogotowie kasowe:" + cashDeposit);

		entityManager.close();

		return cashDeclaration;
	}
}
