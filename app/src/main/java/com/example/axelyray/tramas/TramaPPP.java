package com.example.axelyray.tramas;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class TramaPPP extends AppCompatActivity implements View.OnClickListener {
    Spinner datos;
    ValorSpinner SpinerVal = new ValorSpinner();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trama_ppp);
        //crea spinner
        datos = (Spinner) findViewById(R.id.Spinnerdatos);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource
                (this, R.array.datos, android.R.layout.simple_spinner_item);// createFromResource() te permite crear un
        // ArrayAdapter a partir de la matriz de strings.

        datos.setAdapter(adapter);

        SpinerVal.valores(datos);

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

    public String BinDireccion(View view) {
        String val = " ";
        EditText IngSYN = (EditText) findViewById(R.id.IngDireccion);
        String DatSYN = IngSYN.getText().toString();
        boolean a = checaTFCRC(view, IngSYN, DatSYN);
        if (IngSYN.getText().toString().length() == 8) {
            if (a) {
                int dec = Integer.parseInt(DatSYN, 2);
                val = Integer.toHexString(dec).toUpperCase();
                System.out.println("Funciona");
            } else {
                val = "00";
            }
        } else {
            IngSYN.setText("00000000");
        }
        return val;
    }

    public String BinControl(View view) {
        String val = " ";
        EditText IngSYN = (EditText) findViewById(R.id.IngControl);
        String DatSYN = IngSYN.getText().toString();
        boolean a = checaTFCRC(view, IngSYN, DatSYN);
        if (IngSYN.getText().toString().length() == 8) {
            if (a) {
                int dec = Integer.parseInt(DatSYN, 2);
                val = Integer.toHexString(dec).toUpperCase();
                System.out.println("Funciona");
            } else {
                val = "00";
            }
        } else {
            IngSYN.setText("00000000");
        }
        return val;
    }

    public String BinCRC(View view) {
        String val = " ";
        EditText IngSYN = (EditText) findViewById(R.id.IngDeteccion);
        String DatSYN = IngSYN.getText().toString();
        boolean a = checaTFCRC(view, IngSYN, DatSYN);
        if (IngSYN.getText().toString().length() == 16) {
            if (a) {
                int dec = Integer.parseInt(DatSYN, 2);
                val = Integer.toHexString(dec).toUpperCase();
                System.out.println("Funciona");
            } else {
                val = "00";
            }
        } else {
            IngSYN.setText("0000000000000000");
        }
        return val;
    }

    public void onClick(View view) {
        int a[];
        String Arrtotal[];
        String datosArray = "";
        String RDireccion = "";
        String RControl = "";
        String RError = "";

        TextView MostValor = (TextView) findViewById(R.id.MostValor);
        TextView MostValor2 = (TextView) findViewById(R.id.MostValor2);
        TextView MostVaSpinner = (TextView) findViewById(R.id.MostVaSpinner);
        TextView MostValor3 = (TextView) findViewById(R.id.MostValor3);
        TextView MostValor4 = (TextView) findViewById(R.id.MostValor4);
        TextView MostValor5 = (TextView) findViewById(R.id.MostValor5);
        EditText IngValor = (EditText) findViewById(R.id.IngValor);

        if (IngValor.getText().toString().isEmpty()) {
            IngValor.setText("Ingrese Frase");
        } else {
            RDireccion = BinDireccion(view);
            RControl = BinControl(view);
            RError = BinCRC(view);

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
        String valorSpinner = SpinerVal.valores(datos);
        MostValor.setText("Valor de Direccion: " + RDireccion);
        MostValor2.setText("Valor de Control: " + RControl);
        MostVaSpinner.setText("Valor de identificador: " + valorSpinner);
        System.out.println("Valor de Spinner: " + valorSpinner);
        MostValor3.setText("Valor de Texto: " + limpia(datosArray));
        MostValor4.setText("Valor de Error: " + RError);
        MostValor5.setText("Trama PPP: " + "7E" + "," + RDireccion + "," + RControl + "," + valorSpinner + "," + limpia(datosArray) + "," + RError + "," + "7E");
    }

    private static String limpia(String datosArray) {
        datosArray = datosArray.trim();
        if (datosArray != null && datosArray.length() > 0 && datosArray.charAt(datosArray.length() - 1) == ',') {
            datosArray = datosArray.substring(0, datosArray.length() - 1);
        }
        return datosArray;
    }
}
