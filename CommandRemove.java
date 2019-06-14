/*    */ package com.deadvcr.laughingstock;
/*    */ 
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ public class CommandRemove
/*    */   implements CommandExecutor
/*    */ {
/*    */   public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
/*    */   {
/* 14 */     if ((sender instanceof Player)) {
/* 15 */       Player ps = (Player)sender;
/* 16 */       if (args.length == 0) {
/* 17 */         ps.sendMessage("Please enter a player");
/*    */       } else {
/* 19 */         String pName = args[0];
/* 20 */         Player p = Bukkit.getPlayer(pName);
/* 21 */         if (p != null) {
/* 22 */           Database db = new Database();
/* 23 */           db.connect("127.0.0.1", 27017);
/* 24 */           db.updatePlayer(p.getUniqueId(), false, "");
/* 25 */           ps.sendMessage(p.getDisplayName() + " has been removed from the laughing stock.");
/*    */         } else {
/* 27 */           ps.sendMessage("Player is null.");
/*    */         }
/*    */       }
/*    */     }
/* 31 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Terry\Documents\LaughingStock.jar!\com\deadvcr\laughingstock\CommandRemove.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */