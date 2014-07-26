/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.gyroninja.Sewers;

import java.util.Random;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.BlockFace;

/**
 *
 * @author gyroninja
 */
public class SewerManhole implements SewerPart {

	public void generate(Location start, int length, BlockFace bf, Random gen) {

		for (int i = 0; i < length; i++) {

			if (i == 0) {

				start.getBlock().setType(Material.IRON_FENCE);

				//TODO Add location to file
			}

			else {

				start.getBlock().setType(Material.LADDER);

				//TODO pass blockface instead of null, set data of ladder according to block face
			}
		}
	}
}
