package code.tilegame.entities.creatures.statics;

import java.awt.Graphics;

import code.tilegame.Handler;
import code.tilegame.gfx.Assets;
import code.tilegame.items.Item;
import code.tilegame.tiles.Tile;

public class Tree extends StaticEntity{
	
	public Tree(Handler handler, float x, float y)
	{
		super(handler, x, y, 2*Tile.TILE_WIDTH, 4*Tile.TILE_HEIGHT);
		
		//bounds
		bounds.x=width/4+width/10;
		bounds.y=height-20;
		bounds.width=width/2-width/5;
		bounds.height=height/40;
	}

	public void tick()
	{
		
	}

	public void render(Graphics g) 
	{
		g.drawImage(Assets.tree2Big, (int) (x-handler.getGameCamera().getxOffset()), (int) (y-handler.getGameCamera().getyOffset()), width, height, null);	
	}
	
	public void die()
	{
		handler.getWorld().getItemManager().addItem(Item.woodItem.createNew((int)(x+Tile.TILE_WIDTH), (int)(y+3.5*Tile.TILE_HEIGHT)));
	}
}
