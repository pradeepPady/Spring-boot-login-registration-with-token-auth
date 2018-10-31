package com.honeybridge.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection="restaurant")
public class Restorants {

	public Restorants(String _id, String uRL, String address, String address_line_2, String name, String outcode,
			String postcode, String rating, String typeOfFood) {
		super();
		this._id = _id;
		URL = uRL;
		this.address = address;
		this.address_line_2 = address_line_2;
		this.name = name;
		this.outcode = outcode;
		this.postcode = postcode;
		this.rating = rating;
		this.typeOfFood = typeOfFood;
	}
	public Restorants() {
	}
	@Id
    private String _id;
	private String URL;
	private String address;
	@Field("address line 2")
	private String address_line_2;
	private String name;
	private String outcode;
	private String postcode;
	private String rating;
	@Field("type_of_food")
	private String typeOfFood;
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getURL() {
		return URL;
	}
	public void setURL(String uRL) {
		URL = uRL;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress_line_2() {
		return address_line_2;
	}
	public void setAddress_line_2(String address_line_2) {
		this.address_line_2 = address_line_2;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getOutcode() {
		return outcode;
	}
	public void setOutcode(String outcode) {
		this.outcode = outcode;
	}
	public String getPostcode() {
		return postcode;
	}
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	public String getRating() {
		return rating;
	}
	public void setRating(String rating) {
		this.rating = rating;
	}
	public String getTypeOfFood() {
		return typeOfFood;
	}
	public void setTypeOfFood(String typeOfFood) {
		this.typeOfFood = typeOfFood;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((URL == null) ? 0 : URL.hashCode());
		result = prime * result + ((_id == null) ? 0 : _id.hashCode());
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((address_line_2 == null) ? 0 : address_line_2.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((outcode == null) ? 0 : outcode.hashCode());
		result = prime * result + ((postcode == null) ? 0 : postcode.hashCode());
		result = prime * result + ((rating == null) ? 0 : rating.hashCode());
		result = prime * result + ((typeOfFood == null) ? 0 : typeOfFood.hashCode());
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
		Restorants other = (Restorants) obj;
		if (URL == null) {
			if (other.URL != null)
				return false;
		} else if (!URL.equals(other.URL))
			return false;
		if (_id == null) {
			if (other._id != null)
				return false;
		} else if (!_id.equals(other._id))
			return false;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (address_line_2 == null) {
			if (other.address_line_2 != null)
				return false;
		} else if (!address_line_2.equals(other.address_line_2))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (outcode == null) {
			if (other.outcode != null)
				return false;
		} else if (!outcode.equals(other.outcode))
			return false;
		if (postcode == null) {
			if (other.postcode != null)
				return false;
		} else if (!postcode.equals(other.postcode))
			return false;
		if (rating == null) {
			if (other.rating != null)
				return false;
		} else if (!rating.equals(other.rating))
			return false;
		if (typeOfFood == null) {
			if (other.typeOfFood != null)
				return false;
		} else if (!typeOfFood.equals(other.typeOfFood))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Restorants [_id=" + _id + ", URL=" + URL + ", address=" + address + ", address_line_2=" + address_line_2
				+ ", name=" + name + ", outcode=" + outcode + ", postcode=" + postcode + ", rating=" + rating
				+ ", typeOfFood=" + typeOfFood + "]";
	}
}
