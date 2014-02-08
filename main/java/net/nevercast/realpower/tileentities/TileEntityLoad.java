package net.nevercast.realpower.tileentities;

import net.minecraft.tileentity.TileEntity;
import net.nevercast.realpower.api.IPowerLoad;
import net.nevercast.realpower.api.IPowerObject;

/**
 * Created by Josh on 8/02/14.
 */
public class TileEntityLoad extends TileEntity implements IPowerLoad {
    @Override
    public double getLoad() {
        return 0;
    }

    @Override
    public double getInternalResistance() {
        return 0;
    }
}
