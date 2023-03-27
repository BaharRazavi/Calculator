package com.example.calculator.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.RotateAnimation;
import android.widget.Toast;

import com.example.calculator.R;
import com.example.calculator.activity.MainActivity;
import com.example.calculator.databinding.FragmentCalculatorBinding;

import java.text.NumberFormat;

public class CalculatorFragment extends Fragment {

    private FragmentCalculatorBinding binding;
    private Double firstNumber, secondNumber;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCalculatorBinding.inflate(inflater,container,false);
        return binding.getRoot();


        binding.imageViewPlus.setOnClickListener(view -> {

            //Rotation animation
            RotateAnimation rotateAnimation = new RotateAnimation(0, 180, RotateAnimation.RELATIVE_TO_SELF,
                    .5f, RotateAnimation.RELATIVE_TO_SELF
                    , .5f);
            rotateAnimation.setDuration(1000);
            binding.imageViewPlus.startAnimation(rotateAnimation);


            //Calculate
            firstNumber = Double.parseDouble(binding.editTextFirstNumber.getText().toString());
            secondNumber = Double.parseDouble(binding.editTextSecondNumber.getText().toString());
            binding.textViewAnswer.setText(firstNumber + secondNumber + "");
        });


        binding.imageViewMines.setOnClickListener(view -> {

            //Rotation animation
            RotateAnimation rotateAnimation = new RotateAnimation(0, 180, RotateAnimation.RELATIVE_TO_SELF,
                    .5f, RotateAnimation.RELATIVE_TO_SELF
                    , .5f);
            rotateAnimation.setDuration(1000);
            binding.imageViewMines.startAnimation(rotateAnimation);


            //Calculate
            firstNumber = Double.parseDouble(binding.editTextFirstNumber.getText().toString());
            secondNumber = Double.parseDouble(binding.editTextSecondNumber.getText().toString());
            binding.textViewAnswer.setText(firstNumber - secondNumber + "");

        });


        binding.imageViewMultiplied.setOnClickListener(view -> {

            //Rotation animation
            RotateAnimation rotateAnimation = new RotateAnimation(0, 180, RotateAnimation.RELATIVE_TO_SELF,
                    .5f, RotateAnimation.RELATIVE_TO_SELF
                    , .5f);
            rotateAnimation.setDuration(1000);
            binding.imageViewMultiplied.startAnimation(rotateAnimation);


            //Calculate
            firstNumber = Double.parseDouble(binding.editTextFirstNumber.getText().toString());
            secondNumber = Double.parseDouble(binding.editTextSecondNumber.getText().toString());
            binding.textViewAnswer.setText(firstNumber * secondNumber + "");
        });

        binding.imageViewDivided.setOnClickListener(view -> {

            //Rotation animation
            RotateAnimation rotateAnimation = new RotateAnimation(0, 180, RotateAnimation.RELATIVE_TO_SELF,
                    .5f, RotateAnimation.RELATIVE_TO_SELF
                    , .5f);
            rotateAnimation.setDuration(1000);
            binding.imageViewDivided.startAnimation(rotateAnimation);


            //Calculate
            firstNumber = Double.parseDouble(binding.editTextFirstNumber.getText().toString());
            secondNumber = Double.parseDouble(binding.editTextSecondNumber.getText().toString());

            NumberFormat nf = NumberFormat.getInstance();
            nf.setMaximumFractionDigits(2);
            double num = Double.parseDouble(firstNumber / secondNumber + "");
            binding.textViewAnswer.setText(nf.format(num));


//            if (secondNumber == 0) {
//                binding.textViewAnswer.setText("∞");
////                Toast.makeText(getActivity(), "Cannot divide by zero", Toast.LENGTH_SHORT).show();
//
//            }

        });

    }
}