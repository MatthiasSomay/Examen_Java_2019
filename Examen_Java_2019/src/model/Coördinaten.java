package model;

import utilities.afronden.Afronden;

public class Coördinaten {

    private double lengte;
    private double breedte;
    private Afronden afronden = new Afronden();

    public Coördinaten(double lengte, double breedte) {
        setLengte(lengte);
        setBreedte(breedte);
    }

    @Override
    public String toString() {
        return ("Coördinaten(" +
                "Lengte: " + getLengte() + "; " +
                "Breedte: " + getBreedte() + ")"
        );
    }

    public double getLengte() {
        return lengte;
    }

    public void setLengte(double lengte) throws IllegalArgumentException {
        if (lengte <= 0) {
            throw new IllegalArgumentException("Ongeldige lengte");

        }
        this.lengte = afronden.RondAfNaarTweeNaKomma(lengte);
    }

    public double getBreedte() {
        return breedte;
    }

    public void setBreedte(double breedte) {
        if (breedte <= 0) {
            throw new IllegalArgumentException("Ongeldige breedte");

        }
        this.breedte = afronden.RondAfNaarTweeNaKomma(breedte);
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
