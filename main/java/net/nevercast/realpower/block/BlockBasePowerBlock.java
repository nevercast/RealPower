package net.nevercast.realpower.block;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;

/**
 * Created by Josh on 8/02/14.
 */
public abstract class BlockBasePowerBlock extends BlockContainer {
    public BlockBasePowerBlock(String name) {
        super(Material.iron);
        setCreativeTab(CreativeTabs.tabAllSearch);
        setBlockName("realpower." + name);
        setBlockTextureName("realpower:block_" + name);
        GameRegistry.registerBlock(this, name);
    }
}
