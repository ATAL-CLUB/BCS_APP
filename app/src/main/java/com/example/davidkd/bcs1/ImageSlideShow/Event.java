package com.example.davidkd.bcs1.ImageSlideShow;

import com.example.davidkd.bcs1.R;

/**
 * Created by davidg on 04/05/2017.
 */

public class Event {

    private String name ,info ;

    private int imageResourceId;

    public static final Event[] EVENTS = {


            new Event("Careers in IT project management"
                    ,"Elizabeth Harrin"
                    ,R.drawable.bcs_event
                   ),

            new Event("Hands-on Incident Response and Digital Forensics"
                    ,"Mike Sheward"
                    ,R.drawable.bcs_book_two
            ),
            new Event("Growing Yourself As A Leader"
                    ,"Brian Sutton, Robina Chatham"
                    ,R.drawable.bce_book_three
            ),
            new Event("Westminster Abby"
                    ,"That know ask case sex hent several her had offence. Did had way law dinner square tastes."
                    ,R.drawable.bcs
            ),
            new Event("Westminster Abby"
                    ,"That know ask case sex hent several her had offence. Did had way law dinner square tastes."
                    ,R.drawable.bcs
            ),
            new Event("Westminster Abby"
                    ,"That know ask case sex hent several her had offence. Did had way law dinner square tastes."
                    ,R.drawable.bcs
            )



    };

    public Event(String name, String info , int imageResourceId ) {
        this.name = name;
        this.info = info;
        this.imageResourceId = imageResourceId;

    }


    public String getName() {
        return name;
    }

    public String getInfo() {
        return info;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }
}


