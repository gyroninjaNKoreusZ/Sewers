/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.gyroninja.Sewers;

import java.util.Random;
import org.bukkit.Location;
import org.bukkit.block.BlockFace;

/**
 *
 * @author gyroninja
 */
public class SewerGenerator implements SewerPart {

	public void generate(Location start, int length, BlockFace bf, Random gen) {

		SewerManhole manhole = new SewerManhole();

		manhole.generate(start, gen.nextInt(15) + 20, BlockFace.values()[gen.nextInt(4)], gen);
	}
}
