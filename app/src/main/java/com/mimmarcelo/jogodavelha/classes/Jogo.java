package com.mimmarcelo.jogodavelha.classes;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Jogo {
    private Tabuleiro tabuleiro;
    private Paint background;
    private Paint textPaint;
    private String tempo;

    public Jogo(){
        background = new Paint();
        background.setColor(Color.WHITE);

        textPaint = new Paint();

    }

    public void configurarJanela(int altura, int largura){
        tabuleiro = new Tabuleiro(altura, largura);

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
    }
}