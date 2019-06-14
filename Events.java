package com.deadvcr.laughingstock;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Events implements Listener
{
  @EventHandler
  public void onPlayerJoin(PlayerJoinEvent e)
  {
    Player p = e.getPlayer();
    Database d = new Database();
    d.connect("127.0.0.1", 27017);
    boolean lsstatus = d.readLSStatus(p.getUniqueId());
    String lsreason = d.readLSReason(p.getUniqueId());
    String displayname = p.getDisplayName();
    if (!d.checkIfExists(p.getUniqueId())) {
      d.storePlayer(p.getUniqueId(), p.getDisplayName(), lsstatus, lsreason);
    }

    if (lsstatus) {
      org.bukkit.Bukkit.broadcastMessage(ChatColor.BLUE + "" + ChatColor.BOLD + displayname + " is the laughing stock of this community! Point at them and laugh for: " + lsreason);
    }
  }
}


/* Location:              C:\Users\Terry\Documents\LaughingStock.jar!\com\deadvcr\laughingstock\Events.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */