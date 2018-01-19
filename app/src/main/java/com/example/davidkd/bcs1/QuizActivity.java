package com.example.davidkd.bcs1;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

public class QuizActivity extends Activity {

    public Toolbar toolbar;
    Button bt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        toolbar = (Toolbar) findViewById(R.id.toolbar);

        bt =(Button)findViewById(R.id.b1);

        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent in  = new Intent (getApplicationContext(),QuizQuestionsActivity.class);
                startActivity(in);
            }

        });



    }
}
