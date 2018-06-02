package easy.cashDeclaration;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CashDeclaration {
	@Id
	@GeneratedValue
	private long id;
	private BigDecimal sumOfCash;
	private BigDecimal sumOfCreditCards;
	private BigDecimal cashDeposit;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public BigDecimal getSumOfCash() {
		return sumOfCash;
	}

	public void setSumOfCash(BigDecimal sumOfCash) {
		this.sumOfCash = sumOfCash;
	}

	public BigDecimal getCashDeposit() {
		return cashDeposit;
	}

	public void setCashDeposit(BigDecimal cashDeposit) {
		this.cashDeposit = cashDeposit;
	}

	public BigDecimal getSumOfCreditCards() {
		return sumOfCreditCards;
	}

	public void setSumOfCreditCards(BigDecimal sumOfCreditCards) {
		this.sumOfCreditCards = sumOfCreditCards;
	}

}
