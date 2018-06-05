package easy.receipts;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import easy.products.Product;

@Entity
public class Receipt {
	@Id
	@GeneratedValue
	private long id;
	private String name;
	@Temporal(TemporalType.TIMESTAMP)
	private java.util.Date utilTimeStamp;
	@OneToMany
	@JoinColumn(name = "receipt_id")
	private List<Product> listOfProducts;

	private BigDecimal value;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public java.util.Date getUtilTimeStamp() {
		return utilTimeStamp;
	}

	public void setUtilTimeStamp(java.util.Date utilTimeStamp) {
		this.utilTimeStamp = utilTimeStamp;
	}

	public List<Product> getListOfProducts() {
		return listOfProducts;
	}

	public void setListOfProducts(List<Product> listOfProducts) {
		this.listOfProducts = listOfProducts;
	}

	public BigDecimal getValue() {
		return value;
	}

	public void setValue(BigDecimal value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Receipt [id=" + id + ", name=" + name + ", utilTimeStamp=" + utilTimeStamp + ", listOfProducts="
				+ listOfProducts + ", value=" + value + "]";
	}

}
