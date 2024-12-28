package dev.ev1dent.kpmainframe;

import dev.ev1dent.kpmainframe.events.PlayersFirstJoin;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public final class KPMainFrame extends JavaPlugin {

    @Override
    public void onEnable() {
        registerEvents();

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public void registerEvents() {
        Bukkit.getPluginManager().registerEvents(new PlayersFirstJoin(), this);
    }
}
