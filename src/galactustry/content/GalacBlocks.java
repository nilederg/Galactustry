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
	typeEMixer, typeDCooler, typeCMixer, typeBMixer, typeACooler,
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
			
			consumeLiquid(Liquids.oil, 18f / 60f);
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
			requirements(Category.power, with(Items.copper, 1000, Items.metaglass, 750, Items.graphite, 500, Items.silicon, 800, Items.phaseFabric, 300, Items.plastanium, 400, Items.surgeAlloy, 500, GalacItems.electroid, 750, GalacItems.graphene, 250));
			size = 8;
			health = 1800;
			powerProduction = 4150f;
			itemDuration = 120f;
			// TODO make helium work
			// outputLiquid = new LiquidStack(GalacLiquids.helium, 12f / 60f);

			explosionDamage = 100000;
			
			ambientSound = Sounds.pulse;
			ambientSoundVolume = 0.1f;
			drawer = new DrawMulti(new DrawRegion("-bottom"), new DrawLiquidTile(GalacLiquids.coolantC), new DrawRegion("-mid"), new DrawPlasma(), new DrawDefault());

			consumePower(3500f);
			consumeLiquids(LiquidStack.with(Liquids.hydrogen, 12f / 60f, GalacLiquids.coolantC, 15f / 60f));
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

		typeEMixer = new GenericCrafter("type-e-mixer"){{
			requirements(Category.crafting, with(Items.lead, 100, Items.graphite, 60, Items.silicon, 60));

			outputLiquid = new LiquidStack(GalacLiquids.coolantE, 12f / 60f);
			craftTime = 120f;
			size = 2;
			hasItems = true;
			hasPower = true;
			hasLiquids = true;

			consumeItem(Items.graphite, 1);
			consumeLiquids(LiquidStack.with(Liquids.cryofluid, 12f / 60f, Liquids.oil, 6f / 60f));
			consumePower(1.00f);
		}};

		typeDCooler = new GenericCrafter("type-d-cooler"){{
			requirements(Category.crafting, with(Items.thorium, 50, Items.metaglass, 70, Items.plastanium, 100, Items.silicon, 80));

			outputLiquid = new LiquidStack(GalacLiquids.coolantD, 12f / 60f);
			craftTime = 120f;
			size = 3;
			hasItems = false;
			hasPower = true;
			hasLiquids = true;

			consumeLiquid(GalacLiquids.coolantE, 12f / 60f);
			consumePower(5.00f);
		}};

		typeCMixer = new GenericCrafter("type-c-mixer"){{
			requirements(Category.crafting, with(Items.titanium, 150, Items.plastanium, 120, Items.silicon, 80));

			outputLiquid = new LiquidStack(GalacLiquids.coolantC, 12f / 60f);
			craftTime = 120f;
			size = 2;
			hasItems = false;
			hasPower = true;
			hasLiquids = true;

			consumeLiquids(LiquidStack.with(Liquids.nitrogen, 9f / 60f, Liquids.hydrogen, 9f / 60f));
			consumePower(1.50f);
		}};

		typeBMixer = new GenericCrafter("type-b-mixer"){{
			requirements(Category.crafting, with(Items.surgeAlloy, 80, Items.plastanium, 140, Items.silicon, 100, GalacItems.graphene, 50));

			outputLiquid = new LiquidStack(GalacLiquids.coolantB, 12f / 60f);
			craftTime = 60f;
			size = 3;
			hasItems = true;
			hasPower = true;
			hasLiquids = true;

			consumeLiquids(LiquidStack.with(GalacLiquids.coolantD, 12f / 60f, GalacLiquids.coolantC, 12f / 60f, GalacLiquids.helium, 12f / 60f));
			consumeItem(Items.surgeAlloy, 1);
			consumePower(3.00f);
		}};

		typeACooler = new GenericCrafter("type-a-cooler"){{
			requirements(Category.crafting, with(Items.surgeAlloy, 120, Items.plastanium, 140, Items.silicon, 80, GalacItems.electroid, 100, Items.phaseFabric, 100));

			outputLiquid = new LiquidStack(GalacLiquids.coolantA, 12f / 60f);
			craftTime = 60f;
			size = 4;
			hasItems = false;
			hasPower = true;
			hasLiquids = true;

			consumeLiquid(GalacLiquids.coolantB, 12f / 60f);
			consumeItem(Items.phaseFabric, 1);
			consumePower(100.0f);
		}};

    }
}