package com.example.davidkd.bcs1;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_PIZZA_ID = "pizzaId";

    public Button buttonPlayStop, testbutton;
    private MediaPlayer mediaPlayer;
    private SeekBar seekBar;

    private final Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pizza_info);
//        initViews();


//
//        // create our manager instance after the content view is set
//        SystemBarTintManager tintManager = new SystemBarTintManager(this);
//        // enable status bar tint
//        tintManager.setStatusBarTintEnabled(true);
//        // enable navigation bar tint
//        tintManager.setNavigationBarTintEnabled(true);
//        // set the transparent color of the status bar, 20% darker
//        tintManager.setTintColor(Color.parseColor("#20000000"));


        //Set the toolbar as the activity's app bar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        toolbar.setPadding(10, getStatusBarHeight(), 10, 10);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);



        //Display details of the pizza
        int pizzaId = (Integer)getIntent().getExtras().get(EXTRA_PIZZA_ID);

        String pizzaName = Book.BOOKS[pizzaId].getBInfo();
        TextView textView = (TextView)findViewById(R.id.text);
        textView.setText(pizzaName);

        String pizzaInfo = Book.BOOKS[pizzaId].getBInfo();
        TextView textView1 = (TextView)findViewById(R.id.info);
        textView1.setText(pizzaInfo);


        int pizzaImage = Book.BOOKS[pizzaId].getBimageResourceId();
        ImageView imageView = (ImageView)findViewById(R.id.pizza_image);
        imageView.setImageDrawable(ContextCompat.getDrawable(this, pizzaImage));
        imageView.setContentDescription(pizzaName);




    }

















}
