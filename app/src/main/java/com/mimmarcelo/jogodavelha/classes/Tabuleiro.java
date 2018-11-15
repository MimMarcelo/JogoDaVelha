package com.mimmarcelo.jogodavelha.classes;

import android.graphics.Canvas;

public class Tabuleiro extends BaseObjeto {

    public Tabuleiro(int alturaDaTela, int larguraDaTela) {
        super(alturaDaTela, larguraDaTela);
        getArte().setStrokeWidth(getPixelX()/10);
    }

    @Override
    public void reiniciar() {

    }

    @Override
    public void atualizarPosicoes(double intervalo) {

    }

    @Override
    public void desenhar(Canvas canvas) {
        canvas.drawLine(getPixelX()*1, getPixelY()*3, getPixelX()*4, getPixelY()*3, getArte());
        canvas.drawLine(getPixelX()*1, getPixelY()*4, getPixelX()*4, getPixelY()*4, getArte());
        canvas.drawLine(getPixelX()*2, getPixelY()*2, getPixelX()*2, getPixelY()*5, getArte());
        canvas.drawLine(getPixelX()*3, getPixelY()*2, getPixelX()*3, getPixelY()*5, getArte());
    }
}
