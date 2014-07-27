/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.gyroninja.Sewers;

import java.util.Random;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;

/**
 *
 * @author gyroninja
 */
public class SewerManhole implements SewerPart {

	private int[] ladderDataOffset = new int[] {

		0, 1, 1, -2
	};

	public Block generate(Block start, int length, BlockFace bf, Random gen) {

		Block centerBlock = start;

		for (int i = 0; i < length; centerBlock = centerBlock.getRelative(BlockFace.DOWN), i++) {

			if (i == 0) {

				for (BlockFace adjacent : BlockFace.values()) {

					if (adjacent == BlockFace.UP || adjacent == BlockFace.DOWN) {

						continue;
					}

					if (adjacent == BlockFace.SELF) {

						centerBlock.setType(Material.IRON_FENCE);

						break;
					}

					//Clear air above sewer hole
					centerBlock.getRelative(adjacent).getRelative(BlockFace.UP).setType(Material.AIR);
				}

				//TODO Add location to file
			}

			else {

				centerBlock.setType(Material.LADDER);
				centerBlock.setData((byte) (bf.ordinal() + ladderDataOffset[bf.ordinal()]));
			}

			for (BlockFace adjacent : BlockFace.values()) {

				if (adjacent == BlockFace.UP || adjacent == BlockFace.DOWN || adjacent == BlockFace.SELF) {

					continue;
				}

				centerBlock.getRelative(adjacent).setType(Material.SMOOTH_BRICK);
				centerBlock.getRelative(adjacent).setData((byte) gen.nextInt(3));
			}
		}

		return centerBlock;
	}
}
