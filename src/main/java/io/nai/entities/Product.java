package io.nai.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
  private String ref;
  private int quantity;
  private double unitPrice;
public String getRef() {
	return ref;
}
public void setRef(String ref) {
	this.ref = ref;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public double getUnitPrice() {
	return unitPrice;
}

public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}
public void setUnitPrice(double unitPrice) {
	this.unitPrice = unitPrice;
}
public Product(String ref, int quantity, double d) {
	super();
	this.ref = ref;
	this.quantity = quantity;
	this.unitPrice = d;
}
public Product() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((ref == null) ? 0 : ref.hashCode());
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
	Product other = (Product) obj;
	if (ref == null) {
		if (other.ref != null)
			return false;
	} else if (!ref.equals(other.ref))
		return false;
	return true;
}
  
}
