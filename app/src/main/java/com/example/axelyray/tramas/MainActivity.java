package com.example.axelyray.tramas;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
        int i=0;
    String j;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button Aceptar = (Button)findViewById(R.id.Aceptar1);

        Aceptar.setOnClickListener(this);
    }


    boolean checaTFCRC(View view,EditText IngETX,String DatETX) {
        for (int j = 0; j < IngETX.length(); j++) {
            if (DatETX.toCharArray()[j]=='1'||DatETX.toCharArray()[j]=='0') {
                //showSnackBar(valorView,"Por favor introduzca solo ceros y unos");

                System.out.println("Iteracion: "+j);
                if(j+1==IngETX.length()){
                    return true;
                }
            }
        }

        Snackbar.make(view, "Por favor introdusca solo ceros y unos", Snackbar.LENGTH_LONG)
                .show();
        return false;
    }




    public String BinCRC(View view){
        String val=" ";
        EditText IngCRC=(EditText)findViewById(R.id.IngCRC);
        String DatCRC = IngCRC.getText().toString();
        boolean a=checaTFCRC(view,IngCRC,DatCRC);
        if(IngCRC.getText().toString().length()==16) {
            //
            if(a){
                int dec = Integer.parseInt(DatCRC, 2);
                val = Integer.toHexString(dec).toUpperCase();
                System.out.println("Funciona");
            }else{
                val="00";
            }
        }
        else{
            IngCRC.setText("0000000000000000");
        }
        return val;
    }

    boolean checaTF(View view,EditText IngETX,String DatETX) {
        for (int j = 0; j < IngETX.length(); j++) {
                if (DatETX.toCharArray()[j]=='1'||DatETX.toCharArray()[j]=='0') {
                    //showSnackBar(valorView,"Por favor introduzca solo ceros y unos");

                    System.out.println("Iteracion: "+j);
                    if(j+1==IngETX.length()){
                        return true;
                    }
                }
        }

        Snackbar.make(view, "Por favor introdusca solo ceros y unos", Snackbar.LENGTH_LONG)
                .show();
        return false;
    }

    public String BinETX(View view){
        String val=" ";
        String cade;
        EditText IngETX=(EditText)findViewById(R.id.IngETX);
        String DatETX = IngETX.getText().toString();
        boolean a=checaTF(view,IngETX,DatETX);
        if(IngETX.getText().toString().length()==8) {
            if (a) {
                int dec = Integer.parseInt(DatETX, 2);
                val = Integer.toHexString(dec).toUpperCase();
                System.out.println("Valores buenos: " + val);
            } else {
                val = "00";
            }
        }else {
            IngETX.setText("00000000");
        }
        //opBinario
        return val;
    }

    public String BinCabecera(View view){
        //System.out.println("HEXADECIMAL11: "+val);
        String val=" ";
        EditText IngCabecera=(EditText)findViewById(R.id.IngCabecera);
        String DatCabecera=IngCabecera.getText().toString();
        boolean a=checaTFCRC(view,IngCabecera,DatCabecera);
        if(IngCabecera.getText().toString().length()==8) {
            //
            if(a){
                int dec = Integer.parseInt(DatCabecera, 2);
                val = Integer.toHexString(dec).toUpperCase();
                System.out.println("Funciona");
            }else{
                val="00";
            }
        }
        else{
            IngCabecera.setText("00000000");
        }
        return val;
    }

    public String BinSYN(View view){
        String val=" ";
        EditText IngSYN=(EditText)findViewById(R.id.SYN);
        String DatSYN=IngSYN.getText().toString();
        boolean a=checaTFCRC(view,IngSYN,DatSYN);
        if(IngSYN.getText().toString().length()==8) {
            if(a){
                int dec = Integer.parseInt(DatSYN, 2);
                val = Integer.toHexString(dec).toUpperCase();
                System.out.println("Funciona");
            }else{
                val="00";
            }
        }
        else{
            IngSYN.setText("00000000");
        }
        return val;
    }

    public String BinSOH(View view){
        String val=" ";
        EditText IngSOH=(EditText)findViewById(R.id.IngSOH);
        String DatSOH=IngSOH.getText().toString();
        boolean a=checaTFCRC(view,IngSOH,DatSOH);
        if(IngSOH.getText().toString().length()==8) {
            if(a){
                int dec = Integer.parseInt(DatSOH, 2);
                val = Integer.toHexString(dec).toUpperCase();
                System.out.println("Funciona");
            }else{
                val="00";
            }
        }
        else{
            IngSOH.setText("00000000");
        }
        return val;
    }

    public String BinSTX(View view){
        ////*********
        String val=" ";
        EditText IngSTX=(EditText)findViewById(R.id.IngSTX);
        String DatSTX=IngSTX.getText().toString();
        boolean a=checaTFCRC(view,IngSTX,DatSTX);
        if(IngSTX.getText().toString().length()==8) {
            if(a){
                int dec = Integer.parseInt(DatSTX, 2);
                val = Integer.toHexString(dec).toUpperCase();
            }else{
                val="00";
            }
        }
        else{
            IngSTX.setText("00000000");
        }
        return val;
        //**********

    }

    @Override
    public void onClick(View view) {
        int a[];

        String Arrtotal[];

        TextView MostValor= (TextView) findViewById(R.id.MostValor);
        TextView MostValor2 =(TextView) findViewById(R.id.MostValor2);
        TextView MostValor3 =(TextView) findViewById(R.id.MostValor3);
        TextView MostValor4 =(TextView) findViewById(R.id.MostValor4);
        TextView MostValor5 =(TextView) findViewById(R.id.MostValor5);
        EditText IngValor = (EditText)findViewById(R.id.IngValor);

        if(IngValor.getText().toString().isEmpty()){
            IngValor.setText("Ingrese Frase");
        }else {
            String RCRC=BinCRC(view);
            //BinETX(view);
            String RETX=BinETX(view);
            String RCabecera=BinCabecera(view);
            String RBinSYN =BinSYN(view);
            String RSOH =BinSOH(view);
            String RSTX =BinSTX(view);

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
            String datosArray = "";
            for (String elemento: Arrtotal) {
                datosArray += elemento + ",";
            }


            System.out.println(datosArray);
            for (int i = 0; i < tam; i++) {
                System.out.print(Arrtotal[i]);

            }

            String ga =Arrays.toString(Arrtotal);

            System.out.println("Arreglo total: "+Arrays.toString(Arrtotal));

            MostValor.setText("Valor de SYN: "+RBinSYN+"\n"+" Valor de SOH: "+RSOH);
            MostValor2.setText(" Valor de Cabecera: "+RCabecera+"Valor de STX: "+RSTX+"\n");
            MostValor3.setText("Texto: "+limpia(datosArray)+"\n "+" Valor de ETX: "+RETX);
            MostValor4.setText("Valor CRC:  "+ RCRC);
            String to=RBinSYN+","+RSOH+","+RCabecera+","+RSTX+","+limpia(datosArray)+","+RETX+","+RCRC;
            System.out.println(RBinSYN+","+RSOH+","+RCabecera+","+RSTX+","+limpia(datosArray)+","+RETX+","+RCRC);
            MostValor5.setText("Trama: "+to);
            cade = null;

        }
    }

    private static String limpia(String datosArray){
        datosArray = datosArray.trim();
        if (datosArray != null && datosArray.length() > 0 && datosArray.charAt(datosArray.length() - 1) == ',') {
            datosArray = datosArray.substring(0, datosArray.length() - 1);
        }
        return datosArray;
    }
}
