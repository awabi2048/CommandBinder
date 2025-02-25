package awabi2048.command_binder

import org.bukkit.configuration.file.FileConfiguration
import org.bukkit.entity.Player
import org.bukkit.plugin.java.JavaPlugin

class Main : JavaPlugin() {

    companion object {
        lateinit var instance: JavaPlugin
        lateinit var configFile: FileConfiguration

        var detectionCooldown: MutableMap<Player, MutableList<Binder>> = mutableMapOf()
    }

    override fun onEnable() {
        instance = this
        server.pluginManager.registerEvents(EventListener, instance)
        configFile = config
        saveDefaultConfig()

        getCommand("commandbinder_reload")?.setExecutor(ReloadCommand)
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}
