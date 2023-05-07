package com.example.fooddelivery.views.adapter;


import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fooddelivery.databinding.ItemRestaurantBinding;
import com.example.fooddelivery.views.model.Restaurants;

import java.util.List;


public class RestaurantAdapter extends RecyclerView.Adapter<RestaurantAdapter.ViewHolder> {

    private List<Restaurants> restaurants;
    private OnClickItemListener onClickItemListener;
    public interface OnClickItemListener{
        void onClickRestroItem(Restaurants restaurants);
    }

    public RestaurantAdapter(List<Restaurants> restaurantsList, OnClickItemListener onClickItemListener){
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
        Restaurants restaurant=restaurants.get(position);
        holder.binding.restaurantImgView.setImageResource(restaurant.getRestaurantImg());
        holder.binding.restroNameTv.setText(restaurant.getRestoName());
        holder.binding.distanceInMinute.setText(restaurant.getDistanceInMins());
        holder.itemView.setOnClickListener(v -> {
            onClickItemListener.onClickRestroItem(restaurant);
        });
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
}


