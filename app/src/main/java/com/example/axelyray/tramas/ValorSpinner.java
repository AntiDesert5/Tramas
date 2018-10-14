package com.example.axelyray.tramas;

import android.widget.Spinner;

public class ValorSpinner {
    public String valores(Spinner spinner) {

        switch (spinner.getSelectedItemPosition()) {
            case 0://empieza desde 0
                return "0001";
            case 1:
                return "0021";
            case 2:
                return "0023";
            case 3:
                return "0025";
            case 4:
                return "0027";
            case 5:
                break;
            case 6:
                break;
            case 7:
                break;
            case 8:
                break;
            case 9:
                break;
            case 10:
                break;
            case 11:
                return;
            case 12:
                return;

        }
        return "0000";
    }
}
