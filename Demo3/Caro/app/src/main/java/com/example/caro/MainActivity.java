package com.example.caro;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Objects;

public class MainActivity extends AppCompatActivity {
    static final String PLAYER_X="X";
    static final String PLAYER_O="O";
    enum GameStatus{
        NOT_START,
        PLAYING,
        X_WIN,
        O_WIN,
        DRAW
    }


    Button[][] buttons = new Button[3][3]; // buttons[row][col]
    String[][] pieces = new String[3][3];
    int countPieces; // use to check draw ((count pieces == 9) => draw)
    Button playButton;
    TextView textViewResult;

    // game info
    GameStatus gameStatus = GameStatus.NOT_START;
    String activePlayer="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        playButton = findViewById(R.id.btnPlay);
        textViewResult = findViewById(R.id.textShowResult);

        buttons[0][0] = findViewById(R.id.btn1);
        buttons[0][1] = findViewById(R.id.btn2);
        buttons[0][2] = findViewById(R.id.btn3);

        buttons[1][0] = findViewById(R.id.btn4);
        buttons[1][1] = findViewById(R.id.btn5);
        buttons[1][2] = findViewById(R.id.btn6);

        buttons[2][0] = findViewById(R.id.btn7);
        buttons[2][1] = findViewById(R.id.btn8);
        buttons[2][2] = findViewById(R.id.btn9);

        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (gameStatus != GameStatus.PLAYING){
                    startGame();
                }
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    void startGame(){
        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++){
                pieces[i][j] = "";
                buttons[i][j].setText("");
                buttons[i][j].setBackgroundColor(Color.LTGRAY);
            }
        gameStatus = GameStatus.PLAYING;
        countPieces = 0;
        activePlayer=PLAYER_X;
        textViewResult.setVisibility(TextView.INVISIBLE);
        playButton.setVisibility(View.INVISIBLE);
    }

    boolean canGo(int row, int col){
        return (gameStatus == GameStatus.PLAYING) && (pieces[row][col].isEmpty());
    }

    void play(int row, int col){
        if (!canGo(row, col))
            return;

        pieces[row][col] = activePlayer;
        countPieces ++;

        // CHECK WIN
        boolean winByRow = pieces[row][0].equals(pieces[row][1]) && pieces[row][1].equals(pieces[row][2]);

        boolean winByCol = pieces[0][col].equals(pieces[1][col]) && pieces[1][col].equals(pieces[2][col]);

        boolean onDiagonal1 = (row == col),
                winByDiagonal1 = pieces[0][0].equals(pieces[1][1]) && pieces[1][1].equals(pieces[2][2]);

        boolean onDiagonal2 = (row + col == 2),
                winByDiagonal2 = pieces[2][0].equals(pieces[1][1]) && pieces[1][1].equals(pieces[0][2]);

        if (winByRow || winByCol || (onDiagonal1 && winByDiagonal1) || (onDiagonal2 && winByDiagonal2)){
            gameStatus = activePlayer.equals(PLAYER_X) ? GameStatus.X_WIN : GameStatus.O_WIN;

            textViewResult.setVisibility(View.VISIBLE);
            textViewResult.setText(activePlayer + " WIN");
            playButton.setText("Chơi lại");
            playButton.setVisibility(View.VISIBLE);
        }else if(countPieces == 9){
            gameStatus = GameStatus.DRAW;

            textViewResult.setVisibility(View.VISIBLE);
            textViewResult.setText("DRAW");
            playButton.setText("Chơi lại");
            playButton.setVisibility(View.VISIBLE);
        }

        activePlayer = activePlayer.equals(PLAYER_X) ? PLAYER_O : PLAYER_X;
    }

    public void onButtonClick(View view) {
        int row=-1, col=-1;
        Button selectedButton = (Button) view;
        for(int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (buttons[i][j].getId() == selectedButton.getId()) {
                    row = i;
                    col = j;
                    break;
                }
            }
        }
        if (canGo(row, col)){
            selectedButton.setBackgroundColor(activePlayer.equals(PLAYER_X) ? Color.GREEN : Color.RED);
            selectedButton.setText(activePlayer);
            play(row, col);
        }else{
            Toast.makeText(MainActivity.this, "Can not go", Toast.LENGTH_SHORT).show();
        }
    }
}