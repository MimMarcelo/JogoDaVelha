package com.mimmarcelo.jogodavelha;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import com.mimmarcelo.jogodavelha.classes.Jogador;
import com.mimmarcelo.jogodavelha.classes.Jogo;
import com.mimmarcelo.jogodavelha.classes.JogoThread;
import com.mimmarcelo.jogodavelha.classes.Npc;

/**
 * TODO: document your custom view class.
 */
public class JogoView extends SurfaceView implements SurfaceHolder.Callback {

    private Jogo jogo;
    private JogoThread thread;
    private AppCompatActivity activity;

    public JogoView(Context context, AttributeSet attrs) {
        super(context, attrs);
        activity = (AppCompatActivity)context;
        getHolder().addCallback(this);

        Jogador j1 = new Jogador();
        j1.setNome("Marcelo");
        j1.setIdSimbolo(R.drawable.x);
        Jogador j2 = new Npc();
        j2.setIdSimbolo(R.drawable.o);
        jogo = new Jogo(context, j1, j2);

    }

    public void iniciar(){
        thread = new JogoThread(getHolder(), jogo);
        thread.setRodando(true);
        thread.start();
    }

    public void parar(){
        if(thread != null)
            thread.setRodando(false);
    }

    public void liberarRecursos(){

    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        jogo.configurarJanela(h, w);

    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        iniciar();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        boolean retry = true;
        thread.setRodando(false);

        while (retry){
            try {
                thread.join();
                retry = false;
            }
            catch (InterruptedException e){
                Log.e("JogoView", "Thread interrompida", e);
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if(event.getAction() == MotionEvent.ACTION_DOWN)
            jogo.realizarJogada(event.getX(), event.getY());
        return true;
    }
}
