/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.gyroninja.Sewers;

import java.util.Random;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;

/**
 *
 * @author gyroninja
 */
public class SewerGenerator implements SewerPart {

	private SewerManhole manhole = new SewerManhole();
	private SewerEntrance entrance = new SewerEntrance();

	public Block generate(Block start, int length, BlockFace bf, Random gen) {

		Block next = start;

		BlockFace direction =  BlockFace.values()[gen.nextInt(4)];

		next = manhole.generate(next, gen.nextInt(15) + 20, direction, gen);

		next = entrance.generate(next, gen.nextInt(8) + 12, direction, gen);

		return null;
	}
}
