package galactustry.content;

import arc.graphics.Color;
import mindustry.type.Liquid;

public class GalacLiquids{
    public static Liquid kerosene
    // Coolants soon
    ;

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
	}
}