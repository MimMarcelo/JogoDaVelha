package com.mimmarcelo.jogodavelha.classes;

import java.util.ArrayList;

public class Npc extends Jogador {
    public Npc() {
        setNome("NPC");
    }

    @Override
    public boolean jogar(Simbolo[] simbolos, int quadro) {
        /*
        //Fácil
        for(int i = 0; i < 9; i++)
            if (simbolos[i].marcar(getIdSimbolo()))
                return true;
                */
//        ArrayList<Integer> jogador = new ArrayList<>();
        ArrayList<Integer> npc = new ArrayList<>();

        for(int i = 0; i < 9; i++){
            if(simbolos[quadro].getIdMarcado() == getIdSimbolo())
                npc.add(i);
//            else
//                jogador.add(i);
        }

        if(npc.contains(0) && npc.contains(1)){
            if(simbolos[2].marcar(getIdSimbolo())) return true;
        }
        if(npc.contains(0) && npc.contains(2)){
            if(simbolos[1].marcar(getIdSimbolo())) return true;
        }
        if(npc.contains(0) && npc.contains(3)){
            if(simbolos[6].marcar(getIdSimbolo())) return true;
        }
        if(npc.contains(0) && npc.contains(6)){
            if(simbolos[3].marcar(getIdSimbolo())) return true;
        }
        if(npc.contains(0) && npc.contains(4)){
            if(simbolos[8].marcar(getIdSimbolo())) return true;
        }
        if(npc.contains(0) && npc.contains(8)){
            if(simbolos[4].marcar(getIdSimbolo())) return true;
        }
        if(npc.contains(1) && npc.contains(4)){
            if(simbolos[7].marcar(getIdSimbolo())) return true;
        }
        if(npc.contains(1) && npc.contains(7)){
            if(simbolos[4].marcar(getIdSimbolo())) return true;
        }
        if(npc.contains(2) && npc.contains(5)){
            if(simbolos[8].marcar(getIdSimbolo())) return true;
        }
        if(npc.contains(2) && npc.contains(8)){
            if(simbolos[5].marcar(getIdSimbolo())) return true;
        }
        if(npc.contains(2) && npc.contains(6)){
            if(simbolos[4].marcar(getIdSimbolo())) return true;
        }
        if(npc.contains(2) && npc.contains(4)){
            if(simbolos[6].marcar(getIdSimbolo())) return true;
        }
        if(npc.contains(3) && npc.contains(4)){
            if(simbolos[5].marcar(getIdSimbolo())) return true;
        }
        if(npc.contains(3) && npc.contains(5)){
            if(simbolos[4].marcar(getIdSimbolo())) return true;
        }
        if(npc.contains(6) && npc.contains(7)){
            if(simbolos[8].marcar(getIdSimbolo())) return true;
        }
        if(npc.contains(6) && npc.contains(8)){
            if(simbolos[7].marcar(getIdSimbolo())) return true;
        }

        //Fácil
        for(int i = 0; i < 9; i++)
            if (simbolos[i].marcar(getIdSimbolo()))
                return true;

        return false;
    }
}
