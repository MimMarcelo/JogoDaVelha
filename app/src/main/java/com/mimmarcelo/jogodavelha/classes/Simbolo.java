package com.mimmarcelo.jogodavelha.classes;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

public class Simbolo extends BaseObjeto {

    private int idImagem;
    private int esquerda;
    private int topo;
    private int deslocamento;

    public Simbolo(Context context, int larguraDaTela, int alturaDaTela) {
        super(context, larguraDaTela, alturaDaTela);
        deslocamento = getPixelX()/15;
    }

    public void setIdImagem(int idImagem) {
        this.idImagem = idImagem;
    }

    public void setPosicao(int esquerda, int topo) {
        this.esquerda = getPixelX()*esquerda+deslocamento*3;
        this.topo = getPixelY()*topo+deslocamento+deslocamento;
        if(esquerda <= 1) {
            this.topo += deslocamento;
        }
        if(esquerda <= 2)
            this.topo += deslocamento;
        if(topo <= 2)
            this.esquerda += deslocamento;
        if(topo <= 3)
            this.esquerda += deslocamento;
    }

    @Override
    public void reiniciar() {

    }

    @Override
    public void atualizarPosicoes(double intervalo) {

    }

    @Override
    public void desenhar(Canvas canvas) {
        canvas.drawBitmap(BitmapFactory.decodeResource(getContext().getResources(), idImagem), esquerda, topo, getArte());
    }
}
