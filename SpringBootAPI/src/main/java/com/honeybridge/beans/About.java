package com.honeybridge.beans;

import java.util.ArrayList;

public class About {
	
	private String collage;
	private String highSchool;
    private Contact contact;
    private ArrayList<Friend> friends;
    private ArrayList<Followers> followers;
	public String getCollage() {
		return collage;
	}
	public void setCollage(String collage) {
		this.collage = collage;
	}
	public String getHighSchool() {
		return highSchool;
	}
	public void setHighSchool(String highSchool) {
		this.highSchool = highSchool;
	}
	public Contact getContact() {
		return contact;
	}
	public void setContact(Contact contact) {
		this.contact = contact;
	}
	public ArrayList<Friend> getFriends() {
		return friends;
	}
	public void setFriends(ArrayList<Friend> friends) {
		this.friends = friends;
	}
	public ArrayList<Followers> getFollowers() {
		return followers;
	}
	public void setFollowers(ArrayList<Followers> followers) {
		this.followers = followers;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((collage == null) ? 0 : collage.hashCode());
		result = prime * result + ((contact == null) ? 0 : contact.hashCode());
		result = prime * result + ((followers == null) ? 0 : followers.hashCode());
		result = prime * result + ((friends == null) ? 0 : friends.hashCode());
		result = prime * result + ((highSchool == null) ? 0 : highSchool.hashCode());
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
		About other = (About) obj;
		if (collage == null) {
			if (other.collage != null)
				return false;
		} else if (!collage.equals(other.collage))
			return false;
		if (contact == null) {
			if (other.contact != null)
				return false;
		} else if (!contact.equals(other.contact))
			return false;
		if (followers == null) {
			if (other.followers != null)
				return false;
		} else if (!followers.equals(other.followers))
			return false;
		if (friends == null) {
			if (other.friends != null)
				return false;
		} else if (!friends.equals(other.friends))
			return false;
		if (highSchool == null) {
			if (other.highSchool != null)
				return false;
		} else if (!highSchool.equals(other.highSchool))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "About [ collage=" + collage + ", highSchool=" + highSchool + ", contact=" + contact
				+ ", friends=" + friends + ", followers=" + followers + "]";
	}
}
