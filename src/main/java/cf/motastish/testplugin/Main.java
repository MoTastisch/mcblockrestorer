package cf.motastish.testplugin;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public final class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getCommand("restoreblks").setExecutor(new command());
        getServer().getPluginManager().registerEvents(new listener(), this);
        executeEveryMinute();


    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Integer dcly = 0;
    public static Integer dcly2 = 0;

    void executeEveryMinute(){
        new BukkitRunnable() {
            @Override
            public void run() {
                dcly = dcly+1;
            }
        }.runTaskTimer(this,0,20*150);
    }

}