package com.example.axelyray.tramas;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class trama802 extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trama802);
        Button Aceptar = (Button) findViewById(R.id.Aceptar1);
        Aceptar.setOnClickListener(this);
    }

    boolean checaTFCRC(View view, EditText IngETX, String DatETX) {
        for (int j = 0; j < IngETX.length(); j++) {
            if (DatETX.toCharArray()[j] == '1' || DatETX.toCharArray()[j] == '0') {
                //showSnackBar(valorView,"Por favor introduzca solo ceros y unos");

                System.out.println("Iteracion: " + j);
                if (j + 1 == IngETX.length()) {
                    return true;
                }
            }
        }

        Snackbar.make(view, "Por favor introdusca solo ceros y unos", Snackbar.LENGTH_LONG)
                .show();
        return false;
    }

    public String BinCRC(View view) {
        String val = " ";
        EditText IngSYN = (EditText) findViewById(R.id.IngCRC8);
        String DatSYN = IngSYN.getText().toString();
        boolean a = checaTFCRC(view, IngSYN, DatSYN);
        if (IngSYN.getText().toString().length() == 4) {
            if (a) {
                int dec = Integer.parseInt(DatSYN, 2);
                val = Integer.toHexString(dec).toUpperCase();
            } else {
                val = "00";
            }
        } else {
            IngSYN.setText("0000");
        }
        return val;
    }

    public String BinDire4(View view) {
        String val = " ";
        EditText IngSYN = (EditText) findViewById(R.id.IngDireccion4);
        String DatSYN = IngSYN.getText().toString();
        boolean a = checaTFCRC(view, IngSYN, DatSYN);
        if (IngSYN.getText().toString().length() == 6) {
            if (a) {
                int dec = Integer.parseInt(DatSYN, 2);
                val = Integer.toHexString(dec).toUpperCase();
            } else {
                val = "00";
            }
        } else {
            IngSYN.setText("000000");
        }
        return val;
    }

    public String BinContSecu(View view) {
        String val = " ";
        EditText IngSYN = (EditText) findViewById(R.id.IngContSec);
        String DatSYN = IngSYN.getText().toString();
        boolean a = checaTFCRC(view, IngSYN, DatSYN);
        if (IngSYN.getText().toString().length() == 2) {
            if (a) {
                int dec = Integer.parseInt(DatSYN, 2);
                val = Integer.toHexString(dec).toUpperCase();
            } else {
                val = "00";
            }
        } else {
            IngSYN.setText("00");
        }
        return val;
    }

    public String BinDire3(View view) {
        String val = " ";
        EditText IngSYN = (EditText) findViewById(R.id.IngDireccion3);
        String DatSYN = IngSYN.getText().toString();
        boolean a = checaTFCRC(view, IngSYN, DatSYN);
        if (IngSYN.getText().toString().length() == 6) {
            if (a) {
                int dec = Integer.parseInt(DatSYN, 2);
                val = Integer.toHexString(dec).toUpperCase();
            } else {
                val = "00";
            }
        } else {
            IngSYN.setText("000000");
        }
        return val;
    }


    public void onClick(View view) {
        EditText ingConTrama = (EditText) findViewById(R.id.IngTramControl);
        EditText fname = (EditText) findViewById(R.id.fname);
        String ContSecu = BinContSecu(view);
        String Dir4 = BinDire4(view);
        String RCRC = BinCRC(view);
        fname.setText("Control de Secuencia: " + ContSecu + "\n" + "Direccion 4: " + Dir4 + "\n" + "CRC: " + RCRC);
    }
}
