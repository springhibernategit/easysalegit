package easy.users;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

import easy.shops.Shop;

public class UserRepository {

	private EntityManagerFactory entityManagerFactory;

	public void openEntityManagerFactory() {
		entityManagerFactory = Persistence.createEntityManagerFactory("easyDataBase");
	}

	public void closeEntityManagerFactory() {
		entityManagerFactory.close();
	}

	public void inItData() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		User mainAdmin = new User();
		mainAdmin.setPassword("abcd1234");
		mainAdmin.setFirstName("Michal");
		mainAdmin.setLastName("Sowinski");
		mainAdmin.setRole(Role.ADMINISTRATOR);
		mainAdmin.setShop(null);

		User firstCashier = new User();
		firstCashier.setFirstName("Anna");
		firstCashier.setLastName("Nowak");
		firstCashier.setPassword("cashier");
		firstCashier.setRole(Role.CASHIER);

		Shop shop = new Shop();
		shop.setName("Sklep Warszawa");
		shop.setAddress("Koszykowa 111");
		shop.setNumber("SklepWarszawa1");
		List<Shop> listOfShops = new ArrayList<>();
		listOfShops.add(shop);

		firstCashier.setShop(listOfShops);

		entityManager.getTransaction().begin();
		entityManager.persist(mainAdmin);
		entityManager.persist(firstCashier);
		entityManager.persist(shop);
		entityManager.getTransaction().commit();

		entityManager.close();

	}

	public Role findRoleByUserPassword(String password) {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();
		Query query = entityManager.createQuery("select a.role from User a where a.password = :password");
		query.setParameter("password", password);
		Role role = null;
		if (!query.getResultList().isEmpty()) {
			role = (Role) query.getResultList().get(0);
		}

		entityManager.getTransaction().commit();

		entityManager.close();

		return role;

	}

	public boolean exist(String input) {

		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();
		Query query = entityManager.createQuery("select count(a.id) from Administrator a where a.password = :password");
		query.setParameter("password", input);

		long count = (long) query.getSingleResult();
		entityManager.getTransaction().commit();

		entityManager.close();

		if (count > 0) {
			return true;
		}
		return false;
	}

	public void addUserToDataBase() {
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		String getFirstNameFromAdministrator = JOptionPane.showInputDialog("Enter Firstname:");
		String getLastNameFromAdministrator = JOptionPane.showInputDialog("Enter Lastname:");
		String getPasswordFromAdministrator = JOptionPane.showInputDialog("Enter password:");

		// String getShopsFromAdministrator =JOptionPane.showInputDialog("Enter
		// Shops:");

		User user = new User();
		user.setFirstName(getFirstNameFromAdministrator);
		user.setLastName(getLastNameFromAdministrator);
		user.setPassword(getPasswordFromAdministrator);

		Role[] roleOfUser = new Role[2];
		roleOfUser[0] = Role.ADMINISTRATOR;
		roleOfUser[1] = Role.CASHIER;
		Object questionAboutRole = JOptionPane.showInputDialog(null, "Enter Role:", "Roles",
				JOptionPane.QUESTION_MESSAGE, null, roleOfUser, null);

		if (questionAboutRole == Role.ADMINISTRATOR) {
			user.setRole(Role.ADMINISTRATOR);

		} else if (questionAboutRole == Role.CASHIER) {
			user.setRole(Role.CASHIER);
		}

		entityManager.getTransaction().begin();
		entityManager.persist(user);
		entityManager.getTransaction().commit();

		entityManager.close();
		// 1) zrobic relacje manytomany miedzy shop a user i zapisac te obiekty
		// do bazy
	}
	
	public void searchUser(){
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		String[] sortingSelection = new String[4];
		sortingSelection[0] = "By first name";
		sortingSelection[1] = "By last name";
		sortingSelection[2] = "By role";
		sortingSelection[3] = "By shop";
		Object questionAboutHowToSearchUser =JOptionPane.showInputDialog(null, "How would you like to search user::", "Search",
				JOptionPane.QUESTION_MESSAGE, null, sortingSelection, null);
		
		
		
		if(questionAboutHowToSearchUser == sortingSelection[0]){
			String name =JOptionPane.showInputDialog("Enter name:");
			TypedQuery<User> query = entityManager.createQuery("Select e from User where e.firstName = name",User.class);
			Object user =query.getSingleResult();
			JOptionPane.showInputDialog(user);
			
			
		}
	
		
		entityManager.close();
	}
	
	
	public void deleteUser(String password){
	EntityManager entityManager = entityManagerFactory.createEntityManager();

	entityManager.getTransaction().begin();
	Query query = entityManager.createQuery("delete a from User a where a.password = :password");
	query.setParameter("password", password);
	
	entityManager.getTransaction().commit();
	

	entityManager.close();

	
	
	
	
	
		
	}

}