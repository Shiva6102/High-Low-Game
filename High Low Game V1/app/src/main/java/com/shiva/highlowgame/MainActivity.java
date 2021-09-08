package com.shiva.highlowgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    int rnum;

    public void generateRNum(){
        Random random=new Random();
        rnum=1+random.nextInt(25);
    }
    public void onClickGuess(View view){
        String message;
        EditText tnum = (EditText) findViewById(R.id.Num);
        int num = Integer.parseInt(tnum.getText().toString());

        if(num>25 || num<1) {
            message="Out of range number!!";
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
        else if(num>rnum){
            message="No, Guess lower!!";
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
        else if(num<rnum){
            message="No, Guess higher!!";
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        }
        else{
            /*TextView textView3 = (TextView) findViewById(R.id.textView3);
            textView3.setText("Congratulations, You got it.");*/

            message="Congratulations, You got it.";
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show();

            generateRNum();
        }

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        generateRNum();
    }
}