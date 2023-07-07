package com.example.fooddelivery.views.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class MenuResponse{

	@SerializedName("data")
	private List<MenuItem> data;

	@SerializedName("status")
	private boolean status;

	public List<MenuItem> getData(){
		return data;
	}

	public boolean isStatus(){
		return status;
	}
}