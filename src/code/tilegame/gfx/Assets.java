package code.tilegame.gfx;

import java.awt.Font;
import java.awt.image.BufferedImage;

public class Assets {
	
	public static BufferedImage[] player_down, player_up, player_left, player_right;
	public static BufferedImage player_idle;
	public static BufferedImage dirt, grass, stone, tree, grass2, dirt2, wood, woodBox, stone2;
	public static BufferedImage tree2Big, stoneAsset, treeBranch;
	public static BufferedImage[] btn_start;
	public static BufferedImage inventoryScreen;
	
	//fonts
	public static Font font28;
	
	
	private static final int width=32, height=32;
	
	public static void init()
	{
		SpriteSheet sheet = new SpriteSheet(ImageLoader.loadImage("/textures/sheet.png"));
		
		//inventory screen
		inventoryScreen=ImageLoader.loadImage("/textures/inventoryScreen.png");
		font28 = FontLoader.loadFont("resources/fonts/slkscr.ttf", 28);
		
		//player animation
		player_down=new BufferedImage[2];
		player_down[0]=sheet.crop(4*width, 0, width, height);
		player_down[1]=sheet.crop(5*width, 0, width, height);
		
		player_up=new BufferedImage[2];
		player_up[0]=sheet.crop(6*width, 0, width, height);
		player_up[1]=sheet.crop(7*width, 0, width, height);
		
		player_right=new BufferedImage[2];
		player_right[0]=sheet.crop(4*width, height, width, height);
		player_right[1]=sheet.crop(5*width, height, width, height);
		
		player_left=new BufferedImage[2];
		player_left[0]=sheet.crop(6*width, height, width, height);
		player_left[1]=sheet.crop(7*width, height, width, height);
		
		//button start
		btn_start=new BufferedImage[2];
		btn_start[0]=sheet.crop(5*width, 2*height, 2*width, height);
		btn_start[1]=sheet.crop(5*width, 3*height, 2*width, height);
			
		treeBranch=sheet.crop(7*width, 2*height, width, height);
		stoneAsset=sheet.crop(4*width, 4*height, width, height);
		player_idle=sheet.crop(2*width, 2*height, width, height);
		dirt=sheet.crop(width, 0, width, height);
		grass=sheet.crop(2*width, 0, width, height);
		grass2=sheet.crop(3*width, 0, width, height);
		tree=sheet.crop(0, height, width, height);
		dirt2=sheet.crop(width, height, width, height);
		wood=sheet.crop(2*width, height, width, height);
		woodBox=sheet.crop(3*width, height, width, height);
		stone=sheet.crop(0, 2*height, width, height);
		stone2=sheet.crop(width, 2*height, width, height);
		tree2Big=sheet.crop(4*width, 2*height, width, 2*height);
	}

}
