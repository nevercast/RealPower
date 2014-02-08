package net.nevercast.realpower.tileentities;

import net.nevercast.realpower.api.IPowerSupply;

/**
 * Created by Josh on 8/02/14.
 */
public class TileEntitySupply extends TileEntityBase implements IPowerSupply {
    @Override
    public double getPotential() {
        return 12;
    }

    @Override
    public double getAmperage() {
        return 10;
    }
}
