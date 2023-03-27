package com.example.calculator.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.example.calculator.R;
import com.example.calculator.databinding.ActivitySplashBinding;

public class SplashActivity extends AppCompatActivity {


    private ActivitySplashBinding binding;
    private Handler handler;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySplashBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Animations

        //move top
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.move_top);
        binding.textViewWelcome.setAnimation(animation);
        //move right
        Animation animation1 =  AnimationUtils.loadAnimation(this, R.anim.move_right);
        binding.spPlus.setAnimation(animation1);
        binding.spMultiplied.setAnimation(animation1);
        //move left
        Animation animation2 =  AnimationUtils.loadAnimation(this, R.anim.move_left);
        binding.spMines.setAnimation(animation2);
        binding.spDivided.setAnimation(animation2);

        //Handler
        handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this, MainActivity.class));

                finish();}
        },6000);
    }
}