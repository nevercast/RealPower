package net.nevercast.realpower.logic;

/**
 * Created by Josh on 8/02/14.
 */
public class EELogic {
    public static final class ConductiveMaterial {
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

    /**
     * Get the resistance of a segment of wire
     * @param length Length in meters of the wire
     * @param thinkness cross-sectional distance (m)
     * @param material Material the wire is made of
     * @return Resistance of wire in ohms (Ω)
     */
    public static double getWireSegmentResistance(double length, double thinkness, ConductiveMaterial material) {
        double ohms = material.getResistance();
        return ohms * (Math.pow(thinkness,2)/length);
    }

    /**
     * Get voltage drop for a segment of set of wires/devices
     * @param ohms Total accumulated resistance of the circuit (Ω)
     * @param amperes Flowing amperage (A)
     * @return Voltage drop (V)
     */
    public static double getVoltageDrop(double ohms, double amperes) {
        return ohms * amperes;
    }

    /**
     * Get wire mass in grams
     * @param length length of wire (m)
     * @param thinkness cross-sectional distance (m)
     * @param material Material the wire is made of
     * @return wire mass in grams
     */
    public static double getWireMass(double length, double thinkness, ConductiveMaterial material) {
        double volume = length * Math.pow(thinkness, 2);
        return material.density * volume;
    }

    /**
     * Get heat produced in material over time
     * @param wattsOfEnergy Power (W)
     * @param lengthOfWire length of wire (m)
     * @param thickness cross-sectional distance (m)
     * @param material Material the wire is made of
     * @param timeStep elapsed time (s)
     * @return Heat produced (K)
     */
    public static double getHeatProduction(double wattsOfEnergy, double lengthOfWire, double thickness, ConductiveMaterial material, double timeStep) {
        double wireMass = getWireMass(lengthOfWire, thickness, material);
        double joules = wattsOfEnergy * timeStep;
        return (joules * material.getSpecificHeat()) / wireMass;
    }

    /**
     * Gets the power produced
     * @param voltage Volts (V)
     * @param amperes Flowing amperage (A)
     * @return Watts (W)
     */
    public static double getPower(double voltage,double amperes){
        return voltage*amperes;
    }
}
