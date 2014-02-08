package net.nevercast.realpower.tileentities;

import net.minecraft.tileentity.TileEntity;
import net.nevercast.realpower.api.IPowerObject;

/**
 * Created by Josh on 8/02/14.
 */
public class TileEntityCable extends TileEntityBase  {
    @Override
    public double getInternalResistance() {
        return 0;
    }

    @Override
    public boolean isConductor() {
        return true;
    }
}
