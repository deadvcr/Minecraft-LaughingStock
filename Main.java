/*    */ package com.deadvcr.laughingstock;
/*    */ 
/*    */ import org.bukkit.Bukkit;
/*    */ import org.bukkit.command.PluginCommand;
/*    */ import org.bukkit.plugin.PluginManager;
/*    */ 
/*    */ public class Main extends org.bukkit.plugin.java.JavaPlugin
/*    */ {
/*    */   public void onEnable()
/*    */   {
/* 11 */     Bukkit.getConsoleSender().sendMessage("Starting laughing stock");
/* 12 */     Bukkit.getPluginManager().registerEvents(new Events(), this);
/* 13 */     getCommand("laughingstockadd").setExecutor(new CommandAdd());
/* 14 */     getCommand("laughingstockremove").setExecutor(new CommandRemove());
/*    */   }
/*    */   
/*    */   public void onDisable() {}
/*    */ }


/* Location:              C:\Users\Terry\Documents\LaughingStock.jar!\com\deadvcr\laughingstock\Main.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */