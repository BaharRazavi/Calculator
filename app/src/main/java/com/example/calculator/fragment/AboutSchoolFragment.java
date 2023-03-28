package com.example.calculator.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.calculator.R;
import com.example.calculator.databinding.FragmentAboutSchoolBinding;


public class AboutSchoolFragment extends Fragment {

    private FragmentAboutSchoolBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentAboutSchoolBinding.inflate(inflater,container,false);
        return binding.getRoot();
    }
}