/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package net.gyroninja.Sewers;

import java.util.Random;
import org.bukkit.block.Block;
import org.bukkit.block.BlockFace;

/**
 *
 * @author gyroninja
 */
public interface SewerPart {

	public abstract Block generate(Block start, int length, BlockFace bf, Random gen);
}
