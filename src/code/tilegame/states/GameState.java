package code.tilegame.states;

import java.awt.Graphics;
import code.tilegame.Handler;
import code.tilegame.worlds.World;

public class GameState extends State{

	private World world;
	
	public GameState(Handler handler)
	{
		super(handler);
		
		world=new World(handler, "Resources/worlds/world1.txt");
		handler.setWorld(world);
		//player=new Player(handler, 100,100);	
	}
	
	public void tick()
	{
		world.tick();
		//player.tick();
	}
	
	public void render(Graphics g)
	{
		world.render(g);
		//player.render(g);
		//Tile.tiles[0].render(g, 0, 0);
	}
}
