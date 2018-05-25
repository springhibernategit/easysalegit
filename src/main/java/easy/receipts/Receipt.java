//package easy.receipts;
//
//import java.util.List;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.Id;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
//
//import easy.products.Product;
//
//@Entity
//public class Receipt {
//	@Id
//	@GeneratedValue
//	private long id;
//	private String number;
//	@Temporal(TemporalType.TIMESTAMP)
//	private java.util.Date utilTimeStamp;
//	private List<Product> listOfProducts;
//
//	public long getId() {
//		return id;
//	}
//
//	public void setId(long id) {
//		this.id = id;
//	}
//
//	public java.util.Date getUtilTimeStamp() {
//		return utilTimeStamp;
//	}
//
//	public void setUtilTimeStamp(java.util.Date utilTimeStamp) {
//		this.utilTimeStamp = utilTimeStamp;
//	}
//
//	public List<Product> getListOfProducts() {
//		return listOfProducts;
//	}
//
//	public void setListOfProducts(List<Product> listOfProducts) {
//		this.listOfProducts = listOfProducts;
//	}
//
//	public String getNumber() {
//		return number;
//	}
//
//	public void setNumber(String number) {
//		this.number = number;
//	}
//
//}
