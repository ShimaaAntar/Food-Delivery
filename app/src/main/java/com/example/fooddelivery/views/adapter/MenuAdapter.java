package com.example.fooddelivery.views.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.fooddelivery.R;
import com.example.fooddelivery.databinding.ItemMenuBinding;
import com.example.fooddelivery.views.model.Menu;
import com.example.fooddelivery.views.model.MenuItem;
import com.example.fooddelivery.views.model.RestaurantItem;
import com.example.fooddelivery.views.model.Restaurants;

import java.util.List;

public class MenuAdapter extends RecyclerView.Adapter<MenuAdapter.ViewHolder> {
    private List<MenuItem>menus;
    private OnClickItemListener onClickItemListener;
    public interface OnClickItemListener{
        void onClickMenuItem(MenuItem menu);
    }

    public MenuAdapter(List<MenuItem> menus, OnClickItemListener onClickItemListener) {
        this.menus = menus;
        this.onClickItemListener = onClickItemListener;
    }

    @NonNull
    @Override
    public MenuAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(ItemMenuBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false));
    }
    @NonNull
    @Override
    public void onBindViewHolder(@NonNull MenuAdapter.ViewHolder holder, int position) {
        MenuItem menu=menus.get(position);
        //holder.binding.menuImgView.setImageResource(menu.getMenuImg());
        holder.binding.menuNameTV.setText(menu.getName());
        holder.binding.priceTV.setText(menu.getPrice());
        holder.binding.restroName.setText(menu.getDescription());
        holder.itemView.setOnClickListener(v -> {
            onClickItemListener.onClickMenuItem(menu);
        });
        Glide.with(holder.itemView.getContext())
                .load("http://206.189.103.8/api/"+menu.getPic())
                .placeholder(R.drawable.menu1)
                .into(holder.binding.menuImgView);
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
    public void setList(List<MenuItem> restList){
        this.menus = restList;
        this.notifyDataSetChanged();
    }
}
