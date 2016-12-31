package graphics;

public class FireballSprite {
	public static Sprite[] fireballRed;
	public static Sprite[] fireballCyan;
	public static Sprite[] fireballBlack;
	public static Sprite[] fireballPurple;
	public static Sprite[] fireballOrange;
	public static Sprite[] fireballBlue;
	public static Sprite[] fireballGreen;
	public static Sprite[] fireballYellow;
	public static Sprite[] fireballRedFull;
	public static Sprite[] fireballCyanFull;
	public static Sprite[] fireballBlackFull;
	public static Sprite[] fireballPurpleFull;
	public static Sprite[] fireballOrangeFull;
	public static Sprite[] fireballBlueFull;
	public static Sprite[] fireballGreenFull;
	public static Sprite[] fireballYellowFull;

	static {
		Sprite fireball_base = new Sprite(60, 0, 0, SpriteSheet.fireball);
		Sprite fireball_small = new Sprite(30, 30, fireball_base);
		Sprite fireball_tiny = new Sprite(20, 10, fireball_base);

		int[] includeRed = { 0xbfd54e3a, 0x9fde7565, 0xffebaba2 };
		int[] includeCyan = { 0xaf3fa7bd, 0x9fb8dfe7, 0xcfb8dfe7 };
		int[] includeBlack = { 0xaf565656, 0x9f787878 };
		int[] includePurple = { 0x7f953fbd, 0xcfbf76d1 };
		int[] includeOrange = { 0x9fff3700, 0xaffea740 };
		int[] includeBlue = { 0xff3651a1, 0xff5e79c9 };
		int[] includeGreen = { 0x7f349330, 0xbf53c44f };
		int[] includeYellow = { 0xffbdb93f };

		fireballRed = Sprite.roll(Sprite.replaceColors(fireball_tiny, fireball_tiny.getTopColors(), PlayerSprite.playerRed[0][0].getTopColors(fireball_tiny.getColors().length, includeRed)), 12);
		fireballCyan = Sprite.roll(Sprite.replaceColors(fireball_tiny, fireball_tiny.getTopColors(), PlayerSprite.playerCyan[0][0].getTopColors(fireball_tiny.getColors().length, includeCyan)), 12);
		fireballBlack = Sprite.roll(Sprite.replaceColors(fireball_tiny, fireball_tiny.getTopColors(), PlayerSprite.playerBlack[0][0].getTopColors(fireball_tiny.getColors().length, includeBlack)), 12);
		fireballPurple = Sprite.roll(Sprite.replaceColors(fireball_tiny, fireball_tiny.getTopColors(), PlayerSprite.playerPurple[0][0].getTopColors(fireball_tiny.getColors().length, includePurple)), 12);
		fireballOrange = Sprite.roll(Sprite.replaceColors(fireball_tiny, fireball_tiny.getTopColors(), PlayerSprite.playerOrange[0][0].getTopColors(fireball_tiny.getColors().length, includeOrange)), 12);
		fireballBlue = Sprite.roll(Sprite.replaceColors(fireball_tiny, fireball_tiny.getTopColors(), PlayerSprite.playerBlue[0][0].getTopColors(fireball_tiny.getColors().length, includeBlue)), 12);
		fireballGreen = Sprite.roll(Sprite.replaceColors(fireball_tiny, fireball_tiny.getTopColors(), PlayerSprite.playerGreen[0][0].getTopColors(fireball_tiny.getColors().length, includeGreen)), 12);
		fireballYellow = Sprite.roll(Sprite.replaceColors(fireball_tiny, fireball_tiny.getTopColors(), PlayerSprite.playerYellow[0][0].getTopColors(fireball_tiny.getColors().length, includeYellow)), 12);

		int[] includeRedFull = { 0x8fdd7060, 0xafd95d4a, 0xdfe3897c, 0xffdb6452, 0xefd44833, 0x4fac3523 };
		int[] includeCyanFull = { 0xaf3fa7bd, 0x9fb8dfe7, 0xcfb8dfe7 };
		int[] includeBlackFull = { 0xaf565656, 0x9f787878 };
		int[] includePurpleFull = { 0x7f953fbd, 0xcfbf76d1 };
		int[] includeOrangeFull = { 0x9fff3700, 0xaffea740 };
		int[] includeBlueFull = { 0xff3651a1, 0xff5e79c9 };
		int[] includeGreenFull = { 0x7f349330, 0xbf53c44f };
		int[] includeYellowFull = { 0xffbdb93f };

		fireballRedFull = Sprite.roll(Sprite.replaceColors(fireball_small, fireball_small.getColors(), PlayerSprite.playerRed[0][0].getTopColors(fireball_small.getColors().length, includeRedFull)), 12);
		fireballCyanFull = Sprite.roll(Sprite.replaceColors(fireball_small, fireball_small.getTopColors(), PlayerSprite.playerCyan[0][0].getTopColors(fireball_small.getColors().length, includeCyanFull)), 12);
		fireballBlackFull = Sprite.roll(Sprite.replaceColors(fireball_small, fireball_small.getTopColors(), PlayerSprite.playerBlack[0][0].getTopColors(fireball_small.getColors().length, includeBlackFull)), 12);
		fireballPurpleFull = Sprite.roll(Sprite.replaceColors(fireball_small, fireball_small.getTopColors(), PlayerSprite.playerPurple[0][0].getTopColors(fireball_small.getColors().length, includePurpleFull)), 12);
		fireballOrangeFull = Sprite.roll(Sprite.replaceColors(fireball_small, fireball_small.getTopColors(), PlayerSprite.playerOrange[0][0].getTopColors(fireball_small.getColors().length, includeOrangeFull)), 12);
		fireballBlueFull = Sprite.roll(Sprite.replaceColors(fireball_small, fireball_small.getTopColors(), PlayerSprite.playerBlue[0][0].getTopColors(fireball_small.getColors().length, includeBlueFull)), 12);
		fireballGreenFull = Sprite.roll(Sprite.replaceColors(fireball_small, fireball_small.getTopColors(), PlayerSprite.playerGreen[0][0].getTopColors(fireball_small.getColors().length, includeGreenFull)), 12);
		fireballYellowFull = Sprite.roll(Sprite.replaceColors(fireball_small, fireball_small.getTopColors(), PlayerSprite.playerYellow[0][0].getTopColors(fireball_small.getColors().length, includeYellowFull)), 12);
	}
}
