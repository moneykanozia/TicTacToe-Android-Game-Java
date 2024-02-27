package com.mad.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    RadioButton rg_P1_rb1,rg_P1_rb2,rg_P2_rb1,rg_P2_rb2;
    Button b_next;
    TextView showError,money;
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        money = (TextView)findViewById(R.id.money);
        rg_P1_rb1 = (RadioButton)findViewById(R.id.rg_P1_rb1);
        rg_P1_rb2 = (RadioButton)findViewById(R.id.rg_P1_rb2);
        rg_P2_rb1 = (RadioButton)findViewById(R.id.rg_P2_rb1);
        rg_P2_rb2 = (RadioButton)findViewById(R.id.rg_P2_rb2);
        b_next = (Button)findViewById(R.id.b_next);
        showError = (TextView)findViewById(R.id.showError);
        rg_P1_rb1.setOnClickListener(radioListener1);
        rg_P1_rb2.setOnClickListener(radioListener1);
        rg_P2_rb1.setOnClickListener(radioListener2);
        rg_P2_rb2.setOnClickListener(radioListener2);
        i = new Intent(MainActivity.this,Board.class);
        b_next.setOnClickListener(b_next_listnr);
        setEmpty();
    }
    private View.OnClickListener radioListener1 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            RadioButton rb = (RadioButton)v;
            String sign = (String) rb.getText();
            i.putExtra("P1_Sign",sign);
        }
    };
    private View.OnClickListener radioListener2 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            RadioButton rb = (RadioButton)v;
            String sign = (String) rb.getText();
            i.putExtra("P2_Sign",sign);
        }
    };
    private View.OnClickListener b_next_listnr = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
           if(rg_P1_rb1.isChecked() || rg_P1_rb2.isChecked()){
               if(rg_P2_rb1.isChecked() || rg_P2_rb2.isChecked()){
                   showError.setText("");
                   showError.setVisibility(View.INVISIBLE);
                   finish();
                   startActivity(i);
               }
               else{
                    showError.setText("Player 2 Choose Sign");
                   showError.setVisibility(View.VISIBLE);
               }
           }
           else{
               if(!rg_P2_rb1.isChecked() && !rg_P2_rb2.isChecked()){

                   showError.setText("Choose Signs");
                   showError.setVisibility(View.VISIBLE);
               }
               else{
                   showError.setText("Player 1 Choose Sign");
                   showError.setVisibility(View.VISIBLE);
               }
           }
        }
    };

    void setEmpty(){
        rg_P1_rb1.setChecked(false);
        rg_P1_rb2.setChecked(false);
        rg_P2_rb1.setChecked(false);
        rg_P2_rb2.setChecked(false);
    }

}