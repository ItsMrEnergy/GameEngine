package tilegame.worlds;

import tilegame.utils.Vector2i;
/**
 * This class holds data of nodes which reference tiles
 * @author Kenneth Lange
 * M: Engine
 */
public class Node {

	public Vector2i tile;
	public Node parent;
	public double fCost, gCost, hCost;
	
	public Node(Vector2i tile, Node parent, double gCost, double hCost) {
		this.tile = tile;
		this.parent = parent;
		this.gCost = gCost;
		this.hCost = hCost;
		fCost = this.gCost + this.hCost;
	}
	
}
