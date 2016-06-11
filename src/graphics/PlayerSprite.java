package graphics;

import java.util.ArrayList;

public class PlayerSprite {
	// Player sprites:

	//up
	public static Sprite player00 = new Sprite(32, 0, 3, SpriteSheet.flame);
	public static Sprite player01 = new Sprite(32, 1, 3, SpriteSheet.flame);
	public static Sprite player02 = new Sprite(32, 2, 3, SpriteSheet.flame);
	//side
	public static Sprite player10 = new Sprite(32, 0, 2, SpriteSheet.flame);
	public static Sprite player11 = new Sprite(32, 1, 2, SpriteSheet.flame);
	public static Sprite player12 = new Sprite(32, 2, 2, SpriteSheet.flame);
	//down
	public static Sprite player20 = new Sprite(32, 0, 0, SpriteSheet.flame);
	public static Sprite player21 = new Sprite(32, 1, 0, SpriteSheet.flame);
	public static Sprite player22 = new Sprite(32, 2, 0, SpriteSheet.flame);

	public static Sprite[][] playerRed = new Sprite[][] { { player00, player01, player02 }, { player10, player11, player12 }, { player20, player21, player22 } };

	//up
	public static Sprite player03 = new Sprite(32, 3, 3, SpriteSheet.flame);
	public static Sprite player04 = new Sprite(32, 4, 3, SpriteSheet.flame);
	public static Sprite player05 = new Sprite(32, 5, 3, SpriteSheet.flame);
	//side
	public static Sprite player13 = new Sprite(32, 3, 2, SpriteSheet.flame);
	public static Sprite player14 = new Sprite(32, 4, 2, SpriteSheet.flame);
	public static Sprite player15 = new Sprite(32, 5, 2, SpriteSheet.flame);
	//down
	public static Sprite player23 = new Sprite(32, 3, 0, SpriteSheet.flame);
	public static Sprite player24 = new Sprite(32, 4, 0, SpriteSheet.flame);
	public static Sprite player25 = new Sprite(32, 5, 0, SpriteSheet.flame);

	public static Sprite[][] playerCyan = new Sprite[][] { { player03, player04, player05 }, { player13, player14, player15 }, { player23, player24, player25 } };

	//up
	public static Sprite player06 = new Sprite(32, 6, 3, SpriteSheet.flame);
	public static Sprite player07 = new Sprite(32, 7, 3, SpriteSheet.flame);
	public static Sprite player08 = new Sprite(32, 8, 3, SpriteSheet.flame);
	//side
	public static Sprite player16 = new Sprite(32, 6, 2, SpriteSheet.flame);
	public static Sprite player17 = new Sprite(32, 7, 2, SpriteSheet.flame);
	public static Sprite player18 = new Sprite(32, 8, 2, SpriteSheet.flame);
	//down
	public static Sprite player26 = new Sprite(32, 6, 0, SpriteSheet.flame);
	public static Sprite player27 = new Sprite(32, 7, 0, SpriteSheet.flame);
	public static Sprite player28 = new Sprite(32, 8, 0, SpriteSheet.flame);

	public static Sprite[][] playerBlack = new Sprite[][] { { player06, player07, player08 }, { player16, player17, player18 }, { player26, player27, player28 } };

	//up
	public static Sprite player09 = new Sprite(32, 9, 3, SpriteSheet.flame);
	public static Sprite player010 = new Sprite(32, 10, 3, SpriteSheet.flame);
	public static Sprite player011 = new Sprite(32, 11, 3, SpriteSheet.flame);
	//side
	public static Sprite player19 = new Sprite(32, 9, 2, SpriteSheet.flame);
	public static Sprite player110 = new Sprite(32, 10, 2, SpriteSheet.flame);
	public static Sprite player111 = new Sprite(32, 11, 2, SpriteSheet.flame);
	//down
	public static Sprite player29 = new Sprite(32, 9, 0, SpriteSheet.flame);
	public static Sprite player210 = new Sprite(32, 10, 0, SpriteSheet.flame);
	public static Sprite player211 = new Sprite(32, 11, 0, SpriteSheet.flame);

	public static Sprite[][] playerPurple = new Sprite[][] { { player09, player010, player011 }, { player19, player110, player111 }, { player29, player210, player211 } };

	//up
	public static Sprite player30 = new Sprite(32, 0, 7, SpriteSheet.flame);
	public static Sprite player31 = new Sprite(32, 1, 7, SpriteSheet.flame);
	public static Sprite player32 = new Sprite(32, 2, 7, SpriteSheet.flame);
	//side
	public static Sprite player40 = new Sprite(32, 0, 6, SpriteSheet.flame);
	public static Sprite player41 = new Sprite(32, 1, 6, SpriteSheet.flame);
	public static Sprite player42 = new Sprite(32, 2, 6, SpriteSheet.flame);
	//down
	public static Sprite player50 = new Sprite(32, 0, 4, SpriteSheet.flame);
	public static Sprite player51 = new Sprite(32, 1, 4, SpriteSheet.flame);
	public static Sprite player52 = new Sprite(32, 2, 4, SpriteSheet.flame);

	public static Sprite[][] playerOrange = new Sprite[][] { { player30, player31, player32 }, { player40, player41, player42 }, { player50, player51, player52 } };

	//up
	public static Sprite player33 = new Sprite(32, 3, 7, SpriteSheet.flame);
	public static Sprite player34 = new Sprite(32, 4, 7, SpriteSheet.flame);
	public static Sprite player35 = new Sprite(32, 5, 7, SpriteSheet.flame);
	//side
	public static Sprite player43 = new Sprite(32, 3, 6, SpriteSheet.flame);
	public static Sprite player44 = new Sprite(32, 4, 6, SpriteSheet.flame);
	public static Sprite player45 = new Sprite(32, 5, 6, SpriteSheet.flame);
	//down
	public static Sprite player53 = new Sprite(32, 3, 4, SpriteSheet.flame);
	public static Sprite player54 = new Sprite(32, 4, 4, SpriteSheet.flame);
	public static Sprite player55 = new Sprite(32, 5, 4, SpriteSheet.flame);

	public static Sprite[][] playerBlue = new Sprite[][] { { player33, player34, player35 }, { player43, player44, player45 }, { player53, player54, player55 } };

	//up
	public static Sprite player36 = new Sprite(32, 6, 7, SpriteSheet.flame);
	public static Sprite player37 = new Sprite(32, 7, 7, SpriteSheet.flame);
	public static Sprite player38 = new Sprite(32, 8, 7, SpriteSheet.flame);
	//side
	public static Sprite player46 = new Sprite(32, 6, 6, SpriteSheet.flame);
	public static Sprite player47 = new Sprite(32, 7, 6, SpriteSheet.flame);
	public static Sprite player48 = new Sprite(32, 8, 6, SpriteSheet.flame);
	//down
	public static Sprite player56 = new Sprite(32, 6, 4, SpriteSheet.flame);
	public static Sprite player57 = new Sprite(32, 7, 4, SpriteSheet.flame);
	public static Sprite player58 = new Sprite(32, 8, 4, SpriteSheet.flame);

	public static Sprite[][] playerGreen = new Sprite[][] { { player36, player37, player38 }, { player46, player47, player48 }, { player56, player57, player58 } };

	//up
	public static Sprite player39 = new Sprite(32, 9, 7, SpriteSheet.flame);
	public static Sprite player310 = new Sprite(32, 10, 7, SpriteSheet.flame);
	public static Sprite player311 = new Sprite(32, 11, 7, SpriteSheet.flame);
	//side
	public static Sprite player49 = new Sprite(32, 9, 6, SpriteSheet.flame);
	public static Sprite player410 = new Sprite(32, 10, 6, SpriteSheet.flame);
	public static Sprite player411 = new Sprite(32, 11, 6, SpriteSheet.flame);
	//down
	public static Sprite player59 = new Sprite(32, 9, 4, SpriteSheet.flame);
	public static Sprite player510 = new Sprite(32, 10, 4, SpriteSheet.flame);
	public static Sprite player511 = new Sprite(32, 11, 4, SpriteSheet.flame);

	public static Sprite[][] playerYellow = new Sprite[][] { { player39, player310, player311 }, { player49, player410, player411 }, { player59, player510, player511 } };

}
