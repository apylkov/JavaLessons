package com.rs.mvis.manager;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rs.mvis.model.Fridge;
import com.rs.mvis.model.Product;
import com.rs.mvis.model.StoragePlace;
import com.rs.mvis.model.StorageType;

public class FridgeManager
{
	private Map<Integer, Fridge> fridges;

	public FridgeManager()
	{
		this.fridges = new HashMap<Integer, Fridge>();
	}

	public void createFridge()
	{
		List<StoragePlace> places = new ArrayList<StoragePlace>();
		places.add(new StoragePlace(new StorageType()));
		Fridge fridge = new Fridge(1, "Best fridge", places);
		fridges.put(fridge.getID(), fridge);
	}

	public void addProductToFridge(Integer fridgeID, Product product)
	{
		Fridge fridge = fridges.get(fridgeID);
		Integer rc = fridge.addProduct(product);
	}

}
