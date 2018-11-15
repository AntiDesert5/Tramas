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
        if (DatSYN.isEmpty()) {
            val = "000000000000";
        }
        val = DatSYN;


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
        if (DatSYN.isEmpty()) {
            val = "000000000000";
        }
        val = DatSYN;


        return val;
    }

    public String BinDire2(View view) {
        String val = " ";
        EditText IngSYN = (EditText) findViewById(R.id.IngDireccion2);
        String DatSYN = IngSYN.getText().toString();
        if (DatSYN.isEmpty()) {
            val = "000000000000";
        }
        val = DatSYN;
        return val;
    }

    public String BinDire(View view) {
        String val = " ";
        EditText IngSYN = (EditText) findViewById(R.id.IngDireccion);
        String DatSYN = IngSYN.getText().toString();
        if (DatSYN.isEmpty()) {
            val = "000000000000";
        }
        val = DatSYN;


        return val;
    }

    public String BinDuracion(View view) {
        String val = " ";
        EditText IngSYN = (EditText) findViewById(R.id.IngDuracion);
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

    public String BinControl(View view) {
        String val = " ";
        EditText IngSYN = (EditText) findViewById(R.id.IngTramControl);
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


    public void onClick(View view) {
        int a[];
        String Arrtotal[];
        EditText ingConTrama = (EditText) findViewById(R.id.IngTramControl);
        EditText RES = (EditText) findViewById(R.id.RES);
        EditText fname = (EditText) findViewById(R.id.fname);
        EditText IngValor = (EditText) findViewById(R.id.IngMensajeCodificar);
        String ContSecu = BinContSecu(view);
        String datosArray = "";
        String Dir4 = BinDire4(view);
        String RCRC = BinCRC(view);
        String Dir3 = BinDire3(view);
        String Dir2 = BinDire2(view);
        String Dir = BinDire(view);
        String Duracion = BinDuracion(view);
        String Control = BinControl(view);


        if (IngValor.getText().toString().isEmpty()) {
            IngValor.setText("Ingrese Frase");
        } else {
            String cade = IngValor.getText().toString();
            int tam = cade.length();
            a = new int[tam];
            Arrtotal = new String[tam];

            for (int x = 0; x < cade.length(); x++) {
                int tamanio = IngValor.length();
                System.out.println(cade.charAt(x) + " = " + cade.codePointAt(x));
                int asc = cade.codePointAt(x);
                a[x] = asc;
                //ascci(asc,tamanio);
            }

            for (int i = 0; i < tam; i++) {
                int b = a[i];
                String hexa = Integer.toHexString(b).toUpperCase();
                Arrtotal[i] = hexa;
            }

            for (String elemento : Arrtotal) {
                datosArray += elemento + ",";
            }

            System.out.println(datosArray);
            for (int i = 0; i < tam; i++) {
                System.out.print(Arrtotal[i]);
            }
        }

        fname.setText("Datos: " + limpia(datosArray) + "\n" + "Control de Trama: " + Control + "\n" + "ID Duracion: " + Duracion + "\n" + "Direccion 1: " + Dir + "\n" + "Direccion 2: " + Dir2 + "\n" + "Direccion 3: " + Dir3 + "\n" + "Control de Secuencia: " + ContSecu + "\n" + "Direccion 4: " + Dir4 + "\n" + "CRC: " + RCRC);
        RES.setText("Trama: " + Control + Duracion + Dir + Dir2 + Dir3 + ContSecu + Dir4 + RCRC);
    }

    private static String limpia(String datosArray) {
        datosArray = datosArray.trim();
        if (datosArray != null && datosArray.length() > 0 && datosArray.charAt(datosArray.length() - 1) == ',') {
            datosArray = datosArray.substring(0, datosArray.length() - 1);
        }
        return datosArray;
    }
}
