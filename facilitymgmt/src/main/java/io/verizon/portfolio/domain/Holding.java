package io.pivotal.portfolio.domain;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.Set;

public class Holding {

	private Integer id;
	private String item;
	private Integer quantity = 0;
	private BigDecimal purchaseValue = BigDecimal.ZERO;
	private BigDecimal sellValue = BigDecimal.ZERO;
	private Set<Order> orders = new HashSet<>();
	private BigDecimal currentValue = BigDecimal.ZERO;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getitem() {
		return item;
	}
	public void setitem(String item) {
		this.item = item;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getPurchaseValue() {
		return purchaseValue;
	}
	public void setPurchaseValue(BigDecimal purchaseValue) {
		this.purchaseValue = purchaseValue;
	}
	public Set<Order> getOrders() {
		return orders;
	}
	public void setOrders(Set<Order> orders) {
		this.orders = orders;
	}
	public BigDecimal getCurrentValue() {
		return currentValue;
	}
	public void setCurrentValue(BigDecimal currentValue) {
		this.currentValue = currentValue;
	}
	
	public void addOrder(Order order) {
		
		if (orders.contains(order)) {
			//TODO: throw RuntimeException
		} else {
			orders.add(order);
			
			if (order.getOrderType().equals("ADD")) {
				setQuantity(getQuantity()+order.getQuantity());
				//setPurchaseValue(getPurchaseValue().add(order.getPrice().multiply(new BigDecimal(order.getQuantity()))));
			} else if (order.getOrderType().equals("DELETE")) {
				setQuantity(getQuantity()-order.getQuantity());
				//setSellValue(getSellValue().add(order.getPrice().multiply(new BigDecimal(order.getQuantity()))));
			}
		}
	}

	public BigDecimal getSellValue() {
		return sellValue;
	}
	public void setSellValue(BigDecimal sellPrice) {
		this.sellValue = sellPrice;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Holding [id=").append(id).append(", item=")
				.append(item).append(", quantity=").append(quantity)
				.append(", purchasePrice=").append(purchaseValue)
				.append(", sellPrice=").append(sellValue).append(", orders=")
				.append(orders).append(", currentValue=").append(currentValue)
				.append("]");
		return builder.toString();
	}
}
