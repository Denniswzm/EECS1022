package com.example.dennis97.caps;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.media.AudioManager;
import android.media.ToneGenerator;


public class CapsActivity extends AppCompatActivity {

    private Game game;
    private String question;
    private String answer;
    private int score;
    private int qNum = 1;
    private ToneGenerator tg;

    private void ask(){
        question = game.qa();
        String[] qa = question.split("\n", 2);
        question = qa[0];
        answer = qa[1];
        TextView questionBox = (TextView) findViewById(R.id.question);
        questionBox.setText(question);
    }

    public void onDone(View v) {
        if (this.qNum == 10){
            finish();
            return;
        }
        EditText answerbox = (EditText) findViewById(R.id.answer);
        TextView qNumbox = (TextView)  findViewById(R.id.qNum);
        TextView SCOREbox = (TextView)  findViewById(R.id.SCORE);
        Button Done = (Button)findViewById(R.id.done);

        String userAns = answerbox.getText().toString();

        answer = answer.trim();
        if (answer.equalsIgnoreCase(userAns)) {
            tg.startTone(ToneGenerator.TONE_CDMA_ABBR_INTERCEPT,200);
            score++;
        } else
        tg.startTone(ToneGenerator.TONE_CDMA_ALERT_CALL_GUARD,100);
        String logComposed = "Q# " + qNum + ":" + this.question + "\n" + "Your answer: " + userAns + "\n" + "Correct answer:" + this.answer + "\n";
        TextView logBox = (TextView) findViewById(R.id.log);

        String history = logBox.getText().toString();
        logBox.setText(logComposed+"\n");
        logBox.append(history);
        qNum++;

        SCOREbox.setText("SCORE = " + score);

        qNumbox.setText("Q# :" +qNum);
        answerbox.setText(" ");

        if (this.qNum == 10) {
            TextView questionBox = (TextView) findViewById(R.id.question);
            questionBox.setText("GAME OVER");
        }
        else
            ask();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //init
        game = new Game();
        this.tg= new ToneGenerator(AudioManager.STREAM_ALARM,100);
        score = 0;
        qNum = 1;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_caps);

        ask();
    }
}
