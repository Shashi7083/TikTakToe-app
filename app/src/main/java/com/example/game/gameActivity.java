package com.example.game;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

import org.w3c.dom.Text;


public class gameActivity extends AppCompatActivity {

    Button restart;

    boolean gameActive = true;
    int player_playing = 0;
    int[] state = {2,2,2,2,2,2,2,2,2};

    int[][] winner = { { 0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}   };



    
    public void playing(View view){

        ImageView image = (ImageView) view;

        int tappedImage = Integer.parseInt(image.getTag().toString());

        if(state[tappedImage]==2 &&  gameActive) {
            state[tappedImage] = player_playing;

            image.setTranslationY(-1000f);

            if (player_playing == 0) {
                image.setImageResource(R.drawable.x);
                player_playing = 1;

                TextView txtview1 = findViewById(R.id.txtstatus1);
                txtview1.setText("Current Move - o");

            } else {
                player_playing = 0;
                image.setImageResource(R.drawable.o);


                TextView txtview_1 = findViewById(R.id.txtstatus1);
                txtview_1.setText("Current Move - x");

            }

            image.animate().translationYBy(1000f).setDuration(300);
        }
        for(int winners[]: winner){
            if(state[winners[0]] == state[winners[1]] && state[winners[1]] == state[winners[2]] && state[winners[0]]!=2){

                String winnerStr;
                gameActive = false;

                if(state[winners[0]]==0){
                    winnerStr = " x Won the match";
                }
                else{
                    winnerStr = " o Won the match";
                }

                TextView  txtview_1 = findViewById(R.id.txtstatus1);
                txtview_1.setText(winnerStr);

            }

        }
    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);


        getSupportActionBar().hide();
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);

        restart = findViewById(R.id.restart);

        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((ImageView)findViewById(R.id.img0)).setImageResource(0);
                ((ImageView)findViewById(R.id.img1)).setImageResource(0);
                ((ImageView)findViewById(R.id.img2)).setImageResource(0);
                ((ImageView)findViewById(R.id.img3)).setImageResource(0);
                ((ImageView)findViewById(R.id.img4)).setImageResource(0);
                ((ImageView)findViewById(R.id.img5)).setImageResource(0);
                ((ImageView)findViewById(R.id.img6)).setImageResource(0);
                ((ImageView)findViewById(R.id.img7)).setImageResource(0);
                ((ImageView)findViewById(R.id.img8)).setImageResource(0);

                gameActive = true;
                for(int i=0;i < state.length; i++){
                    state[i] = 2;
                }


            }
        });
        

    }
}