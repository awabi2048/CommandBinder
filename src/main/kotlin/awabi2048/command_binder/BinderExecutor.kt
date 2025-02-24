package awabi2048.command_binder

import awabi2048.command_binder.Main.Companion.configFile
import awabi2048.command_binder.Main.Companion.instance
import org.bukkit.Bukkit
import org.bukkit.entity.Player

class BinderExecutor(private val player: Player, private val binder: Binder) {
    fun execute() {
        val playerCommandsRaw = configFile.getStringList("${binder.toString().lowercase()}.player_commands")
        val serverCommandsRaw = configFile.getStringList("${binder.toString().lowercase()}.server_commands")

        val playerCommands = playerCommandsRaw.map {
            it.replace("%player_name%", player.displayName)
                .replace("%player_uuid%", player.uniqueId.toString())
        }

        val serverCommands = serverCommandsRaw.map {
            it.replace("%player_name%", player.displayName)
                .replace("%player_uuid%", player.uniqueId.toString())
        }

        playerCommands.forEach { player.performCommand(it) }
        serverCommands.forEach { Bukkit.dispatchCommand(instance.server.consoleSender, it) }
    }
}
