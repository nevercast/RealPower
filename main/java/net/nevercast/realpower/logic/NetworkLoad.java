package net.nevercast.realpower.logic;

/**
 * Created by Josh on 8/02/14.
 */
public class NetworkLoad {
    public int x,y,z;
    public double amperes;
    public double totalResistance;

    public NetworkLoad(int x, int y, int z, double amperes, double ohms) {
        this.x = x;
        this.y = y;
        this.z = z;
        this.amperes = amperes;
        this.totalResistance = ohms;
    }
}
