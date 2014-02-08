package net.nevercast.realpower.block;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;
import net.minecraft.world.World;
import net.nevercast.realpower.tileentities.TileEntityBase;

/**
 * Created by Josh on 8/02/14.
 */
public abstract class BlockBasePowerBlock extends BlockContainer {
    public BlockBasePowerBlock(String name) {
        super(Material.iron);
        setCreativeTab(CreativeTabs.tabAllSearch);
        setBlockName("realpower." + name);
        setBlockTextureName("realpower:" + name);
        GameRegistry.registerBlock(this, name);
    }

    @Override
    public boolean onBlockActivated(World p_149727_1_, int p_149727_2_, int p_149727_3_, int p_149727_4_, EntityPlayer p_149727_5_, int p_149727_6_, float p_149727_7_, float p_149727_8_, float p_149727_9_) {
        if(!p_149727_1_.isRemote) {
            TileEntityBase entityBase = (TileEntityBase)p_149727_1_.getTileEntity(p_149727_2_, p_149727_3_, p_149727_4_);
            p_149727_5_.addChatMessage(new ChatComponentText(entityBase.toString()));
        }
        return super.onBlockActivated(p_149727_1_, p_149727_2_, p_149727_3_, p_149727_4_, p_149727_5_, p_149727_6_, p_149727_7_, p_149727_8_, p_149727_9_);
    }
}
