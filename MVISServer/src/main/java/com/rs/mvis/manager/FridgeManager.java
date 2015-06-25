package com.rs.mvis.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rs.mvis.model.Fridge;
import com.rs.mvis.model.MeasureUnit;
import com.rs.mvis.model.Product;
import com.rs.mvis.model.StoragePlace;
import com.rs.mvis.model.StorageType;

public class FridgeManager
{
	private Map<Integer, Fridge> fridges;

	public FridgeManager()
	{
		this.fridges = new HashMap<Integer, Fridge>();
		loadFridges();
	}

	private void loadFridges()
	{
		createFridge();
	}

	public void createFridge()
	{
		List<StoragePlace> places = new ArrayList<StoragePlace>();
		places.add(new StoragePlace(StorageType.FRIDGE));
		Fridge fridge = new Fridge(1, "Best fridge", places);
		fridges.put(fridge.getID(), fridge);

		fridge.addProduct(new Product("Kolbasa", 123L, 2342L, "Doctorskaya", 134123f, MeasureUnit.kg, StorageType.FRIDGE, 123));
	}

	public void addProductToFridge(Integer fridgeID, Product product)
	{
		Fridge fridge = fridges.get(fridgeID);
		Integer rc = fridge.addProduct(product);
	}

	public List<Fridge> getFridges()
	{
		return new ArrayList<Fridge>(fridges.values());
	}

	public List<Product> getAllProducts()
	{
		List<Product> products = new ArrayList<Product>();
		for (Fridge fridge : getFridges())
		{
			products.addAll(fridge.getAllProducts());
		}
		return products;
	}

}
