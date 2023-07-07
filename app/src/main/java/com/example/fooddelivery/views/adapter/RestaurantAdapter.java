package com.example.fooddelivery.views.adapter;


import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.fooddelivery.R;
import com.example.fooddelivery.databinding.ItemRestaurantBinding;
import com.example.fooddelivery.views.model.RestaurantItem;
import com.example.fooddelivery.views.model.Restaurants;

import java.util.List;


public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.ViewHolder> {

    private List<RestaurantItem> restaurants;
    private OnClickItemListener onClickItemListener;
    public interface OnClickItemListener{
        void onClickRestroItem(RestaurantItem restaurants);
    }

    public RestaurantAdapter(List<RestaurantItem> restaurantsList, OnClickItemListener onClickItemListener){
        restaurants = restaurantsList;
        this.onClickItemListener = onClickItemListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemRestaurantBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
    }

    @NonNull
    @Override

    public void onBindViewHolder(@NonNull RestaurantAdapter.ViewHolder holder, int position) {
        RestaurantItem restaurant=restaurants.get(position);
        //holder.binding.restaurantImgView.setImageResource(restaurant.getPic());
        holder.binding.restroNameTv.setText(restaurant.getName());
        holder.binding.distanceInMinute.setText(restaurant.getDeliveryTime());
        holder.itemView.setOnClickListener(v -> {
            onClickItemListener.onClickRestroItem(restaurant);
        });
        Glide.with(holder.itemView.getContext())
                .load("http://206.189.103.8/api/"+restaurant.getPic())
                .placeholder(R.drawable.restaurant1)
                .into(holder.binding.restaurantImgView);
    }

    @Override
    public int getItemCount() {return restaurants.size();}

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ItemRestaurantBinding binding;
        public ViewHolder(@NonNull ItemRestaurantBinding itemView) {
            super(itemView.getRoot());
            binding=itemView;

        }
    }
    public void setList(List<RestaurantItem> restList){
        this.restaurants = restList;
        this.notifyDataSetChanged();
    }
}


