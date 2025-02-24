package awabi2048.command_binding

import awabi2048.command_binding.Main.Companion.configFile
import awabi2048.command_binding.Main.Companion.instance
import org.bukkit.Bukkit
import org.bukkit.entity.Player

class BinderExecutor(val player: Player, val binder: Binder) {
    fun execute() {
        val playerCommands = configFile.getStringList("${binder.toString().lowercase()}.player_commands")
        val serverCommands = configFile.getStringList("${binder.toString().lowercase()}.server_commands")

        playerCommands.forEach { player.performCommand(it) }
        serverCommands.forEach { Bukkit.dispatchCommand(instance.server.consoleSender, it) }
    }
}
