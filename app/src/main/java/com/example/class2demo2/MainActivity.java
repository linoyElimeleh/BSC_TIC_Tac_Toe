package com.example.class2demo2;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    int counter = 0;
    int[] matIndexes = {0, 0, 0, 0, 0, 0, 0, 0, 0};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
    public void checkWhoWin(int index,ImageView turn_score) {
        if (matIndexes[index] == 1) {
            turn_score.setImageResource(R.drawable.xwin);
        } else {
            turn_score.setImageResource(R.drawable.owin);
        }
    }

    public boolean checkIfWin(ImageView turn_score) {
        ImageView winIndex = findViewById(R.id.main_win_index);
        if (matIndexes[0] != 0 && matIndexes[0] == matIndexes[1] && matIndexes[1] == matIndexes[2]) {
            checkWhoWin(0,turn_score);
            //winIndex.setImageResource(R.drawable.xwin);
            return true;
        }
        if (matIndexes[3] != 0 && matIndexes[3] == matIndexes[4] && matIndexes[4] == matIndexes[5]) {
            checkWhoWin(3,turn_score);
            //log the winner and win location
            return true;
        }
        if (matIndexes[6] != 0 && matIndexes[6] == matIndexes[7] && matIndexes[7] == matIndexes[8]) {
            checkWhoWin(6,turn_score);
            //log the winner and win location
            return true;
        }
        if (matIndexes[0] != 0 && matIndexes[0] == matIndexes[3] && matIndexes[3] == matIndexes[6]) {
            checkWhoWin(0,turn_score);
            //log the winner and win location
            return true;
        }
        if (matIndexes[1] != 0 && matIndexes[1] == matIndexes[4] && matIndexes[4] == matIndexes[7]) {
            checkWhoWin(1,turn_score);
            //log the winner and win location
            return true;
        }
        if (matIndexes[2] != 0 && matIndexes[2] == matIndexes[5] && matIndexes[5] == matIndexes[8]) {
            checkWhoWin(2,turn_score);
            //log the winner and win location
            return true;
        }
        if (matIndexes[0] != 0 && matIndexes[0] == matIndexes[4] && matIndexes[4] == matIndexes[8]) {
            checkWhoWin(0,turn_score);
            winIndex.setImageResource(R.drawable.xplay);
            return true;
        }
        if (matIndexes[2] != 0 && matIndexes[2] == matIndexes[4] && matIndexes[4] == matIndexes[5]) {
            checkWhoWin(2,turn_score);
            //log the winner and win location
            return true;
        }
        return false;
    }

    public void initializeListener(@IdRes int id) {
        ImageView currentImg = findViewById(id);
        ImageView turn_score = findViewById(R.id.main_turn_score);
        currentImg.setSelected(true);
        currentImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentImg.isSelected()) {
                    int index = Integer.parseInt(currentImg.getTag().toString()) - 1;
                    if (counter % 2 == 0) {
                        currentImg.setImageResource(R.drawable.x);
                        matIndexes[index] = 1;
                        turn_score.setImageResource(R.drawable.oplay);
                    } else {
                        currentImg.setImageResource(R.drawable.o);
                        matIndexes[index] = 2;
                        turn_score.setImageResource(R.drawable.xplay);
                    }
                    if (checkIfWin(turn_score)){
                        System.out.println("You Win");
                    }
                    counter++;
                    currentImg.setSelected(false);
                }
            }
        });
    }
}