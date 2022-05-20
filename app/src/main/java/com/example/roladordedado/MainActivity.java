package com.example.roladordedado;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int delayTempo = 20;
    int dadoRolagem = 40;
    int[] dadoImagens = new int[]{R.drawable.d1, R.drawable.d2, R.drawable.d3, R.drawable.d4, R.drawable.d5, R.drawable.d6};
    Random random = new Random();
    TextView help;
    ImageView dado1;
    ImageView dado2;
    LinearLayout guardaDado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        help = findViewById(R.id.help);
        guardaDado = findViewById(R.id.guardaDado);
        dado1 = findViewById(R.id.dado1);
        dado2 = findViewById(R.id.dado2);
        guardaDado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    rolaDado();
                } catch (Exception e){
                  e.printStackTrace();
                }
            }
        });
    }

    private void rolaDado() {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                for (int i=0; i < dadoRolagem; i++){
                    int dadoUm = random.nextInt(6) + 1;
                    int dadoDois = random.nextInt(6) + 1;
                    dado1.setImageResource(dadoImagens[dadoUm-1]);
                    dado2.setImageResource(dadoImagens[dadoDois-1]);
                    try {
                        Thread.sleep(delayTempo);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();
    }
}