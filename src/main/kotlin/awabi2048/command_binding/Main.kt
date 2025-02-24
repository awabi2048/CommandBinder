package awabi2048.command_binding

import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin() {

    companion object {
        lateinit var instance: JavaPlugin
        lateinit var configFile: FileConfiguration
    }

    override fun onEnable() {
        // Plugin startup logic
        server.pluginManager.registerEvents(EventListener, instance)
        configFile = config
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}
