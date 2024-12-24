package net.cobra.purpleheartforest.item;

import net.cobra.purpleheartforest.PurpleHeartForest;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Rarity;

import java.util.function.Function;

public class ModItems {

    public static final Item CRYSTALLITE = register("crystallite", Item::new, new Item.Settings().rarity(Rarity.RARE));

    public static Item register(String id, Function<Item.Settings, Item> factory, Item.Settings settings) {
        return register(PurpleHeartForest.setItemRegistryKey(id), factory, settings);
    }

    private static Item register(RegistryKey<Item> key, Function<Item.Settings, Item> factory, Item.Settings settings) {
        Item item = factory.apply(settings.registryKey(key));
        return Registry.register(Registries.ITEM, key, item);
    }

    public static void register() {

    }
}
