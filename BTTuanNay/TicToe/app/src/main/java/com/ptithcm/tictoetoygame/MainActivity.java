package com.ptithcm.tictoetoygame;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import android.graphics.Color;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    int Winer = -1;
    int startGame = 0;
    Button btPlayAgain,bt1,bt2,bt3,bt4,bt5,bt6,bt7,bt8,bt9;
    TextView txtShowresult;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        btPlayAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (startGame == 1) {
                    PlayAgain();
                    startGame = 0;
                    btPlayAgain.setText("Bắt đầu");
                }
                else if (startGame == 0)
                {
                    btPlayAgain.setText("Chơi lại");
                    startGame = 1;
                }
            }
        });
    }

    void PlayAgain() {
        Player1.clear();
        Player2.clear();
        Winer=-1;
        bt1.setText("");
        bt1.setBackgroundColor(Color.rgb(188,185,185));
        bt2.setText("");
        bt2.setBackgroundColor(Color.rgb(188,185,185));
        bt3.setText("");
        bt3.setBackgroundColor(Color.rgb(188,185,185));
        bt4.setText("");
        bt4.setBackgroundColor(Color.rgb(188,185,185));
        bt5.setText("");
        bt5.setBackgroundColor(Color.rgb(188,185,185));
        bt6.setText("");
        bt6.setBackgroundColor(Color.rgb(188,185,185));
        bt7.setText("");
        bt7.setBackgroundColor(Color.rgb(188,185,185));
        bt8.setText("");
        bt8.setBackgroundColor(Color.rgb(188,185,185));
        bt9.setText("");
        bt9.setBackgroundColor(Color.rgb(188,185,185));
        txtShowresult.setVisibility(View.INVISIBLE);
    }

    void Anhxa() {
        btPlayAgain =  findViewById(R.id.btPlayAgain);
        bt1 =  findViewById(R.id.bt1);
        bt2 =  findViewById(R.id.bt2);
        bt3 =  findViewById(R.id.bt3);
        bt4 =  findViewById(R.id.bt4);
        bt5 =  findViewById(R.id.bt5);
        bt6 =  findViewById(R.id.bt6);
        bt7 =  findViewById(R.id.bt7);
        bt8 =  findViewById(R.id.bt8);
        bt9 =  findViewById(R.id.bt9);
        txtShowresult = findViewById(R.id.txtShowresult);
    }

    public void btClick(View view) {
        Button btSelected = (Button) view;

        int CellID=0;
        int id = btSelected.getId();
        if (id == R.id.bt1) {
            CellID = 1;
        } else if (id == R.id.bt2) {
            CellID = 2;
        } else if (id == R.id.bt3) {
            CellID = 3;
        } else if (id == R.id.bt4) {
            CellID = 4;
        } else if (id == R.id.bt5) {
            CellID = 5;
        } else if (id == R.id.bt6) {
            CellID = 6;
        } else if (id == R.id.bt7) {
            CellID = 7;
        } else if (id == R.id.bt8) {
            CellID = 8;
        } else if (id == R.id.bt9) {
            CellID = 9;
        }

        if (Winer == -1 && startGame == 1)
        {
            PlayGame(CellID, btSelected);
        }
    }

    int ActivePlayer=1; // 1 : first, 2 second
    ArrayList<Integer> Player1 = new ArrayList<>();
    ArrayList<Integer> Player2 = new ArrayList<>();
    void PlayGame(int CellID, Button btselected){
        if(ActivePlayer == 1)
        {
            btselected.setText("X");
            btselected.setBackgroundColor(Color.GREEN);
            btselected.setTextColor(Color.RED);
            Player1.add(CellID);
            ActivePlayer = 2;
        }
        else if (ActivePlayer ==2)
        {
            btselected.setText("O");
            btselected.setTextColor(Color.WHITE);
            btselected.setBackgroundColor(Color.BLUE);
            Player2.add(CellID);
            ActivePlayer = 1;

        }
        CheckWiner();
        if (Winer == 1) {
            txtShowresult.setVisibility(View.VISIBLE);
            txtShowresult.setText("Player 1 thắng !");
//Toast.makeText(this,"Play 1 thắng !",Toast.LENGTH_LONG).show();
        }
        else if (Winer == 2) {
            txtShowresult.setVisibility(View.VISIBLE);
            txtShowresult.setText("Player 2 thắng !");
//Toast.makeText(this,"Play 2 thắng !",Toast.LENGTH_LONG).show();
        }
        else if (Winer == 0) {
            txtShowresult.setVisibility(View.VISIBLE);
            txtShowresult.setText("Hòa !");
//Toast.makeText(this,"Hòa !",Toast.LENGTH_LONG).show();
        }
    }
    void CheckWiner(){
//Dòng 1
        if(Player1.contains(1) && Player1.contains(2) &&
                Player1.contains(3)){
            Winer =1;
        }
        if(Player2.contains(1) && Player2.contains(2) &&
                Player2.contains(3)){
            Winer =2;
        }
//Dòng 2
        if(Player1.contains(4) && Player1.contains(5) &&
                Player1.contains(6)){
            Winer =1;
        }
        if(Player2.contains(4) && Player2.contains(5) &&
                Player2.contains(6)){
            Winer =2;
        }
//Dòng 3
        if(Player1.contains(7) && Player1.contains(8) &&
                Player1.contains(9)){
            Winer =1;
        }
        if(Player2.contains(7) && Player2.contains(8) &&
                Player2.contains(9)){
            Winer =2;
        }
//Cột 1
        if(Player1.contains(1) && Player1.contains(4) &&
                Player1.contains(7)){
            Winer =1;
        }
        if(Player2.contains(1) && Player2.contains(4) &&

                Player2.contains(7)){
            Winer =2;
        }
//Cột 2
        if(Player1.contains(2) && Player1.contains(5) &&
                Player1.contains(8)){
            Winer =1;
        }
        if(Player2.contains(2) && Player2.contains(5) &&
                Player2.contains(8)){
            Winer =2;
        }
//Cột 3
        if(Player1.contains(2) && Player1.contains(5) &&
                Player1.contains(8)){
            Winer =1;
        }
        if(Player2.contains(3) && Player2.contains(6) &&
                Player2.contains(9)){
            Winer =2;
        }
//Chéo 1
        if(Player1.contains(1) && Player1.contains(5) &&
                Player1.contains(9)){
            Winer =1;
        }
        if(Player2.contains(1) && Player2.contains(5) &&
                Player2.contains(9)){
            Winer =2;
        }
//Chéo 2
        if(Player1.contains(3) && Player1.contains(5) &&
                Player1.contains(7)){
            Winer =1;
        }
        if(Player2.contains(3) && Player2.contains(5) &&
                Player2.contains(7)){
            Winer =2;
        }
        int sum = Player1.size() + Player2.size();
        if (sum == 9 && Winer == -1)
        {
            Winer = 0;
        }
    }
}