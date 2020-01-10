package com.Resimulators.simukraft.datagen;

import net.minecraft.block.BlockState;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;


@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class Datageneration {


    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator gen = event.getGenerator();
        gen.addProvider(new BlockStateGeneration(gen, event.getExistingFileHelper()));
        gen.addProvider(new Lang(gen));
        gen.addProvider(new ItemModelGeneration(gen, event.getExistingFileHelper()));


        if (event.includeServer()) {
            gen.addProvider(new RecipeGeneration(gen));
        }
    }


}
