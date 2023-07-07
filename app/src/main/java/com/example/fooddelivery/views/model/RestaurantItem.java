package com.example.fooddelivery.views.model;

import com.google.gson.annotations.SerializedName;

public class RestaurantItem {

	@SerializedName("cover_photo")
	private Object coverPhoto;

	@SerializedName("updated_at")
	private String updatedAt;

	@SerializedName("name")
	private String name;

	@SerializedName("tags1")
	private String tags1;

	@SerializedName("verified")
	private String verified;

	@SerializedName("tags2")
	private String tags2;

	@SerializedName("created_at")
	private String createdAt;

	@SerializedName("id")
	private int id;

	@SerializedName("pic")
	private String pic;

	@SerializedName("delivery_time")
	private String deliveryTime;

	@SerializedName("lat")
	private String lat;

	@SerializedName("long")
	private String jsonMemberLong;

	public Object getCoverPhoto(){
		return coverPhoto;
	}

	public String getUpdatedAt(){
		return updatedAt;
	}

	public String getName(){
		return name;
	}

	public String getTags1(){
		return tags1;
	}

	public String getVerified(){
		return verified;
	}

	public String getTags2(){
		return tags2;
	}

	public String getCreatedAt(){
		return createdAt;
	}

	public int getId(){
		return id;
	}

	public String getPic(){
		return pic;
	}

	public String getDeliveryTime(){
		return deliveryTime;
	}

	public String getLat(){
		return lat;
	}

	public String getJsonMemberLong(){
		return jsonMemberLong;
	}
}