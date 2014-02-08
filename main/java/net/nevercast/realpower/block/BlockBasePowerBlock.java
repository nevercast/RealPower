package net.nevercast.realpower.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

/**
 * Created by Josh on 8/02/14.
 */
public abstract class BlockBasePowerBlock extends Block {
    public BlockBasePowerBlock() {
        super(Material.iron);
        setCreativeTab(CreativeTabs.tabAllSearch);
    }
}
