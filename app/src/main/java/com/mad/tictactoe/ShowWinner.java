package com.mad.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ShowWinner extends AppCompatActivity implements View.OnClickListener {
    TextView tvShow;
    Button newGame,quit;
    Bundle bundleWinnerSign;
    String winnerSign;
    String player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.show_winner);
        tvShow = (TextView)findViewById(R.id.tvShow);
        newGame = (Button)findViewById(R.id.NewGame);
        quit = (Button)findViewById(R.id.Quit);
        bundleWinnerSign = getIntent().getExtras();
        winnerSign = bundleWinnerSign.getString("WinnerSign");
        newGame.setOnClickListener(this);
        quit.setOnClickListener(this);
        showWinner();
    }
    void showWinner(){
        if(winnerSign.equals("O") || winnerSign.equals("#")){
            tvShow.setText("Player 1 is Winner");
        }
        else if(winnerSign.equals("X") || winnerSign.equals("$")){
            tvShow.setText("Player 2 is Winner");
        }
        else{
            tvShow.setText("No Winner");
        }
    }
    public void onClick(View v){
        if(v.getId()==R.id.NewGame){
            Intent i = new Intent(this,MainActivity.class);
            startActivity(i);
        }
        else{
            finishAffinity();
        }
    }
}