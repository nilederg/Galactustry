package galactustry.content;

import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.content.Liquids;
import mindustry.gen.Sounds;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.type.LiquidStack;
import mindustry.world.Block;
import mindustry.world.blocks.liquid.Conduit;
import mindustry.world.blocks.power.ConsumeGenerator;
import mindustry.world.blocks.power.ImpactReactor;
import mindustry.world.blocks.production.GenericCrafter;
import mindustry.world.draw.*;

import static mindustry.type.ItemStack.with;

public class GalacBlocks{
    //environment
    public static Block 
	// production
	graphenePeeler, keroseneRefinery, carbonNanoassembler, electroidCharger,
	// power
	keroseneGenerator, fusionReactor,
	// liquid
	insulatedConduit, magneticIsolationConduit;

    public static void load() {
		graphenePeeler = new GenericCrafter("graphene-peeler"){{
            requirements(Category.crafting, with(Items.copper, 80, Items.lead, 30, Items.titanium, 40, Items.silicon, 25));

            updateEffect = Fx.pulverizeMedium;
            outputItem = new ItemStack(GalacItems.graphene, 3);
            craftTime = 120f;
            size = 2;
            hasItems = true;
			hasPower = true;
			hasLiquids = false;
			
			ambientSound = Sounds.techloop;

            consumeItem(Items.graphite, 1);
            consumePower(1.50f);
        }};
		
		keroseneRefinery = new GenericCrafter("kerosene-refinery"){{
			requirements(Category.crafting, with(Items.lead, 100, Items.graphite, 150, Items.plastanium, 100, Items.silicon, 80));
			
			updateEffect = Fx.plasticburn;
			outputLiquid = new LiquidStack(GalacLiquids.kerosene, 6f / 60f);
			craftTime = 120f;
			size = 3;
			hasItems = false;
			hasPower = true;
			hasLiquids = true;
			
			ambientSound = Sounds.smelter;
			
			consumeLiquid(Liquids.oil, (float) 0.3);
			consumePower(2.50f);
		}};
		
		keroseneGenerator = new ConsumeGenerator("kerosene-generator"){{
			requirements(Category.crafting, with(Items.graphite, 80, Items.thorium, 40, Items.silicon, 60));

			generateEffect = Fx.smeltsmoke;
			itemDuration = 120f;
			size = 2;
			hasItems = false;
			hasPower = true;
			hasLiquids = true;

			drawer = new DrawMulti(new DrawDefault(), new DrawFlame(Color.valueOf("ffef99")));
			ambientSound = Sounds.smelter;
			
			consumeLiquids(LiquidStack.with(GalacLiquids.kerosene, 4f / 60f, Liquids.cryofluid, 2f / 60f));
			powerProduction = 30f;
		}};

		fusionReactor = new ImpactReactor("fusion-reactor"){{
			requirements(Category.power, with(Items.copper, 1));
			size = 8;
			health = 1800;
			powerProduction = 4150f;
			itemDuration = 120f;
			
			ambientSound = Sounds.pulse;
			ambientSoundVolume = 0.1f;
			drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawLiquidTile(Liquids.cryofluid), new DrawRegion("-mid"), new DrawPlasma(), new DrawDefault());

			consumePower(3500f);
			consumeLiquids(LiquidStack.with(Liquids.hydrogen, 12f / 60f, Liquids.cryofluid, 1f / 60f));
		}};

		insulatedConduit = new Conduit("insulated-conduit"){{
			requirements(Category.liquid, with(Items.oxide, 2, Items.metaglass, 1, Items.graphite, 1));
			liquidCapacity = 12f;
			liquidPressure = 1.025f;
			health = 90;
		}};

		magneticIsolationConduit = new Conduit("magnetic-isolation-conduit"){{
			requirements(Category.liquid, with(GalacItems.electroid, 2, Items.metaglass, 1, Items.silicon, 1, Items.titanium, 1));
			liquidCapacity = 12f;
			liquidPressure = 1.25f;
			health = 90;
		}};

		carbonNanoassembler = new GenericCrafter("carbon-nanoassembler"){{
			requirements(Category.crafting, with(Items.graphite, 250, Items.surgeAlloy, 140, Items.phaseFabric, 160, Items.silicon, 250));

			updateEffect = Fx.smeltsmoke;
			outputItem = new ItemStack(GalacItems.nanoglass, 1);
			craftTime = 180f;
			itemCapacity = 20;
			size = 4;
			hasItems = true;
			hasPower = true;
			hasLiquids = false;

			ambientSound = Sounds.techloop;

			consumeItems(with(GalacItems.graphene, 10, Items.metaglass, 1, Items.phaseFabric, 1, Items.carbide, 1));
			consumePower(12f);
		}};

		electroidCharger = new GenericCrafter("electroid-charger"){{
			requirements(Category.crafting, with(Items.plastanium, 120, Items.surgeAlloy, 120, Items.lead, 160, Items.silicon, 200));

			// TODO electric zappy effects
			updateEffect = Fx.smeltsmoke;
			outputItem = new ItemStack(GalacItems.electroid, 2);
			craftTime = 60f;
			size = 3;
			hasItems = true;
			hasPower = true;
			hasLiquids = false;

			ambientSound = Sounds.techloop;

			consumeItems(with(Items.graphite, 2, Items.surgeAlloy, 3, Items.phaseFabric, 2, Items.tungsten, 1));
			consumePower(8f);
		}};
    }
}