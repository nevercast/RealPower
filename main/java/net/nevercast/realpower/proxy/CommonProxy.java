package net.nevercast.realpower.proxy;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.tileentity.TileEntity;
import net.nevercast.realpower.annotations.PowerBlock;
import net.nevercast.realpower.block.BlockCable;
import net.nevercast.realpower.block.BlockLoad;
import net.nevercast.realpower.block.BlockSupply;
import net.nevercast.realpower.tileentities.TileEntityCable;
import net.nevercast.realpower.tileentities.TileEntityLoad;
import net.nevercast.realpower.tileentities.TileEntitySupply;
import net.nevercast.realpower.util.Log;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.logging.Logger;

public class CommonProxy {

    public final static class Block {
        @PowerBlock(name = "cable", tile = TileEntityCable.class)
        public static BlockCable blockCable;
        @PowerBlock(name = "supply", tile = TileEntitySupply.class)
        public static BlockSupply blockSupply;
        @PowerBlock(name = "load", tile = TileEntityLoad.class)
        public static BlockLoad blockLoad;
    }

    public void registerBlocks() {
        for(Field field : Block.class.getDeclaredFields()){
            try{
                Class type = field.getType();
                PowerBlock powerBlockAnnotation = field.getAnnotation(PowerBlock.class);
                net.minecraft.block.Block instance = (net.minecraft.block.Block)type.getConstructor().newInstance();
                field.set(null, instance);
                String name = powerBlockAnnotation.name();
                instance.setBlockName("realpower." + name);
                instance.setBlockTextureName("realpower:" + name);
                GameRegistry.registerBlock(instance, name);
                if(powerBlockAnnotation.tile() != TileEntity.class)
                    GameRegistry.registerTileEntity(powerBlockAnnotation.tile(), powerBlockAnnotation.name());

            }catch (Exception ex) {
                Log.info("Exception while registering block " + field.getName() + ", " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }
}
