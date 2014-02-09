package net.nevercast.realpower.logic;

/**
 * Created by Josh on 8/02/14.
 */
public class EELogic {

    public static final double SQRT_2 = Math.sqrt(2);

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
     * @param thickness cross-sectional distance (m)
     * @param material Material the wire is made of
     * @return wire mass in grams
     */
    public static double getWireMass(double length, double thickness, ConductiveMaterial material) {
            double volume = length * Math.pow(thickness, 2);
            return material.getDensity() * volume;
    }

    /**
     * Gets the Total surface area of the wire
     * @param length Length in meters of the wire
     * @param thickness cross-sectional distance (m)
     * @param includeEnds if ends should be included in the calculation
     * @return Total Surface Area in m^2
     */
    public static double getWireSurfaceArea(double length, double thickness, boolean includeEnds){
        double result = 0;
        double endArea = (Math.pow(thickness,2))*2;
        result += (thickness*length)*4;
        if(includeEnds){
            result +=endArea;
        }
        return result;
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

    public static final class AC {

        public static double getRMSVoltage(double volts) {
            return volts / SQRT_2;
        }

        public static double getRMSPower(double watts) {
            return watts / SQRT_2;
        }
    }


}
