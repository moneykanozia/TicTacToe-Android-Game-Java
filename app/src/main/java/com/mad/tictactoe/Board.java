package com.mad.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Board extends AppCompatActivity implements View.OnClickListener {
    TextView r1c1,r1c2,r1c3,r2c1,r2c2,r2c3,r3c1,r3c2,r3c3;
    Bundle getSigns;
    String p1Sign,p2Sign;
    Integer p1Turn=0,p2Turn=1;
    Intent i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_board);
        r1c1 = (TextView)findViewById(R.id.r1c1);
        r1c2 = (TextView)findViewById(R.id.r1c2);
        r1c3 = (TextView)findViewById(R.id.r1c3);
        r2c1 = (TextView)findViewById(R.id.r2c1);
        r2c2 = (TextView)findViewById(R.id.r2c2);
        r2c3 = (TextView)findViewById(R.id.r2c3);
        r3c1 = (TextView)findViewById(R.id.r3c1);
        r3c2 = (TextView)findViewById(R.id.r3c2);
        r3c3 = (TextView)findViewById(R.id.r3c3);
        getSigns = getIntent().getExtras();
        p1Sign = getSigns.getString("P1_Sign");
        p2Sign = getSigns.getString("P2_Sign");
        i = new Intent(Board.this,ShowWinner.class);
        setAllEnabled();
        setWhiteBackGroundColor();
        setTextEmpty();
        setClickListeners();
    }
     void setClickListeners(){
        r1c1.setOnClickListener(this);
        r1c2.setOnClickListener(this);
        r1c3.setOnClickListener(this);
        r2c1.setOnClickListener(this);
        r2c2.setOnClickListener(this);
        r2c3.setOnClickListener(this);
        r3c1.setOnClickListener(this);
        r3c2.setOnClickListener(this);
        r3c3.setOnClickListener(this);
     }
     public void onClick(View v){
        if(v.getId()==R.id.r1c1){
            setValue(r1c1);
        }
        else if(v.getId()==R.id.r1c2){
            setValue(r1c2);
         }
        else if(v.getId()==R.id.r1c3){
            setValue(r1c3);
        }
        else if(v.getId()==R.id.r2c1){
            setValue(r2c1);
        }
        else if(v.getId()==R.id.r2c2){
            setValue(r2c2);
        }
        else if(v.getId()==R.id.r2c3){
            setValue(r2c3);
        }
        else if(v.getId()==R.id.r3c1){
            setValue(r3c1);
        }
        else if(v.getId()==R.id.r3c2){
            setValue(r3c2);
        }
        else if(v.getId()==R.id.r3c3){
            setValue(r3c3);
        }
     }
     void setValue(TextView tv){
         if(p1Turn==0 || p1Turn==2 ||p1Turn==4 ||p1Turn==6 ||p1Turn==8){
             tv.setText(p1Sign);
             tv.setEnabled(false);
             p1Turn+=1;
             noWinner();
             match(tv,p1Sign);
         }
         else{
             tv.setText(p2Sign);
             tv.setEnabled(false);
             p1Turn+=1;
             noWinner();
             match(tv,p2Sign);
         }
     }

     void match(TextView tv,String sign){
        i.putExtra("WinnerSign",sign);
        if (tv==r1c1){
            if(r1c2.getText().toString()==r1c1.getText().toString()){
                if(r1c3.getText().toString()==r1c1.getText().toString()){
                    setRedColor(r1c1,r1c2,r1c3);
                }
            }
            if(r2c1.getText().toString()==r1c1.getText().toString()){
                if(r3c1.getText().toString()==r1c1.getText().toString()){
                    setRedColor(r1c1,r2c1,r3c1);
                }
            }
            if(r2c2.getText().toString()==r1c1.getText().toString()){
                if(r3c3.getText().toString()==r1c1.getText().toString()){
                    setRedColor(r1c1,r2c2,r3c3);
                }
            }
         }
        else if(tv==r1c2){
            if(r1c1.getText().toString()==r1c2.getText().toString()){
                if(r1c3.getText().toString()==r1c2.getText().toString()){
                    setRedColor(r1c1,r1c2,r1c3);
                }
            }
            if(r2c2.getText().toString()==r1c2.getText().toString()){
                if(r3c2.getText().toString()==r1c2.getText().toString()){
                    setRedColor(r1c2,r2c2,r3c2);
                }
            }
        }
         else if (tv==r1c3){
             if(r1c2.getText().toString()==r1c3.getText().toString()){
                 if(r1c1.getText().toString()==r1c3.getText().toString()){
                     setRedColor(r1c1,r1c2,r1c3);
                 }
             }
             if(r2c3.getText().toString()==r1c3.getText().toString()){
                 if(r3c3.getText().toString()==r1c3.getText().toString()){
                     setRedColor(r1c3,r2c3,r3c3);
                 }
             }
             if(r2c2.getText().toString()==r1c3.getText().toString()){
                 if(r3c1.getText().toString()==r1c3.getText().toString()){
                     setRedColor(r1c3,r2c2,r3c1);
                 }
             }
         }
        else if(tv==r2c1){
            if(r1c1.getText().toString()==r2c1.getText().toString()){
                if(r3c1.getText().toString()==r2c1.getText().toString()){
                    setRedColor(r1c1,r2c1,r3c1);
                }
            }
            if(r2c2.getText().toString()==r2c1.getText().toString()){
                if(r2c3.getText().toString()==r2c1.getText().toString()){
                    setRedColor(r2c1,r2c2,r2c3);
                }
            }
        }
        else if (tv==r2c2){
            if(r1c2.getText().toString()==r2c2.getText().toString()){
                if(r3c2.getText().toString()==r2c2.getText().toString()){
                    setRedColor(r1c2,r2c2,r3c2);
                }
            }
            if(r2c1.getText().toString()==r2c2.getText().toString()){
                if(r2c3.getText().toString()==r2c2.getText().toString()){
                    setRedColor(r2c1,r2c2,r2c3);
                }
            }
            if(r1c1.getText().toString()==r2c2.getText().toString()){
                if(r3c3.getText().toString()==r2c2.getText().toString()){
                    setRedColor(r1c1,r2c2,r3c3);
                }
            }
        }
        else if (tv==r2c3){
            if(r1c3.getText().toString()==r2c3.getText().toString()){
                if(r3c3.getText().toString()==r2c3.getText().toString()){
                    setRedColor(r1c3,r2c3,r3c3);
                }
            }
            if(r2c2.getText().toString()==r2c3.getText().toString()){
                if(r2c1.getText().toString()==r2c3.getText().toString()){
                    setRedColor(r2c1,r2c2,r2c3);
                }
            }
        }
        else if (tv==r3c1){
            if(r2c1.getText().toString()==r3c1.getText().toString()){
                if(r1c1.getText().toString()==r3c1.getText().toString()){
                    setRedColor(r1c1,r2c1,r3c1);
                }
            }
            if(r3c2.getText().toString()==r3c1.getText().toString()){
                if(r3c3.getText().toString()==r3c1.getText().toString()){
                    setRedColor(r3c1,r3c2,r3c3);
                }
            }
            if(r2c2.getText().toString()==r3c1.getText().toString()){
                if(r1c3.getText().toString()==r3c1.getText().toString()){
                    setRedColor(r1c3,r2c2,r3c1);
                }
            }
        }
        else if (tv==r3c2){
            if(r3c1.getText().toString()==r3c2.getText().toString()){
                if(r3c3.getText().toString()==r3c2.getText().toString()){
                    setRedColor(r3c1,r3c2,r3c3);
                }
            }
            if(r2c2.getText().toString()==r3c2.getText().toString()){
                if(r1c2.getText().toString()==r3c2.getText().toString()){
                    setRedColor(r1c2,r2c2,r3c2);
                }
            }
        }
        else if (tv==r3c3){
            if(r2c3.getText().toString()==r3c3.getText().toString()){
                if(r1c3.getText().toString()==r3c3.getText().toString()){
                    setRedColor(r1c3,r2c3,r3c3);
                }
            }
            if(r3c2.getText().toString()==r3c3.getText().toString()){
                if(r3c1.getText().toString()==r3c3.getText().toString()){
                    setRedColor(r3c1,r3c2,r3c3);
                }
            }
            if(r2c2.getText().toString()==r3c3.getText().toString()){
                if(r1c1.getText().toString()==r3c3.getText().toString()){
                    setRedColor(r1c1,r2c2,r3c3);
                }
            }
        }
     }

     void setRedColor(TextView tv1,TextView tv2,TextView tv3){
        tv1.setBackgroundColor(getResources().getColor(R.color.red));
        tv2.setBackgroundColor(getResources().getColor(R.color.red));
        tv3.setBackgroundColor(getResources().getColor(R.color.red));
        finish();
        startActivity(i);
     }

    void setAllEnabled(){
        r1c1.setEnabled(true);
        r1c2.setEnabled(true);
        r1c3.setEnabled(true);
        r2c1.setEnabled(true);
        r2c2.setEnabled(true);
        r2c3.setEnabled(true);
        r3c1.setEnabled(true);
        r3c2.setEnabled(true);
        r3c3.setEnabled(true);
    }

    void setWhiteBackGroundColor(){
        r1c1.setBackgroundColor(getResources().getColor(R.color.white));
        r1c2.setBackgroundColor(getResources().getColor(R.color.white));
        r1c3.setBackgroundColor(getResources().getColor(R.color.white));
        r2c1.setBackgroundColor(getResources().getColor(R.color.white));
        r2c2.setBackgroundColor(getResources().getColor(R.color.white));
        r2c3.setBackgroundColor(getResources().getColor(R.color.white));
        r3c1.setBackgroundColor(getResources().getColor(R.color.white));
        r3c2.setBackgroundColor(getResources().getColor(R.color.white));
        r3c3.setBackgroundColor(getResources().getColor(R.color.white));
    }

    void setTextEmpty(){
        r1c1.setText("");
        r1c2.setText("");
        r1c3.setText("");
        r2c1.setText("");
        r2c2.setText("");
        r2c3.setText("");
        r3c1.setText("");
        r3c2.setText("");
        r3c3.setText("");
    }
    void noWinner(){
        if(r1c1.getText().toString()!="" && r1c2.getText().toString()!="" && r1c3.getText().toString()!="" && r2c1.getText().toString()!="" && r2c2.getText().toString()!="" && r2c3.getText().toString()!=""
        && r3c1.getText().toString()!="" && r3c2.getText().toString()!="" && r3c3.getText().toString()!=""){
            i.putExtra("WinnerSign","No");
            finish();
            startActivity(i);
        }
    }
}