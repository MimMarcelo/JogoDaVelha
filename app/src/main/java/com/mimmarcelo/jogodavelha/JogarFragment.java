package com.mimmarcelo.jogodavelha;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class JogarFragment extends Fragment {
    private JogoView jogoView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = super.onCreateView(inflater, container, savedInstanceState);

        jogoView = v.findViewById(R.id.jogoView);
//        jogoView.setTargetfragment(this);

        return v;
    }

    @Override
    public void onPause() {
        super.onPause();
        jogoView.parar();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        jogoView.liberarRecursos();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        jogoView.iniciar();
    }
}
