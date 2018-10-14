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
                return "0029";
            case 6:
                return "002B";
            case 7:
                return "0231";
            case 8:
                return "0233";
            case 9:
                return "8021";
            case 10:
                return "8023";
            case 11:
                return "8025";
            case 12:
                return "8027";
            case 13:
                return "8029";
            case 14:
                return "802B";
            case 15:
                return "C021";
            case 16:
                return "C023";
            case 17:
                return "C223";

        }
        return "0000";
    }
}
