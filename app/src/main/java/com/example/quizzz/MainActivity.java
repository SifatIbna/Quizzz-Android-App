package com.example.quizzz;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button mTrueButton;
    Button mFalseButton;
    TextView myQuestionTextView,ScoreView,QuestionNumView;
    ProgressBar mProgressBar;

    int index;
    int mQuestion;
    boolean mAnswer;
    int score;


    private TrueFalse[] mQuestionBank = new TrueFalse[] {
        new TrueFalse(R.string.question_1,true),
        new TrueFalse(R.string.question_2,true),
        new TrueFalse(R.string.question_3,true),
        new TrueFalse(R.string.question_4,true),
        new TrueFalse(R.string.question_5,true),
        new TrueFalse(R.string.question_6,true),
        new TrueFalse(R.string.question_7,true),
        new TrueFalse(R.string.question_8,true),
        new TrueFalse(R.string.question_9,true),
        new TrueFalse(R.string.question_10,true),
        new TrueFalse(R.string.question_11,true),
        new TrueFalse(R.string.question_12,true),
        new TrueFalse(R.string.question_13,true)
    };

    final int PROGRESS_BAR_INCREMENT = (int) Math.ceil(100/mQuestionBank.length);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState != null){
            score = savedInstanceState.getInt("ScoreKey");
            index = savedInstanceState.getInt("IndexKey");
        }

        else {
            score = 0;
            index = 0;
        }

        mTrueButton = (Button) findViewById(R.id.true_button);
        mFalseButton = (Button) findViewById(R.id.false_button);
        myQuestionTextView = (TextView) findViewById(R.id.question_text_view);
        ScoreView = (TextView) findViewById(R.id.score);
       // QuestionNumView = (TextView) findViewById(R.id.question_num);
        mProgressBar = (ProgressBar) findViewById(R.id.progress_bar);

        ScoreView.setText("Score "+score+"/"+ mQuestionBank.length);

        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(true);
                UpdateQuestion();
            }
        });

        mFalseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer(false);
                UpdateQuestion();
            }
        });

    }

    public void UpdateQuestion(){
        index = (index+1) % mQuestionBank.length;

        if(index == 0) {
            AlertDialog.Builder alert = new AlertDialog.Builder(this);
            alert.setTitle("Game Over");
            alert.setCancelable(false);
            alert.setMessage("You Scored "+score+"Points!");
            alert.setPositiveButton("Close Application", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    finish();
                }
            });
            alert.show();
        }

        mQuestion = mQuestionBank[index].getQuestionID();
        myQuestionTextView.setText(mQuestion);
        //QuestionNumView.setText("Question "+ (index+1));
        mProgressBar.incrementProgressBy(PROGRESS_BAR_INCREMENT);
        ScoreView.setText("Score "+score+"/"+ mQuestionBank.length);

    }

    private void checkAnswer(boolean answer){
        mAnswer = mQuestionBank[index].isCorrectAnswer();
        if(mAnswer == answer){
            Toast.makeText(getApplicationContext(),R.string.correct_toast,Toast.LENGTH_SHORT).show();
            score = score +1 ;
        }
        else {
            Toast.makeText(getApplicationContext(),R.string.incorrect_toast,Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {

        super.onSaveInstanceState(outState);

        outState.putInt("ScoreKey",score);
        outState.putInt("IndexKey", index);

    }
}