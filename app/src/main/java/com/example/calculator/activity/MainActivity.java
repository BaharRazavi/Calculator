package com.example.calculator.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.calculator.R;
import com.example.calculator.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    boolean doubleBackToExitPressedOnce = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //binding
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //setting navigation drawer
        drawerLayout = binding.drawerLayout;
        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.nav_open, R.string.nav_close);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        setupDrawerContent(binding.navigationView);
    }

    private void setupDrawerContent(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(
                menuItem -> {
                    selectDrawerItem(menuItem);
                    return true;
                });
    }

    private void selectDrawerItem(MenuItem menuItem) {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        //switch case for changing layout by clicking on each menu of navigation drawer
        switch (menuItem.getItemId()){
            case R.id.calculatorFragment2:
                navController.navigate(R.id.calculatorFragment2);
                break;

            case R.id.aboutAppFragment2:
                navController.navigate(R.id.aboutAppFragment2);
                break;

            case R.id.application_code:
                //opening a site
                Intent codeIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/BaharRazavi/Calculator"));
                startActivity(codeIntent);
                break;

            case R.id.aboutSchoolFragment2:
                navController.navigate(R.id.aboutSchoolFragment2);
                break;

            case R.id.schoolWeblog:
                //opening a site
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://drahalimmarvasti.blogfa.com/"));
                startActivity(browserIntent);
                break;
        }

            // Highlight the selected item has been done by NavigationView
            menuItem.setChecked(true);
            // Set action bar title
            setTitle(menuItem.getTitle());
            // Close the navigation drawer
            drawerLayout.closeDrawers();

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    //show exit dialog
    private void showExitDialog(){
        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Are you sure to Exit?")
                .setMessage("Exiting will go out of the application.")
                .setPositiveButton("Yes", (dialogInterface, i) -> {
                    //set what would happen when positive button is clicked
                    finish();
                })
                .setNegativeButton("No", (dialogInterface, i) -> {
                    //set what should happen when negative button is clicked
                    Toast.makeText(getApplicationContext(),"Welcome back.",Toast.LENGTH_LONG).show();
                })
                .show();

    }

    @Override
    //if back button pressed, first navigation drawer close, then come out of the application.
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(binding.navigationView)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }

        if (doubleBackToExitPressedOnce){
            super.onBackPressed();
            return;
        }
        this.doubleBackToExitPressedOnce = true;
        showExitDialog();

        new Handler(Looper.getMainLooper()).postDelayed(() -> doubleBackToExitPressedOnce=false, 2000);
    }
}