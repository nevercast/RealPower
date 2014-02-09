package net.nevercast.realpower.block;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.nevercast.realpower.tileentities.TileEntitySupply;

/**
 * Created by Josh on 8/02/14.
 */
public class BlockSupply extends BlockBasePowerBlock {

    public BlockSupply() {
        super("supply");
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return new TileEntitySupply();
    }

    @Override
    public boolean canJoin(IBlockAccess access, int x, int y, int z, int thisMeta) {
        return true;
    }
}
