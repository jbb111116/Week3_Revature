package com.revature.models;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;

//@JsonIgnoreProperties() <-- best if you want to add more ignore cases.
public class Candy {

	private int id;
	private String name;
	
	// Prevents the flavor field to be written in JSON.
	@JsonIgnore
	private String flavor;
	
	private String type;
	private boolean chocolateCovered;
	private boolean containsNuts;
	private int numberOfPieces;
	private BigDecimal price;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFlavor() {
		return flavor;
	}

	public void setFlavor(String flavor) {
		this.flavor = flavor;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public boolean isChocolateCovered() {
		return chocolateCovered;
	}

	public void setChocolateCovered(boolean chocolateCovered) {
		this.chocolateCovered = chocolateCovered;
	}

	public boolean isContainsNuts() {
		return containsNuts;
	}

	public void setContainsNuts(boolean containsNuts) {
		this.containsNuts = containsNuts;
	}

	public int getNumberOfPieces() {
		return numberOfPieces;
	}

	public void setNumberOfPieces(int numberOfPieces) {
		this.numberOfPieces = numberOfPieces;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Candy(int id, String name, String flavor, String type, boolean chocolateCovered, boolean containsNuts,
			int numberOfPieces, BigDecimal price) {
		super();
		this.id = id;
		this.name = name;
		this.flavor = flavor;
		this.type = type;
		this.chocolateCovered = chocolateCovered;
		this.containsNuts = containsNuts;
		this.numberOfPieces = numberOfPieces;
		this.price = price;
	}

	public Candy() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (chocolateCovered ? 1231 : 1237);
		result = prime * result + (containsNuts ? 1231 : 1237);
		result = prime * result + ((flavor == null) ? 0 : flavor.hashCode());
		result = prime * result + id;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + numberOfPieces;
		result = prime * result + ((price == null) ? 0 : price.hashCode());
		result = prime * result + ((type == null) ? 0 : type.hashCode());
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
		Candy other = (Candy) obj;
		if (chocolateCovered != other.chocolateCovered)
			return false;
		if (containsNuts != other.containsNuts)
			return false;
		if (flavor == null) {
			if (other.flavor != null)
				return false;
		} else if (!flavor.equals(other.flavor))
			return false;
		if (id != other.id)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (numberOfPieces != other.numberOfPieces)
			return false;
		if (price == null) {
			if (other.price != null)
				return false;
		} else if (!price.equals(other.price))
			return false;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Candy [id=" + id + ", name=" + name + ", flavor=" + flavor + ", type=" + type + ", chocolateCovered="
				+ chocolateCovered + ", containsNuts=" + containsNuts + ", numberOfPieces=" + numberOfPieces
				+ ", price=" + price + "]";
	}
	

}
