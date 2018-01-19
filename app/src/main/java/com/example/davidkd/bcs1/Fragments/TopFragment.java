package com.example.davidkd.bcs1.Fragments;


import android.app.FragmentTransaction;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.os.Handler;


import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.davidkd.bcs1.Book;
import com.example.davidkd.bcs1.ImageSlideShow.Event;
import com.example.davidkd.bcs1.QuizActivity;
import com.example.davidkd.bcs1.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class TopFragment extends Fragment {



    public TopFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view =  inflater.inflate(R.layout.fragment_top, container, false);

        RecyclerView Recycler = (RecyclerView) view.findViewById(R.id.recycler);

        RecyclerView Recycler2 = (RecyclerView) view.findViewById(R.id.recycler2);

        //books

        String[] pizzaNames = new String[Book.BOOKS.length];

        for (int i = 0; i < pizzaNames.length; i++) {
            pizzaNames[i] = Book.BOOKS[i].getBname();
        }

        String[] pizzaInfo = new String[Book.BOOKS.length];

        for (int i = 0; i < pizzaInfo.length; i++) {
            pizzaInfo[i] = Book.BOOKS[i].getBInfo();
        }

        int[] pizzaImages = new int[Book.BOOKS.length];

        for (int i = 0; i < pizzaImages.length; i++) {
            pizzaImages[i] = Book.BOOKS[i].getBimageResourceId();
        }




//events

        String[]  Name = new String[Event.EVENTS.length];

        for (int i = 0; i < Name.length; i++) {
            Name[i] = Event.EVENTS[i].getName();
        }

        String[] Info = new String[Event.EVENTS.length];

        for (int i = 0; i < Info.length; i++) {
            Info[i] = Event.EVENTS[i].getInfo();
        }

        int[]  Image = new int[Event.EVENTS.length];

        for (int i = 0; i < Image.length; i++) {
            Image[i] = Event.EVENTS[i].getImageResourceId();
        }



        //event
        ImageAdapter2 imageAdapter = new ImageAdapter2(Name, Info,Image);
        Recycler2.setAdapter(imageAdapter);

        //book
        ImageAdapter Adapter = new ImageAdapter(pizzaNames, pizzaInfo,pizzaImages);
        Recycler.setAdapter(Adapter);

        LinearLayoutManager layoutManager = new LinearLayoutManager((getActivity()),LinearLayoutManager.HORIZONTAL, false);

        LinearLayoutManager layoutManager2 = new LinearLayoutManager((getActivity()),LinearLayoutManager.HORIZONTAL, false);

        Recycler.setLayoutManager(layoutManager);

        Recycler2.setLayoutManager(layoutManager2);


        Button quizLaunchButton = (Button) view.findViewById(R.id.quizActivityLaunchButton);

        quizLaunchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent quizLaunchIntent = new Intent(getActivity(), QuizActivity.class);
                startActivity(quizLaunchIntent);
            }
        });
        return view;
    }


}
