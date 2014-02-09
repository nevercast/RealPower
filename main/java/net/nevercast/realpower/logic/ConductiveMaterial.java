package net.nevercast.realpower.logic;

/**
 * Created by Josh on 9/02/14.
 */
public class ConductiveMaterial {
    public static ConductiveMaterial Copper = new ConductiveMaterial(0.000000017D, 1084.62, 8.96, 0.4);

    private double resistance;
    private double meltingPoint;
    private double density;
    private double specificHeat;

    public double getResistance() {
        return resistance;
    }

    /**
     * Melting point in Celsius
     * @return
     */
    public double getMeltingPoint() {
        return meltingPoint;
    }

    /**
     * Material density in g/cm^3
     * @return
     */
    public double getDensity() {
        return density;
    }

    /**
     * Get specific heat of material in Joules/gram Celsius
     * @return
     */
    public double getSpecificHeat() {
        return specificHeat;
    }

    public ConductiveMaterial(double resistance, double meltingPoint, double density, double specificHeat) {
        this.resistance = resistance;
        this.meltingPoint = meltingPoint;
        this.density = density;
        this.specificHeat = specificHeat;
    }
}
