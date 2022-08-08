package galactustry.content;

import arc.graphics.Color;
import mindustry.content.StatusEffects;
import mindustry.type.Liquid;

public class GalacLiquids{
    public static Liquid kerosene, helium,
    // Coolants soon
    coolantA, coolantB, coolantC, coolantD, coolantE;

    public static void load(){
		kerosene = new Liquid("kerosene", Color.valueOf("9a9aa7")){{
            viscosity = 0.6f;
            flammability = 2f;
            explosiveness = 1.6f;
            barColor = Color.valueOf("9a9aa7");
            effect = GalacStatusEffects.fuelDoused;
            boilPoint = 0.55f;
            gasColor = Color.grays(0.8f);
        }};

        coolantE = new Liquid("coolantE", Color.valueOf("73c5f1")){{
            heatCapacity = 1.0f;
            temperature = 0.25f;
            effect = StatusEffects.freezing;
			barColor = Color.valueOf("73c5f1");
            lightColor = Color.valueOf("0097f5").a(0.2f);
            boilPoint = 0.55f;
            gasColor = Color.valueOf("b5e0fb");
        }};

        coolantD = new Liquid("coolantD", Color.valueOf("66c9ff")){{
            heatCapacity = 1.2f;
            temperature = 0.15f;
            effect = StatusEffects.freezing;
			barColor = Color.valueOf("66c9ff");
            lightColor = Color.valueOf("0097f5").a(0.2f);
            boilPoint = 0.55f;
            gasColor = Color.valueOf("aee3ff");
        }};

        coolantC = new Liquid("coolantC", Color.valueOf("b9bce0")){{
            heatCapacity = 1.3f;
            temperature = 0.15f;
            effect = StatusEffects.freezing;
			barColor = Color.valueOf("b9bce0");
            lightColor = Color.valueOf("0097f5").a(0.2f);
            boilPoint = 0.55f;
            gasColor = Color.valueOf("e4d9eb");
        }};

        coolantB = new Liquid("coolantB", Color.valueOf("b2c3ed")){{
            heatCapacity = 3.0f;
            temperature = 0.15f;
            effect = StatusEffects.freezing;
			barColor = Color.valueOf("b2c3ed");
            lightColor = Color.valueOf("0097f5").a(0.2f);
            boilPoint = 0.55f;
            gasColor = Color.valueOf("dfdef7");
        }};

        coolantA = new Liquid("coolantA", Color.valueOf("a3b8fc")){{
            heatCapacity = 10.0f;
            temperature = 0.01f;
            effect = StatusEffects.freezing;
			barColor = Color.valueOf("a3b8fc");
            lightColor = Color.valueOf("0097f5").a(0.2f);
            boilPoint = 0.55f;
            gasColor = Color.valueOf("d4d5ff");
        }};

        helium = new Liquid("helium", Color.valueOf("d294ea")){{
            gas = true;
        }};

	}
}