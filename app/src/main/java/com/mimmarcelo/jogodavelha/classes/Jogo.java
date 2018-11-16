package com.mimmarcelo.jogodavelha.classes;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import com.mimmarcelo.jogodavelha.R;

import java.util.ArrayList;

public class Jogo {
    private Context context;
    private Paint background;
    private Paint textPaint;
    private String tempo;

    private Tabuleiro tabuleiro;
    private ArrayList<Simbolo> simbolos;

    public Jogo(Context context){
        this.context = context;
        background = new Paint();
        background.setColor(Color.WHITE);

        textPaint = new Paint();

    }

    public void configurarJanela(int altura, int largura){
        tabuleiro = new Tabuleiro(context, largura, altura);
        simbolos = new ArrayList<>();

        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++) {
                Simbolo simbolo = new Simbolo(context, largura, altura);
                simbolo.setIdImagem(R.drawable.vazio);
                simbolo.setPosicao(i+1, j+2);
                simbolos.add(simbolo);
            }

        textPaint.setTextSize(largura/20);
        textPaint.setAntiAlias(true);
    }

    public void novoJogo(){

    }

    public void setTempo(String tempo){
        this.tempo = tempo;
    }

    public void desenhar(Canvas canvas){
        canvas.drawRect(0, 0, canvas.getWidth(), canvas.getHeight(), background);
        canvas.drawText(tempo, 30, 50, textPaint);
        tabuleiro.desenhar(canvas);
        for (Simbolo simbolo: simbolos) {
            simbolo.desenhar(canvas);
        }
    }
}
