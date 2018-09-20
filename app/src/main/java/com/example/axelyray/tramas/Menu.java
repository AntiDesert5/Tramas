package com.example.axelyray.tramas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity implements View.OnClickListener {
    public Button ButtonCRC,ButtonHDLC;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        ButtonCRC = (Button)findViewById(R.id.BottonCRC);
        ButtonHDLC = (Button)findViewById(R.id.BottonHDLC);

        ButtonCRC.setOnClickListener(this);
        ButtonHDLC.setOnClickListener(this);
    }

    public void onClick(View control_pulsado) {
        switch (control_pulsado.getId()){
            case R.id.BottonCRC:
                ButtonCRC.setText("funciona");
                Intent intent = new Intent(Menu.this,MainActivity.class);
                startActivity(intent);
                break;
            case R.id.BottonHDLC:
                ButtonHDLC.setText("Funciona 2");
                Intent intent2 = new Intent(Menu.this,TramaHDLC.class);
                startActivity(intent2);
                break;
        }
    }
}
