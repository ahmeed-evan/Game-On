package com.innovertech.gameon.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.Navigation;

import android.os.Bundle;

import com.innovertech.gameon.R;

public class PlayerPointDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_point_details);
        Navigation.findNavController(this, R.id.nav_host_player_point_details)
                .setGraph(R.navigation.nav_point_details, getIntent().getExtras());
    }
}