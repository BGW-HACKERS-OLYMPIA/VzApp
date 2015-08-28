package io.pivotal.portfolio.domain;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "ORDERS")
public class Order {

	@Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "orderid")
	private Integer orderId;

	@Column(name = "employeeid")
	@NotNull
	private String employeeid;
	
	@Column(name = "item", length = 10)
	@NotNull
	private String item;

	//@Column(name = "orderfee", precision = 14, scale = 2)
	//private BigDecimal orderFee;

	@Column(name = "completiondate")
	@Temporal(TemporalType.TIMESTAMP)
	@DateTimeFormat(style = "LL")
	private Date completionDate;

	@Column(name = "ordertype")
	@NotNull
	@Enumerated
	private OrderType orderType;

	//@Column(name = "price", precision = 14, scale = 2)
	//@NotNull
	//private BigDecimal price;

	@Column(name = "quantity")
	@NotNull
	private Integer quantity;

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public String getemployeeid() {
		return employeeid;
	}

	public void setemployeeid(String employeeid) {
		this.employeeid = employeeid;
	}

	//public String getitem() {
		//return item;
	//}

	//public void setitem(String item) {
		//this.item = item;
	//}

	public BigDecimal getOrderFee() {
		return orderFee;
	}

	public void setOrderFee(BigDecimal orderFee) {
		this.orderFee = orderFee;
	}

	public Date getCompletionDate() {
		return completionDate;
	}

	public void setCompletionDate(Date completionDate) {
		this.completionDate = completionDate;
	}

	public OrderType getOrderType() {
		return orderType;
	}

	public void setOrderType(OrderType orderType) {
		this.orderType = orderType;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Order [orderId=").append(orderId)
				.append(", employeeid=").append(employeeid).append(", item=")
				.append(item).append(", orderFee=").append(orderFee)
				.append(", completionDate=").append(completionDate)
				.append(", orderType=").append(orderType).append(", price=")
				.append(price).append(", quantity=").append(quantity)
				.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((employeeid == null) ? 0 : employeeid.hashCode());
		result = prime * result
				+ ((completionDate == null) ? 0 : completionDate.hashCode());
		result = prime * result
				+ ((orderFee == null) ? 0 : orderFee.hashCode());
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		result = prime * result
				+ ((orderType == null) ? 0 : orderType.hashCode());
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result
				+ ((quantity == null) ? 0 : quantity.hashCode());
		result = prime * result + ((item == null) ? 0 : item.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		if (employeeid == null) {
			if (other.employeeid != null)
				return false;
		} else if (!employeeid.equals(other.employeeid))
			return false;
		if (completionDate == null) {
			if (other.completionDate != null)
				return false;
		} else if (!completionDate.equals(other.completionDate))
			return false;
		if (orderFee == null) {
			if (other.orderFee != null)
				return false;
		} else if (!orderFee.equals(other.orderFee))
			return false;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		if (orderType != other.orderType)
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (quantity == null) {
			if (other.quantity != null)
				return false;
		} else if (!quantity.equals(other.quantity))
			return false;
		if (item == null) {
			if (other.item != null)
				return false;
		} else if (!item.equals(other.item))
			return false;
		return true;
	}

}
