package com.example.class2demo2;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Button;
import android.widget.Toast;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    int turn = 0;
    int counter=0;
    int[] matIndexes;

    public void start(){
        matIndexes = new int[9];
        ImageView turn_score = findViewById(R.id.main_turn_score);
        turn_score.setImageResource(R.drawable.xplay);
        initializeListener(R.id.main_squre_00);
        initializeListener(R.id.main_squre_01);
        initializeListener(R.id.main_squre_02);
        initializeListener(R.id.main_squre_10);
        initializeListener(R.id.main_squre_11);
        initializeListener(R.id.main_squre_12);
        initializeListener(R.id.main_squre_20);
        initializeListener(R.id.main_squre_21);
        initializeListener(R.id.main_squre_22);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start();
        Button b = findViewById(R.id.main_button_newgame);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                turn = 0;
                counter=0;
                start();
            }
        });
    }

    public void checkWhoWin(int index,ImageView turn_score) {
        if (matIndexes[index] == 1) {
            turn_score.setImageResource(R.drawable.xwin);
        } else {
            turn_score.setImageResource(R.drawable.owin);
        }
    }

    public boolean checkIfFinish(ImageView turn_score) {
        ImageView winIndex = findViewById(R.id.main_win);
        if (matIndexes[0] != 0 && matIndexes[0] == matIndexes[1] && matIndexes[1] == matIndexes[2]) {
            checkWhoWin(0,turn_score);
            winIndex.setImageResource(R.drawable.mark3turn);
            return true;
        }
        if (matIndexes[3] != 0 && matIndexes[3] == matIndexes[4] && matIndexes[4] == matIndexes[5]) {
            checkWhoWin(3,turn_score);
            winIndex.setImageResource(R.drawable.mark4turn);
            return true;
        }
        if (matIndexes[6] != 0 && matIndexes[6] == matIndexes[7] && matIndexes[7] == matIndexes[8]) {
            checkWhoWin(6,turn_score);
            winIndex.setImageResource(R.drawable.mark5turn);
            return true;
        }
        if (matIndexes[0] != 0 && matIndexes[0] == matIndexes[3] && matIndexes[3] == matIndexes[6]) {
            checkWhoWin(0,turn_score);
            winIndex.setImageResource(R.drawable.mark3);
            return true;
        }
        if (matIndexes[1] != 0 && matIndexes[1] == matIndexes[4] && matIndexes[4] == matIndexes[7]) {
            checkWhoWin(1,turn_score);
            winIndex.setImageResource(R.drawable.mark4);
            return true;
        }
        if (matIndexes[2] != 0 && matIndexes[2] == matIndexes[5] && matIndexes[5] == matIndexes[8]) {
            checkWhoWin(2,turn_score);
            winIndex.setImageResource(R.drawable.mark5);
            return true;
        }
        if (matIndexes[0] != 0 && matIndexes[0] == matIndexes[4] && matIndexes[4] == matIndexes[8]) {
            checkWhoWin(0,turn_score);
            winIndex.setImageResource(R.drawable.mark1);
            return true;
        }
        if (matIndexes[2] != 0 && matIndexes[2] == matIndexes[4] && matIndexes[4] == matIndexes[6]) {
            checkWhoWin(2,turn_score);
            winIndex.setImageResource(R.drawable.mark2);
            return true;
        }
        if (counter==9){
            turn_score.setImageResource(R.drawable.nowin);
            return true;
        }
        return false;
    }


    public void initializeListener(@IdRes int id) {
        ImageView winIndex = findViewById(R.id.main_win);
        ImageView currentImg = findViewById(id);
        ImageView turn_score = findViewById(R.id.main_turn_score);
        currentImg.setSelected(false);
        currentImg.setImageResource(R.drawable.empty);
        winIndex.setImageResource(R.drawable.empty);
        currentImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                counter++;
                if (!currentImg.isSelected()) {
                    int index = Integer.parseInt(currentImg.getTag().toString()) - 1;
                    if (turn % 2 == 0) {
                        currentImg.setImageResource(R.drawable.x);
                        matIndexes[index] = 1;
                        turn_score.setImageResource(R.drawable.oplay);
                    } else {
                        currentImg.setImageResource(R.drawable.o);
                        matIndexes[index] = 2;
                        turn_score.setImageResource(R.drawable.xplay);
                    }
                    if (checkIfFinish(turn_score)){
                        Toast.makeText(getApplicationContext(),"game done",Toast.LENGTH_LONG).show();
                        System.out.println("You Win");
                    }
                    turn++;
                    currentImg.setSelected(true);
                }
            }
        });
    }
}