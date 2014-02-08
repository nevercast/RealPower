package net.nevercast.realpower.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.nevercast.realpower.tileentities.TileEntityCable;

public class BlockCable extends BlockBasePowerBlock {

    public BlockCable() {
        super("cable");
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return new TileEntityCable();
    }
}
