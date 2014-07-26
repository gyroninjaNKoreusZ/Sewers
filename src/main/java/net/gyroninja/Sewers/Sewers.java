/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.gyroninja.Sewers;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author gyroninja
 */

public class Sewers extends JavaPlugin {

	@Override
	public void onEnable() {

		Bukkit.getPluginManager().registerEvents(new SewersListener(), this);
	}
}
