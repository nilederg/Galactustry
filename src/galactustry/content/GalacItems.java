package galactustry.content;

import arc.graphics.Color;
import mindustry.type.Item;

public class GalacItems{
    public static Item
    graphene, nanoglass, electroid;

    public static void load(){
		graphene = new Item("graphene", Color.valueOf("0f1526")){{
            cost = 2f;
        }};
        nanoglass = new Item("nanoglass", Color.valueOf("535470")){{
            cost = 5f;
        }};
        electroid = new Item("electroid", Color.valueOf("c0fc3f")){{
            cost = 1.5f;
            charge = 1.5f;
            explosiveness = 0.2f;
        }};
    }
}