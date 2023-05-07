package com.example.fooddelivery.views.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fooddelivery.databinding.ItemMenuBinding;
import com.example.fooddelivery.views.model.Menu;
import com.example.fooddelivery.views.model.Restaurants;

import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {
    private List<Menu>menus;
    private OnClickItemListener onClickItemListener;
    public interface OnClickItemListener{
        void onClickMenuItem(Menu menu);
    }

    public MenuAdapter(List<Menu> menus, OnClickItemListener onClickItemListener) {
        this.menus = menus;
        this.onClickItemListener = onClickItemListener;
    }

    @NonNull
    @Override
    public MenuAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemMenuBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull MenuAdapter.ViewHolder holder, int position) {
        Menu menu=menus.get(position);
        holder.binding.menuImgView.setImageResource(menu.getMenuImg());
        holder.binding.menuNameTV.setText(menu.getName());
        holder.binding.priceTV.setText(menu.getPrice());
        holder.binding.restroName.setText(menu.getRestroName());

    }

    @Override
    public int getItemCount() {
        return menus.size();
    }



    class ViewHolder extends RecyclerView.ViewHolder{
        private ItemMenuBinding binding;
        public ViewHolder(@NonNull ItemMenuBinding itemView) {
            super(itemView.getRoot());
            binding=itemView;
        }
    }
}
