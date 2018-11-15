package com.mimmarcelo.jogodavelha;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnJogar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnJogar = findViewById(R.id.btnJogar);
        btnJogar.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Intent intent;
        if(v == btnJogar){
            intent = new Intent(MainActivity.this, JogoActivity.class);
            startActivity(intent);
        }
    }
}
