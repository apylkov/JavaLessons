package com.rs.mvis;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(Include.NON_NULL)
public class User
{

	private String name;

	private String pwd;

	@JsonCreator
	public User(@JsonProperty(value = "name", required = true) String name, @JsonProperty(value = "pwd", required = true) String pwd)
	{
		this.name = name;
		this.pwd = pwd;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	@JsonIgnore
	public String getPwd()
	{
		return pwd;
	}

	@JsonIgnore
	public void setPwd(String pwd)
	{
		this.pwd = pwd;
	}
}
