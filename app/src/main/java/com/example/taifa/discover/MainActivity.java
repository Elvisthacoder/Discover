package com.example.taifa.discover;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
    }

    /**
     * Init UI
     */

    private void initUI() {

        final SwitchCompat switchColored = (SwitchCompat) findViewById(R.id.home_switch_colored);
        final SwitchCompat switchFourItems = (SwitchCompat) findViewById(R.id.home_switch_four_items);
        final AHBottomNavigation bottomNavigation = (AHBottomNavigation) findViewById(R.id.bottom_navigation);
        final TextView currentItem = (TextView) findViewById(R.id.home_current_item);
        final ArrayList<AHBottomNavigationItem> items = new ArrayList<>();

    }
