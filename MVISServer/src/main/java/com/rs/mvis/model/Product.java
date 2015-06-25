package com.rs.mvis.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.rs.mvis.utils.IDGenerator;

@JsonIgnoreProperties(ignoreUnknown = true)
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

	@JsonCreator
	public Product(@JsonProperty(value = "name", required = true) String name, @JsonProperty(value = "dateExpired", required = false) Long dateExpired,
			@JsonProperty(value = "productionDate", required = false) Long productionDate, @JsonProperty(value = "description", required = false) String description,
			@JsonProperty(value = "quantity", required = false) Float quantity, @JsonProperty(value = "measureUnit", required = false) MeasureUnit measureUnit,
			@JsonProperty(value = "storageType", required = false) StorageType storageType, @JsonProperty(value = "calories", required = false) Integer calories)
	{
		this.name = name;
		this.dateExpired = dateExpired;
		this.productionDate = productionDate;
		this.description = description == null ? "No description" : description;
		this.quantity = quantity;
		this.measureUnit = measureUnit;
		this.storageType = storageType;
		this.calories = calories == null ? -1 : calories;
		this.ID = IDGenerator.generateID();
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

	public void setName(String name)
	{
		this.name = name;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}
}
