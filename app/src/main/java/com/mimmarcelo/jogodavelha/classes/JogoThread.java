package com.mimmarcelo.jogodavelha.classes;

import android.graphics.Canvas;
import android.util.Log;
import android.view.SurfaceHolder;

public class JogoThread extends Thread {

    private boolean rodando;
    private double segundos;
    private SurfaceHolder holder;
    private Jogo jogo;

    public JogoThread(SurfaceHolder holder, Jogo jogo) {
        setName("Thread do Jogo");
        this.segundos = 0;
        this.holder = holder;
        this.jogo = jogo;
    }

    public void setRodando(boolean rodando) {
        this.rodando = rodando;
    }

    @Override
    public void run() {
        Canvas canvas = null;
        long horaDoUltimoFrame = System.currentTimeMillis();
        long horaAtual = 0;
        double tempoPassado = 0;

        while(rodando){
            try{
                canvas = holder.lockCanvas();

                synchronized (holder){
                    horaAtual = System.currentTimeMillis();
                    tempoPassado = horaAtual - horaDoUltimoFrame;
                    segundos += tempoPassado / 1000;
                    jogo.setTempo(String.format("Tempo restante: %1$.1fs", segundos));
                    jogo.desenhar(canvas);

                    Log.i(getName(), String.format("Segundos: %1$.1f", segundos));
                    horaDoUltimoFrame = horaAtual;
                }
            }
            catch (Exception e){
                Log.e(getName(), "Erro não verificado...", e);
            }
            finally {
                if(canvas != null)
                    holder.unlockCanvasAndPost(canvas);
            }
        }
    }
}
