package me.erisos.qsystem;

import me.erisos.qsystem.commands.QCommands;
import me.erisos.qsystem.listeners.QCommandEvent;
import me.erisos.qsystem.listeners.QJoinEvent;
import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class QSystem extends JavaPlugin {


    @Override
    public void onEnable() {

        Bukkit.getPluginManager().registerEvents(new QJoinEvent(), this);
        Bukkit.getPluginManager().registerEvents(new QCommandEvent(this), this);

        getCommand("qSystem").setExecutor(new QCommands());

        getConfig().options().copyDefaults();
        saveDefaultConfig();
    }
}