package com.example.davidkd.bcs1.Fragments;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.example.davidkd.bcs1.R;





/**
 * A simple {@link Fragment} subclass.
 */
public class MembershipFragment extends Fragment {


    private PopupWindow popupWindow;
    private LayoutInflater layoutInflater;
    private ScrollView membershipRelativeLayout;
    private Button associateButton, professionalButton, charteredITProfessionalButton, affiliateButton, fellowshipButton, stellarButton, studentMembershipButton, StudentChaptersButton, moreButton;


    public MembershipFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_membership, container, false);
        membershipRelativeLayout = (ScrollView) v.findViewById(R.id.membership_RelativeLayout);
        moreButton = (Button) v.findViewById(R.id.moreButton);

        moreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goToURL("http://www.bcs.org/category/14670",v);
            }
        });




        //associate
        associateButton = (Button) v.findViewById(R.id.associate_text);
        layoutInflater = (LayoutInflater) getActivity().getApplicationContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        associateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadXMLFileAsPopUp(R.layout.test);
            }
        });

        //professional
        professionalButton = (Button) v.findViewById(R.id.professional_text);
        professionalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadXMLFileAsPopUp(R.layout.professionalpopup);
            }
        });


        //chartered professional
        charteredITProfessionalButton = (Button) v.findViewById(R.id.chartered_it_professional_text);
        charteredITProfessionalButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadXMLFileAsPopUp(R.layout.chartereditpopup);
            }
        });

        //affiliate
        affiliateButton = (Button) v.findViewById(R.id.affiliate);
        affiliateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadXMLFileAsPopUp(R.layout.affiliatepopup);
            }
        });


        //FellowShip
        fellowshipButton = (Button) v.findViewById(R.id.fellowship_text);
        fellowshipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadXMLFileAsPopUp(R.layout.fellowshippopup);
            }
        });

        //StudentMembership
        studentMembershipButton = (Button) v.findViewById(R.id.student_membership_text);
        studentMembershipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadXMLFileAsPopUp(R.layout.studentmembershippopup);
            }
        });


        //STELLAR
        stellarButton = (Button) v.findViewById(R.id.steller_group_text);
        stellarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadXMLFileAsPopUp(R.layout.stellergouppopup);
            }
        });

        //StudentChapters
        StudentChaptersButton = (Button) v.findViewById(R.id.Student_Chapters_text);
        StudentChaptersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadXMLFileAsPopUp(R.layout.studentchapterspopup);
            }
        });

        return v;
    }

    //create a method for a specific textview to load a specific xml file
    public void loadXMLFileAsPopUp(int resource){

        ViewGroup popupContainer = (ViewGroup) layoutInflater.inflate(resource, null);

        popupWindow = new PopupWindow(popupContainer, 1000, 1420, true); //popup window size (width, height)
        popupWindow.showAtLocation(membershipRelativeLayout, Gravity.NO_GRAVITY,50,600); //popup window location (x,y)

        popupContainer.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                popupWindow.dismiss();
                return true;
            }
        });
    }

    public void goToURL(String url, View v) {
        Uri webpage = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        Intent chooser = Intent.createChooser(intent, "Choose an application...");
        v.getContext().startActivity(chooser);
    }



}
