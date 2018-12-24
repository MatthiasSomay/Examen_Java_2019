/**
 * @Autor: Matthias Somay & Kenneth Van De Borne
 * @Date: 24/12/2018
 * @Project: Examen_Java_2019
 * @Purpose: klasse voor format getallen
 */



package utilities.afronden;

import java.text.DecimalFormat;

public class Afronden {


        DecimalFormat dfGeheelGetal = new DecimalFormat("0.00");
        DecimalFormat dfTweeNaKomma = new DecimalFormat("0.00");

        public int RondAfNaarGeheelGetal(double d){
            return Integer.parseInt(dfGeheelGetal.format(d).replace(",", "."));
        }

        public double RondAfNaarTweeNaKomma(double d){
            return Double.parseDouble(dfTweeNaKomma.format(d).replace(",", "."));
        }
    }

