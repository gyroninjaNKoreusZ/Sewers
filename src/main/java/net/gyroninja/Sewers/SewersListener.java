/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.gyroninja.Sewers;

import java.util.Random;
import org.bukkit.block.Block;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.world.ChunkPopulateEvent;

/**
 *
 * @author gyroninja
 */
public class SewersListener implements Listener {

	@EventHandler
	public void onChunkPopulate(ChunkPopulateEvent event) {

		long seed = event.getWorld().getSeed();

		//Generate offset with higher 4 bits with X and lower 4 bits with Z
		long chunkOffset = event.getChunk().getX();

		chunkOffset <<= 4;

		chunkOffset &= event.getChunk().getZ();

		Random gen = new Random(seed + chunkOffset);

		//Replace with config value (1 in 100 chunks generates sewer)
		if (gen.nextInt(100) == 0) {

			SewerGenerator generator = new SewerGenerator();

			Block start = event.getWorld().getHighestBlockAt(event.getChunk().getBlock(gen.nextInt(16), 0, gen.nextInt(16)).getLocation());

			//Replace with config value (size 5 - 50 segments)
			generator.generate(start, gen.nextInt(45) + 5, null, gen);
		}
	}
}
