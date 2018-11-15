package com.mimmarcelo.jogodavelha.classes;

import android.graphics.Canvas;
import android.graphics.Paint;

public abstract class BaseObjeto {
    private Paint arte;
    private int alturaDaTela;
    private int larguraDaTela;
    private boolean visivel;

    public BaseObjeto(int alturaDaTela, int larguraDaTela) {
        this(alturaDaTela, larguraDaTela, true);
    }

    public BaseObjeto(int alturaDaTela, int larguraDaTela, boolean visivel) {
        this.alturaDaTela = alturaDaTela;
        this.larguraDaTela = larguraDaTela;
        this.visivel = visivel;

        arte = new Paint();
    }

    public Paint getArte() {
        return arte;
    }

    public int getAlturaDaTela() {
        return alturaDaTela;
    }

    public int getLarguraDaTela() {
        return larguraDaTela;
    }

    public boolean isVisivel() {
        return visivel;
    }

    public void setVisivel(boolean visivel) {
        this.visivel = visivel;
    }

    public int getPixelY(){
        return alturaDaTela / 6;
    }

    public int getPixelX(){
        return larguraDaTela / 5;
    }

    public abstract void reiniciar();

    public abstract void atualizarPosicoes(double intervalo);

    public abstract void desenhar(Canvas canvas);

}
