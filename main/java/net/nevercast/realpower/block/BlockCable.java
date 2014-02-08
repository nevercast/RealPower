package net.nevercast.realpower.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.nevercast.realpower.tileentities.TileEntityCable;

public class BlockCable extends BlockBasePowerBlock {

    public BlockCable() {
        super("cable");
        setBlockBounds(0f,0.25f,0.25f,1f,0.75f,0.75f);
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return new TileEntityCable();
    }
}
