package com.rs.mvis.model;

import java.util.ArrayList;
import java.util.List;

public class Fridge
{
	private Integer ID;
	private String description;
	private List<StoragePlace> storages;

	private final Integer RC_ERROR = 1;
	private final Integer RC_SUCCESS = 0;

	public Fridge(Integer ID, String description, List<StoragePlace> storages)
	{
		this.ID = ID;
		this.storages = storages;
		this.description = description == null ? "No description" : description;
	}

	public Integer addProduct(Product product)
	{
		StorageType type = product.getStorageType();
		for (StoragePlace storage : storages)
		{
			if (storage.getType() == type)
			{
				storage.addProduct(product);
				return RC_SUCCESS;
			}
		}
		return RC_ERROR;
	}

	public Integer getID()
	{
		return ID;
	}

	public List<Product> getProductsByName(String name)
	{
		List<Product> productsList = new ArrayList<Product>();
		for (StoragePlace storagePlace : storages)
		{
			for (Product product : storagePlace.getProducts())
			{
				if (product.getName().toLowerCase().equals(name.toLowerCase()))
				{
					productsList.add(product);
				}
			}
		}
		return productsList;
	}

	public Product getProductByID(String id)
	{
		for (StoragePlace storagePlace : storages)
		{
			for (Product product : storagePlace.getProducts())
			{
				if (product.getID().equals(id))
				{
					return product;
				}
			}
		}
		return null;
	}

	public List<Product> getAllProducts()
	{
		List<Product> productsList = new ArrayList<Product>();
		for (StoragePlace storagePlace : storages)
			for (Product product : storagePlace.getProducts())
				productsList.add(product);

		return productsList;
	}

	public String getDescription()
	{
		return description;
	}
}
