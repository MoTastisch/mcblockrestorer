package cf.motastish.testplugin;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import static org.bukkit.Bukkit.getWorld;

public class command implements CommandExecutor{
    private Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("Testplugin");
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
        Player p = (Player) sender;
        sender.sendMessage("§6§lT§6estPlugin §7| Blöcke werden wieder hergestellt...");
        Integer countar = 0;
        if(listener.counter.get(listener.idd.get(p))!=null){
            Integer counter = listener.counter.get(listener.idd.get(p));
            Integer counterr = listener.counter.get(listener.idd.get(p));
            World world = p.getWorld();
            while(counter>0){
                counter = counter-1;
                Integer blkid = listener.idd.get(sender);
                Integer blkcounter = listener.counter.get(blkid);
                Integer lkey = null;
                if(blkid>=9){
                    lkey = Integer.valueOf("0"+blkid+blkcounter);
                } if(blkid>=99) {
                    lkey = Integer.valueOf(blkid+blkcounter);
                } if(blkid>=999){
                    throw new RuntimeException("Die Anzahl ist zu groß!");
                } else {
                    lkey = Integer.valueOf("00"+blkid+blkcounter);
                }
                if(lkey!=null){
                    if(listener.dclym.get(lkey)== Main.dcly-1 || listener.dclym.get(lkey)==Main.dcly) {
                        countar = countar+1;
                        world.getBlockAt(listener.location.get(lkey)).setType(listener.block.get(listener.location.get(lkey)));
                    }
                }
                listener.counter.put(blkid, counter);

            }
            listener.counter.put(listener.idd.get(sender), null);
            sender.sendMessage("§6§lT§6estPlugin §7| §e"+countar+" §7von §c"+counterr+" §7Blöcke(n) wurden §eerfolgreich §7wieder hergestellt.");

        } else sender.sendMessage("§6§lT§6estPlugin §7| §cDu hast noch keine Blöcke abgebaut!");

        return true;
    }
}
