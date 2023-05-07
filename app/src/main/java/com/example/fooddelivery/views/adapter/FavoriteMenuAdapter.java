package com.example.fooddelivery.views.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fooddelivery.databinding.ItemFavoriteBinding;
import com.example.fooddelivery.databinding.ItemMenuBinding;
import com.example.fooddelivery.views.model.Menu;

import java.util.List;

public class FavoriteMenuAdapter extends RecyclerView.Adapter<FavoriteMenuAdapter.ViewHolder> {
    private List<Menu> menuList;

    public FavoriteMenuAdapter(List<Menu> menus) {
        menuList = menus;
    }
    /////////////////////
    public class ViewHolder extends RecyclerView.ViewHolder{
        private ItemFavoriteBinding binding;
        public ViewHolder(@NonNull ItemFavoriteBinding itemView) {
            super(itemView.getRoot());
            binding=itemView;
        }
    }////////
    @NonNull
    @Override
    public FavoriteMenuAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new FavoriteMenuAdapter.ViewHolder(ItemFavoriteBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull FavoriteMenuAdapter.ViewHolder holder, int position) {
        Menu menu=menuList.get(position);
        holder.binding.menuImgView.setImageResource(menu.getMenuImg());
        holder.binding.menuNameTV.setText(menu.getName());
        holder.binding.priceTV.setText("$");
        holder.binding.priceTV.append(String.valueOf(menu.getPrice()));
        holder.binding.restroName.setText(menu.getRestroName());
        holder.binding.buyAgainBtn.setTag(position);
    }

    @Override
    public int getItemCount() {
        return menuList.size();
    }
}
