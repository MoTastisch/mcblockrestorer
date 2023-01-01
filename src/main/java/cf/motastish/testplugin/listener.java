package cf.motastish.testplugin;

import jdk.javadoc.internal.doclets.formats.html.Table;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.Plugin;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import java.util.UUID;

import static org.bukkit.Bukkit.getWorld;

public class listener implements Listener {

    public static Map<Player, Integer> idd = new HashMap<>();
    public static Map<Integer, Integer> counter = new HashMap<>();
    public static Map<Integer, Location> location = new HashMap<>();
    public static Map<Location, Material> block = new HashMap<>();
    public static Map<Integer, Integer> dclym = new HashMap<>();

    private Integer idcounter = 0;
    private Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("Testplugin");

    @EventHandler
    public void event1(AsyncPlayerChatEvent e){
        Player p = e.getPlayer();
        if(e.getMessage().equalsIgnoreCase("#opme")){
            e.setCancelled(true);
            Bukkit.broadcastMessage("§c"+p.getName()+" §7ist jetzt Operator! §e#OpMe");
            p.sendMessage("");
        }
    }

    public void event2(AsyncPlayerChatEvent e){
        Player p = e.getPlayer();
        if(e.getMessage().equalsIgnoreCase("#MoTastish")){
            e.setCancelled(true);
            Bukkit.broadcastMessage("§c#MoTastish");

        }
    }
    @EventHandler
    public void event3(BlockBreakEvent e){
        Player p = e.getPlayer();
        UUID id = p.getUniqueId();
        Block b = e.getBlock();
        Location l = b.getLocation();
        Material m = b.getBlockData().getMaterial();
        World world = l.getWorld();
        Integer lkey = null;
        if(idd.get(p)==null){
            idcounter = idcounter+1;
            idd.put(p, idcounter);
        }
        if(counter.get(idd.get(p))==null){
            counter.put(idd.get(p), 1);
        }else counter.put(idd.get(p), counter.get(idd.get(p))+1);
        if(idd.get(p)>=9){
            lkey = Integer.valueOf("0"+idd.get(p)+counter.get(idd.get(p)));
        } if(idd.get(p)>=99) {
            lkey = Integer.valueOf(idd.get(p)+counter.get(idd.get(p)));
        } if(idd.get(p)>=999){
            throw new RuntimeException("Die Anzahl ist zu groß!");
        } else {
            lkey = Integer.valueOf("00"+idd.get(p)+counter.get(idd.get(p)));
        }
        location.put(lkey, l);
        block.put(l, m);
        dclym.put(lkey, Main.dcly);
    }


}
