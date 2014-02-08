package net.nevercast.realpower.tileentities;

import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;
import net.nevercast.realpower.api.IPowerLoad;
import net.nevercast.realpower.api.IPowerObject;
import net.nevercast.realpower.api.IPowerSupply;
import net.nevercast.realpower.logic.NetworkLoad;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Josh on 8/02/14.
 */
public class TileEntityBase extends TileEntity implements IPowerObject {
    @Override
    public double getInternalResistance() {
        return 0;
    }

    @Override
    /**
     * Get the direct adjacent loads
     */
    public NetworkLoad[] getDirectLoad() {
        List<NetworkLoad> loads = new ArrayList<NetworkLoad>();
        for(ForgeDirection dir : ForgeDirection.VALID_DIRECTIONS) {
            int x = xCoord + dir.offsetX;
            int y = yCoord + dir.offsetY;
            int z = zCoord + dir.offsetZ;
            TileEntity te = worldObj.getTileEntity(x,y,z);
            if(te != null && te instanceof IPowerLoad){
                IPowerLoad load = (IPowerLoad)te;
                NetworkLoad loadRequest = new NetworkLoad(x,y,z, load.getLoad(), load.getInternalResistance());
                loads.add(loadRequest);
            }
        }
        return loads.toArray(new NetworkLoad[loads.size()]);
    }

    @Override
    public NetworkLoad[] getTransversingLoad() {
        return new NetworkLoad[0];
    }

    @Override
    public boolean isConductor() {
        return false;
    }

    public double getTotalLoad() {
        NetworkLoad[] loads = getDirectLoad();
        double totalLoad = 0;
        for(NetworkLoad load : loads) {
            totalLoad += load.amperes;
        }
        return totalLoad;
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
        if(isConductor()) {
            result += ", Conductor Load: " + getTotalLoad();
        }
        return result;
    }
}
