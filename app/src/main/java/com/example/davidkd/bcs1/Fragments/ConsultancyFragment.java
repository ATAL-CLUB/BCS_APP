package com.example.davidkd.bcs1.Fragments;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.davidkd.bcs1.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class ConsultancyFragment extends Fragment {

    Button ourCustBtn, whitePaperBtn, ourServiceBtn, blogBtn, discoverMore1Btn, discoverMore2Btn, discoverMore3Btn;


    public ConsultancyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_consultancy, container, false);

        //Initialise ALL views
        ourCustBtn = (Button) v.findViewById(R.id.OurCustomerID);
        whitePaperBtn = (Button) v.findViewById(R.id.whitePaperID);
        ourServiceBtn = (Button) v.findViewById(R.id.ServiceID);
        blogBtn = (Button) v.findViewById(R.id.OurBlogID);

        discoverMore1Btn = (Button)v.findViewById(R.id.discover_more1ID);
        discoverMore2Btn = (Button)v.findViewById(R.id.discover_more2ID);
        discoverMore3Btn = (Button)v.findViewById(R.id.discover_more3ID);

        ourCustBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToURL("https://www.youtube.com/watch?v=yM6JfUogpcI",v);
            }
        });

        whitePaperBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToURL("https://go.pardot.com/l/46492/2017-01-16/4jvkp6",v);
            }
        });

        ourServiceBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToURL("http://www.bcs.org/category/17784", v);
            }
        });

        blogBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToURL("http://www.bcs.org/content/conBlog/85", v);
            }
        });


        discoverMore1Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToURL("http://www.bcs.org/category/18002", v);

            }
        });

        discoverMore2Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToURL("http://www.bcs.org/content/conWebDoc/56137",v);
            }
        });

        discoverMore3Btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToURL("http://www.bcs.org/category/18780",v);
            }
        });


        return v;
    }
    public void goToURL(String url, View v) {
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        Intent chooser = Intent.createChooser(intent, "Choose an application...");
        v.getContext().startActivity(chooser);
    }


}
