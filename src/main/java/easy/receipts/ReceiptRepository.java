package easy.receipts;

import java.security.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ReceiptRepository {
	Receipt receipt = new Receipt();
	ReceiptNameGenerator receiptNameGenerator = new ReceiptNameGenerator();
	Date date = new Date();
	java.sql.Timestamp timestamp = new java.sql.Timestamp(new Date().getTime());

	private EntityManagerFactory entityManagerFactory;

	public void openEntityManagerFactory() {
		entityManagerFactory = Persistence.createEntityManagerFactory("easyDataBase");
	}

	public void closeEntityManagerFactory() {
		entityManagerFactory.close();
	}

	public void createReceipt(List listOfProducts) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		receipt.setListOfProducts(listOfProducts);
		receipt.setName(receiptNameGenerator.createNameOfReceipt());
		receipt.setUtilTimeStamp(timestamp);

		entityManager.close();

	}

}
