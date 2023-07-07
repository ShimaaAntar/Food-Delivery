package com.example.fooddelivery.views.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class RestaurentResponse{

	@SerializedName("data")
	private List<RestaurantItem> data;

	@SerializedName("status")
	private boolean status;

	public List<RestaurantItem> getData(){
		return data;
	}

	public boolean isStatus(){
		return status;
	}
}