package net.nevercast.realpower.api;

/**
 * Created by Josh on 8/02/14.
 */
public interface IPowerLoad extends IPowerObject {
    /**
     * Load on a circuit
     * @return Amperes of load
     */
    public double getLoad();
}
