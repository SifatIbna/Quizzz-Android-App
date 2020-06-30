package com.example.quizzz;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button mTrueButton;
    Button mFalseButton;
    TextView myQuestionTextView,ScoreView,QuestionNumView;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTrueButton = (Button) findViewById(R.id.true_button);
        mFalseButton = (Button) findViewById(R.id.false_button);
        myQuestionTextView = (TextView) findViewById(R.id.question_text_view);
        ScoreView = (TextView) findViewById(R.id.score);
        QuestionNumView = (TextView) findViewById(R.id.question_num);

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
                checkAnswer(true);
                UpdateQuestion();
            }
        });

    }

    public void UpdateQuestion(){
        index = (index+1) % mQuestionBank.length;
        mQuestion = mQuestionBank[index].getQuestionID();
        myQuestionTextView.setText(mQuestion);
        QuestionNumView.setText("Question "+ (index+1));
    }

    private void checkAnswer(boolean answer){
        mAnswer = mQuestionBank[index].isCorrectAnswer();
        if(mAnswer == answer){
            Toast.makeText(getApplicationContext(),R.string.correct_toast,Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(getApplicationContext(),R.string.incorrect_toast,Toast.LENGTH_SHORT).show();
        }
    }
}