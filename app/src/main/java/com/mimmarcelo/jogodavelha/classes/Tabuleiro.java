package com.mimmarcelo.jogodavelha.classes;

import android.content.Context;
import android.graphics.Canvas;

public class Tabuleiro extends BaseObjeto {

    private Barra barras[];

    public Tabuleiro(Context context, int larguraDaTela, int alturaDaTela) {
        super(context, larguraDaTela, alturaDaTela);
        barras = new Barra[4];
        for(int i = 0; i < 4; i++){
            barras[i] = new Barra(context, larguraDaTela, alturaDaTela);
            if(i < 2) {
                barras[i].setDirecao(Barra.HORIZONTAL);
                barras[i].setPosicao(getPixelX(), getPixelY()*(i+3));
            }
            else{
                barras[i].setDirecao(Barra.VERTICAL);
                barras[i].setPosicao(getPixelX()*i, getPixelY()*2);
            }
        }
    }

    public int getQuadro(float x, float y){
        int quadro = -1;
        for(int i = 0; i < 3; i++)
            for(int j = 0; j < 3; j++) {
                if ((x >= getPixelX() * (i + 1) && x < getPixelX() * (i + 2)) &&
                        (y >= getPixelY() * (j + 2) && y < getPixelY() * (j + 3))){
                    return ++quadro;
                }
                quadro++;
            }
        return -1;
    }
    @Override
    public void reiniciar() {

    }

    @Override
    public void atualizarPosicoes(double intervalo) {

    }

    @Override
    public void desenhar(Canvas canvas) {
        for(Barra b: barras)
            b.desenhar(canvas);
    }
}
