package ru.Boss90.SexSystem.Commands;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import ru.Boss90.SexSystem.Utils.*;
public class SubCommandsSex implements CommandExecutor {
	  public boolean onCommand(final CommandSender sender, final Command cmd, final String label, final String[] args) {
		  
		if (!(sender instanceof Player)) {
	    	System.out.println("You are not a player");
	    	return true;
		}
		final Player commandSender = (Player) sender;
	    if (!commandSender.hasPermission("SexSystem.UseSubCommandsSex")) {
	        ChatUtils.sendMessage(commandSender, "Messages.NoPerm");
	        return true;
	    }if (args.length == 0) {
			ChatUtils.help(commandSender);
			return true;
		}
	    List<String> listOffers = Main.plugin.getConfig().getStringList("randomOffers");
	    Random randomInt = new Random();
	    int index = randomInt.nextInt(listOffers.size());
	    String randomWord = listOffers.get(index);
	    
	    //SUBCOMMANDS
		if (args[0].equalsIgnoreCase("buy")) {
			final ItemStack toy = new ItemStack(Material.BLAZE_ROD, 1);
			final ItemMeta metaToy = toy.getItemMeta();
			final ArrayList<String> list = new ArrayList<>();
            list.add(ConfigUtils.configGetString("Igryshka.Lore"));
            metaToy.setDisplayName(ConfigUtils.configGetString("Igryshka.Name"));
            metaToy.setLore(list);
            toy.setItemMeta(metaToy);
            commandSender.getInventory().addItem(toy);
            EconomyProvider.takeMoney(commandSender, Main.plugin.getConfig().getInt("Price.Buy"));
            ChatUtils.sendMessage(commandSender, "Messages.BuyIgryshka");
		}if (args[0].equalsIgnoreCase("help")) {
				List<String> helpMessages = Main.plugin.getConfig().getStringList("Help");
				helpMessages.forEach(commandSender::sendMessage);
				for(String message : helpMessages) {
					commandSender.sendMessage(message);
				}
		}if (args[0].equalsIgnoreCase("call")) {
				if (args.length == 1) {
					ChatUtils.sendMessage(commandSender, "Messages.offlinePlayerMessage");
					return true;
				}if (Bukkit.getPlayer(args[1]) == null) {
					ChatUtils.sendMessage(commandSender, "Messages.offlinePlayerMessage");
					return true;
				}if (args[1].contains(commandSender.getName())) {
					ChatUtils.sendMessage(commandSender, "Messages.nameCommandSender");
					return true;
				}if (commandSender.getLocation().distance(Bukkit.getPlayer(args[1]).getLocation()) >= Main.plugin.getConfig().getInt("Settings.distance") + 0.0D) {
					ChatUtils.sendMessage(commandSender, "Messages.Distance");
			    	return true;
			    }
				EffectUtils.givePlayerEffects(commandSender); //This method adds the effect to the player: SLOW, BLINDNESS, WEAKNESS, for 10 seconds with level 2.
				ChatUtils.sendMessage(commandSender, "Messages.SexSucess"); //This method sends the player a text with a color translation from the config.
				commandSender.sendMessage(ColorUtils.parserColor(randomWord));
				EffectUtils.givePlayerEffects(Bukkit.getPlayer(args[1]));
				ChatUtils.sendMessage(Bukkit.getPlayer(args[1]), "Messages.SexSucess");
				Bukkit.getPlayer(args[1]).sendMessage(ColorUtils.parserColor(randomWord));
		}
		return true; 
}
}
