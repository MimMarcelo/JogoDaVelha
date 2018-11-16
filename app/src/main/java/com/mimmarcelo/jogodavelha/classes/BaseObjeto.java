package com.mimmarcelo.jogodavelha.classes;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;

public abstract class BaseObjeto {
    private Context context;
    private Paint arte;
    private int alturaDaTela;
    private int larguraDaTela;
    private boolean visivel;

    public BaseObjeto(Context context, int larguraDaTela, int alturaDaTela) {
        this(context, larguraDaTela, alturaDaTela, true);
    }

    public BaseObjeto(Context context, int larguraDaTela, int alturaDaTela, boolean visivel) {
        this.context = context;
        this.larguraDaTela = larguraDaTela;
        this.alturaDaTela = alturaDaTela;
        this.visivel = visivel;

        arte = new Paint();
    }

    public Context getContext(){
        return context;
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
