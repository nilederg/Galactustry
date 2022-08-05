package galactustry.content;

import mindustry.content.Fx;
import mindustry.content.Items;
import mindustry.content.Liquids;
import mindustry.gen.Sounds;
import mindustry.type.Category;
import mindustry.type.ItemStack;
import mindustry.type.LiquidStack;
import mindustry.world.Block;
import mindustry.world.blocks.power.ConsumeGenerator;
import mindustry.world.blocks.production.GenericCrafter;

import static mindustry.type.ItemStack.with;

public class GalacBlocks{
    //environment
    public static Block 
	// production
	graphenePeeler, keroseneRefinery,
	// power
	keroseneGenerator;

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
			
			ambientSound = Sounds.smelter;
			
			consumeLiquids(LiquidStack.with(GalacLiquids.kerosene, 4f / 60f, Liquids.cryofluid, 2f / 60f));
			powerProduction = 12.5f;
		}};
    }
}