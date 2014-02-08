package net.nevercast.realpower.proxy;

import net.nevercast.realpower.block.BlockCable;
import net.nevercast.realpower.block.BlockLoad;
import net.nevercast.realpower.block.BlockSupply;

public class CommonProxy {

    public final static class Block {
        public static BlockCable blockCable;
        public static BlockSupply blockSupply;
        public static BlockLoad blockLoad;
    }

    public void registerBlocks() {
        Block.blockCable = new BlockCable();
        Block.blockSupply = new BlockSupply();
        Block.blockLoad = new BlockLoad();
    }
}
