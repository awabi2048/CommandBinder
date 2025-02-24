package awabi2048.command_binder

import awabi2048.command_binder.Main.Companion.configFile
import awabi2048.command_binder.Main.Companion.instance
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import java.io.File

object ReloadCommand: CommandExecutor {
    override fun onCommand(p0: CommandSender, p1: Command, p2: String, p3: Array<out String>?): Boolean {

        configFile.load(instance.dataFolder.path + File.separator + "config.yml")
        p0.sendMessage("CommandBinder >> Reloaded config.")

        return true
    }
}
