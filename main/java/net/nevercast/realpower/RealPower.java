package net.nevercast.realpower;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import net.nevercast.realpower.proxy.CommonProxy;

/**
 * Created by Josh on 8/02/14.
 */

@Mod(modid = "net.nevercast.realpower", version = "@VERSION@")
public class RealPower {

    @SidedProxy(clientSide = "net.nevercast.realpower.proxy.ClientProxy", serverSide = "net.nevercast.realpower.proxy.CommonProxy")
    public static CommonProxy proxy;

    @Mod.Instance()
    public static RealPower instance;
}

