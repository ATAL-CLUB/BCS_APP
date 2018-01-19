package com.example.davidkd.bcs1;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class QuizQuestionsActivity extends AppCompatActivity {

    Button bt ,bt1;
    TextView tv, currentQuestionTv;
    RadioGroup rg;
    RadioButton r1, r2, r3,r4;
    int currentQuestion = 0;


    private int seconds = 0;
    private boolean running;
    private boolean wasRunning;
    public static String questions[] = {


            //question 1
            "what does BCS stand for",
            //question 2
            "When was BCS founded?",
            ////question 3
            "What is the aim of the STELLAR group?",
            ////question 4
            "Which of these is not helpful in getting a Professional membership",
            ////question 5
            "How many levels of memberships are there",
            ////question 6
            "What is C#?",
            ////question 7
            "In 2015, how old would Ada Lovelace have been?"};

    String answers[] = {
            //question 1
            "British Computer Society",
            //question 2 answer
            "1957",
            //question 3 answer
            "To get more women into IT",
            //question 4 answer
            "An A-level in IT",
            //question 5 answer
            "6",
            //question 6 answer
            "Programming language",
            //question 7 answer
            "200"};
    String opts[] = {
            //question 1 options
            "British Computer School","British Converting Solutions","Body Corporate Service","British Computer Society",
            //question 2 options
            "2001", "2016", "1957", "2003",
            //question 3 options
            "To get more men into IT", "To get more women into IT", "To investigate Interstellar","To find out more about IT",
            //question 4 options
            "An A-level in IT", "5 years IT work experience", "2/3 years IT experience with recognised qualification","A BCS accredited honours degree",
            //question 5 options
            "6", "4", "2", "1",
            //question 6 options
            "Car brand", "Programming language","Drug", "Food"
            //question 7 options
            ,"200","75", "100","175"

    };

    int position = 0;
    public static int correct;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if(savedInstanceState != null){
            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
            wasRunning = savedInstanceState.getBoolean("wasRunning");
        }
        runTimer();
        running = true;
    }


    public void onClickStop (View view){
        running = false;
    }

    public void onClickStart(View v){running = true;}

    public void runTimer(){

        final Handler handler = new Handler();
        handler.post(new Runnable(){
            @Override
            public void run(){
                TextView timeView = (TextView) findViewById(R.id.time_view);
                int hours = seconds / 3600;
                int minutes = (seconds % 3600)/ 60;
                int secs = seconds % 60;
                boolean timerDone = false;
                String time = String.format("%d:%02d:%02d", hours, minutes, secs);

                switch (secs){
                    case 45:
                        timeView.setTextColor(Color.parseColor("#ffb121"));
                        break;
                    case 50:
                        timeView.setTextColor(Color.RED);
                        break;
                    default:
                        break;
                }
                if(minutes == 1){
                    try {
                        Intent i = new Intent(QuizQuestionsActivity.this, QuizResultsActivity.class);
                        startActivity(i);
                        QuizQuestionsActivity.this.finish();
                    } catch (Exception ex){
                        ex.printStackTrace();
                    } finally {
                        QuizQuestionsActivity.this.finish();
                    }
                }
//                if(timerDone){
//                    running = false;
//
//                }
                if(running){
                    seconds++;
                }
                handler.postDelayed(this, 1000);
                timeView.setText(time);
            }
        });


        setContentView(R.layout.activity_quiz_questions);

        tv = (TextView) findViewById(R.id.question);
        currentQuestionTv = (TextView) findViewById(R.id.current_question_tv);

        bt = (Button) findViewById(R.id.movebt);

        bt1 = (Button) findViewById(R.id.backbt);

        rg = (RadioGroup) findViewById(R.id.rg);
        r1 = (RadioButton) findViewById(R.id.r1);
        r2 = (RadioButton) findViewById(R.id.r2);
        r3 = (RadioButton) findViewById(R.id.r3);
        r4 = (RadioButton) findViewById(R.id.r4);

        tv.setText(questions[position]);
        r1.setText(opts[position]);
        r2.setText(opts[position + 1]);
        r3.setText(opts[position + 2]);
        r4.setText(opts[position + 3]);
        currentQuestionTv.setText(currentQuestion + "/7");



        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                RadioButton selectedans = (RadioButton) findViewById(rg.getCheckedRadioButtonId());
                try {
                    String selectedansText = selectedans.getText().toString();
                    if (selectedansText == answers[position]) {
                        correct--;

                    }
                    position--;
                    currentQuestion-=1;
                    currentQuestionTv.setText(currentQuestion + "/7");
                } catch (NullPointerException e){
                    e.printStackTrace();
                }


                if (position < questions.length) {

                    tv.setText(questions[position]);
                    r1.setText(opts[position * 4]);
                    r2.setText(opts[position * 4 + 1]);
                    r3.setText(opts[position * 4 + 2]);
                    r4.setText(opts[position * 4 + 3]);

                } else {



                }


            }
        });

        bt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                RadioButton selectedans = (RadioButton) findViewById(rg.getCheckedRadioButtonId());
                try {
                    String selectedansText = selectedans.getText().toString();
                    if (selectedansText == answers[position]) {
                        correct++;
                    }
                    position++;
                    currentQuestion+=1;
                    currentQuestionTv.setText(currentQuestion + "/7");
                } catch (NullPointerException e){
                    e.printStackTrace();
                }


                if (position < questions.length) {

                    tv.setText(questions[position]);
                    r1.setText(opts[position * 4]);
                    r2.setText(opts[position * 4 + 1]);
                    r3.setText(opts[position * 4 + 2]);
                    r4.setText(opts[position * 4 + 3]);

                } else {
                    Intent in = new Intent(getApplicationContext(), QuizResultsActivity.class);
                    startActivity(in);
                }

            }

        });
    }

}
