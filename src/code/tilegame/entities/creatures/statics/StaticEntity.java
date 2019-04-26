package code.tilegame.entities.creatures.statics;

import code.tilegame.Handler;
import code.tilegame.entities.Entity;

public abstract class StaticEntity extends Entity{

	public StaticEntity(Handler handler, float x, float y, int width, int height)
	{
		super(handler, x, y, width, height);
	}
}
