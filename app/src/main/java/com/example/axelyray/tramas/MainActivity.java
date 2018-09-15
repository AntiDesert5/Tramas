package com.example.axelyray.tramas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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

    public void BinCRC(){
        EditText IngCRC=(EditText)findViewById(R.id.IngCRC);
        if(IngCRC.getText().toString().length()==16) {
            char [] arrCRC=IngCRC.getText().toString().toCharArray();
                String DatCRC = IngCRC.getText().toString();
                //opbinario
                int dec = Integer.parseInt(DatCRC, 2);
                String val = Integer.toHexString(dec).toUpperCase();
                System.out.println("HEXADECIMAL12: " + val);
                System.out.println("Funciona");
        }
        else{
            IngCRC.setText("0000000000000000");
        }
    }

    public void BinETX(){
        EditText IngETX=(EditText)findViewById(R.id.IngETX);
        if(IngETX.getText().toString().length()==8) {
                String DatETX = IngETX.getText().toString();
                //opBinario
                int dec = Integer.parseInt(DatETX, 2);
                String val = Integer.toHexString(dec).toUpperCase();
                System.out.println("HEXADECIMAL11: " + val);

        }else{
            IngETX.setText("00000000");
        }
    }

    public String BinCabecera(){
        EditText IngCabecera=(EditText)findViewById(R.id.IngCabecera);
        String DatCabecera=IngCabecera.getText().toString();
        //opBinario
        int dec=Integer.parseInt(DatCabecera,2);
        String val=Integer.toHexString(dec).toUpperCase();
        System.out.println("HEXADECIMAL11: "+val);
        return val;
    }

    public String BinSYN(){
        EditText IngSYN=(EditText)findViewById(R.id.SYN);
        String DatSYN=IngSYN.getText().toString();
        //opBinario
        int dec=Integer.parseInt(DatSYN,2);
        String val=Integer.toHexString(dec).toUpperCase();
        System.out.println("HEXADECIMAL11: "+val);
        return val;
    }

    public String BinSOH(){
        EditText IngSOH=(EditText)findViewById(R.id.IngSOH);
        String DatSOH=IngSOH.getText().toString();
        //opBinario
        int dec=Integer.parseInt(DatSOH,2);
        String val=Integer.toHexString(dec).toUpperCase();
        System.out.println("HEXADECIMAL11: "+val);
        return val;
    }

    public String BinSTX(){
        EditText IngSTX=(EditText)findViewById(R.id.IngSTX);
        String DatSTX=IngSTX.getText().toString();
        //opBinario
        int dec=Integer.parseInt(DatSTX,2);
        String val=Integer.toHexString(dec).toUpperCase();
        System.out.println("HEXADECIMAL11: "+val);
        return  val;
    }

    @Override
    public void onClick(View view) {
        int a[];

        String Arrtotal[];

        EditText MostValor= (EditText)findViewById(R.id.MostValor);
        EditText MostValor2 =(EditText)findViewById(R.id.MostValor2);
        EditText MostValor3 =(EditText)findViewById(R.id.MostValor3);
        EditText IngValor = (EditText)findViewById(R.id.IngValor);

        if(IngValor.getText().toString().isEmpty()){
            IngValor.setText("Ingrese Frase");
        }else {
            BinCRC();
            BinETX();
            String RCabecera=BinCabecera();
            String RBinSYN =BinSYN();
            String RSOH =BinSOH();
            String RSTX =BinSTX();

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

            for (int i = 0; i < tam; i++) {
                System.out.print(Arrtotal[i]);


            }

            String ga =Arrays.toString(Arrtotal);

            System.out.println("Arreglo total: "+Arrays.toString(Arrtotal));
            MostValor.setText("Valor de STX: "+RSTX+"\n\t"+"Valor de SOH: "+RSOH+"\n");
            MostValor2.setText("Valor de SYN: "+RBinSYN+"\n"+"Valor de Cabecera: "+RCabecera);
            MostValor3.setText("Texto:"+ga);
            cade = null;

        }
    }

}
