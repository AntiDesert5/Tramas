package com.example.axelyray.tramas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity implements View.OnClickListener {
    public Button ButtonCRC, ButtonHDLC, ButtonPPP, ButtonEthernet, Button802;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        ButtonCRC = (Button)findViewById(R.id.BottonCRC);
        ButtonHDLC = (Button)findViewById(R.id.BottonHDLC);
        ButtonPPP = (Button)findViewById(R.id.BottonPPP);
        ButtonEthernet = (Button) findViewById(R.id.ButtonEternet);
        Button802 = (Button) findViewById(R.id.Button802);

        ButtonCRC.setOnClickListener(this);
        ButtonHDLC.setOnClickListener(this);
        ButtonPPP.setOnClickListener(this);
        ButtonEthernet.setOnClickListener(this);
        Button802.setOnClickListener(this);
    }

    public void onClick(View control_pulsado) {
        switch (control_pulsado.getId()){
            case R.id.BottonCRC:
                Intent intent = new Intent(Menu.this,MainActivity.class);
                startActivity(intent);
                break;
            case R.id.BottonHDLC:
                Intent intent2 = new Intent(Menu.this,TramaHDLC.class);
                startActivity(intent2);
                break;
            case R.id.BottonPPP:
                Intent intent3 = new Intent(Menu.this,TramaPPP.class);
                startActivity(intent3);
                break;
            case R.id.ButtonEternet:
                Intent intent4 = new Intent(Menu.this, Enthernet.class);
                startActivity(intent4);
                break;
            case R.id.Button802:
                Intent intent5 = new Intent(Menu.this, trama802.class);
                startActivity(intent5);
                break;
        }
    }
}
