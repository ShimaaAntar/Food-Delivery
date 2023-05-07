package com.example.fooddelivery.views.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavDirections;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.fooddelivery.R;
import com.example.fooddelivery.databinding.FragmentChatBinding;
import com.example.fooddelivery.views.adapter.ChatAdapter;
import com.example.fooddelivery.views.firstOpenApp.SignInActivity;
import com.example.fooddelivery.views.firstOpenApp.SignUpActivity;
import com.example.fooddelivery.views.model.Chat;

import java.util.ArrayList;
import java.util.List;

public class ChatFragment extends Fragment implements ChatAdapter.OnClickItemOfChat {
    private FragmentChatBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_chat, container, false);

        List<Chat> chatList = new ArrayList<>();
        chatList.add(new Chat(R.drawable.photo1, "Anamwp", "Your Order Just Arrived!", "20:00"));
        chatList.add(new Chat(R.drawable.photo, "Guy Hawkins", "Your Order Just Arrived!", "20:00"));
        chatList.add(new Chat(R.drawable.photo3, "Leslie Alexander", "Your Order Just Arrived!", "20:00"));

        binding.arrowBackBtn.setOnClickListener(view -> {

        });
        prepareRecycler(chatList);

        return binding.getRoot();
    }



    private void prepareRecycler(List<Chat> chats){
        binding.rvChatting.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,
                false));
        binding.rvChatting.setHasFixedSize(true);
        binding.rvChatting.setItemAnimator(new DefaultItemAnimator());
        ChatAdapter chatAdapter = new ChatAdapter(this, chats);
        binding.rvChatting.setAdapter(chatAdapter);
    }


    @Override
    public void onClickItem(Chat chat, View view) {
        String name = chat.getName();
        int image = chat.getImage();

        Bundle bundle = new Bundle();
        bundle.putInt("Image", image);
        bundle.putString("Name", name);

    }

}