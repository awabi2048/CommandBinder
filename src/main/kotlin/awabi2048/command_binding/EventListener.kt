package awabi2048.command_binding

import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerSwapHandItemsEvent

object EventListener: Listener {
    @EventHandler
    fun onShiftF(event: PlayerSwapHandItemsEvent) {
        if (event.player.isSneaking) {
            val executor = BinderExecutor(event.player, Binder.SHIFT_F)
            executor.execute()
        }
    }


}
