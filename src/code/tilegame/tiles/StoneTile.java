package code.tilegame.tiles;

import code.tilegame.gfx.Assets;

public class StoneTile extends Tile{
	
	public StoneTile(int id) 
	{
		super(Assets.stone2, id);
	}
	
	
	public boolean isSolid()
	{
		return true;
	}

}
