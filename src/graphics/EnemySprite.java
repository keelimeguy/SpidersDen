package graphics;

public class EnemySprite {
	// Enemy sprites:

	//up
	public static Sprite devil00 = new Sprite(32, 0, 2, SpriteSheet.devil);
	public static Sprite devil01 = new Sprite(32, 1, 2, SpriteSheet.devil);
	public static Sprite devil02 = new Sprite(32, 2, 2, SpriteSheet.devil);
	//side
	public static Sprite devil10 = new Sprite(32, 0, 1, SpriteSheet.devil);
	public static Sprite devil11 = new Sprite(32, 1, 1, SpriteSheet.devil);
	public static Sprite devil12 = new Sprite(32, 2, 1, SpriteSheet.devil);
	//down
	public static Sprite devil20 = new Sprite(32, 0, 0, SpriteSheet.devil);
	public static Sprite devil21 = new Sprite(32, 1, 0, SpriteSheet.devil);
	public static Sprite devil22 = new Sprite(32, 2, 0, SpriteSheet.devil);

	public static Sprite[][] devil = new Sprite[][] { { devil00, devil01, devil02 }, { devil10, devil11, devil12 }, { devil20, devil21, devil22 } };

	//up
	public static Sprite brainBeast00 = new Sprite(96, 0, 2, SpriteSheet.brainBeast);
	public static Sprite brainBeast01 = new Sprite(96, 1, 2, SpriteSheet.brainBeast);
	//side
	public static Sprite brainBeast10 = new Sprite(96, 0, 1, SpriteSheet.brainBeast);
	public static Sprite brainBeast11 = new Sprite(96, 1, 1, SpriteSheet.brainBeast);
	//down
	public static Sprite brainBeast20 = new Sprite(96, 0, 0, SpriteSheet.brainBeast);
	public static Sprite brainBeast21 = new Sprite(96, 1, 0, SpriteSheet.brainBeast);

	public static Sprite[][] brainBeast = new Sprite[][] { { brainBeast00, brainBeast01 }, { brainBeast10, brainBeast11 }, { brainBeast20, brainBeast21 } };

}
