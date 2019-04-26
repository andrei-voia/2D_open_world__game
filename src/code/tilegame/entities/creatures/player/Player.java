package code.tilegame.entities.creatures.player;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import code.tilegame.Handler;
import code.tilegame.entities.creatures.Creature;
import code.tilegame.gfx.Animation;
import code.tilegame.gfx.Assets;
import code.tilegame.inventory.Inventory;

public class Player extends Creature{

	//Animations
	private Animation animDown, animUp, animLeft, animRight;
	
	//Attack timer
	private long lastAttackTimer, attackCooldown = 500, attackTimer = attackCooldown ;
	
	//inventory object
	private Inventory inventory;
	
	public Player(Handler handler, float x, float y) 
	{
		super(handler, x, y, Creature.DEFAULT_CREATURE_HEIGHT, Creature.DEFAULT_CREATURE_WIDTH);
		
		//Hit box
		bounds.x=22;
		bounds.y=25;
		bounds.width=20;
		bounds.height=39;
		
		//Animations
		animDown=new Animation(100, Assets.player_down);
		animUp=new Animation(100, Assets.player_up);
		animLeft=new Animation(100, Assets.player_left);
		animRight=new Animation(100, Assets.player_right);
		
		//inventory 
		inventory = new Inventory(handler);
	}
	

	
	public void tick() 
	{		
		//Animation
		animDown.tick();
		animUp.tick();
		animLeft.tick();
		animRight.tick();
		
		//Movement
		getInput();
		move();
		handler.getGameCamera().centerOnEntity(this);
		
		//Attack
		checkAttacks();
		
		//inventory
		inventory.tick();
	}
	
	

	public void render(Graphics g) 
	{
		g.drawImage(getCurrentAnimationFrame(), (int)(x - handler.getGameCamera().getxOffset()), 
				 (int) (y - handler.getGameCamera().getyOffset()), width, height, null);
		
		//inventory
		inventory.render(g);
	}
	
	//for inventory
	public void postRender(Graphics g)
	{
		inventory.render(g);
	}
	
	
	private void getInput()
	{
		xMove=0;
		yMove=0;
		
		//don t move when inventory open
		if(inventory.isActive()) return;
		
		if(handler.getKeyManager().up) yMove=-speed;
		if(handler.getKeyManager().down) yMove=speed;
		if(handler.getKeyManager().left) xMove=-speed;
		if(handler.getKeyManager().right) xMove=speed;
		
	}
	

	private BufferedImage getCurrentAnimationFrame()
	{
		if(xMove==0&&yMove==0)return Assets.player_idle;
		if(xMove<0) return animLeft.getCurrentFrame();
		else if(xMove>0)return animRight.getCurrentFrame();
		else if(yMove<0)return animUp.getCurrentFrame();
		else return animDown.getCurrentFrame();
	}
	
	public void die()
	{
		System.out.println("you lose");
	}
	
	public void checkAttacks()
	{
		//timer for attack
		attackTimer+=System.currentTimeMillis() - lastAttackTimer;
		lastAttackTimer = System.currentTimeMillis();
		if(attackTimer<attackCooldown) return;
		
		//don t attack when inventory open
		if(inventory.isActive()) return;
			
		Rectangle cb = getCollisionBounds(0,0);
		//attackRectangle
		Rectangle ar = new Rectangle();
		int arSize = 20;
		
		ar.width=arSize;
		ar.height=arSize;
		
		//how you handle direction of attacks
		if(handler.getKeyManager().space)
		{
			if(handler.getKeyManager().up)
			{
				ar.x=cb.x+cb.width/2-arSize/2;
				ar.y=cb.y-arSize;
			}
			else if(handler.getKeyManager().down)
			{
				ar.x=cb.x+cb.width/2-arSize/2;
				ar.y=cb.y+cb.height;
			}
			else if(handler.getKeyManager().left)
			{
				ar.x=cb.x-arSize;
				ar.y=cb.y+cb.height/2-arSize/2;
			}
			else if(handler.getKeyManager().right)
			{
				ar.x=cb.x+cb.width;
				ar.y=cb.y+cb.height/2-arSize/2;
			}
		}		
		else return;
		
		//reset timer for attack
		attackTimer=0;
				
		for(code.tilegame.entities.Entity e : handler.getWorld().getEntityManager().getEntities())
		{
			if(e.equals(this))continue;
			if(e.getCollisionBounds(0, 0).intersects(ar))
			{
				e.hurt(80);
				return;
			}	
		}	
	}
	
	
	//Getters and setters
	public Inventory getInventory() {
		return inventory;
	}



	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	
}
