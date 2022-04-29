package com.example.jogodoadivinha;

// Brenda Mirelle Vicente Santiago & Gabriel Costa da Silva

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button btn01;
    private Button btn02;
    private Button btn03;

    private TextView lblResposta;
    private TextView lblResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn01 = findViewById(R.id.btn01);
        btn02 = findViewById(R.id.btn02);
        btn03 = findViewById(R.id.btn03);

        lblResposta = findViewById(R.id.lblResposta);
        lblResultado = findViewById(R.id.lblResultado);

        btn01.setOnClickListener(new escutadorBtn01());
        btn02.setOnClickListener(new escutadorBtn02());
        btn03.setOnClickListener(new escutadorBtn03());
    }

    class escutadorBtn01 implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            int chute = 1;
            adivinha(chute);
        }
    }

    class escutadorBtn02 implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            int chute = 2;
            adivinha(chute);
        }
    }

    class escutadorBtn03 implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            int chute = 3;
            adivinha(chute);
        }
    }

    private void adivinha(int chute) {
        int resposta = new Random().nextInt(3) + 1;
        lblResposta.setText("Pensei em: " + Integer.toString(resposta));

        if (chute == resposta) {
            String msg = "Você acertou, nós escolhemos o " + resposta + ".\nJogue mais uma vez!";
            Toast.makeText(this, msg, Toast.LENGTH_LONG).show();

            lblResultado.setText("Parabéns, você acertou!");

        } else {
            String msg = "Você errou, eu escolhi o " + resposta + " e você o " + chute + ".\nJogue mais uma vez!";
            Toast.makeText(this, msg, Toast.LENGTH_LONG).show();

            lblResultado.setText("Que pena, você errou!");
        }
    }
}