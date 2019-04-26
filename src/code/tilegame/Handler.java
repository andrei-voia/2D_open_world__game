package code.tilegame;

import code.tilegame.gfx.GameCamera;
import code.tilegame.input.KeyManager;
import code.tilegame.input.MouseManager;
import code.tilegame.worlds.World;

public class Handler {
	
	private Game game;
	private World world;
	
	public Handler(Game game)
	{
		this.game=game;
	}
	
	
	
	public MouseManager getMouseManager()
	{
		return game.getMouseManager();
	}
	

	public GameCamera getGameCamera()
	{
		return game.getGameCamera();
	}
	
	public KeyManager getKeyManager()
	{
		return game.getKeyManager();
	}
	
	public int getWidth()
	{
		return game.getWidth();
	}

	public int getHeight()
	{
		return game.getHeight();
	}
	
		
	
	
	//GETTERS / SETTERS
	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public World getWorld() {
		return world;
	}

	public void setWorld(World world) {
		this.world = world;
	}

}
