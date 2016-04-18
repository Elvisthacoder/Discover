package com.example.taifa.discover;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.FrameLayout;

import java.util.ArrayList;

/**
 * Created by taifa on 4/18/16.
 */
public class AHBottomNavigation extends FrameLayout{

    // Static
    private static String TAG = "AHBottomNavigation";
    private static final int MIN_ITEMS = 3;
    private static final int MAX_ITEMS = 5;

    // Listener
    private AHBottomNavigationListener listener;
    private OnTabSelectedListener tabSelectedListener;

    // Variables
    private Context context;
    private ArrayList<AHBottomNavigationItem> items = new ArrayList<>();
    private ArrayList<View> views = new ArrayList<>();
    private View backgroundColorView;
    private boolean colored = false;

    private int defaultBackgroundColor = Color.WHITE;
    private int accentColor = Color.WHITE;
    private int inactiveColor = Color.WHITE;

    private int currentItem = 0;
    private int currentColor = 0;
    private float selectedItemWidth, notSelectedItemWidth;


}
