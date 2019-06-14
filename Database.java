 package com.deadvcr.laughingstock;

 import com.mongodb.DBObject;
 import java.util.UUID;

 public class Database
 {
   private com.mongodb.DBCollection players;
   private com.mongodb.DB mcserverdb;
   private com.mongodb.MongoClient client;

   public boolean connect(String ip, int port)
   {
     try
     {
       this.client = new com.mongodb.MongoClient(ip, port);
     } catch (java.net.UnknownHostException e) {
       System.out.println("could not connect.");
       e.printStackTrace();
       return false;
     }
     this.mcserverdb = this.client.getDB("laughingstock");

     this.players = this.mcserverdb.getCollection("players");
     return true;
   }

   public void storePlayer(UUID uuid, String name, boolean laughingStock, String laughingStockReason) {
     DBObject obj = new com.mongodb.BasicDBObject("uuid", uuid);
     obj.put("name", name);
     obj.put("laughingstock", Boolean.valueOf(laughingStock));
     obj.put("laughingstockreason", laughingStockReason);

     this.players.insert(new DBObject[] { obj });
   }

   public void readPlayer(UUID uuid) {
     DBObject r = new com.mongodb.BasicDBObject("uuid", uuid);
     DBObject found = this.players.findOne(r);

     if (found == null) {
       return;
     }

     String name = (String)found.get("name");
     boolean laughingstock = ((Boolean)found.get("laughingstock")).booleanValue();
     String laughingstockreason = (String)found.get("laughingstockreason");
   }

   public void updatePlayer(UUID uuid, boolean laughingStock, String laughingStockReason)
   {
     DBObject r = new com.mongodb.BasicDBObject("uuid", uuid);
     DBObject found = this.players.findOne(r);
     if (found == null) {
       return;
     }

     System.out.println("Adding info for");
     System.out.println(uuid);

     DBObject obj = new com.mongodb.BasicDBObject("uuid", uuid);
     obj.put("laughingstock", Boolean.valueOf(laughingStock));
     obj.put("laughingstockreason", laughingStockReason);
     this.players.update(found, obj);
   }

   public boolean readLSStatus(UUID uuid) {
     DBObject r = new com.mongodb.BasicDBObject("uuid", uuid);
     DBObject found = this.players.findOne(r);

     if (found == null) {
       return false;
     }

     boolean laughingstock = ((Boolean)found.get("laughingstock")).booleanValue();

   }

   public String readLSReason(UUID uuid) {
     DBObject e = new com.mongodb.BasicDBObject("uuid", uuid);
     DBObject found = this.players.findOne(e);

     if (found == null) {
       return "";
     }

     String lsreason = (String)found.get("laughingstockreason");
     return lsreason;
   }

   public boolean checkIfExists(UUID uuid) {
     DBObject e = new com.mongodb.BasicDBObject("uuid", uuid);
     if (this.players.find(e).count() >= 1) {
       System.out.println("Exists");
       return true;
     }
     System.out.println("Does not exist.");
     return false;
   }
 }


/* Location:              C:\Users\Terry\Documents\LaughingStock.jar!\com\deadvcr\laughingstock\Database.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       0.7.1
 */