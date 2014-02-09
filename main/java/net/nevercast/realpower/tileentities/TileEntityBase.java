package net.nevercast.realpower.tileentities;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import net.nevercast.realpower.api.IPowerLoad;
import net.nevercast.realpower.api.IPowerObject;
import net.nevercast.realpower.api.IPowerSupply;
import net.nevercast.realpower.logic.PowerNetwork;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Josh on 8/02/14.
 */
public class TileEntityBase extends TileEntity implements IPowerObject {

    public TileEntityBase() {
        System.out.println("Constructor");
    }

    @Override
    public double getInternalResistance() {
        return 0;
    }

    @Override
    public boolean isConductor() {
        return false;
    }


    @Override
    public String toString() {
        String result = getClass().getSimpleName() + ", R: " + getInternalResistance();
        if(this instanceof IPowerLoad) {
            result += ", Load (A): " + ((IPowerLoad)this).getLoad();
        }
        if(this instanceof IPowerSupply) {
            result += ", V: " + ((IPowerSupply)this).getPotential();
            result += ", A: " + ((IPowerSupply)this).getAmperage();
        }
        return result;
    }
}
