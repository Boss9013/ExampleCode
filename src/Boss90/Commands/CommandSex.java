package Boss90.Commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import Boss90.Utils.EconomyManager;
import Boss90.Utils.SexMain;
import Boss90.Utils.SexMethods;
public class CommandSex implements CommandExecutor{
	  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	    if (!sender.hasPermission("Sex.Sex")) {
	        sender.sendMessage(SexMain.plugin.getConfig().getString("Messages.NoPermission"));
	      return true;
	    }
	    if (!(sender instanceof Player)) {
	    	System.out.println("You no player.");
	    	return true;
	    }
	    Player p = (Player) sender;
		if (args.length == 0) {
			SexMethods.Help(p);
			return true;
		}
	    List<String> messs = SexMain.plugin.getConfig().getStringList("Random");
	    Random r = new Random();
	    int index = r.nextInt(messs.size());
	    String mess = messs.get(index);
	    
	    //Ñâåğõó ïğîâåğêè/ïåğåìåííûå
	    
	    //ÑÍÈÇÓ ÏĞÎÂÅĞÊÀ ÏÎÄÊÎÌÀÍÄ
	    
		switch (args[0].toString()) {
			case ("buy"):
            ItemStack i2 = new ItemStack(Material.BLAZE_ROD, 1);
            ItemMeta metaclock = i2.getItemMeta();
            ArrayList<String> list = new ArrayList<>();
            list.add(SexMethods.ConfigString("Igryshka.Lore"));
            metaclock.setDisplayName(SexMethods.ConfigString("Igryshka.Name"));
            metaclock.setLore(list);
            i2.setItemMeta(metaclock);
            p.getInventory().addItem(i2);
            EconomyManager.takeMoney(p, SexMain.plugin.getConfig().getInt("Price.Buy"));
            SexMethods.sendMessage(p, "Messages.BuyIgryshka");
			break;
			case ("help"):
		        for (int i3 = 0; i3 < SexMain.plugin.getConfig().getStringList("Help").size(); i3++) {
		        	p.sendMessage(ChatColor.translateAlternateColorCodes('&',SexMain.plugin.getConfig().getStringList("Help").remove(i3)));
		        }
				break;
			case ("call"):
				if(args.length == 1) {
					SexMethods.sendMessage(p, "Messages.OfflinePlayer");
					return true;
				}
				if(Bukkit.getPlayer(args[1]) == null) {
					SexMethods.sendMessage(p, "Messages.OfflinePlayer");
					return true;
				}
				if(args[1].contains(p.getName())) {
					SexMethods.sendMessage(p, "Messages.SexPartner");
					return true;
				}
			    if (p.getLocation().distance(Bukkit.getPlayer(args[1]).getLocation()) >= SexMain.plugin.getConfig().getInt("Settings.distance") + 0.0D) {
					SexMethods.sendMessage(p, "Messages.Distance");
			    	return true;
			    }
				SexMethods.Effect(p);
				SexMethods.sendMessage(p, "Messages.SexSucess");
				SexMethods.sendMessage2(p, mess);
				SexMethods.Effect(Bukkit.getPlayer(args[1]));
				SexMethods.sendMessage(Bukkit.getPlayer(args[1]), "Messages.SexSucess");
				SexMethods.sendMessage2(Bukkit.getPlayer(args[1]), mess);
				break;
			default:
				SexMethods.Help(p);
				break;
		}
		return true; 
}
}
