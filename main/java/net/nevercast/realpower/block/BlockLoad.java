package net.nevercast.realpower.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.nevercast.realpower.tileentities.TileEntityLoad;

public class BlockLoad extends BlockBasePowerBlock {

    public BlockLoad() {
        super("load");
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return new TileEntityLoad();
    }

    @Override
    public boolean canJoin(IBlockAccess access, int x, int y, int z, int thisMeta) {
        return true;
    }
}
