package code.tilegame.entities.creatures.statics;

import java.awt.Graphics;

import code.tilegame.Handler;
import code.tilegame.gfx.Assets;
import code.tilegame.items.Item;
import code.tilegame.tiles.Tile;

public class Rock extends StaticEntity{

	public Rock(Handler handler, float x, float y) 
	{
		super(handler, x, y, Tile.TILE_WIDTH, Tile.TILE_HEIGHT);
		bounds.x=3;
		bounds.y=(int) (height/2f);
		bounds.width=width-6;
		bounds.height=(int) (height-width/1.2f);	
	}

	public void tick() 
	{
		
	}

	public void render(Graphics g)
	{
		g.drawImage(Assets.stoneAsset, (int)(x-handler.getGameCamera().getxOffset()), (int) (y-handler.getGameCamera().getyOffset()), width, height, null);
	}
	
	public void die()
	{
		handler.getWorld().getItemManager().addItem(Item.stoneItem.createNew((int)x, (int)y));
	}
}
