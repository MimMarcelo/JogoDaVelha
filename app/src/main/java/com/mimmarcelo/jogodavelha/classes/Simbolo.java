package com.mimmarcelo.jogodavelha.classes;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;

public class Simbolo extends BaseObjeto {

    private int idImagem[];
    private int idMarcado;
    private int esquerda;
    private int topo;
    private int deslocamento;

    public Simbolo(Context context, int larguraDaTela, int alturaDaTela) {
        super(context, larguraDaTela, alturaDaTela);
        deslocamento = getPixelX()/15;
        idImagem = new int[3];
        idMarcado = 2;
    }

    public void setIdImagem(int idVazio, int idX, int idO) {
        idMarcado = idVazio;
        this.idImagem[2] = idVazio;
        this.idImagem[1] = idX;
        this.idImagem[0] = idO;
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

    public boolean marcar(int idMarcador){
        if(idMarcado == idImagem[2]) {
            idMarcado = idMarcador;
            return true;
        }
        return false;
    }

    public int getIdMarcado(){
        return idMarcado;
    }

    @Override
    public void reiniciar() {

    }

    @Override
    public void atualizarPosicoes(double intervalo) {

    }

    @Override
    public void desenhar(Canvas canvas) {
        canvas.drawBitmap(BitmapFactory.decodeResource(getContext().getResources(), idMarcado), esquerda, topo, getArte());
    }

}
