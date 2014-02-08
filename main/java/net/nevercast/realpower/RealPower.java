package net.nevercast.realpower;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.nevercast.realpower.proxy.CommonProxy;

@Mod(modid = "realpower", version = "@VERSION@")
public class RealPower {

    @SidedProxy(clientSide = "net.nevercast.realpower.proxy.ClientProxy", serverSide = "net.nevercast.realpower.proxy.CommonProxy")
    public static CommonProxy proxy;

    @Mod.Instance()
    public static RealPower instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent evt) {
        proxy.registerBlocks();
    }
}

