package easy.products;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

public class ProductRepository {
	private EntityManagerFactory entityManagerFactory;
	private BigDecimal price;
	Product product = new Product();

	public void openEntityManagerFactory() {
		entityManagerFactory = Persistence.createEntityManagerFactory("easyDataBase");
	}

	public void closeEntityManagerFactory() {
		entityManagerFactory.close();
	}

	public Product doesProductExistInBase(String code) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();
		Product product = null;
		TypedQuery<Product> query = entityManager.createQuery("select a from Product a where a.barCode = :code",
				Product.class);
		query.setParameter("code", code);

		try {
			product = query.getSingleResult();
			String barCode = product.getBarCode();
			String name = product.getName();
			BigDecimal price = product.getPrice();

			entityManager.getTransaction().commit();
			entityManager.close();

		} catch (NoResultException e) {
			JOptionPane.showMessageDialog(null, "nie znaleziono produktu o podanym kodzie ");
		}
		return product;
	}

	// public BigDecimal getPriceFromProduct(String code) {
	//
	// EntityManager entityManager = entityManagerFactory.createEntityManager();
	// entityManager.getTransaction().begin();
	// Product product = null;
	// TypedQuery<Product> query = entityManager.createQuery("select a.price
	// from Product a where a.code = :code",
	// Product.class);
	// query.setParameter("code", code);
	//
	// try {
	// product = query.getSingleResult();
	//
	// price = product.getPrice();
	//
	// entityManager.getTransaction().commit();
	// entityManager.close();
	//
	// } catch (NoResultException e) {
	// JOptionPane.showMessageDialog(null, "nie znaleziono produktu o podanym
	// kodzie ");
	// }
	// return price;
	//
	// }

	public BigDecimal getPricesFromProduct(List<Product> listOfProducts) {
		BigDecimal toPay = new BigDecimal("0");
		for (int i = 0; i < listOfProducts.size(); i++) {
			Product product = listOfProducts.get(i);
			BigDecimal priceOfProduct = product.getPrice();
			toPay = priceOfProduct.add(toPay);

		}
		return toPay;

	}

}
