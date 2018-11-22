package com.mimmarcelo.jogodavelha.classes;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.widget.Toast;

import com.mimmarcelo.jogodavelha.R;

public class Jogo {
    private Context context;
    private Paint background;
    private Paint textPaint;
    private String tempo;
    private boolean carregando;
    private int contador;
    private boolean fimDeJogo;
    private int ganhador;

    private Tabuleiro tabuleiro;
    private Simbolo simbolos[];
    private Barra barra;
    private Jogador jogadores[];

    public Jogo(Context context, Jogador jogador1, Jogador jogador2) {
        this.context = context;
        this.carregando = false;
        this.fimDeJogo = false;
        this.contador = 0;
        this.ganhador = 2;//Não existe essa posição na lista de jogadores, portanto ninguém ganhou ainda

        background = new Paint();
        background.setColor(Color.WHITE);

        textPaint = new Paint();

        jogadores = new Jogador[2];
        jogadores[0] = jogador1;
        jogadores[1] = jogador2;
    }

    public void configurarJanela(int altura, int largura) {
        tabuleiro = new Tabuleiro(context, largura, altura);
        barra = new Barra(context, largura, altura);
        simbolos = new Simbolo[9];
        contador = 0;

        for (int i = 0; i < 3; i++)
            for (int j = 0; j < 3; j++) {
                Simbolo simbolo = new Simbolo(context, largura, altura);
                simbolo.setIdImagem(R.drawable.vazio, R.drawable.x, R.drawable.o);
                simbolo.setPosicao(i + 1, j + 2);
                simbolos[contador++] = simbolo;
            }

        contador = 0;
        textPaint.setTextSize(largura / 20);
        textPaint.setAntiAlias(true);
    }

    public Jogador getGanhador(){
        if(ganhador < 2)
            return jogadores[ganhador];

        return null;
    }
    public boolean isFimDeJogo() {
        return fimDeJogo;
    }

    public void setFimDeJogo() {

        contador++;
        if (simbolos[0].getIdMarcado() != R.drawable.vazio && simbolos[0].getIdMarcado() == simbolos[1].getIdMarcado() && simbolos[0].getIdMarcado() == simbolos[2].getIdMarcado()) {
            fimDeJogo = true;
            ganhador = (contador-1)%2;
            barra.setDirecao(Barra.VERTICAL);
            barra.setPosicao(barra.getPixelX() * 1.4f, barra.getPixelY() * 2);
        } else if (simbolos[0].getIdMarcado() != R.drawable.vazio && simbolos[0].getIdMarcado() == simbolos[3].getIdMarcado() && simbolos[0].getIdMarcado() == simbolos[6].getIdMarcado()) {
            fimDeJogo = true;
            ganhador = (contador-1)%2;
            barra.setDirecao(Barra.HORIZONTAL);
            barra.setPosicao(barra.getPixelX() * 1, barra.getPixelY() * 2.4f);
        } else if (simbolos[0].getIdMarcado() != R.drawable.vazio && simbolos[0].getIdMarcado() == simbolos[4].getIdMarcado() && simbolos[0].getIdMarcado() == simbolos[8].getIdMarcado()) {
            fimDeJogo = true;
            ganhador = (contador-1)%2;
            barra.setDirecao(Barra.DIAGONAL1);
            barra.setPosicao(barra.getPixelX() * 1, barra.getPixelY() * 2);
        } else if (simbolos[1].getIdMarcado() != R.drawable.vazio && simbolos[1].getIdMarcado() == simbolos[4].getIdMarcado() && simbolos[1].getIdMarcado() == simbolos[7].getIdMarcado()) {
            fimDeJogo = true;
            ganhador = (contador-1)%2;
            barra.setDirecao(Barra.HORIZONTAL);
            barra.setPosicao(barra.getPixelX() * 1, barra.getPixelY() * 3.4f);
        } else if (simbolos[2].getIdMarcado() != R.drawable.vazio && simbolos[2].getIdMarcado() == simbolos[5].getIdMarcado() && simbolos[2].getIdMarcado() == simbolos[8].getIdMarcado()) {
            fimDeJogo = true;
            ganhador = (contador-1)%2;
            barra.setDirecao(Barra.HORIZONTAL);
            barra.setPosicao(barra.getPixelX() * 1, barra.getPixelY() * 4.4f);
        } else if (simbolos[2].getIdMarcado() != R.drawable.vazio && simbolos[2].getIdMarcado() == simbolos[4].getIdMarcado() && simbolos[2].getIdMarcado() == simbolos[6].getIdMarcado()) {
            fimDeJogo = true;
            ganhador = (contador-1)%2;
            barra.setDirecao(Barra.DIAGONAL2);
            barra.setPosicao(barra.getPixelX() * 1, barra.getPixelY() * 5);
        } else if (simbolos[3].getIdMarcado() != R.drawable.vazio && simbolos[3].getIdMarcado() == simbolos[4].getIdMarcado() && simbolos[3].getIdMarcado() == simbolos[5].getIdMarcado()) {
            fimDeJogo = true;
            ganhador = (contador-1)%2;
            barra.setDirecao(Barra.VERTICAL);
            barra.setPosicao(barra.getPixelX() * 2.4f, barra.getPixelY() * 2);
        } else if (simbolos[6].getIdMarcado() != R.drawable.vazio && simbolos[6].getIdMarcado() == simbolos[7].getIdMarcado() && simbolos[6].getIdMarcado() == simbolos[8].getIdMarcado()) {
            fimDeJogo = true;
            ganhador = (contador-1)%2;
            barra.setDirecao(Barra.VERTICAL);
            barra.setPosicao(barra.getPixelX() * 3.4f, barra.getPixelY() * 2);
        } else if (contador == 9)
            fimDeJogo = true;
    }

    public void novoJogo() {

    }

    public void realizarJogada(float x, float y) {
        if (!carregando && !fimDeJogo) {
            carregando = true;
            int daVez = contador%2;

            int quadro = tabuleiro.getQuadro(x, y);

            if (jogadores[daVez].jogar(simbolos, quadro)) {
                setFimDeJogo();
                daVez = contador%2;
                if(!isFimDeJogo() && jogadores[daVez] instanceof Npc){
                    jogadores[daVez].jogar(simbolos, 0);
                    setFimDeJogo();
                }
            }
            carregando = false;
        }
        if (fimDeJogo) {
            Toast.makeText(context, "O Joguinho acabou!", Toast.LENGTH_SHORT).show();
        }
    }

    public void setTempo(String tempo) {
        this.tempo = tempo;
    }

    public void desenhar(Canvas canvas) {
        canvas.drawRect(0, 0, canvas.getWidth(), canvas.getHeight(), background);
        canvas.drawText(tempo, 30, 50, textPaint);
        canvas.drawText("Vez do jogador: "+jogadores[contador%2].getNome(), 30, 80, textPaint);
        tabuleiro.desenhar(canvas);
        for (Simbolo simbolo : simbolos) {
            simbolo.desenhar(canvas);
        }
    }

    public boolean desenharFimDeJogo(Canvas canvas) {
        String textoDeFimDeJogo = "";
        if(getGanhador() == null){
            textoDeFimDeJogo = "Empatou...";
            canvas.drawText(textoDeFimDeJogo, 30, 120, textPaint);
            return false;
        }
        else {
            textoDeFimDeJogo = jogadores[ganhador].getNome() + " é o vencedor!";
            canvas.drawText(textoDeFimDeJogo, 30, 120, textPaint);
            barra.desenhar(canvas);
            return !barra.isTerminou();
        }
    }
}
