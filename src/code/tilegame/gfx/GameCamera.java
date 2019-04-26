package code.tilegame.gfx;

import code.tilegame.Handler;
import code.tilegame.entities.Entity;
import code.tilegame.tiles.Tile;

public class GameCamera {
	
	private float xOffset;
	private float yOffset;
	private Handler handler;
	
	public GameCamera(Handler handler, float xOffset, float yOffset)
	{
		this.handler=handler;
		this.xOffset=xOffset;
		this.yOffset=yOffset;
	}
	
	//stops camera on the edges of the map
	public void checkBlankSpace() 
	{
		if(xOffset<0)xOffset=0;
		
		else if(xOffset>handler.getWorld().getWidth()*Tile.TILE_WIDTH-handler.getWidth())
			xOffset=handler.getWorld().getWidth()*Tile.TILE_WIDTH-handler.getWidth();
		
		if(yOffset<0)yOffset=0;
		
		else if(yOffset>handler.getWorld().getHeight()*Tile.TILE_HEIGHT-handler.getHeight())
			yOffset=handler.getWorld().getHeight()*Tile.TILE_HEIGHT-handler.getHeight();
	}
	
	
	public void centerOnEntity(Entity e)
	{
		xOffset=e.getX() - handler.getWidth()/2+e.getWidth()/2;
		yOffset=e.getY() - handler.getHeight()/2+e.getHeight()/2;
		
		//check for stop camera
		checkBlankSpace();
	}
 
	public void move(float xAmount, float yAmount)
	{
		xOffset+=xAmount;
		yOffset+=yAmount;
		
		//check for stop camera
		//checkBlankSpace();
	}
	
	public float getxOffset() {
		return xOffset;
	}

	public void setxOffset(float xOffset) {
		this.xOffset = xOffset;
	}

	public float getyOffset() {
		return yOffset;
	}

	public void setyOffset(float yOffset) {
		this.yOffset = yOffset;
	}

}
