package ru.boss90.sexsystem.commands;

import java.util.*;
import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import net.md_5.bungee.api.chat.*;
import ru.boss90.sexsystem.main.Main;
import ru.boss90.sexsystem.utils.*;

public class SubCommandSex implements CommandExecutor {
	
	  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		  
		if (!(sender instanceof Player)) {
	    	System.out.println("You are not a player");
	    	return true;
		}
		
		//variables
		
		Player commandSender = (Player) sender;
		
		//Checks
		
	    if (!commandSender.hasPermission("SexSystem.useSubCommands")) {
	        MessageUtils.sendMessage(commandSender, "Messages.NoPerm");
	        return true;
	    }
	    
	    if (args.length == 0) {
			MessageUtils.sendMessage(commandSender, "Messages.SelectPage");
			TextComponent message = new TextComponent(ChatColor.translateAlternateColorCodes('&', "&aClick" ));
			message.setClickEvent(new ClickEvent( ClickEvent.Action.RUN_COMMAND, "/sex help"));
			message.setHoverEvent(new HoverEvent( HoverEvent.Action.SHOW_TEXT, new ComponentBuilder("Click for me.").create() ) );
			commandSender.spigot().sendMessage(message);
			return true;
	    }
	    
	    //SUBCOMMANDS
	    
		if (args[0].equalsIgnoreCase("buy")) {

			ArrayList<String> list = new ArrayList<>();	
			ItemStack toy = new ItemStack(Material.BLAZE_ROD);
			ItemMeta metaToy = toy.getItemMeta();
            list.add(ConfigUtils.getString("Toy.Lore"));
            metaToy.setDisplayName(ConfigUtils.getString("Toy.Name"));
            metaToy.setLore(list);
            toy.setItemMeta(metaToy);
            commandSender.getInventory().addItem(toy);
            EconomyProvider.takeMoney(commandSender, Main.plugin.getConfig().getInt("Settings.PriceToy"));
            MessageUtils.sendMessage(commandSender, "Messages.BuyToy");
            
		}
		
		if (args[0].equalsIgnoreCase("help")) {
			
				List<String> helpMessages = Main.plugin.getConfig().getStringList("helpForPlugin");
				for(String helpMsg : helpMessages) {
					commandSender.sendMessage(ColorUtils.parser(helpMsg));
				}
				return true;		
				
		}
		
		if (args[0].equalsIgnoreCase("call")) {
			
			List<String> listOffers = Main.plugin.getConfig().getStringList("randomOffers");
		    String randomWord = listOffers.get(new Random().nextInt(listOffers.size()));
			
			if (args.length == 1) {
				MessageUtils.sendMessage(commandSender, "Messages.NullFindPartner");
				return true;
			}
			if (Bukkit.getPlayer(args[1]) == null) {
				MessageUtils.sendMessage(commandSender, "Messages.FailedFindPartner");
				return true;
			}
			if (args[1].contains(commandSender.getName())) {
				MessageUtils.sendMessage(commandSender, "Messages.PartnerIsSender");
				return true;
			}
			if (commandSender.getLocation().distance(Bukkit.getPlayer(args[1]).getLocation()) >= Main.plugin.getConfig().getInt("Settings.distance")) {
				MessageUtils.sendMessage(commandSender, "Messages.PartnerIsFarAway");
				return true;
			}
																				
			EffectUtils.givePlayerEffects(commandSender); //This method adds the effect to the player: SLOW, BLINDNESS, WEAKNESS, for 10 seconds with level 2.
			MessageUtils.sendMessage(commandSender, "Messages.SucessSexMale"); //This method sends the player a text with a color translation from the config.
	        commandSender.sendMessage(ColorUtils.parser(randomWord));
			EffectUtils.givePlayerEffects(Bukkit.getPlayer(args[1]));
	        MessageUtils.sendMessage(Bukkit.getPlayer(args[1]), "Messages.SucessSexGirl");
			Bukkit.getPlayer(args[1]).sendMessage(ColorUtils.parser(randomWord));
				
		}
		return true; 
}
}
