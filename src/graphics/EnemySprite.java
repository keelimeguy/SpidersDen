package graphics;

public class EnemySprite {
	// Enemy sprites:

	public static Sprite[][] devil;
	static {
		//up
		Sprite devil00 = new Sprite(32, 0, 2, SpriteSheet.devil);
		Sprite devil01 = new Sprite(32, 1, 2, SpriteSheet.devil);
		Sprite devil02 = new Sprite(32, 2, 2, SpriteSheet.devil);
		//side
		Sprite devil10 = new Sprite(32, 0, 1, SpriteSheet.devil);
		Sprite devil11 = new Sprite(32, 1, 1, SpriteSheet.devil);
		Sprite devil12 = new Sprite(32, 2, 1, SpriteSheet.devil);
		//down
		Sprite devil20 = new Sprite(32, 0, 0, SpriteSheet.devil);
		Sprite devil21 = new Sprite(32, 1, 0, SpriteSheet.devil);
		Sprite devil22 = new Sprite(32, 2, 0, SpriteSheet.devil);

		devil = new Sprite[][] { { devil00, devil01, devil02 }, { devil10, devil11, devil12 }, { devil20, devil21, devil22 } };
	}

	public static Sprite[][] brainBeast;
	static {
		//up
		Sprite brainBeast00 = new Sprite(96, 0, 2, SpriteSheet.brainBeast);
		Sprite brainBeast01 = new Sprite(96, 1, 2, SpriteSheet.brainBeast);
		//side
		Sprite brainBeast10 = new Sprite(96, 0, 1, SpriteSheet.brainBeast);
		Sprite brainBeast11 = new Sprite(96, 1, 1, SpriteSheet.brainBeast);
		//down
		Sprite brainBeast20 = new Sprite(96, 0, 0, SpriteSheet.brainBeast);
		Sprite brainBeast21 = new Sprite(96, 1, 0, SpriteSheet.brainBeast);

		brainBeast = new Sprite[][] { { brainBeast00, brainBeast01 }, { brainBeast10, brainBeast11 }, { brainBeast20, brainBeast21 } };
	}
}
