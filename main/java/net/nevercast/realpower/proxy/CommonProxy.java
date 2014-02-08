package net.nevercast.realpower.proxy;

import net.nevercast.realpower.block.CableBlock;
import net.nevercast.realpower.block.LoadBlock;
import net.nevercast.realpower.block.SupplyBlock;

/**
 * Created by Josh on 8/02/14.
 */
public class CommonProxy {

    public final static class Block {
        public static CableBlock cableBlock;
        public static SupplyBlock supplyBlock;
        public static LoadBlock loadBlock;
    }

    public void registerBlocks() {
        Block.cableBlock = new CableBlock();
        Block.supplyBlock = new SupplyBlock();
        Block.loadBlock = new LoadBlock();
    }
}
