package net.nevercast.realpower.api;

import net.nevercast.realpower.logic.NetworkLoad;

/**
 * Created by Josh on 8/02/14.
 */
public interface IPowerObject {
    /**
     * Internal resistance in ohms
     * @return ohms of internal resistance
     */
    public double getInternalResistance();

    public NetworkLoad[] getDirectLoad();
    public NetworkLoad[] getTransversingLoad();
    public boolean isConductor();
}
