package graphics;

public class SpiderSprite {

	private static final int SIZE_X = 52, SIZE_Y = 52;

	// Spider sprites:

	/*----------------------------------------------------------------------------------------------
		Walk Sprites
	----------------------------------------------------------------------------------------------*/

	//up
	public static Sprite spiderWalkBlack00 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 0, 0, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlack01 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 1, 0, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlack02 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 2, 0, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlack03 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 3, 0, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlack04 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 4, 0, SpriteSheet.spiderWalk));
	//left
	public static Sprite spiderWalkBlack10 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 0, 1, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlack11 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 1, 1, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlack12 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 2, 1, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlack13 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 3, 1, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlack14 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 4, 1, SpriteSheet.spiderWalk));
	//down
	public static Sprite spiderWalkBlack20 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 0, 2, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlack21 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 1, 2, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlack22 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 2, 2, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlack23 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 3, 2, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlack24 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 4, 2, SpriteSheet.spiderWalk));
	//right
	public static Sprite spiderWalkBlack30 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 0, 3, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlack31 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 1, 3, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlack32 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 2, 3, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlack33 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 3, 3, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlack34 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 4, 3, SpriteSheet.spiderWalk));

	//up
	public static Sprite spiderAtkBlack00 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 0, 0, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkBlack01 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 1, 0, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkBlack02 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 2, 0, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkBlack03 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 3, 0, SpriteSheet.spiderAtk));
	//left
	public static Sprite spiderAtkBlack10 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 0, 1, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkBlack11 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 1, 1, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkBlack12 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 2, 1, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkBlack13 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 3, 1, SpriteSheet.spiderAtk));
	//down
	public static Sprite spiderAtkBlack20 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 0, 2, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkBlack21 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 1, 2, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkBlack22 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 2, 2, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkBlack23 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 3, 2, SpriteSheet.spiderAtk));
	//right
	public static Sprite spiderAtkBlack30 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 0, 3, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkBlack31 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 1, 3, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkBlack32 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 2, 3, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkBlack33 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 3, 3, SpriteSheet.spiderAtk));

	public static Sprite spiderDeathBlack00 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 0, 0, SpriteSheet.spiderDeath));
	public static Sprite spiderDeathBlack01 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 1, 0, SpriteSheet.spiderDeath));
	public static Sprite spiderDeathBlack02 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 2, 0, SpriteSheet.spiderDeath));
	public static Sprite spiderDeathBlack03 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 3, 0, SpriteSheet.spiderDeath));

	public static Sprite[][] spiderBlack = new Sprite[][] { { spiderWalkBlack00, spiderWalkBlack01, spiderWalkBlack02, spiderWalkBlack03, spiderWalkBlack04, spiderAtkBlack00, spiderAtkBlack01, spiderAtkBlack02, spiderAtkBlack03, spiderDeathBlack00, spiderDeathBlack01, spiderDeathBlack02, spiderDeathBlack03 }, { spiderWalkBlack10, spiderWalkBlack11, spiderWalkBlack12, spiderWalkBlack13, spiderWalkBlack14, spiderAtkBlack10, spiderAtkBlack11, spiderAtkBlack12, spiderAtkBlack13, spiderDeathBlack00, spiderDeathBlack01, spiderDeathBlack02, spiderDeathBlack03 },
			{ spiderWalkBlack20, spiderWalkBlack21, spiderWalkBlack22, spiderWalkBlack23, spiderWalkBlack24, spiderAtkBlack20, spiderAtkBlack21, spiderAtkBlack22, spiderAtkBlack23, spiderDeathBlack00, spiderDeathBlack01, spiderDeathBlack02, spiderDeathBlack03 }, { spiderWalkBlack30, spiderWalkBlack31, spiderWalkBlack32, spiderWalkBlack33, spiderWalkBlack34, spiderAtkBlack30, spiderAtkBlack31, spiderAtkBlack32, spiderAtkBlack33, spiderDeathBlack00, spiderDeathBlack01, spiderDeathBlack02, spiderDeathBlack03 } };

	//up
	public static Sprite spiderWalkSilver00 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 5, 0, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkSilver01 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 6, 0, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkSilver02 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 7, 0, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkSilver03 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 8, 0, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkSilver04 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 9, 0, SpriteSheet.spiderWalk));
	//left
	public static Sprite spiderWalkSilver10 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 5, 1, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkSilver11 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 6, 1, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkSilver12 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 7, 1, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkSilver13 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 8, 1, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkSilver14 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 9, 1, SpriteSheet.spiderWalk));
	//down
	public static Sprite spiderWalkSilver20 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 5, 2, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkSilver21 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 6, 2, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkSilver22 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 7, 2, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkSilver23 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 8, 2, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkSilver24 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 9, 2, SpriteSheet.spiderWalk));
	//right
	public static Sprite spiderWalkSilver30 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 5, 3, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkSilver31 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 6, 3, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkSilver32 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 7, 3, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkSilver33 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 8, 3, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkSilver34 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 9, 3, SpriteSheet.spiderWalk));

	//up
	public static Sprite spiderAtkSilver00 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 4, 0, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkSilver01 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 5, 0, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkSilver02 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 6, 0, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkSilver03 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 7, 0, SpriteSheet.spiderAtk));
	//left
	public static Sprite spiderAtkSilver10 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 4, 1, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkSilver11 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 5, 1, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkSilver12 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 6, 1, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkSilver13 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 7, 1, SpriteSheet.spiderAtk));
	//down
	public static Sprite spiderAtkSilver20 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 4, 2, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkSilver21 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 5, 2, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkSilver22 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 6, 2, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkSilver23 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 7, 2, SpriteSheet.spiderAtk));
	//right
	public static Sprite spiderAtkSilver30 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 4, 3, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkSilver31 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 5, 3, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkSilver32 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 6, 3, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkSilver33 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 7, 3, SpriteSheet.spiderAtk));

	public static Sprite spiderDeathSilver00 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 4, 0, SpriteSheet.spiderDeath));
	public static Sprite spiderDeathSilver01 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 5, 0, SpriteSheet.spiderDeath));
	public static Sprite spiderDeathSilver02 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 6, 0, SpriteSheet.spiderDeath));
	public static Sprite spiderDeathSilver03 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 7, 0, SpriteSheet.spiderDeath));

	public static Sprite[][] spiderSilver = new Sprite[][] { { spiderWalkSilver00, spiderWalkSilver01, spiderWalkSilver02, spiderWalkSilver03, spiderWalkSilver04, spiderAtkSilver00, spiderAtkSilver01, spiderAtkSilver02, spiderAtkSilver03, spiderDeathSilver00, spiderDeathSilver01, spiderDeathSilver02, spiderDeathSilver03 }, { spiderWalkSilver10, spiderWalkSilver11, spiderWalkSilver12, spiderWalkSilver13, spiderWalkSilver14, spiderAtkSilver10, spiderAtkSilver11, spiderAtkSilver12, spiderAtkSilver13, spiderDeathSilver00, spiderDeathSilver01, spiderDeathSilver02, spiderDeathSilver03 },
			{ spiderWalkSilver20, spiderWalkSilver21, spiderWalkSilver22, spiderWalkSilver23, spiderWalkSilver24, spiderAtkSilver20, spiderAtkSilver21, spiderAtkSilver22, spiderAtkSilver23, spiderDeathSilver00, spiderDeathSilver01, spiderDeathSilver02, spiderDeathSilver03 }, { spiderWalkSilver30, spiderWalkSilver31, spiderWalkSilver32, spiderWalkSilver33, spiderWalkSilver34, spiderAtkSilver30, spiderAtkSilver31, spiderAtkSilver32, spiderAtkSilver33, spiderDeathSilver00, spiderDeathSilver01, spiderDeathSilver02, spiderDeathSilver03 } };

	//up
	public static Sprite spiderWalkBlue00 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 10, 0, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlue01 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 11, 0, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlue02 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 12, 0, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlue03 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 13, 0, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlue04 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 14, 0, SpriteSheet.spiderWalk));
	//left
	public static Sprite spiderWalkBlue10 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 10, 1, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlue11 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 11, 1, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlue12 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 12, 1, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlue13 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 13, 1, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlue14 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 14, 1, SpriteSheet.spiderWalk));
	//down
	public static Sprite spiderWalkBlue20 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 10, 2, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlue21 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 11, 2, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlue22 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 12, 2, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlue23 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 13, 2, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlue24 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 14, 2, SpriteSheet.spiderWalk));
	//right
	public static Sprite spiderWalkBlue30 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 10, 3, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlue31 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 11, 3, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlue32 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 12, 3, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlue33 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 13, 3, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlue34 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 14, 3, SpriteSheet.spiderWalk));

	//up
	public static Sprite spiderAtkBlue00 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 8, 0, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkBlue01 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 9, 0, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkBlue02 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 10, 0, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkBlue03 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 11, 0, SpriteSheet.spiderAtk));
	//left
	public static Sprite spiderAtkBlue10 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 8, 1, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkBlue11 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 8, 1, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkBlue12 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 10, 1, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkBlue13 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 11, 1, SpriteSheet.spiderAtk));
	//down
	public static Sprite spiderAtkBlue20 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 8, 2, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkBlue21 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 9, 2, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkBlue22 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 10, 2, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkBlue23 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 11, 2, SpriteSheet.spiderAtk));
	//right
	public static Sprite spiderAtkBlue30 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 8, 3, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkBlue31 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 9, 3, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkBlue32 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 10, 3, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkBlue33 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 11, 3, SpriteSheet.spiderAtk));

	public static Sprite spiderDeathBlue00 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 8, 0, SpriteSheet.spiderDeath));
	public static Sprite spiderDeathBlue01 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 9, 0, SpriteSheet.spiderDeath));
	public static Sprite spiderDeathBlue02 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 10, 0, SpriteSheet.spiderDeath));
	public static Sprite spiderDeathBlue03 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 11, 0, SpriteSheet.spiderDeath));

	public static Sprite[][] spiderBlue = new Sprite[][] { { spiderWalkBlue00, spiderWalkBlue01, spiderWalkBlue02, spiderWalkBlue03, spiderWalkBlue04, spiderAtkBlue00, spiderAtkBlue01, spiderAtkBlue02, spiderAtkBlue03, spiderDeathBlue00, spiderDeathBlue01, spiderDeathBlue02, spiderDeathBlue03 }, { spiderWalkBlue10, spiderWalkBlue11, spiderWalkBlue12, spiderWalkBlue13, spiderWalkBlue14, spiderAtkBlue10, spiderAtkBlue11, spiderAtkBlue12, spiderAtkBlue13, spiderDeathBlue00, spiderDeathBlue01, spiderDeathBlue02, spiderDeathBlue03 }, { spiderWalkBlue20, spiderWalkBlue21, spiderWalkBlue22, spiderWalkBlue23, spiderWalkBlue24, spiderAtkBlue20, spiderAtkBlue21, spiderAtkBlue22, spiderAtkBlue23, spiderDeathBlue00, spiderDeathBlue01, spiderDeathBlue02, spiderDeathBlue03 },
			{ spiderWalkBlue30, spiderWalkBlue31, spiderWalkBlue32, spiderWalkBlue33, spiderWalkBlue34, spiderAtkBlue30, spiderAtkBlue31, spiderAtkBlue32, spiderAtkBlue33, spiderDeathBlue00, spiderDeathBlue01, spiderDeathBlue02, spiderDeathBlue03 } };

	//up
	public static Sprite spiderWalkRed00 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 15, 0, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkRed01 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 16, 0, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkRed02 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 17, 0, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkRed03 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 18, 0, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkRed04 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 19, 0, SpriteSheet.spiderWalk));
	//left
	public static Sprite spiderWalkRed10 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 15, 1, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkRed11 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 16, 1, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkRed12 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 17, 1, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkRed13 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 18, 1, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkRed14 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 19, 1, SpriteSheet.spiderWalk));
	//down
	public static Sprite spiderWalkRed20 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 15, 2, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkRed21 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 16, 2, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkRed22 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 17, 2, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkRed23 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 18, 2, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkRed24 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 19, 2, SpriteSheet.spiderWalk));
	//right
	public static Sprite spiderWalkRed30 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 15, 3, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkRed31 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 16, 3, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkRed32 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 17, 3, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkRed33 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 18, 3, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkRed34 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 19, 3, SpriteSheet.spiderWalk));

	//up
	public static Sprite spiderAtkRed00 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 12, 0, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkRed01 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 13, 0, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkRed02 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 14, 0, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkRed03 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 15, 0, SpriteSheet.spiderAtk));
	//left
	public static Sprite spiderAtkRed10 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 12, 1, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkRed11 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 13, 1, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkRed12 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 14, 1, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkRed13 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 15, 1, SpriteSheet.spiderAtk));
	//down
	public static Sprite spiderAtkRed20 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 12, 2, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkRed21 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 13, 2, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkRed22 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 14, 2, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkRed23 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 15, 2, SpriteSheet.spiderAtk));
	//right
	public static Sprite spiderAtkRed30 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 12, 3, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkRed31 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 13, 3, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkRed32 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 14, 3, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkRed33 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 15, 3, SpriteSheet.spiderAtk));

	public static Sprite spiderDeathRed00 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 12, 0, SpriteSheet.spiderDeath));
	public static Sprite spiderDeathRed01 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 13, 0, SpriteSheet.spiderDeath));
	public static Sprite spiderDeathRed02 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 14, 0, SpriteSheet.spiderDeath));
	public static Sprite spiderDeathRed03 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 15, 0, SpriteSheet.spiderDeath));

	public static Sprite[][] spiderRed = new Sprite[][] { { spiderWalkRed00, spiderWalkRed01, spiderWalkRed02, spiderWalkRed03, spiderWalkRed04, spiderAtkRed00, spiderAtkRed01, spiderAtkRed02, spiderAtkRed03, spiderDeathRed00, spiderDeathRed01, spiderDeathRed02, spiderDeathRed03 }, { spiderWalkRed10, spiderWalkRed11, spiderWalkRed12, spiderWalkRed13, spiderWalkRed14, spiderAtkRed10, spiderAtkRed11, spiderAtkRed12, spiderAtkRed13, spiderDeathRed00, spiderDeathRed01, spiderDeathRed02, spiderDeathRed03 }, { spiderWalkRed20, spiderWalkRed21, spiderWalkRed22, spiderWalkRed23, spiderWalkRed24, spiderAtkRed20, spiderAtkRed21, spiderAtkRed22, spiderAtkRed23, spiderDeathRed00, spiderDeathRed01, spiderDeathRed02, spiderDeathRed03 },
			{ spiderWalkRed30, spiderWalkRed31, spiderWalkRed32, spiderWalkRed33, spiderWalkRed34, spiderAtkRed30, spiderAtkRed31, spiderAtkRed32, spiderAtkRed33, spiderDeathRed00, spiderDeathRed01, spiderDeathRed02, spiderDeathRed03 } };

	//up
	public static Sprite spiderWalkBlackDots00 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 0, 4, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlackDots01 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 1, 4, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlackDots02 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 2, 4, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlackDots03 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 3, 4, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlackDots04 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 4, 4, SpriteSheet.spiderWalk));
	//left
	public static Sprite spiderWalkBlackDots10 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 0, 5, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlackDots11 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 1, 5, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlackDots12 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 2, 5, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlackDots13 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 3, 5, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlackDots14 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 4, 5, SpriteSheet.spiderWalk));
	//down
	public static Sprite spiderWalkBlackDots20 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 0, 6, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlackDots21 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 1, 6, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlackDots22 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 2, 6, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlackDots23 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 3, 6, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlackDots24 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 4, 6, SpriteSheet.spiderWalk));
	//right
	public static Sprite spiderWalkBlackDots30 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 0, 7, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlackDots31 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 1, 7, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlackDots32 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 2, 7, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlackDots33 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 3, 7, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlackDots34 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 4, 7, SpriteSheet.spiderWalk));

	//up
	public static Sprite spiderAtkBlackDots00 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 0, 4, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkBlackDots01 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 1, 4, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkBlackDots02 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 2, 4, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkBlackDots03 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 3, 4, SpriteSheet.spiderAtk));
	//left
	public static Sprite spiderAtkBlackDots10 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 0, 5, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkBlackDots11 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 1, 5, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkBlackDots12 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 2, 5, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkBlackDots13 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 3, 5, SpriteSheet.spiderAtk));
	//down
	public static Sprite spiderAtkBlackDots20 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 0, 6, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkBlackDots21 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 1, 6, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkBlackDots22 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 2, 6, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkBlackDots23 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 3, 6, SpriteSheet.spiderAtk));
	//right
	public static Sprite spiderAtkBlackDots30 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 0, 7, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkBlackDots31 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 1, 7, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkBlackDots32 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 2, 7, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkBlackDots33 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 3, 7, SpriteSheet.spiderAtk));

	public static Sprite spiderDeathBlackDots00 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 0, 1, SpriteSheet.spiderDeath));
	public static Sprite spiderDeathBlackDots01 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 1, 1, SpriteSheet.spiderDeath));
	public static Sprite spiderDeathBlackDots02 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 2, 1, SpriteSheet.spiderDeath));
	public static Sprite spiderDeathBlackDots03 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 3, 1, SpriteSheet.spiderDeath));

	public static Sprite[][] spiderBlackDots = new Sprite[][] { { spiderWalkBlackDots00, spiderWalkBlackDots01, spiderWalkBlackDots02, spiderWalkBlackDots03, spiderWalkBlackDots04, spiderAtkBlackDots00, spiderAtkBlackDots01, spiderAtkBlackDots02, spiderAtkBlackDots03, spiderDeathBlackDots00, spiderDeathBlackDots01, spiderDeathBlackDots02, spiderDeathBlackDots03 }, { spiderWalkBlackDots10, spiderWalkBlackDots11, spiderWalkBlackDots12, spiderWalkBlackDots13, spiderWalkBlackDots14, spiderAtkBlackDots10, spiderAtkBlackDots11, spiderAtkBlackDots12, spiderAtkBlackDots13, spiderDeathBlackDots00, spiderDeathBlackDots01, spiderDeathBlackDots02, spiderDeathBlackDots03 },
			{ spiderWalkBlackDots20, spiderWalkBlackDots21, spiderWalkBlackDots22, spiderWalkBlackDots23, spiderWalkBlackDots24, spiderAtkBlackDots20, spiderAtkBlackDots21, spiderAtkBlackDots22, spiderAtkBlackDots23, spiderDeathBlackDots00, spiderDeathBlackDots01, spiderDeathBlackDots02, spiderDeathBlackDots03 }, { spiderWalkBlackDots30, spiderWalkBlackDots31, spiderWalkBlackDots32, spiderWalkBlackDots33, spiderWalkBlackDots34, spiderAtkBlackDots30, spiderAtkBlackDots31, spiderAtkBlackDots32, spiderAtkBlackDots33, spiderDeathBlackDots00, spiderDeathBlackDots01, spiderDeathBlackDots02, spiderDeathBlackDots03 } };

	//up
	public static Sprite spiderWalkSilverDots00 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 5, 4, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkSilverDots01 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 6, 4, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkSilverDots02 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 7, 4, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkSilverDots03 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 8, 4, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkSilverDots04 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 9, 4, SpriteSheet.spiderWalk));
	//left
	public static Sprite spiderWalkSilverDots10 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 5, 5, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkSilverDots11 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 6, 5, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkSilverDots12 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 7, 5, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkSilverDots13 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 8, 5, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkSilverDots14 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 9, 5, SpriteSheet.spiderWalk));
	//down
	public static Sprite spiderWalkSilverDots20 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 5, 6, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkSilverDots21 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 6, 6, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkSilverDots22 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 7, 6, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkSilverDots23 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 8, 6, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkSilverDots24 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 9, 6, SpriteSheet.spiderWalk));
	//right
	public static Sprite spiderWalkSilverDots30 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 5, 7, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkSilverDots31 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 6, 7, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkSilverDots32 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 7, 7, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkSilverDots33 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 8, 7, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkSilverDots34 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 9, 7, SpriteSheet.spiderWalk));

	//up
	public static Sprite spiderAtkSilverDots00 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 4, 4, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkSilverDots01 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 5, 4, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkSilverDots02 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 6, 4, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkSilverDots03 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 7, 4, SpriteSheet.spiderAtk));
	//left
	public static Sprite spiderAtkSilverDots10 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 4, 5, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkSilverDots11 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 5, 5, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkSilverDots12 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 6, 5, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkSilverDots13 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 7, 5, SpriteSheet.spiderAtk));
	//down
	public static Sprite spiderAtkSilverDots20 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 4, 6, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkSilverDots21 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 5, 6, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkSilverDots22 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 6, 6, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkSilverDots23 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 7, 6, SpriteSheet.spiderAtk));
	//right
	public static Sprite spiderAtkSilverDots30 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 4, 7, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkSilverDots31 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 5, 7, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkSilverDots32 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 6, 7, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkSilverDots33 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 7, 7, SpriteSheet.spiderAtk));

	public static Sprite spiderDeathSilverDots00 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 4, 1, SpriteSheet.spiderDeath));
	public static Sprite spiderDeathSilverDots01 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 5, 1, SpriteSheet.spiderDeath));
	public static Sprite spiderDeathSilverDots02 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 6, 1, SpriteSheet.spiderDeath));
	public static Sprite spiderDeathSilverDots03 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 7, 1, SpriteSheet.spiderDeath));

	public static Sprite[][] spiderSilverDots = new Sprite[][] { { spiderWalkSilverDots00, spiderWalkSilverDots01, spiderWalkSilverDots02, spiderWalkSilverDots03, spiderWalkSilverDots04, spiderAtkSilverDots00, spiderAtkSilverDots01, spiderAtkSilverDots02, spiderAtkSilverDots03, spiderDeathSilverDots00, spiderDeathSilverDots01, spiderDeathSilverDots02, spiderDeathSilverDots03 }, { spiderWalkSilverDots10, spiderWalkSilverDots11, spiderWalkSilverDots12, spiderWalkSilverDots13, spiderWalkSilverDots14, spiderAtkSilverDots10, spiderAtkSilverDots11, spiderAtkSilverDots12, spiderAtkSilverDots13, spiderDeathSilverDots00, spiderDeathSilverDots01, spiderDeathSilverDots02, spiderDeathSilverDots03 },
			{ spiderWalkSilverDots20, spiderWalkSilverDots21, spiderWalkSilverDots22, spiderWalkSilverDots23, spiderWalkSilverDots24, spiderAtkSilverDots20, spiderAtkSilverDots21, spiderAtkSilverDots22, spiderAtkSilverDots23, spiderDeathSilverDots00, spiderDeathSilverDots01, spiderDeathSilverDots02, spiderDeathSilverDots03 }, { spiderWalkSilverDots30, spiderWalkSilverDots31, spiderWalkSilverDots32, spiderWalkSilverDots33, spiderWalkSilverDots34, spiderAtkSilverDots30, spiderAtkSilverDots31, spiderAtkSilverDots32, spiderAtkSilverDots33, spiderDeathSilverDots00, spiderDeathSilverDots01, spiderDeathSilverDots02, spiderDeathSilverDots03 } };

	//up
	public static Sprite spiderWalkBlueDots00 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 10, 4, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlueDots01 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 11, 4, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlueDots02 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 12, 4, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlueDots03 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 13, 4, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlueDots04 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 14, 4, SpriteSheet.spiderWalk));
	//left
	public static Sprite spiderWalkBlueDots10 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 10, 5, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlueDots11 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 11, 5, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlueDots12 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 12, 5, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlueDots13 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 13, 5, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlueDots14 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 14, 5, SpriteSheet.spiderWalk));
	//down
	public static Sprite spiderWalkBlueDots20 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 10, 6, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlueDots21 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 11, 6, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlueDots22 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 12, 6, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlueDots23 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 13, 6, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlueDots24 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 14, 6, SpriteSheet.spiderWalk));
	//right
	public static Sprite spiderWalkBlueDots30 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 10, 7, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlueDots31 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 11, 7, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlueDots32 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 12, 7, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlueDots33 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 13, 7, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlueDots34 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 14, 7, SpriteSheet.spiderWalk));

	//up
	public static Sprite spiderAtkBlueDots00 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 8, 4, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkBlueDots01 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 9, 4, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkBlueDots02 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 10, 4, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkBlueDots03 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 11, 4, SpriteSheet.spiderAtk));
	//left
	public static Sprite spiderAtkBlueDots10 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 8, 5, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkBlueDots11 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 9, 5, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkBlueDots12 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 10, 5, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkBlueDots13 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 11, 5, SpriteSheet.spiderAtk));
	//down
	public static Sprite spiderAtkBlueDots20 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 8, 6, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkBlueDots21 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 9, 6, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkBlueDots22 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 10, 6, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkBlueDots23 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 11, 6, SpriteSheet.spiderAtk));
	//right
	public static Sprite spiderAtkBlueDots30 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 8, 7, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkBlueDots31 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 9, 7, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkBlueDots32 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 10, 7, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkBlueDots33 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 11, 7, SpriteSheet.spiderAtk));

	public static Sprite spiderDeathBlueDots00 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 8, 1, SpriteSheet.spiderDeath));
	public static Sprite spiderDeathBlueDots01 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 9, 1, SpriteSheet.spiderDeath));
	public static Sprite spiderDeathBlueDots02 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 10, 1, SpriteSheet.spiderDeath));
	public static Sprite spiderDeathBlueDots03 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 11, 1, SpriteSheet.spiderDeath));

	public static Sprite[][] spiderBlueDots = new Sprite[][] { { spiderWalkBlueDots00, spiderWalkBlueDots01, spiderWalkBlueDots02, spiderWalkBlueDots03, spiderWalkBlueDots04, spiderAtkBlueDots00, spiderAtkBlueDots01, spiderAtkBlueDots02, spiderAtkBlueDots03, spiderDeathBlueDots00, spiderDeathBlueDots01, spiderDeathBlueDots02, spiderDeathBlueDots03 }, { spiderWalkBlueDots10, spiderWalkBlueDots11, spiderWalkBlueDots12, spiderWalkBlueDots13, spiderWalkBlueDots14, spiderAtkBlueDots10, spiderAtkBlueDots11, spiderAtkBlueDots12, spiderAtkBlueDots13, spiderDeathBlueDots00, spiderDeathBlueDots01, spiderDeathBlueDots02, spiderDeathBlueDots03 },
			{ spiderWalkBlueDots20, spiderWalkBlueDots21, spiderWalkBlueDots22, spiderWalkBlueDots23, spiderWalkBlueDots24, spiderAtkBlueDots20, spiderAtkBlueDots21, spiderAtkBlueDots22, spiderAtkBlueDots23, spiderDeathBlueDots00, spiderDeathBlueDots01, spiderDeathBlueDots02, spiderDeathBlueDots03 }, { spiderWalkBlueDots30, spiderWalkBlueDots31, spiderWalkBlueDots32, spiderWalkBlueDots33, spiderWalkBlueDots34, spiderAtkBlueDots30, spiderAtkBlueDots31, spiderAtkBlueDots32, spiderAtkBlueDots33, spiderDeathBlueDots00, spiderDeathBlueDots01, spiderDeathBlueDots02, spiderDeathBlueDots03 } };

	//up
	public static Sprite spiderWalkRedDots00 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 15, 4, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkRedDots01 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 16, 4, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkRedDots02 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 17, 4, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkRedDots03 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 18, 4, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkRedDots04 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 19, 4, SpriteSheet.spiderWalk));
	//left
	public static Sprite spiderWalkRedDots10 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 15, 5, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkRedDots11 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 16, 5, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkRedDots12 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 17, 5, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkRedDots13 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 18, 5, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkRedDots14 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 19, 5, SpriteSheet.spiderWalk));
	//down
	public static Sprite spiderWalkRedDots20 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 15, 6, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkRedDots21 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 16, 6, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkRedDots22 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 17, 6, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkRedDots23 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 18, 6, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkRedDots24 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 19, 6, SpriteSheet.spiderWalk));
	//right
	public static Sprite spiderWalkRedDots30 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 15, 7, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkRedDots31 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 16, 7, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkRedDots32 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 17, 7, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkRedDots33 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 18, 7, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkRedDots34 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 19, 7, SpriteSheet.spiderWalk));

	//up
	public static Sprite spiderAtkRedDots00 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 12, 4, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkRedDots01 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 13, 4, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkRedDots02 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 14, 4, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkRedDots03 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 15, 4, SpriteSheet.spiderAtk));
	//left
	public static Sprite spiderAtkRedDots10 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 12, 5, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkRedDots11 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 13, 5, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkRedDots12 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 14, 5, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkRedDots13 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 15, 5, SpriteSheet.spiderAtk));
	//down
	public static Sprite spiderAtkRedDots20 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 12, 6, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkRedDots21 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 13, 6, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkRedDots22 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 14, 6, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkRedDots23 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 15, 6, SpriteSheet.spiderAtk));
	//right
	public static Sprite spiderAtkRedDots30 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 12, 7, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkRedDots31 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 13, 7, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkRedDots32 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 14, 7, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkRedDots33 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 15, 7, SpriteSheet.spiderAtk));

	public static Sprite spiderDeathRedDots00 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 12, 1, SpriteSheet.spiderDeath));
	public static Sprite spiderDeathRedDots01 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 13, 1, SpriteSheet.spiderDeath));
	public static Sprite spiderDeathRedDots02 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 14, 1, SpriteSheet.spiderDeath));
	public static Sprite spiderDeathRedDots03 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 15, 1, SpriteSheet.spiderDeath));

	public static Sprite[][] spiderRedDots = new Sprite[][] { { spiderWalkRedDots00, spiderWalkRedDots01, spiderWalkRedDots02, spiderWalkRedDots03, spiderWalkRedDots04, spiderAtkRedDots00, spiderAtkRedDots01, spiderAtkRedDots02, spiderAtkRedDots03, spiderDeathRedDots00, spiderDeathRedDots01, spiderDeathRedDots02, spiderDeathRedDots03 }, { spiderWalkRedDots10, spiderWalkRedDots11, spiderWalkRedDots12, spiderWalkRedDots13, spiderWalkRedDots14, spiderAtkRedDots10, spiderAtkRedDots11, spiderAtkRedDots12, spiderAtkRedDots13, spiderDeathRedDots00, spiderDeathRedDots01, spiderDeathRedDots02, spiderDeathRedDots03 },
			{ spiderWalkRedDots20, spiderWalkRedDots21, spiderWalkRedDots22, spiderWalkRedDots23, spiderWalkRedDots24, spiderAtkRedDots20, spiderAtkRedDots21, spiderAtkRedDots22, spiderAtkRedDots23, spiderDeathRedDots00, spiderDeathRedDots01, spiderDeathRedDots02, spiderDeathRedDots03 }, { spiderWalkRedDots30, spiderWalkRedDots31, spiderWalkRedDots32, spiderWalkRedDots33, spiderWalkRedDots34, spiderAtkRedDots30, spiderAtkRedDots31, spiderAtkRedDots32, spiderAtkRedDots33, spiderDeathRedDots00, spiderDeathRedDots01, spiderDeathRedDots02, spiderDeathRedDots03 } };

	//up
	public static Sprite spiderWalkBlackSwirl00 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 0, 8, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlackSwirl01 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 1, 8, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlackSwirl02 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 2, 8, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlackSwirl03 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 3, 8, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlackSwirl04 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 4, 8, SpriteSheet.spiderWalk));
	//left
	public static Sprite spiderWalkBlackSwirl10 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 0, 9, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlackSwirl11 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 1, 9, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlackSwirl12 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 2, 9, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlackSwirl13 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 3, 9, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlackSwirl14 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 4, 9, SpriteSheet.spiderWalk));
	//down
	public static Sprite spiderWalkBlackSwirl20 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 0, 10, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlackSwirl21 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 1, 10, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlackSwirl22 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 2, 10, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlackSwirl23 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 3, 10, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlackSwirl24 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 4, 10, SpriteSheet.spiderWalk));
	//right
	public static Sprite spiderWalkBlackSwirl30 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 0, 11, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlackSwirl31 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 1, 11, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlackSwirl32 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 2, 11, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlackSwirl33 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 3, 11, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlackSwirl34 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 4, 11, SpriteSheet.spiderWalk));

	//up
	public static Sprite spiderAtkBlackSwirl00 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 0, 8, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkBlackSwirl01 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 1, 8, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkBlackSwirl02 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 2, 8, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkBlackSwirl03 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 3, 8, SpriteSheet.spiderAtk));
	//left
	public static Sprite spiderAtkBlackSwirl10 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 0, 9, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkBlackSwirl11 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 1, 9, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkBlackSwirl12 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 2, 9, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkBlackSwirl13 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 3, 9, SpriteSheet.spiderAtk));
	//down
	public static Sprite spiderAtkBlackSwirl20 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 0, 10, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkBlackSwirl21 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 1, 10, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkBlackSwirl22 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 2, 10, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkBlackSwirl23 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 3, 10, SpriteSheet.spiderAtk));
	//right
	public static Sprite spiderAtkBlackSwirl30 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 0, 11, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkBlackSwirl31 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 1, 11, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkBlackSwirl32 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 2, 11, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkBlackSwirl33 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 3, 11, SpriteSheet.spiderAtk));

	public static Sprite spiderDeathBlackSwirl00 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 0, 2, SpriteSheet.spiderDeath));
	public static Sprite spiderDeathBlackSwirl01 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 1, 2, SpriteSheet.spiderDeath));
	public static Sprite spiderDeathBlackSwirl02 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 2, 2, SpriteSheet.spiderDeath));
	public static Sprite spiderDeathBlackSwirl03 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 3, 2, SpriteSheet.spiderDeath));

	public static Sprite[][] spiderBlackSwirl = new Sprite[][] { { spiderWalkBlackSwirl00, spiderWalkBlackSwirl01, spiderWalkBlackSwirl02, spiderWalkBlackSwirl03, spiderWalkBlackSwirl04, spiderAtkBlackSwirl00, spiderAtkBlackSwirl01, spiderAtkBlackSwirl02, spiderAtkBlackSwirl03, spiderDeathBlackSwirl00, spiderDeathBlackSwirl01, spiderDeathBlackSwirl02, spiderDeathBlackSwirl03 }, { spiderWalkBlackSwirl10, spiderWalkBlackSwirl11, spiderWalkBlackSwirl12, spiderWalkBlackSwirl13, spiderWalkBlackSwirl14, spiderAtkBlackSwirl10, spiderAtkBlackSwirl11, spiderAtkBlackSwirl12, spiderAtkBlackSwirl13, spiderDeathBlackSwirl00, spiderDeathBlackSwirl01, spiderDeathBlackSwirl02, spiderDeathBlackSwirl03 },
			{ spiderWalkBlackSwirl20, spiderWalkBlackSwirl21, spiderWalkBlackSwirl22, spiderWalkBlackSwirl23, spiderWalkBlackSwirl24, spiderAtkBlackSwirl20, spiderAtkBlackSwirl21, spiderAtkBlackSwirl22, spiderAtkBlackSwirl23, spiderDeathBlackSwirl00, spiderDeathBlackSwirl01, spiderDeathBlackSwirl02, spiderDeathBlackSwirl03 }, { spiderWalkBlackSwirl30, spiderWalkBlackSwirl31, spiderWalkBlackSwirl32, spiderWalkBlackSwirl33, spiderWalkBlackSwirl34, spiderAtkBlackSwirl30, spiderAtkBlackSwirl31, spiderAtkBlackSwirl32, spiderAtkBlackSwirl33, spiderDeathBlackSwirl00, spiderDeathBlackSwirl01, spiderDeathBlackSwirl02, spiderDeathBlackSwirl03 } };

	//up
	public static Sprite spiderWalkSilverSwirl00 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 5, 8, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkSilverSwirl01 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 6, 8, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkSilverSwirl02 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 7, 8, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkSilverSwirl03 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 8, 8, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkSilverSwirl04 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 9, 8, SpriteSheet.spiderWalk));
	//left
	public static Sprite spiderWalkSilverSwirl10 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 5, 9, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkSilverSwirl11 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 6, 9, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkSilverSwirl12 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 7, 9, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkSilverSwirl13 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 8, 9, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkSilverSwirl14 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 9, 9, SpriteSheet.spiderWalk));
	//down
	public static Sprite spiderWalkSilverSwirl20 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 5, 10, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkSilverSwirl21 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 6, 10, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkSilverSwirl22 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 7, 10, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkSilverSwirl23 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 8, 10, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkSilverSwirl24 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 9, 10, SpriteSheet.spiderWalk));
	//right
	public static Sprite spiderWalkSilverSwirl30 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 5, 11, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkSilverSwirl31 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 6, 11, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkSilverSwirl32 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 7, 11, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkSilverSwirl33 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 8, 11, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkSilverSwirl34 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 9, 11, SpriteSheet.spiderWalk));

	//up
	public static Sprite spiderAtkSilverSwirl00 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 4, 8, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkSilverSwirl01 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 5, 8, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkSilverSwirl02 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 6, 8, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkSilverSwirl03 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 7, 8, SpriteSheet.spiderAtk));
	//left
	public static Sprite spiderAtkSilverSwirl10 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 4, 9, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkSilverSwirl11 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 5, 9, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkSilverSwirl12 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 6, 9, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkSilverSwirl13 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 7, 9, SpriteSheet.spiderAtk));
	//down
	public static Sprite spiderAtkSilverSwirl20 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 4, 10, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkSilverSwirl21 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 5, 10, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkSilverSwirl22 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 6, 10, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkSilverSwirl23 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 7, 10, SpriteSheet.spiderAtk));
	//right
	public static Sprite spiderAtkSilverSwirl30 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 4, 11, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkSilverSwirl31 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 5, 11, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkSilverSwirl32 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 6, 11, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkSilverSwirl33 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 7, 11, SpriteSheet.spiderAtk));

	public static Sprite spiderDeathSilverSwirl00 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 4, 2, SpriteSheet.spiderDeath));
	public static Sprite spiderDeathSilverSwirl01 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 5, 2, SpriteSheet.spiderDeath));
	public static Sprite spiderDeathSilverSwirl02 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 6, 2, SpriteSheet.spiderDeath));
	public static Sprite spiderDeathSilverSwirl03 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 7, 2, SpriteSheet.spiderDeath));

	public static Sprite[][] spiderSilverSwirl = new Sprite[][] { { spiderWalkSilverSwirl00, spiderWalkSilverSwirl01, spiderWalkSilverSwirl02, spiderWalkSilverSwirl03, spiderWalkSilverSwirl04, spiderAtkSilverSwirl00, spiderAtkSilverSwirl01, spiderAtkSilverSwirl02, spiderAtkSilverSwirl03, spiderDeathSilverSwirl00, spiderDeathSilverSwirl01, spiderDeathSilverSwirl02, spiderDeathSilverSwirl03 }, { spiderWalkSilverSwirl10, spiderWalkSilverSwirl11, spiderWalkSilverSwirl12, spiderWalkSilverSwirl13, spiderWalkSilverSwirl14, spiderAtkSilverSwirl10, spiderAtkSilverSwirl11, spiderAtkSilverSwirl12, spiderAtkSilverSwirl13, spiderDeathSilverSwirl00, spiderDeathSilverSwirl01, spiderDeathSilverSwirl02, spiderDeathSilverSwirl03 },
			{ spiderWalkSilverSwirl20, spiderWalkSilverSwirl21, spiderWalkSilverSwirl22, spiderWalkSilverSwirl23, spiderWalkSilverSwirl24, spiderAtkSilverSwirl20, spiderAtkSilverSwirl21, spiderAtkSilverSwirl22, spiderAtkSilverSwirl23, spiderDeathSilverSwirl00, spiderDeathSilverSwirl01, spiderDeathSilverSwirl02, spiderDeathSilverSwirl03 }, { spiderWalkSilverSwirl30, spiderWalkSilverSwirl31, spiderWalkSilverSwirl32, spiderWalkSilverSwirl33, spiderWalkSilverSwirl34, spiderAtkSilverSwirl30, spiderAtkSilverSwirl31, spiderAtkSilverSwirl32, spiderAtkSilverSwirl33, spiderDeathSilverSwirl00, spiderDeathSilverSwirl01, spiderDeathSilverSwirl02, spiderDeathSilverSwirl03 } };

	//up
	public static Sprite spiderWalkBlueSwirl00 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 10, 8, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlueSwirl01 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 11, 8, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlueSwirl02 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 12, 8, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlueSwirl03 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 13, 8, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlueSwirl04 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 14, 8, SpriteSheet.spiderWalk));
	//left
	public static Sprite spiderWalkBlueSwirl10 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 10, 9, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlueSwirl11 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 11, 9, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlueSwirl12 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 12, 9, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlueSwirl13 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 13, 9, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlueSwirl14 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 14, 9, SpriteSheet.spiderWalk));
	//down
	public static Sprite spiderWalkBlueSwirl20 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 10, 10, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlueSwirl21 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 11, 10, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlueSwirl22 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 12, 10, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlueSwirl23 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 13, 10, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlueSwirl24 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 14, 10, SpriteSheet.spiderWalk));
	//right
	public static Sprite spiderWalkBlueSwirl30 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 10, 11, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlueSwirl31 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 11, 11, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlueSwirl32 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 12, 11, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlueSwirl33 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 13, 11, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkBlueSwirl34 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 14, 11, SpriteSheet.spiderWalk));

	//up
	public static Sprite spiderAtkBlueSwirl00 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 8, 8, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkBlueSwirl01 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 9, 8, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkBlueSwirl02 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 10, 8, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkBlueSwirl03 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 11, 8, SpriteSheet.spiderAtk));
	//left
	public static Sprite spiderAtkBlueSwirl10 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 8, 9, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkBlueSwirl11 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 9, 9, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkBlueSwirl12 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 10, 9, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkBlueSwirl13 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 11, 9, SpriteSheet.spiderAtk));
	//down
	public static Sprite spiderAtkBlueSwirl20 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 8, 10, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkBlueSwirl21 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 9, 10, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkBlueSwirl22 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 10, 10, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkBlueSwirl23 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 11, 10, SpriteSheet.spiderAtk));
	//right
	public static Sprite spiderAtkBlueSwirl30 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 8, 11, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkBlueSwirl31 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 9, 11, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkBlueSwirl32 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 10, 11, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkBlueSwirl33 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 11, 11, SpriteSheet.spiderAtk));

	public static Sprite spiderDeathBlueSwirl00 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 8, 2, SpriteSheet.spiderDeath));
	public static Sprite spiderDeathBlueSwirl01 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 9, 2, SpriteSheet.spiderDeath));
	public static Sprite spiderDeathBlueSwirl02 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 10, 2, SpriteSheet.spiderDeath));
	public static Sprite spiderDeathBlueSwirl03 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 11, 2, SpriteSheet.spiderDeath));

	public static Sprite[][] spiderBlueSwirl = new Sprite[][] { { spiderWalkBlueSwirl00, spiderWalkBlueSwirl01, spiderWalkBlueSwirl02, spiderWalkBlueSwirl03, spiderWalkBlueSwirl04, spiderAtkBlueSwirl00, spiderAtkBlueSwirl01, spiderAtkBlueSwirl02, spiderAtkBlueSwirl03, spiderDeathBlueSwirl00, spiderDeathBlueSwirl01, spiderDeathBlueSwirl02, spiderDeathBlueSwirl03 }, { spiderWalkBlueSwirl10, spiderWalkBlueSwirl11, spiderWalkBlueSwirl12, spiderWalkBlueSwirl13, spiderWalkBlueSwirl14, spiderAtkBlueSwirl10, spiderAtkBlueSwirl11, spiderAtkBlueSwirl12, spiderAtkBlueSwirl13, spiderDeathBlueSwirl00, spiderDeathBlueSwirl01, spiderDeathBlueSwirl02, spiderDeathBlueSwirl03 },
			{ spiderWalkBlueSwirl20, spiderWalkBlueSwirl21, spiderWalkBlueSwirl22, spiderWalkBlueSwirl23, spiderWalkBlueSwirl24, spiderAtkBlueSwirl20, spiderAtkBlueSwirl21, spiderAtkBlueSwirl22, spiderAtkBlueSwirl23, spiderDeathBlueSwirl00, spiderDeathBlueSwirl01, spiderDeathBlueSwirl02, spiderDeathBlueSwirl03 }, { spiderWalkBlueSwirl30, spiderWalkBlueSwirl31, spiderWalkBlueSwirl32, spiderWalkBlueSwirl33, spiderWalkBlueSwirl34, spiderAtkBlueSwirl30, spiderAtkBlueSwirl31, spiderAtkBlueSwirl32, spiderAtkBlueSwirl33, spiderDeathBlueSwirl00, spiderDeathBlueSwirl01, spiderDeathBlueSwirl02, spiderDeathBlueSwirl03 } };

	//up
	public static Sprite spiderWalkRedSwirl00 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 15, 8, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkRedSwirl01 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 16, 8, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkRedSwirl02 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 17, 8, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkRedSwirl03 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 18, 8, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkRedSwirl04 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 19, 8, SpriteSheet.spiderWalk));
	//left
	public static Sprite spiderWalkRedSwirl10 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 15, 9, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkRedSwirl11 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 16, 9, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkRedSwirl12 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 17, 9, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkRedSwirl13 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 18, 9, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkRedSwirl14 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 19, 9, SpriteSheet.spiderWalk));
	//down
	public static Sprite spiderWalkRedSwirl20 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 15, 10, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkRedSwirl21 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 16, 10, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkRedSwirl22 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 17, 10, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkRedSwirl23 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 18, 10, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkRedSwirl24 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 19, 10, SpriteSheet.spiderWalk));
	//right
	public static Sprite spiderWalkRedSwirl30 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 15, 11, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkRedSwirl31 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 16, 11, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkRedSwirl32 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 17, 11, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkRedSwirl33 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 18, 11, SpriteSheet.spiderWalk));
	public static Sprite spiderWalkRedSwirl34 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 19, 11, SpriteSheet.spiderWalk));

	//up
	public static Sprite spiderAtkRedSwirl00 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 12, 8, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkRedSwirl01 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 13, 8, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkRedSwirl02 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 14, 8, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkRedSwirl03 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 15, 8, SpriteSheet.spiderAtk));
	//left
	public static Sprite spiderAtkRedSwirl10 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 12, 9, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkRedSwirl11 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 13, 9, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkRedSwirl12 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 14, 9, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkRedSwirl13 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 15, 9, SpriteSheet.spiderAtk));
	//down
	public static Sprite spiderAtkRedSwirl20 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 12, 10, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkRedSwirl21 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 13, 10, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkRedSwirl22 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 14, 10, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkRedSwirl23 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 15, 10, SpriteSheet.spiderAtk));
	//right
	public static Sprite spiderAtkRedSwirl30 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 12, 11, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkRedSwirl31 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 13, 11, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkRedSwirl32 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 14, 11, SpriteSheet.spiderAtk));
	public static Sprite spiderAtkRedSwirl33 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 15, 11, SpriteSheet.spiderAtk));

	public static Sprite spiderDeathRedSwirl00 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 12, 2, SpriteSheet.spiderDeath));
	public static Sprite spiderDeathRedSwirl01 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 13, 2, SpriteSheet.spiderDeath));
	public static Sprite spiderDeathRedSwirl02 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 14, 2, SpriteSheet.spiderDeath));
	public static Sprite spiderDeathRedSwirl03 = new Sprite(SIZE_X, SIZE_Y, new Sprite(64, 15, 2, SpriteSheet.spiderDeath));

	public static Sprite[][] spiderRedSwirl = new Sprite[][] { { spiderWalkRedSwirl00, spiderWalkRedSwirl01, spiderWalkRedSwirl02, spiderWalkRedSwirl03, spiderWalkRedSwirl04, spiderAtkRedSwirl00, spiderAtkRedSwirl01, spiderAtkRedSwirl02, spiderAtkRedSwirl03, spiderDeathRedSwirl00, spiderDeathRedSwirl01, spiderDeathRedSwirl02, spiderDeathRedSwirl03 }, { spiderWalkRedSwirl10, spiderWalkRedSwirl11, spiderWalkRedSwirl12, spiderWalkRedSwirl13, spiderWalkRedSwirl14, spiderAtkRedSwirl10, spiderAtkRedSwirl11, spiderAtkRedSwirl12, spiderAtkRedSwirl13, spiderDeathRedSwirl00, spiderDeathRedSwirl01, spiderDeathRedSwirl02, spiderDeathRedSwirl03 },
			{ spiderWalkRedSwirl20, spiderWalkRedSwirl21, spiderWalkRedSwirl22, spiderWalkRedSwirl23, spiderWalkRedSwirl24, spiderAtkRedSwirl20, spiderAtkRedSwirl21, spiderAtkRedSwirl22, spiderAtkRedSwirl23, spiderDeathRedSwirl00, spiderDeathRedSwirl01, spiderDeathRedSwirl02, spiderDeathRedSwirl03 }, { spiderWalkRedSwirl30, spiderWalkRedSwirl31, spiderWalkRedSwirl32, spiderWalkRedSwirl33, spiderWalkRedSwirl34, spiderAtkRedSwirl30, spiderAtkRedSwirl31, spiderAtkRedSwirl32, spiderAtkRedSwirl33, spiderDeathRedSwirl00, spiderDeathRedSwirl01, spiderDeathRedSwirl02, spiderDeathRedSwirl03 } };

}
