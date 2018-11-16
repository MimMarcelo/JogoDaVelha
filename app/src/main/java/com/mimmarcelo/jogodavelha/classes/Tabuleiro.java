package com.mimmarcelo.jogodavelha.classes;

import android.graphics.Canvas;

public class Tabuleiro extends BaseObjeto {

    private int espessura;

    public Tabuleiro(int alturaDaTela, int larguraDaTela) {
        super(alturaDaTela, larguraDaTela);
        this.espessura = getPixelX()/6;
        getArte().setStrokeWidth(espessura);
    }

    @Override
    public void reiniciar() {

    }

    @Override
    public void atualizarPosicoes(double intervalo) {

    }

    @Override
    public void desenhar(Canvas canvas) {
        //Linhas horizontais
        canvas.drawLine(getPixelX()*1, getPixelY()*3, getPixelX()*4, getPixelY()*3-espessura, getArte());
        canvas.drawLine(getPixelX()*1, getPixelY()*4, getPixelX()*4, getPixelY()*4-espessura, getArte());

        //Linhas verticais
        canvas.drawLine(getPixelX()*2+espessura, getPixelY()*2, getPixelX()*2, getPixelY()*5, getArte());
        canvas.drawLine(getPixelX()*3+espessura, getPixelY()*2, getPixelX()*3, getPixelY()*5, getArte());
    }
}
