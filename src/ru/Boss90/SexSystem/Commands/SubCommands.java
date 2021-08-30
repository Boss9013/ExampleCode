package ru.Boss90.SexSystem.Commands;

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

import ru.Boss90.SexSystem.Utils.SexSystemEconomyManager;
import ru.Boss90.SexSystem.Utils.Main;
import ru.Boss90.SexSystem.Utils.Methods;
public class SubCommands implements CommandExecutor{
	  public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		  
		if (!(sender instanceof Player)) {
	    	System.out.println("You no player.");
	    	return true;
		}
		final Player p = (Player) sender;
	    if (!p.hasPermission("Sex.Sex")) {
	        p.sendMessage(Main.plugin.getConfig().getString("Messages.NoPermission"));
	        return true;
	    }
		if (args.length == 0) {
			Methods.Help(p);
			return true;
		}
	    final List<String> messs = Main.plugin.getConfig().getStringList("Random");
	    final Random r = new Random();
	    final int index = r.nextInt(messs.size());
	    final String mess = messs.get(index);
	    
	    //Ñâåğõó ïğîâåğêè/ïåğåìåííûå
	    
	    //ÑÍÈÇÓ ÏĞÎÂÅĞÊÀ ÏÎÄÊÎÌÀÍÄ
	    
		switch (args[0].toString()) {
			case ("buy"):
			final ItemStack i2 = new ItemStack(Material.BLAZE_ROD, 1);
			final ItemMeta metaclock = i2.getItemMeta();
			final ArrayList<String> list = new ArrayList<>();
            list.add(Methods.ConfigString("Igryshka.Lore"));
            metaclock.setDisplayName(Methods.ConfigString("Igryshka.Name"));
            metaclock.setLore(list);
            i2.setItemMeta(metaclock);
            p.getInventory().addItem(i2);
            SexSystemEconomyManager.takeMoney(p, Main.plugin.getConfig().getInt("Price.Buy"));
            Methods.sendMessage(p, "Messages.BuyIgryshka");
			break;
			case ("help"):
		        for (int i3 = 0; i3 < Main.plugin.getConfig().getStringList("Help").size(); i3++) {
		        	p.sendMessage(ChatColor.translateAlternateColorCodes('&',Main.plugin.getConfig().getStringList("Help").remove(i3)));
		        }
				break;
			case ("call"):
				if (args.length == 1) {
					Methods.sendMessage(p, "Messages.OfflinePlayer");
					return true;
				}
				if (Bukkit.getPlayer(args[1]) == null) {
					Methods.sendMessage(p, "Messages.OfflinePlayer");
					return true;
				}
				if (args[1].contains(p.getName())) {
					Methods.sendMessage(p, "Messages.SexPartner");
					return true;
				}
			    if (p.getLocation().distance(Bukkit.getPlayer(args[1]).getLocation()) >= Main.plugin.getConfig().getInt("Settings.distance") + 0.0D) {
					Methods.sendMessage(p, "Messages.Distance");
			    	return true;
			    }
				Methods.Effect(p);
				Methods.sendMessage(p, "Messages.SexSucess");
				Methods.sendMessage2(p, mess);
				Methods.Effect(Bukkit.getPlayer(args[1]));
				Methods.sendMessage(Bukkit.getPlayer(args[1]), "Messages.SexSucess");
				Methods.sendMessage2(Bukkit.getPlayer(args[1]), mess);
				break;
			default:
				Methods.Help(p);
				break;
		}
		return true; 
}
}
