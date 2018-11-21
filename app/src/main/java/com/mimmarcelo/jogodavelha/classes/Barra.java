package com.mimmarcelo.jogodavelha.classes;

import android.content.Context;
import android.graphics.Canvas;

public class Barra extends BaseObjeto {
    public static final int HORIZONTAL = 1;
    public static final int VERTICAL = 2;
    public int espessura;
    public int direcao;
    public int x;
    public int y;
    public float progressoX;
    public float progressoY;
    public boolean terminou;

    public Barra(Context context, int larguraDaTela, int alturaDaTela) {
        super(context, larguraDaTela, alturaDaTela, false);
        this.espessura = getPixelX()/15;
        this.terminou = false;

        getArte().setStrokeWidth(espessura*1.5f);
        getArte().setAntiAlias(true);
    }

    public int getEspessura() {
        return espessura;
    }

    public void setDirecao(int direcao) {
        this.direcao = direcao;
    }

    public void setPosicao(int x, int y) {
        this.x = x;
        this.y = y;
        if(this.direcao == HORIZONTAL){
            this.y+= espessura;
        }
        else{
            this.x+=espessura*4;
        }
        this.progressoX = x;
        this.progressoY = y;

    }

    public boolean isTerminou() {
        return terminou;
    }

    @Override
    public void reiniciar() {

    }

    @Override
    public void atualizarPosicoes(double intervalo) {

    }

    @Override
    public void desenhar(Canvas canvas) {
        switch (direcao){
            case HORIZONTAL:
                if(progressoX <= getPixelX()*4) {
                    progressoX += 10;
                    progressoY -= .5;
                }
                else
                    terminou = true;
                break;
            case VERTICAL:
                if(progressoY <= getPixelY()*5) {
                    progressoY += 10;
                    progressoX -= .18;
                }
                else
                    terminou = true;
                break;
        }
        canvas.drawLine(x, y, progressoX, progressoY, getArte());
    }


}
