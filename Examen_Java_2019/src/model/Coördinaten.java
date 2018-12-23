package model;

import java.text.DecimalFormat;

public class Coördinaten {

    private double lengte;
    private double breedte;

    public Coördinaten(double lengte, double breedte) {
        this.lengte = lengte;
        this.breedte = breedte;
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("0.00");
        return ("Coördinaten(" +
                "Lengte: " + df.format(getLengte()) + "; " +
                "Breedte: " + df.format(getBreedte()) + ")"
        );
    }

    public double getLengte() {
        return lengte;
    }

    public void setLengte(double lengte) {
        this.lengte = lengte;
    }

    public double getBreedte() {
        return breedte;
    }

    public void setBreedte(double breedte) {
        this.breedte = breedte;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coördinaten)) return false;
        Coördinaten that = (Coördinaten) o;
        return Double.compare(that.getLengte(), getLengte()) == 0 &&
                Double.compare(that.getBreedte(), getBreedte()) == 0;
    }
}
