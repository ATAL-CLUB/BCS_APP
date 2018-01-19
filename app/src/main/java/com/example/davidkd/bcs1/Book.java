package com.example.davidkd.bcs1;

/**
 * Created by davidg on 04/05/2017.
 */

public class Book {

    private String bname ,binfo ;

    private int bimageResourceId;

    public static final Book[] BOOKS = {


            new Book("Careers in IT project management"
                    ,"Elizabeth Harrin"
                    ,R.drawable.bcs_book
                   ),

            new Book("Hands-on Incident Response and Digital Forensics"
                    ,"Mike Sheward"
                    ,R.drawable.bcs_book_two
            ),
            new Book("Growing Yourself As A Leader"
                    ,"Brian Sutton, Robina Chatham"
                    ,R.drawable.bce_book_three
            ),
            new Book("Westminster Abby"
                    ,"That know ask case sex hent several her had offence. Did had way law dinner square tastes."
                    ,R.drawable.bcs
            ),
            new Book("Westminster Abby"
                    ,"That know ask case sex hent several her had offence. Did had way law dinner square tastes."
                    ,R.drawable.bcs
            ),
            new Book("Westminster Abby"
                    ,"That know ask case sex hent several her had offence. Did had way law dinner square tastes."
                    ,R.drawable.bcs
            )



    };

    public Book(String bname, String binfo , int bimageResourceId ) {
        this.bname = bname;
        this.binfo = binfo;
        this.bimageResourceId = bimageResourceId;

    }


    public String getBname() {
        return bname;
    }

    public String getBInfo() {
        return binfo;
    }

    public int getBimageResourceId() {
        return bimageResourceId;
    }
}


