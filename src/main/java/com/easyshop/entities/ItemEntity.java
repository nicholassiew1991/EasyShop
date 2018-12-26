package com.easyshop.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "item", schema = "easyshop", catalog = "")
public class ItemEntity {
	private long id;
	private String name;
	private long stock;
	private double price;
	private ItemCategoryEntity itemCategory;

	@Id
	@Column(name = "id")
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Basic
	@Column(name = "name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Basic
	@Column(name = "stock")
	public long getStock() {
		return stock;
	}

	public void setStock(long stock) {
		this.stock = stock;
	}

	@Basic
	@Column(name = "price")
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ItemEntity that = (ItemEntity) o;
		return id == that.id && stock == that.stock && Double.compare(that.price, price) == 0 && Objects.equals(name, that.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, stock, price);
	}

	@ManyToOne
	@JoinColumn(name = "category", referencedColumnName = "id", nullable = false)
	public ItemCategoryEntity getItemCategory() {
		return itemCategory;
	}

	public void setItemCategory(ItemCategoryEntity itemCategory) {
		this.itemCategory = itemCategory;
	}
}
