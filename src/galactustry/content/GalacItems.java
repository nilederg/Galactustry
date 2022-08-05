package galactustry.content;

import arc.graphics.Color;
import mindustry.type.Item;

public class GalacItems{
    public static Item
    graphene;

    public static void load(){
		graphene = new Item("graphene", Color.valueOf("0f1526")){{
            cost = 2f;
        }};
    }
}