package dev.ev1dent.kpmainframe.functionality;

import dev.ev1dent.kpmainframe.utilities.Utils;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.model.user.User;
import net.luckperms.api.node.Node;
import net.luckperms.api.node.types.PermissionNode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class FirstJoinDenyQuarterlyKit implements Listener {

    private final LuckPerms luckPerms;
    private final Utils Utils = new Utils();

    public FirstJoinDenyQuarterlyKit(LuckPerms luckPerms) {
        this.luckPerms = luckPerms;
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if(player.hasPlayedBefore()) return;

        UUID playerUUID = player.getUniqueId();
        luckPerms.getUserManager().modifyUser(playerUUID, (User user) -> {
            Node node = PermissionNode.builder("essentials.kits.quarterly").expiry(30, TimeUnit.DAYS).value(false).build();
            Utils.logInfo("New Player: %s (%s) - Denying Quarterly Kit", player.getName(), player.getUniqueId());
            user.data().add(node);
        });

    }
}
