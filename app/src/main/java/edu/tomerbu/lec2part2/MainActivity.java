package edu.tomerbu.lec2part2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    //Activity properties:
    private EditText etQuestion;
    private TextView tvAnswer;
    private Button btnAsk;
    private ProgressBar progress;
    //an array of all possible answers:
    private String[] answers; //= {"Yes", "No", "Maybe"};
    //random number generator helper class:
    private Random rand = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //use the array we defined in res folder: d
        answers = getResources().getStringArray(R.array.answers);


        //connect the variables using their id's
        etQuestion = findViewById(R.id.edit_your_quesion);
        tvAnswer = findViewById(R.id.text_oracle_answer);
        btnAsk = findViewById(R.id.button_ask);
        progress = findViewById(R.id.progress_oracle);

        //hide the answer for now:
        tvAnswer.setVisibility(View.INVISIBLE);
        //react to the button click:
        btnAsk.setOnClickListener((v)->{
            //delete the previous answer:
            tvAnswer.setText(null);

            //show progress for 1000 ms ->
            progress.setVisibility(View.VISIBLE);

            //all views have a method to execute a Runnable after Delay:
            tvAnswer.postDelayed(()->{
                //code that runs after 1 second:
                //hide progress:
                progress.setVisibility(View.INVISIBLE);
                //show answer:
                showAnswer();
            }, 1000);
        });
    }

    //ctrl + alt + m
    private void showAnswer() {
        //make the text: yes, no, maybe (randomly)
        int r = rand.nextInt(answers.length); // 0 - 2 (length = 3)

        //random answer from the array:
        String ans = answers[r];

        //show the answer in the textView:
        tvAnswer.setText(ans);

        //show the textView:
        tvAnswer.setVisibility(View.VISIBLE);
    }
}
