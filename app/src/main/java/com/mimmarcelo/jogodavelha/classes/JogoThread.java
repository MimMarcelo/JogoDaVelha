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

        while(rodando){
            try{
                canvas = holder.lockCanvas();

                synchronized (holder){
                    segundos += (System.currentTimeMillis() - horaDoUltimoFrame) / 1000;
                    jogo.desenhar(canvas);
                    if(segundos > 10)
                        rodando = false;

                    Log.i(getName(), String.format("Segundos: %1$.1f", segundos));
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
