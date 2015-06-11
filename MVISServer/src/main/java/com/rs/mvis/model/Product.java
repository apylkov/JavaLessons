package com.rs.mvis.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.rs.mvis.utils.IDGenerator;

@JsonInclude(Include.NON_NULL)
public class Product
{
	private String ID;
	private String name;
	private Long dateExpired;
	private Long productionDate;
	private String description;
	private Float quantity;
	private MeasureUnit measureUnit;
	private StorageType storageType;
	private Integer calories;

	public Product(String name, Long dateExpired, Long productionDate, String description, Float quantity, MeasureUnit measureUnit, StorageType storageType, Integer calories)
	{
		this.name = name;
		this.dateExpired = dateExpired;
		this.productionDate = productionDate;
		this.description = description == null ? "No description" : description;
		this.quantity = quantity;
		this.measureUnit = measureUnit;
		this.storageType = storageType;
		this.calories = calories == null ? -1 : calories;
		this.ID = IDGenerator.generateID(16);
	}

	public String getID()
	{
		return ID;
	}

	public String getName()
	{
		return name;
	}

	public Long getDateExpired()
	{
		return dateExpired;
	}

	public Long getProductionDate()
	{
		return productionDate;
	}

	public String getDescription()
	{
		return description;
	}

	public Float getQuantity()
	{
		return quantity;
	}

	public MeasureUnit getMeasureUnit()
	{
		return measureUnit;
	}

	public StorageType getStorageType()
	{
		return storageType;
	}

	public Integer getCalories()
	{
		return calories;
	}
}
