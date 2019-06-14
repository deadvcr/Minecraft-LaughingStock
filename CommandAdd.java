/*    */ package com.deadvcr.laughingstock;
/*    */ 
/*    */ import java.util.Arrays;
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.command.Command;
/*    */ import org.bukkit.command.CommandExecutor;
/*    */ import org.bukkit.command.CommandSender;
/*    */ import org.bukkit.entity.Player;
/*    */ 
/*    */ 
/*    */ public class CommandAdd
/*    */   implements CommandExecutor
/*    */ {
/*    */   public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
/*    */   {
/* 16 */     if ((sender instanceof Player)) {
/* 17 */       Player ps = (Player)sender;
/* 18 */       if (args.length == 0) {
/* 19 */         ps.sendMessage("Please enter a player");
/*    */       } else {
/* 21 */         String pName = args[0];
/* 22 */         Player p = Bukkit.getPlayer(pName);
/* 23 */         if (p != null) {
/* 24 */           String[] reasonarr = (String[])Arrays.copyOfRange(args, 1, args.length);
/*    */           
/*    */ 
/*    */ 
/*    */ 
/* 29 */           String reason = Arrays.toString(reasonarr).replace(",", "").replace("[", "").replace("]", "").trim();
/* 30 */           Database db = new Database();
/* 31 */           db.connect("127.0.0.1", 27017);
/* 32 */           db.updatePlayer(p.getUniqueId(), true, reason);
/* 33 */           ps.sendMessage("Added " + p.getDisplayName() + " to the laughing stock with reason: " + reason);
/*    */         } else {
/* 35 */           ps.sendMessage("Player is null.");
/*    */         }
/*    */       }
/*    */     }
/* 39 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Terry\Documents\LaughingStock.jar!\com\deadvcr\laughingstock\CommandAdd.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */