package galactustry;

import arc.Core;
import arc.Events;
import arc.util.Log;
import arc.util.Time;
import galactustry.content.GalacBlocks;
import galactustry.content.GalacItems;
import galactustry.content.GalacLiquids;
import galactustry.content.GalacStatusEffects;
import mindustry.game.EventType.ClientLoadEvent;
import mindustry.mod.Mod;
import mindustry.ui.dialogs.BaseDialog;

public class galactustry extends Mod{

    public galactustry(){
        Log.info("Loaded Galactustry constructor.");

        //listen for game load event
        Events.on(ClientLoadEvent.class, e -> {
            //show dialog upon startup
            Time.runTask(10f, () -> {
                BaseDialog dialog = new BaseDialog("frog");
                dialog.cont.add("behold").row();
                //mod sprites are prefixed with the mod name (this mod is called 'example-java-mod' in its config)
                dialog.cont.image(Core.atlas.find("galactustry-frog")).pad(20f).row();
                dialog.cont.button("I see", dialog::hide).size(100f, 50f);
                dialog.show();
            });
        });
    }

    @Override
	
    public void loadContent(){
        GalacStatusEffects.load();
        GalacLiquids.load();
        GalacItems.load();
        GalacBlocks.load();
    }
}
