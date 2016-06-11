package graphics;

public class FireballSprite {

	public static Sprite fireball_base = new Sprite(60, 0, 0, SpriteSheet.fireball);
	public static Sprite fireball_small = new Sprite(30, 30, fireball_base);
	public static Sprite fireball_tiny = new Sprite(20, 10, fireball_base);

	public static int[] includeRed = { 0xbfd54e3a, 0x9fde7565, 0xffebaba2 };
	public static int[] includeCyan = { 0xaf3fa7bd, 0x9fb8dfe7, 0xcfb8dfe7 };
	public static int[] includeBlack = { 0xaf565656, 0x9f787878 };
	public static int[] includePurple = { 0x7f953fbd, 0xcfbf76d1 };
	public static int[] includeOrange = { 0x9fff3700, 0xaffea740 };
	public static int[] includeBlue = { 0xff3651a1, 0xff5e79c9 };
	public static int[] includeGreen = { 0x7f349330, 0xbf53c44f };
	public static int[] includeYellow = { 0xffbdb93f };

	public static Sprite[] fireballRed = Sprite.roll(Sprite.replaceColors(fireball_tiny, fireball_tiny.getTopColors(), PlayerSprite.playerRed[0][0].getTopColors(fireball_tiny.getColors().length, includeRed)), 12);
	public static Sprite[] fireballCyan = Sprite.roll(Sprite.replaceColors(fireball_tiny, fireball_tiny.getTopColors(), PlayerSprite.playerCyan[0][0].getTopColors(fireball_tiny.getColors().length, includeCyan)), 12);
	public static Sprite[] fireballBlack = Sprite.roll(Sprite.replaceColors(fireball_tiny, fireball_tiny.getTopColors(), PlayerSprite.playerBlack[0][0].getTopColors(fireball_tiny.getColors().length, includeBlack)), 12);
	public static Sprite[] fireballPurple = Sprite.roll(Sprite.replaceColors(fireball_tiny, fireball_tiny.getTopColors(), PlayerSprite.playerPurple[0][0].getTopColors(fireball_tiny.getColors().length, includePurple)), 12);
	public static Sprite[] fireballOrange = Sprite.roll(Sprite.replaceColors(fireball_tiny, fireball_tiny.getTopColors(), PlayerSprite.playerOrange[0][0].getTopColors(fireball_tiny.getColors().length, includeOrange)), 12);
	public static Sprite[] fireballBlue = Sprite.roll(Sprite.replaceColors(fireball_tiny, fireball_tiny.getTopColors(), PlayerSprite.playerBlue[0][0].getTopColors(fireball_tiny.getColors().length, includeBlue)), 12);
	public static Sprite[] fireballGreen = Sprite.roll(Sprite.replaceColors(fireball_tiny, fireball_tiny.getTopColors(), PlayerSprite.playerGreen[0][0].getTopColors(fireball_tiny.getColors().length, includeGreen)), 12);
	public static Sprite[] fireballYellow = Sprite.roll(Sprite.replaceColors(fireball_tiny, fireball_tiny.getTopColors(), PlayerSprite.playerYellow[0][0].getTopColors(fireball_tiny.getColors().length, includeYellow)), 12);

	public static int[] includeRedFull = { 0x8fdd7060, 0xafd95d4a, 0xdfe3897c, 0xffdb6452, 0xefd44833, 0x4fac3523 };
	public static int[] includeCyanFull = { 0xaf3fa7bd, 0x9fb8dfe7, 0xcfb8dfe7 };
	public static int[] includeBlackFull = { 0xaf565656, 0x9f787878 };
	public static int[] includePurpleFull = { 0x7f953fbd, 0xcfbf76d1 };
	public static int[] includeOrangeFull = { 0x9fff3700, 0xaffea740 };
	public static int[] includeBlueFull = { 0xff3651a1, 0xff5e79c9 };
	public static int[] includeGreenFull = { 0x7f349330, 0xbf53c44f };
	public static int[] includeYellowFull = { 0xffbdb93f };

	public static Sprite[] fireballRedFull = Sprite.roll(Sprite.replaceColors(fireball_small, fireball_small.getColors(), PlayerSprite.playerRed[0][0].getTopColors(fireball_small.getColors().length, includeRedFull)), 12);
	public static Sprite[] fireballCyanFull = Sprite.roll(Sprite.replaceColors(fireball_small, fireball_small.getTopColors(), PlayerSprite.playerCyan[0][0].getTopColors(fireball_small.getColors().length, includeCyanFull)), 12);
	public static Sprite[] fireballBlackFull = Sprite.roll(Sprite.replaceColors(fireball_small, fireball_small.getTopColors(), PlayerSprite.playerBlack[0][0].getTopColors(fireball_small.getColors().length, includeBlackFull)), 12);
	public static Sprite[] fireballPurpleFull = Sprite.roll(Sprite.replaceColors(fireball_small, fireball_small.getTopColors(), PlayerSprite.playerPurple[0][0].getTopColors(fireball_small.getColors().length, includePurpleFull)), 12);
	public static Sprite[] fireballOrangeFull = Sprite.roll(Sprite.replaceColors(fireball_small, fireball_small.getTopColors(), PlayerSprite.playerOrange[0][0].getTopColors(fireball_small.getColors().length, includeOrangeFull)), 12);
	public static Sprite[] fireballBlueFull = Sprite.roll(Sprite.replaceColors(fireball_small, fireball_small.getTopColors(), PlayerSprite.playerBlue[0][0].getTopColors(fireball_small.getColors().length, includeBlueFull)), 12);
	public static Sprite[] fireballGreenFull = Sprite.roll(Sprite.replaceColors(fireball_small, fireball_small.getTopColors(), PlayerSprite.playerGreen[0][0].getTopColors(fireball_small.getColors().length, includeGreenFull)), 12);
	public static Sprite[] fireballYellowFull = Sprite.roll(Sprite.replaceColors(fireball_small, fireball_small.getTopColors(), PlayerSprite.playerYellow[0][0].getTopColors(fireball_small.getColors().length, includeYellowFull)), 12);

}
