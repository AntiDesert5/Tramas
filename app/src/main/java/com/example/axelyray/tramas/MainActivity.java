package com.example.axelyray.tramas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

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
        String DatCRC=IngCRC.getText().toString();
        //opbinario
        int dec=Integer.parseInt(DatCRC,2);
        String val=Integer.toHexString(dec).toUpperCase();
        System.out.println("HEXADECIMAL11: "+val);
    }

    public void BinETX(){
        EditText IngETX=(EditText)findViewById(R.id.IngETX);
        String DatETX=IngETX.getText().toString();
        //opBinario
        int dec=Integer.parseInt(DatETX,2);
        String val=Integer.toHexString(dec).toUpperCase();
        System.out.println("HEXADECIMAL11: "+val);
    }

    public void BinCabecera(){
        EditText IngCabecera=(EditText)findViewById(R.id.IngCabecera);
        String DatCabecera=IngCabecera.getText().toString();
        //opBinario
        int dec=Integer.parseInt(DatCabecera,2);
        String val=Integer.toHexString(dec).toUpperCase();
        System.out.println("HEXADECIMAL11: "+val);
    }

    public void BinSYN(){
        EditText IngSYN=(EditText)findViewById(R.id.SYN);
        String DatSYN=IngSYN.getText().toString();
        //opBinario
        int dec=Integer.parseInt(DatSYN,2);
        String val=Integer.toHexString(dec).toUpperCase();
        System.out.println("HEXADECIMAL11: "+val);
    }

    public void BinSOH(){
        EditText IngSOH=(EditText)findViewById(R.id.IngSOH);
        String DatSOH=IngSOH.getText().toString();
        //opBinario
        int dec=Integer.parseInt(DatSOH,2);
        String val=Integer.toHexString(dec).toUpperCase();
        System.out.println("HEXADECIMAL11: "+val);
    }

    public void BinSTX(){
        EditText IngSTX=(EditText)findViewById(R.id.IngSTX);
        String DatSTX=IngSTX.getText().toString();
        //opBinario
        int dec=Integer.parseInt(DatSTX,2);
        String val=Integer.toHexString(dec).toUpperCase();
        System.out.println("HEXADECIMAL11: "+val);
    }

    @Override
    public void onClick(View view) {
        int a[];

        String Arrtotal[];

        EditText MostValor= (EditText)findViewById(R.id.MostValor);
        EditText IngValor = (EditText)findViewById(R.id.IngValor);


        BinCRC();
        BinETX();
        BinCabecera();
        BinSYN();
        BinSOH();
        BinSTX();

        String cade = IngValor.getText().toString();
        int tam=cade.length();
        a=new int[tam];
        Arrtotal=new String[tam];
        for (int x=0;x<cade.length();x++) {
            int tamanio=IngValor.length();
            System.out.println(cade.charAt(x) + " = " + cade.codePointAt(x));
            int asc = cade.codePointAt(x);
            a[x]=asc;
            //ascci(asc,tamanio);
        }

        for(int i=0;i<tam;i++){
            int b=a[i];
            String hexa=Integer.toHexString(b).toUpperCase();
            Arrtotal[i]=hexa;
        }

        for (int i=0;i<tam;i++){
            System.out.print(Arrtotal[i]);

        }
        String ga= String.valueOf(Arrtotal).toString();
        System.out.println("valor :"+ga);
        MostValor.setText(ga);
        cade=null;

    }
}
