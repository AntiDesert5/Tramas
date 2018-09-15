package com.example.axelyray.tramas;

import android.support.design.widget.Snackbar;
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
        if(a){
            int dec=Integer.parseInt(DatETX,2);
            val=Integer.toHexString(dec).toUpperCase();
            System.out.println("Valores buenos: "+val);
        }else{
            val="00";
        }
        //opBinario
        return val;
    }

    public String BinCabecera(){
        EditText IngCabecera=(EditText)findViewById(R.id.IngCabecera);
        String DatCabecera=IngCabecera.getText().toString();
        //opBinario
        int dec=Integer.parseInt(DatCabecera,2);
        String val=Integer.toHexString(dec).toUpperCase();
        //System.out.println("HEXADECIMAL11: "+val);
        return val;
    }

    public String BinSYN(){
        EditText IngSYN=(EditText)findViewById(R.id.SYN);
        String DatSYN=IngSYN.getText().toString();
        //opBinario
        int dec=Integer.parseInt(DatSYN,2);
        String val=Integer.toHexString(dec).toUpperCase();
        //System.out.println("HEXADECIMAL11: "+val);
        return val;
    }

    public String BinSOH(){
        EditText IngSOH=(EditText)findViewById(R.id.IngSOH);
        String DatSOH=IngSOH.getText().toString();
        //opBinario
        int dec=Integer.parseInt(DatSOH,2);
        String val=Integer.toHexString(dec).toUpperCase();
        //System.out.println("HEXADECIMAL11: "+val);
        return val;
    }

    public String BinSTX(){
        EditText IngSTX=(EditText)findViewById(R.id.IngSTX);
        String DatSTX=IngSTX.getText().toString();
        //opBinario
        int dec=Integer.parseInt(DatSTX,2);
        String val=Integer.toHexString(dec).toUpperCase();
        //System.out.println("HEXADECIMAL11: "+val);
        return  val;
    }

    @Override
    public void onClick(View view) {
        int a[];

        String Arrtotal[];

        EditText MostValor= (EditText)findViewById(R.id.MostValor);
        EditText MostValor2 =(EditText)findViewById(R.id.MostValor2);
        EditText MostValor3 =(EditText)findViewById(R.id.MostValor3);
        EditText MostValor4 =(EditText)findViewById(R.id.MostValor4);
        EditText IngValor = (EditText)findViewById(R.id.IngValor);

        if(IngValor.getText().toString().isEmpty()){
            IngValor.setText("Ingrese Frase");
        }else {
            String RCRC=BinCRC(view);
            //BinETX(view);
            String RETX=BinETX(view);
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
            MostValor3.setText("Texto:"+ga+"\n"+"valor de ETX: "+RETX);
            MostValor4.setText("Valor CRC:  "+ RCRC);

            cade = null;

        }
    }
}
