 package code.tilegame.states;

import java.awt.Graphics;
import code.tilegame.Handler;

public abstract class State {

	private static State currentState=null;
	protected Handler handler;
	
	public State(Handler handler)
	{
		this.handler=handler;
	}
	
	public static void setState(State state)
	{
		currentState=state;
	}
	
	public static State getState()
	{
		return currentState;
	}
	
	//CLASS
	public abstract void tick();
	public abstract void render(Graphics g);
}
