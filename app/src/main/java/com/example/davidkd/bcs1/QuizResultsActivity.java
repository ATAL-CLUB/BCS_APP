package com.example.davidkd.bcs1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;

public class QuizResultsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_quiz_results);

        TextView tv, additionalCommentTv;

        RatingBar ratingBar = (RatingBar) findViewById(R.id.ratingBar);

        tv = (TextView) findViewById(R.id.result);

        additionalCommentTv = (TextView) findViewById(R.id.additional_commentTV);

        tv.setText("Your score is "+QuizQuestionsActivity.correct+"/"+QuizQuestionsActivity.questions.length);

        ratingBar.setRating(QuizQuestionsActivity.correct);

        //additional comment based on users score
        switch (QuizQuestionsActivity.correct){
            case 0:
                additionalCommentTv.setText("Aww... Better luck next time.");
                break;
            case 1:
                additionalCommentTv.setText("Try again!");
                break;
            case 2:
                additionalCommentTv.setText("Try and Improve your score!");
                break;
            case 3:
                additionalCommentTv.setText("You got half...");
                break;
            case 4:
                additionalCommentTv.setText("You are getting there!");
                break;
            case 5:
                additionalCommentTv.setText("Wow! You are knowledgeable!");
                break;
            case 6:
                additionalCommentTv.setText("Wow! You are knowledgeable!");
                break;
            case 7:
                additionalCommentTv.setText("Wow! You are a BCS wizard! :)");
                break;
        }
    }

    public void onEndQuizClick(View v){
        //reset score back to 0
        QuizQuestionsActivity.correct = 0;
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }



}
