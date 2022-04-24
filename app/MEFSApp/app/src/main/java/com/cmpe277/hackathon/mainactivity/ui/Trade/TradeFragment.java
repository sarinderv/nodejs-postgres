package com.cmpe277.hackathon.mainactivity.ui.Trade;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.cmpe277.hackathon.mainactivity.databinding.FragmentTradeBinding;

public class TradeFragment extends Fragment {

    private FragmentTradeBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        TradeViewModel dashboardViewModel =
                new ViewModelProvider(this).get(TradeViewModel.class);

        binding = FragmentTradeBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        //final TextView textView = binding.titleTextView;
        //dashboardViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}