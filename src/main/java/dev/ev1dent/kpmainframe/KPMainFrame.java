package dev.ev1dent.kpmainframe;

import dev.ev1dent.kpmainframe.events.PlayersFirstJoin;
import net.luckperms.api.LuckPerms;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class KPMainFrame extends JavaPlugin {

    private LuckPerms luckPerms;

    @Override
    public void onEnable() {
        registerDependencies();
        registerEvents();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void registerDependencies() {
        luckPerms = this.getServer().getServicesManager().load(LuckPerms.class);
    }

    public void registerEvents() {
        Bukkit.getPluginManager().registerEvents(new PlayersFirstJoin(luckPerms), this);
    }

}
