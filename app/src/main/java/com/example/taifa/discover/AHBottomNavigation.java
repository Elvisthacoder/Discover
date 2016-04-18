package com.example.taifa.discover;

import android.content.Context;
import android.graphics.Color;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
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

    /**
     * Constructor
     *
     * @param context
     */
    public AHBottomNavigation(Context context) {
        super(context);
        this.context = context;
        initColors();
    }

    public AHBottomNavigation(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initColors();
    }

    public AHBottomNavigation(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        initColors();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        initViews();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        createItems();
    }

    /**
     * Init the default colors
     */
    private void initColors() {
        accentColor = ContextCompat.getColor(context, R.color.colorAccent);
        inactiveColor = ContextCompat.getColor(context, R.color.colorInactive);
    }




}
