package net.nevercast.realpower.api;

/**
 * Created by Josh on 8/02/14.
 */
public interface IPowerSupply extends IPowerObject {
    /**
     * Voltage relative to true ground
     * @return Volts of power supply
     */
    public double getPotential();

    /**
     * Max amperage of supply
     * @return Amperes
     */
    public double getAmperage();
}
