package com.example.calculator.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
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
        //view binding
        binding = FragmentCalculatorBinding.inflate(inflater,container,false);
        return binding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        //plus button
        binding.imageViewPlus.setOnClickListener(view0 -> {

            //Rotation animation
            RotateAnimation rotateAnimation = new RotateAnimation(0, 180, RotateAnimation.RELATIVE_TO_SELF,
                    .5f, RotateAnimation.RELATIVE_TO_SELF
                    , .5f);
            rotateAnimation.setDuration(1000);
            binding.imageViewPlus.startAnimation(rotateAnimation);

            //checking that is edit text empty or not
            if (binding.editTextFirstNumber.getText().toString().equals("") || binding.editTextSecondNumber.getText().toString().equals("")) {
                Toast.makeText(getActivity(), "Empty edit text is not allowed", Toast.LENGTH_SHORT).show();
            }
            else {
                //Calculate
                firstNumber = Double.parseDouble(binding.editTextFirstNumber.getText().toString());
                secondNumber = Double.parseDouble(binding.editTextSecondNumber.getText().toString());
                binding.textViewAnswer.setText(firstNumber + secondNumber + "");
            }
        });


        //mines button
        binding.imageViewMines.setOnClickListener(view1 -> {

            //Rotation animation
            RotateAnimation rotateAnimation = new RotateAnimation(0, 180, RotateAnimation.RELATIVE_TO_SELF,
                    .5f, RotateAnimation.RELATIVE_TO_SELF
                    , .5f);
            rotateAnimation.setDuration(1000);
            binding.imageViewMines.startAnimation(rotateAnimation);

            //checking that is edit text empty or not
            if (binding.editTextFirstNumber.getText().toString().equals("") || binding.editTextSecondNumber.getText().toString().equals("")) {
                Toast.makeText(getActivity(), "Empty edit text is not allowed", Toast.LENGTH_SHORT).show();
            }else {
                //Calculate
                firstNumber = Double.parseDouble(binding.editTextFirstNumber.getText().toString());
                secondNumber = Double.parseDouble(binding.editTextSecondNumber.getText().toString());
                binding.textViewAnswer.setText(firstNumber - secondNumber + "");
            }
        });

        //multiplied button
        binding.imageViewMultiplied.setOnClickListener(view2 -> {

            //Rotation animation
            RotateAnimation rotateAnimation = new RotateAnimation(0, 180, RotateAnimation.RELATIVE_TO_SELF,
                    .5f, RotateAnimation.RELATIVE_TO_SELF
                    , .5f);
            rotateAnimation.setDuration(1000);
            binding.imageViewMultiplied.startAnimation(rotateAnimation);

            //checking that is edit text empty or not
            if (binding.editTextFirstNumber.getText().toString().equals("") || binding.editTextSecondNumber.getText().toString().equals(""))
            {
                Toast.makeText(getActivity(), "Empty edit text is not allowed", Toast.LENGTH_SHORT).show();
            }else {
                //Calculate
                firstNumber = Double.parseDouble(binding.editTextFirstNumber.getText().toString());
                secondNumber = Double.parseDouble(binding.editTextSecondNumber.getText().toString());
                binding.textViewAnswer.setText(firstNumber * secondNumber + "");
            }
        });

        //divided button
        binding.imageViewDivided.setOnClickListener(view3 -> {

            //Rotation animation
            RotateAnimation rotateAnimation = new RotateAnimation(0, 180, RotateAnimation.RELATIVE_TO_SELF,
                    .5f, RotateAnimation.RELATIVE_TO_SELF
                    , .5f);
            rotateAnimation.setDuration(1000);
            binding.imageViewDivided.startAnimation(rotateAnimation);

            //checking that is edit text empty or not
            if (binding.editTextFirstNumber.getText().toString().equals("") || binding.editTextSecondNumber.getText().toString().equals("")) {
                Toast.makeText(getActivity(), "Empty edit text is not allowed", Toast.LENGTH_SHORT).show();
            }
            //checking that is the second number 0 or not
            else if (Double.parseDouble(binding.editTextSecondNumber.getText().toString()) == 0) {
                binding.textViewAnswer.setText("∞");
                Toast.makeText(getActivity(), "Cannot divide by zero", Toast.LENGTH_SHORT).show();
            }
            else {
                //Calculate
                secondNumber = Double.parseDouble(binding.editTextSecondNumber.getText().toString());
                firstNumber = Double.parseDouble(binding.editTextFirstNumber.getText().toString());
                //setting maximum fraction digits as 2
                NumberFormat nf = NumberFormat.getInstance();
                nf.setMaximumFractionDigits(2);
                double num = Double.parseDouble(firstNumber / secondNumber + "");
                binding.textViewAnswer.setText(nf.format(num));
            }
        });

    }
}