package tilegame.tile;

import tilegame.gfx.Assets;
/**
 * This class sets the details of a RockTile
 * @author Kenneth Lange
 *
 */
public class RockTile extends Tile{

	public RockTile(int id) {
		super(Assets.stonepath, id);
	}
	
	@Override
	public boolean isSolid(){
		return true;
	}

}
