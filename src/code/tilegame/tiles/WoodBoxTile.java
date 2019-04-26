package code.tilegame.tiles;

import code.tilegame.gfx.Assets;

public class WoodBoxTile extends Tile {
	
	public WoodBoxTile(int id)
	{
		super(Assets.woodBox, id);
	}
	
	public boolean isSolid()
	{
		return true;
	}

}
