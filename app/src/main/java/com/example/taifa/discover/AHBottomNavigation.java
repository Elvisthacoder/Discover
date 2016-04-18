package com.example.taifa.discover;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

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

    /**
     * Init
     */
    private void initViews() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            setElevation(context.getResources().getDimension(R.dimen.bottom_navigation_elevation));
            setClipToPadding(false);
        }

        ViewGroup.LayoutParams params = getLayoutParams();
        params.width = ViewGroup.LayoutParams.MATCH_PARENT;
        params.height = (int) context.getResources().getDimension(R.dimen.bottom_navigation_height);
        setLayoutParams(params);

        if (items.size() < MIN_ITEMS) {
            Log.w(TAG, "The items list should have at least 3 items");
        } else if (items.size() > MAX_ITEMS) {
            Log.w(TAG, "The items list should not have more than 5 items");
        }
    }

    /**
     * Create the items in the bottom navigation
     */
    private void createItems() {

        removeAllViews();
        views.clear();

        backgroundColorView = new View(context);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP && colored) {
            LayoutParams backgroundLayoutParams = new LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
            addView(backgroundColorView, backgroundLayoutParams);
        }

        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(LinearLayout.HORIZONTAL);
        linearLayout.setGravity(Gravity.CENTER);

        int layoutHeight = (int) context.getResources().getDimension(R.dimen.bottom_navigation_height);
        LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, layoutHeight);
        addView(linearLayout, layoutParams);

        if (items.size() == MIN_ITEMS) {
            createClassicItems(linearLayout);
        } else {
            createSmallItems(linearLayout);
        }
    }

    /**
     * Create classic items (only 3 items in the bottom navigation)
     *
     * @param linearLayout The layout where the items are added
     */
    private void createClassicItems(LinearLayout linearLayout){

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        float height = context.getResources().getDimension(R.dimen.bottom_navigation_height);
        float minWidth = context.getResources().getDimension(R.dimen.bottom_navigation_min_width);
        float maxWidth = context.getResources().getDimension(R.dimen.bottom_navigation_max_width);

        int layoutWidth = getWidth();
        if (layoutWidth == 0 || items.size() == 0) {
            return;
        }
        
        float itemWidth = layoutWidth / items.size();
        if (itemWidth < minWidth) {
            itemWidth = minWidth;
        } else if (itemWidth > maxWidth) {
            itemWidth = maxWidth;
        }

    }







}
