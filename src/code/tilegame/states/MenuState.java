package code.tilegame.states;

import java.awt.Graphics;
import code.tilegame.Handler;
import code.tilegame.gfx.Assets;
import code.tilegame.ui.ClickListener;
import code.tilegame.ui.UIImageButton;
import code.tilegame.ui.UIManager;

public class MenuState extends State{
	
	private UIManager uiManager;
	
	public MenuState(Handler handler)
	{
		super(handler);
		uiManager=new UIManager(handler);
		handler.getMouseManager().setUIManager(uiManager);
		
		uiManager.addObject(new UIImageButton(300,300,128,64, Assets.btn_start, new ClickListener()
		{
			public void onClick() {
				handler.getMouseManager().setUIManager(null);
				State.setState(handler.getGame().getGameState());	
			}
		}));
	}
	

	public void tick() {
		uiManager.tick();
	}

	public void render(Graphics g) {
		uiManager.render(g);
	}
}
