package net.nevercast.realpower.block;

import com.ibm.icu.util.IslamicCalendar;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.nevercast.realpower.RealPower;
import net.nevercast.realpower.proxy.CommonProxy;
import net.nevercast.realpower.tileentities.TileEntityCable;

import java.util.List;

public class BlockCable extends BlockBasePowerBlock {

    private static final float[] SIZES = new float[]{1/16f,1/10f,1/4f};


    public BlockCable() {
        super("cable");
    }

    @Override
    public void setBlockBoundsBasedOnState(IBlockAccess access, int x, int y, int z) {
        int metadata = access.getBlockMetadata(x,y,z);

        if(metadata < 0 || metadata >= SIZES.length) return;
        float size = SIZES[metadata];
        float xMin = 0.5F-size;
        float yMin = 0.5F-size;
        float zMin = 0.5F-size;
        float xMax = 0.5F+size;
        float yMax = 0.5F+size;
        float zMax = 0.5F+size;
        if (canJoin(access, x - 1, y, z, metadata)) {
            xMin = 0.0F;
        }
        if (canJoin(access, x + 1, y, z, metadata)) {
            xMax = 1.0F;
        }
        if (canJoin(access, x, y - 1, z, metadata)) {
            yMin = 0.0F;
        }
        if (canJoin(access, x, y + 1, z, metadata)) {
            yMax = 1.0F;
        }
        if (canJoin(access, x, y, z - 1, metadata)) {
            zMin = 0.0F;
        }
        if (canJoin(access, x, y, z + 1, metadata)) {
            zMax = 1.0F;
        }
        setBlockBounds(xMin,yMin,zMin,xMax,yMax,zMax);
    }

    public boolean isCable(IBlockAccess access, int x, int y, int z) {
        Block block = access.getBlock(x,y,z);
        return block instanceof BlockCable;
    }

    public boolean canJoin(IBlockAccess access, int x, int y, int z, int thisMeta) {
        if(isCable(access,x,y,z)) {
            int metadata = access.getBlockMetadata(x,y,z);
            return  metadata == thisMeta;
        }else{
            Block block = access.getBlock(x,y,z);
            if(block instanceof BlockBasePowerBlock) {
                return ((BlockBasePowerBlock)block).canJoin(access, x,y,z,thisMeta);
            }
        }
        return false;
    }

    @Override
    public boolean isOpaqueCube() {
        return false;
    }

    @Override
    public void getSubBlocks(Item p_149666_1_, CreativeTabs p_149666_2_, List p_149666_3_) {
        for(int i = 0; i < SIZES.length; i++) {
            p_149666_3_.add(i, new ItemStack(CommonProxy.Block.blockCable, 1, i));
        }
    }

    @Override
    public TileEntity createNewTileEntity(World world, int i) {
        return new TileEntityCable();
    }
}
