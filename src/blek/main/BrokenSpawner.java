
/////////////////////////////
// Plugin created by blek! //
// creeperywime@gmail.com ///
/////////////////////////////


package blek.main;

import org.bukkit.plugin.java.JavaPlugin;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;


public final class BrokenSpawner extends JavaPlugin implements Listener {
	
	JavaPlugin plugin;
	
	@Override
	public void onEnable() {
		getLogger().info("BrokenSpawner was enabled");
		getLogger().info("BrokenSpawner by blek version 1.0");
		Bukkit.getPluginManager().registerEvents(this, this);
	}
	
	@Override
	public void onDisable() {
		getLogger().info("BrokenSpawner was disabled");
	}
	
	
	@EventHandler
	public void onPlayerMineBlock(BlockBreakEvent e) {
		Block b = e.getBlock();
		
		if (b.getType() == Material.MOB_SPAWNER) {
			
			Player p = e.getPlayer();
			ItemStack item = p.getItemInHand();
			if(item.getType() == Material.GOLD_PICKAXE) {
				
				if(item.getEnchantmentLevel(Enchantment.SILK_TOUCH) == 2) {
					
					p.playSound(p.getLocation(), Sound.ITEM_BREAK, 1, 1);
					p.getItemInHand().setType(Material.MOB_SPAWNER);
					for(Enchantment e1 : p.getItemInHand().getEnchantments().keySet())
					{
						p.getItemInHand().removeEnchantment(e1);
					}
					
				}
			}
		}
		else {
			return;
		}
	}
}
