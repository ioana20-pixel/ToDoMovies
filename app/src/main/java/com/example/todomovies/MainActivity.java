package com.example.todomovies;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import com.example.todomovies.R;
import com.example.todomovies.ui.details.DetailsActivity;
import com.example.todomovies.ui.splash_screen.SplashScreenActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Intent splashIntent = new Intent(this, SplashScreenActivity.class);
        startActivity(splashIntent);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigatin_view);
        NavController navController = Navigation.findNavController(this, R.id.nav_fragment);
        NavigationUI.setupWithNavController(bottomNavigationView, navController);

        Intent intent = new Intent(this, DetailsActivity.class);
        startActivity(intent);
    }
}