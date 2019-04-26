package code.tilegame.worlds;

import java.awt.Graphics;

import code.tilegame.Handler;
import code.tilegame.entities.EntityManager;
import code.tilegame.entities.creatures.player.Player;
import code.tilegame.entities.creatures.statics.Rock;
import code.tilegame.entities.creatures.statics.Tree;
import code.tilegame.items.ItemManager;
import code.tilegame.tiles.Tile;
import code.tilegame.utils.Utils;

public class World {
	
	private Handler handler;
	private int width, height;
	private int spawnX, spawnY; //player
	private int [][]tiles;
	
	//Entities (objects in world)
	private EntityManager entityManager;	
	
	//Items
	private ItemManager itemManager;
	
	public World(Handler handler, String path)
	{
		this.handler=handler;	
		entityManager=new EntityManager(handler, new Player(handler, 100, 100));
		itemManager=new ItemManager(handler);
		
		//tree add
		entityManager.addEntity(new Tree(handler,1*Tile.TILE_WIDTH, (int)(1.5*Tile.TILE_HEIGHT)));
		entityManager.addEntity(new Tree(handler,6*Tile.TILE_WIDTH, -(int)(1.8*Tile.TILE_HEIGHT)));
		entityManager.addEntity(new Tree(handler,9*Tile.TILE_WIDTH, 5*Tile.TILE_HEIGHT-10));
		entityManager.addEntity(new Tree(handler,12*Tile.TILE_WIDTH, 5*Tile.TILE_HEIGHT-10));
		entityManager.addEntity(new Tree(handler,15*Tile.TILE_WIDTH, 5*Tile.TILE_HEIGHT-10));	
		entityManager.addEntity(new Tree(handler,10*Tile.TILE_WIDTH, 7*Tile.TILE_HEIGHT+10));
		entityManager.addEntity(new Tree(handler,13*Tile.TILE_WIDTH, 7*Tile.TILE_HEIGHT+10));
		entityManager.addEntity(new Tree(handler,16*Tile.TILE_WIDTH, 7*Tile.TILE_HEIGHT+10));

		
		//stones add
		entityManager.addEntity(new Rock(handler,4*Tile.TILE_WIDTH, 3*Tile.TILE_HEIGHT+10));
		
		
		
		loadWorld(path);
		
		entityManager.getPlayer().setX(spawnX);
		entityManager.getPlayer().setY(spawnY);
	}
	

	public void tick()
	{
		itemManager.tick();
		entityManager.tick();
	}
	
	public void render(Graphics g)
	{
		int xStart = (int) Math.max(0, handler.getGameCamera().getxOffset() / Tile.TILE_WIDTH);
		int xEnd=(int) Math.min(width, (handler.getGameCamera().getxOffset()+handler.getWidth()) / Tile.TILE_WIDTH+1);
		int yStart=(int) Math.max(0, handler.getGameCamera().getyOffset() / Tile.TILE_HEIGHT);
		int yEnd=(int) Math.min(height, (handler.getGameCamera().getyOffset()+handler.getHeight()) / Tile.TILE_WIDTH+1);
		
	
		
		
		for(int y=yStart;y<yEnd;y++)
		{
			for(int x=xStart;x<xEnd;x++)
			{
				getTile(x,y).render(g,(int)(x*Tile.TILE_WIDTH - handler.getGameCamera().getxOffset()), 
						(int)(y*Tile.TILE_HEIGHT - handler.getGameCamera().getyOffset()));
			}
		}
		
		//Items
		itemManager.render(g);
		//Entities render
		entityManager.render(g);
	}


	public Tile getTile(int x, int y)
	{
		if(x<0||y<0||x>width||y>height)return Tile.grass2Tile;
		Tile t =Tile.tiles[tiles[x][y]];
		if(t==null) return Tile.dirtTile;
		return t;
	}
	
	private void loadWorld(String path)
	{
		
		String file = Utils.loadFileAsString(path);
		String []tokens=file.split("\\s+");
		width=Utils.parseInt(tokens[0]);
		height=Utils.parseInt(tokens[1]);
		spawnX=Utils.parseInt(tokens[2]);
		spawnY=Utils.parseInt(tokens[3]);
		 
		tiles=new int[width][height];
		
		for(int y=0;y<height;y++)
			for(int x=0;x<width;x++)
			{
				tiles[x][y]=Utils.parseInt(tokens[(x+y*width)+4]);
			} 
	}
	
	//Getters and setters
	
	public int getWidth()
	{
		return width;
	}
	
	public int getHeight()
	{
		return height;
	}
	
	public Handler getHandler() {
		return handler;
	}


	public void setHandler(Handler handler) {
		this.handler = handler;
	}


	public ItemManager getItemManager() {
		return itemManager;
	}


	public void setItemManager(ItemManager itemManager) {
		this.itemManager = itemManager;
	}
	
	public EntityManager getEntityManager()
	{
		return entityManager;
	}

}
