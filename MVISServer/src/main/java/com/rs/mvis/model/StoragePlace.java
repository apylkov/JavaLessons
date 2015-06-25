package com.rs.mvis.model;

import java.util.ArrayList;
import java.util.List;

public class StoragePlace
{
	private StorageType type;
	private List<Product> products = new ArrayList<Product>();

	public StoragePlace(StorageType type)
	{
		this.type = type;
	}

	public List<Product> getProducts()
	{
		return products;
	}

	public StorageType getType()
	{
		return type;
	}

	public void addProduct(Product product)
	{
		products.add(product);
	}
}
