package net.nevercast.realpower.tileentities;

import net.minecraft.tileentity.TileEntity;
import net.nevercast.realpower.api.IPowerObject;
import net.nevercast.realpower.api.IPowerSupply;

/**
 * Created by Josh on 8/02/14.
 */
public class TileEntitySupply extends TileEntity implements IPowerSupply {
    @Override
    public double getPotential() {
        return 0;
    }

    @Override
    public double getAmperage() {
        return 0;
    }

    @Override
    public double getInternalResistance() {
        return 0;
    }
}
