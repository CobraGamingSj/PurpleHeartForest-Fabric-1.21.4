package net.cobra.purpleheartforest.world;

import net.cobra.purpleheartforest.PurpleHeartForest;
import terrablender.api.RegionType;
import terrablender.api.Regions;
import terrablender.api.TerraBlenderApi;

public class TerraBlender implements TerraBlenderApi {

    @Override
    public void onTerraBlenderInitialized() {
        TerraBlenderApi.super.onTerraBlenderInitialized();
        Regions.register(new ModOverworldRegion(PurpleHeartForest.modId("overworld"), RegionType.OVERWORLD, 4));
    }
}
