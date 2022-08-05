package galactustry.content;

import arc.graphics.Color;
import mindustry.content.Fx;
import mindustry.type.StatusEffect;

import static mindustry.content.StatusEffects.burning;
import static mindustry.content.StatusEffects.melting;

public class GalacStatusEffects{
    public static StatusEffect fuelDoused;

    public static void load(){
		fuelDoused = new StatusEffect("fuel-doused"){{
            color = Color.valueOf("9a9aa7");
            speedMultiplier = 0.95f;
            effect = Fx.oily;

            init(() -> {
                affinity(melting, (unit, result, time) -> result.set(melting, result.time + time));
                affinity(burning, (unit, result, time) -> result.set(burning, result.time + time));
            });
        }};
	}
}