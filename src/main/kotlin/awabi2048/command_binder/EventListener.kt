package awabi2048.command_binder

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerSwapHandItemsEvent

object EventListener: Listener {
    @EventHandler
    fun onShiftF(event: PlayerSwapHandItemsEvent) {
        if (event.player.isSneaking && Main.detectionCooldown[event.player]?.contains(Binder.SHIFT_F) != true) {
            val executor = BinderExecutor(event.player, Binder.SHIFT_F)
            executor.execute()

            event.isCancelled = true
        }
    }
}
