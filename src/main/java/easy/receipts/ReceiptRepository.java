package easy.receipts;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import easy.products.Product;
import easy.products.ProductRepository;

public class ReceiptRepository {
	Receipt receipt = new Receipt();
	ReceiptNameGenerator receiptNameGenerator = new ReceiptNameGenerator();
	Date date = new Date();
	java.sql.Timestamp timestamp = new java.sql.Timestamp(new Date().getTime());
	ProductRepository productRepository = new ProductRepository();

	private EntityManagerFactory entityManagerFactory;

	public void openEntityManagerFactory() {
		entityManagerFactory = Persistence.createEntityManagerFactory("easyDataBase");
	}

	public void closeEntityManagerFactory() {
		entityManagerFactory.close();
	}

	public Receipt createReceipt(List<Product> listOfProducts) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		receipt.setListOfProducts(listOfProducts);
		receipt.setName(receiptNameGenerator.createNameOfReceipt());
		receipt.setUtilTimeStamp(timestamp);
		receipt.setValue(productRepository.getPricesFromProduct(listOfProducts));

		entityManager.getTransaction().begin();
		entityManager.persist(receipt);
		entityManager.getTransaction().commit();

		entityManager.close();

		return receipt;

	}

}
