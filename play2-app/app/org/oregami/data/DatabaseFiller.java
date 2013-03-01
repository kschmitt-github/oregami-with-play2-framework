package org.oregami.data;

import java.util.Date;

import org.oregami.entities.CountryRelease;
import org.oregami.entities.Game;
import org.oregami.entities.GameTitle;
import org.oregami.entities.Photo;
import org.oregami.entities.Platform;
import org.oregami.entities.Release;
import org.oregami.entities.ReleaseGroup;
import org.oregami.entities.Screenshot;
import org.oregami.entities.user.Role;
import org.oregami.entities.user.User;
import org.oregami.keyobjects.KeyObjects.CountryKey;
import org.oregami.keyobjects.KeyObjects.DistributionKey;
import org.oregami.keyobjects.KeyObjects.PhotoType;
import org.oregami.keyobjects.KeyObjects.ReleaseGroupType;
import org.oregami.keyobjects.KeyObjects.RoleKey;
import org.oregami.keyobjects.KeyObjects.ScreenshotType;
import org.oregami.keyobjects.KeyObjects.SystemKey;

import com.google.inject.Inject;
import com.google.inject.persist.Transactional;

/**
 * Class to fill the database with some sample entities.
 * 
 * @author twendelmuth
 * 
 */
public class DatabaseFiller {

	@Inject 
	private GenericDAO<Game, Long> gameRepository;

	@Inject
	private GenericDAO<User, Long> userRepository;

	@Inject 
	private GenericDAO<Platform, Long> platformRepository;	
	

	private void addMonkeyIsland() {
		Game gameMonkeyIsland = new Game();
		
		gameMonkeyIsland.addGameTitle(new GameTitle("Monkey Island"));
		gameMonkeyIsland.addGameTitle(new GameTitle("Monkey Island 1"));
		gameMonkeyIsland.addGameTitle(new GameTitle("The Secret of Monkey Island"));

		gameMonkeyIsland.setTagLineDescription("Monkey Island tld");
		gameMonkeyIsland.setDescription("Tolles Spiel mit viel Humor! (" + new Date() + ")");

		ReleaseGroup releaseGroupDos = new ReleaseGroup("DOS", SystemKey.MSDOS, ReleaseGroupType.Original);
		Release releaseMsdos1_1 = new Release("Veröffentlichung 1-1 (PC, 5,25, DV, 256 Farben)", DistributionKey.RegularBox);
		releaseMsdos1_1.addCountryRelease(new CountryRelease(CountryKey.Deutschland, 1990));
		releaseGroupDos.addRelease(releaseMsdos1_1);

		// vogDos.addScreenshot(new Screenshot("M_5630_1127336939_monkeyisland1_1.png", ScreenshotType.unknown, "description"));
		releaseGroupDos.addScreenshot(new Screenshot("monkeyisland/dos/M_5630_1127336939_monkeyisland1_1.png", ScreenshotType.unknown, "description not available"));
		releaseGroupDos.addScreenshot(new Screenshot("monkeyisland/dos/M_5630_1127336939_monkeyisland1_2.png", ScreenshotType.unknown, "description not available"));
		releaseGroupDos.addScreenshot(new Screenshot("monkeyisland/dos/M_5630_1127336940_monkeyisland1_3.png", ScreenshotType.unknown, "description not available"));
		releaseGroupDos.addScreenshot(new Screenshot("monkeyisland/dos/M_5630_1127336940_monkeyisland1_4.png", ScreenshotType.unknown, "description not available"));
		releaseGroupDos.addScreenshot(new Screenshot("monkeyisland/dos/M_5630_1127336940_monkeyisland1_5.png", ScreenshotType.unknown, "description not available"));
		releaseGroupDos.addScreenshot(new Screenshot("monkeyisland/dos/M_5630_1127336941_monkeyisland1_6.png", ScreenshotType.unknown, "description not available"));
		releaseGroupDos.addScreenshot(new Screenshot("monkeyisland/dos/M_5630_1127336941_monkeyisland1_7.png", ScreenshotType.unknown, "description not available"));
		releaseGroupDos.addScreenshot(new Screenshot("monkeyisland/dos/M_5630_1127336942_monkeyisland1_10.png", ScreenshotType.unknown, "description not available"));
		releaseGroupDos.addScreenshot(new Screenshot("monkeyisland/dos/M_5630_1127336942_monkeyisland1_8.png", ScreenshotType.unknown, "description not available"));
		releaseGroupDos.addScreenshot(new Screenshot("monkeyisland/dos/M_5630_1127336942_monkeyisland1_9.png", ScreenshotType.unknown, "description not available"));
		releaseGroupDos.addScreenshot(new Screenshot("monkeyisland/dos/M_5630_1127336943_monkeyisland1_11.png", ScreenshotType.unknown, "description not available"));
		releaseGroupDos.addScreenshot(new Screenshot("monkeyisland/dos/M_5630_1127336943_monkeyisland1_12.png", ScreenshotType.unknown, "description not available"));
		releaseGroupDos.addScreenshot(new Screenshot("monkeyisland/dos/M_5630_1127336944_monkeyisland1_13.png", ScreenshotType.unknown, "description not available"));
		releaseGroupDos.addScreenshot(new Screenshot("monkeyisland/dos/M_5630_1127336944_monkeyisland1_14.png", ScreenshotType.unknown, "description not available"));
		releaseGroupDos.addScreenshot(new Screenshot("monkeyisland/dos/M_5630_1127336945_monkeyisland1_15.png", ScreenshotType.unknown, "description not available"));
		releaseGroupDos.addScreenshot(new Screenshot("monkeyisland/dos/M_5630_1127336945_monkeyisland1_16.png", ScreenshotType.unknown, "description not available"));
		releaseGroupDos.addScreenshot(new Screenshot("monkeyisland/dos/M_5630_1127336945_monkeyisland1_17.png", ScreenshotType.unknown, "description not available"));
		releaseGroupDos.addScreenshot(new Screenshot("monkeyisland/dos/M_5630_1127336946_monkeyisland1_18.png", ScreenshotType.unknown, "description not available"));
		releaseGroupDos.addScreenshot(new Screenshot("monkeyisland/dos/M_5630_1127336946_monkeyisland1_19.png", ScreenshotType.unknown, "description not available"));
		releaseGroupDos.addScreenshot(new Screenshot("monkeyisland/dos/M_5630_1127336946_monkeyisland1_20.png", ScreenshotType.unknown, "description not available"));
		releaseGroupDos.addScreenshot(new Screenshot("monkeyisland/dos/M_5630_1127336947_monkeyisland1_21.png", ScreenshotType.unknown, "description not available"));
		releaseGroupDos.addScreenshot(new Screenshot("monkeyisland/dos/M_5630_1127336947_monkeyisland1_22.png", ScreenshotType.unknown, "description not available"));
		releaseGroupDos.addScreenshot(new Screenshot("monkeyisland/dos/M_5630_1127336947_monkeyisland1_23.png", ScreenshotType.unknown, "description not available"));
		releaseGroupDos.addScreenshot(new Screenshot("monkeyisland/dos/M_5630_1127336948_monkeyisland1_24.png", ScreenshotType.unknown, "description not available"));
		releaseGroupDos.addScreenshot(new Screenshot("monkeyisland/dos/M_5630_1127336948_monkeyisland1_25.png", ScreenshotType.unknown, "description not available"));
		releaseGroupDos.addScreenshot(new Screenshot("monkeyisland/dos/M_5630_1127336948_monkeyisland1_26.png", ScreenshotType.unknown, "description not available"));
		releaseGroupDos.addScreenshot(new Screenshot("monkeyisland/dos/M_5630_1127336949_monkeyisland1_27.png", ScreenshotType.unknown, "description not available"));
		releaseGroupDos.addScreenshot(new Screenshot("monkeyisland/dos/M_5630_1127336949_monkeyisland1_28.png", ScreenshotType.unknown, "description not available"));
		releaseGroupDos.addScreenshot(new Screenshot("monkeyisland/dos/M_5630_1127336949_monkeyisland1_29.png", ScreenshotType.unknown, "description not available"));
		releaseGroupDos.addScreenshot(new Screenshot("monkeyisland/dos/M_5630_1127336950_monkeyisland1_30.png", ScreenshotType.unknown, "description not available"));
		releaseGroupDos.addScreenshot(new Screenshot("monkeyisland/dos/M_5630_1127336950_monkeyisland1_31.png", ScreenshotType.unknown, "description not available"));
		releaseGroupDos.addScreenshot(new Screenshot("monkeyisland/megacd/M_5630_1133382714_MONKEYISLAND000.png", ScreenshotType.unknown, "description not available"));
		releaseGroupDos.addScreenshot(new Screenshot("monkeyisland/megacd/M_5630_1133382715_MONKEYISLAND005.png", ScreenshotType.unknown, "description not available"));
		releaseGroupDos.addScreenshot(new Screenshot("monkeyisland/megacd/M_5630_1133382716_MONKEYISLAND010.png", ScreenshotType.unknown, "description not available"));
		releaseGroupDos.addScreenshot(new Screenshot("monkeyisland/megacd/M_5630_1133382716_MONKEYISLAND011.png", ScreenshotType.unknown, "description not available"));
		releaseGroupDos.addScreenshot(new Screenshot("monkeyisland/megacd/M_5630_1133382717_MONKEYISLAND012.png", ScreenshotType.unknown, "description not available"));
		releaseGroupDos.addScreenshot(new Screenshot("monkeyisland/megacd/M_5630_1133382717_MONKEYISLAND013.png", ScreenshotType.unknown, "description not available"));
		releaseGroupDos.addScreenshot(new Screenshot("monkeyisland/megacd/M_5630_1133382718_MONKEYISLAND014.png", ScreenshotType.unknown, "description not available"));

		Release releaseMsdos1_11 = new Release("Veröffentlichung 1-11 (PC, CD, EU, 256 Farben)", DistributionKey.RegularBox);
		releaseMsdos1_11.addCountryRelease(new CountryRelease(CountryKey.Deutschland, 9999));
		releaseMsdos1_11.addCountryRelease(new CountryRelease(CountryKey.Frankreich, 9999));
		releaseMsdos1_11.addCountryRelease(new CountryRelease(CountryKey.Italien, 9999));
		releaseMsdos1_11.addCountryRelease(new CountryRelease(CountryKey.Spanien, 9999));
		releaseMsdos1_11.addCountryRelease(new CountryRelease(CountryKey.UK, 9999));
		releaseGroupDos.addRelease(releaseMsdos1_11);

		releaseMsdos1_11.addPhoto(new Photo("M_5630_1101395547_monkey_island_1_9.jpg", PhotoType.unknown, "description not available"));
		releaseMsdos1_11.addPhoto(new Photo("M_5630_1107353849_monkey_island_1_12.jpg", PhotoType.unknown, "description not available"));
		releaseMsdos1_11.addPhoto(new Photo("M_5630_1115992608_monkeyisland1us.JPG", PhotoType.unknown, "description not available"));
		releaseMsdos1_11.addPhoto(new Photo("M_5630_1115992625_monkeyisland1ger.JPG", PhotoType.unknown, "description not available"));
		releaseMsdos1_11.addPhoto(new Photo("S_5630_1162420631_monkey_island_1_18.jpg", PhotoType.unknown, "description not available"));
		releaseMsdos1_11.addPhoto(new Photo("S_5630_1240255705_MonkeyIsland1-Goodies28legacy29.jpg", PhotoType.unknown, "description not available"));
		releaseMsdos1_11.addPhoto(new Photo("S_5630_1255013946_mits.jpg", PhotoType.unknown, "description not available"));

		ReleaseGroup releaseGroupDosDemo = new ReleaseGroup("DOS", SystemKey.MSDOS, ReleaseGroupType.Demo);

		ReleaseGroup releaseGroupDosEnhanced = new ReleaseGroup("DOS (Verbesserte CD-Version)", SystemKey.MSDOS, ReleaseGroupType.Enhanced);

		gameMonkeyIsland.addReleaseGroup(releaseGroupDos);
		gameMonkeyIsland.addReleaseGroup(releaseGroupDosDemo);
		gameMonkeyIsland.addReleaseGroup(releaseGroupDosEnhanced);

		// ########### Amiga
		ReleaseGroup releaseGroupAmiga = new ReleaseGroup("Amiga 500/600 (OCS/ECS)", SystemKey.Amiga, ReleaseGroupType.Original);

		Release releaseAmiga4_1 = new Release("Veröffentlichung 4-1 (Amiga, 3,5, DV)", DistributionKey.RegularBox);
		releaseAmiga4_1.addCountryRelease(new CountryRelease(CountryKey.Deutschland, 1991));
		Release releaseAmiga4_2 = new Release("Veröffentlichung 4-2 (Amiga, 3,5, UK)", DistributionKey.RegularBox);
		releaseAmiga4_2.addCountryRelease(new CountryRelease(CountryKey.UK, 1991));
		Release releaseAmiga4_3 = new Release("Veröffentlichung 4-3 (Amiga, 3,5, UK Kixx)", DistributionKey.RegularBox);
		releaseAmiga4_3.addCountryRelease(new CountryRelease(CountryKey.UK, 1994));

		releaseAmiga4_1.addPhoto(new Photo("S_5630_1271668192_MonkeyIslandAmigaedit.jpg", PhotoType.unknown, "description not available"));

		releaseGroupAmiga.addRelease(releaseAmiga4_1);
		releaseGroupAmiga.addRelease(releaseAmiga4_2);
		releaseGroupAmiga.addRelease(releaseAmiga4_3);

		ReleaseGroup releaseGroupAmigaDemo = new ReleaseGroup("Amiga 500/600 (OCS/ECS)", SystemKey.Amiga, ReleaseGroupType.Demo);

		gameMonkeyIsland.addReleaseGroup(releaseGroupAmiga);
		gameMonkeyIsland.addReleaseGroup(releaseGroupAmigaDemo);

		// ########### Atari ST
		ReleaseGroup releaseGroupAtariST = new ReleaseGroup("Atari ST", SystemKey.AtariST, ReleaseGroupType.Original);

		Release releaseSt6_1 = new Release("Veröffentlichung 6-1 (Atari ST, 3,5, DV)", DistributionKey.RegularBox);
		releaseSt6_1.addCountryRelease(new CountryRelease(CountryKey.Deutschland, 1991));
		Release releaseSt6_2 = new Release("Veröffentlichung 6-2 (Atari ST, 3,5, US)", DistributionKey.RegularBox);
		releaseSt6_2.addCountryRelease(new CountryRelease(CountryKey.USA, 1991));
		Release releaseSt6_3 = new Release("Veröffentlichung 6-3 (Atari ST, 3,5, UK)", DistributionKey.RegularBox);
		releaseSt6_3.addCountryRelease(new CountryRelease(CountryKey.UK, 1991));

		releaseGroupAtariST.addRelease(releaseSt6_1);
		releaseGroupAtariST.addRelease(releaseSt6_2);
		releaseGroupAtariST.addRelease(releaseSt6_3);

		releaseSt6_1.addPhoto(new Photo("S_5630_1155913776_monkey_island_1_16.jpg", PhotoType.unknown, "description not available"));

		gameMonkeyIsland.addReleaseGroup(releaseGroupAtariST);

		// ########### Apple
		ReleaseGroup releaseGroupApple = new ReleaseGroup("Apple Macintosh", SystemKey.AppleMacintosh, ReleaseGroupType.Original);

		Release releaseApple7_1 = new Release("Veröffentlichung 7-1 (Apple Macintosh, 3,5, US)", DistributionKey.RegularBox);
		releaseApple7_1.addCountryRelease(new CountryRelease(CountryKey.USA, 1991));

		releaseApple7_1.addPhoto(new Photo("S_5630_1198436013_monkey_island_1_27.jpg", PhotoType.unknown, "description not available"));

		releaseGroupApple.addRelease(releaseApple7_1);

		ReleaseGroup vogAppleSpecial = new ReleaseGroup("Apple Macintosh", SystemKey.AppleMacintosh, ReleaseGroupType.Enhanced);

		gameMonkeyIsland.addReleaseGroup(releaseGroupApple);
		gameMonkeyIsland.addReleaseGroup(vogAppleSpecial);

		gameRepository.save(gameMonkeyIsland);
	}

	private void addResidentEvilGame() {

		Game gameResidentEvil = new Game();
		// gameResidentEvil.setId(2l);

		gameResidentEvil.setTagLineDescription("Resident Evil tld");
		gameResidentEvil.setDescription("Horror-Shooter (" + new Date() + ")");
		
		gameResidentEvil.addGameTitle(new GameTitle("Resident Evil"));

		ReleaseGroup releaseGroupPlaystation = new ReleaseGroup("Playstation", SystemKey.SonyPlaystation, ReleaseGroupType.Original);

		releaseGroupPlaystation.addScreenshot(new Screenshot("residentevil/ps1/R_6737_1136470632_PSOGL2_01.jpg", ScreenshotType.unknown, "description not available"));
		releaseGroupPlaystation.addScreenshot(new Screenshot("residentevil/ps1/R_6737_1136470633_PSOGL2_02.jpg", ScreenshotType.unknown, "description not available"));
		releaseGroupPlaystation.addScreenshot(new Screenshot("residentevil/ps1/R_6737_1136470635_PSOGL2_04.jpg", ScreenshotType.unknown, "description not available"));
		releaseGroupPlaystation.addScreenshot(new Screenshot("residentevil/ps1/R_6737_1136470635_PSOGL2_05.jpg", ScreenshotType.unknown, "description not available"));
		releaseGroupPlaystation.addScreenshot(new Screenshot("residentevil/ps1/R_6737_1136470636_PSOGL2_06.jpg", ScreenshotType.unknown, "description not available"));
		releaseGroupPlaystation.addScreenshot(new Screenshot("residentevil/ps1/R_6737_1136470636_PSOGL2_07.jpg", ScreenshotType.unknown, "description not available"));
		releaseGroupPlaystation.addScreenshot(new Screenshot("residentevil/ps1/R_6737_1136470637_PSOGL2_08.jpg", ScreenshotType.unknown, "description not available"));
		releaseGroupPlaystation.addScreenshot(new Screenshot("residentevil/ps1/R_6737_1136470638_PSOGL2_09.jpg", ScreenshotType.unknown, "description not available"));
		releaseGroupPlaystation.addScreenshot(new Screenshot("residentevil/ps1/R_6737_1136470638_PSOGL2_10.jpg", ScreenshotType.unknown, "description not available"));
		releaseGroupPlaystation.addScreenshot(new Screenshot("residentevil/ps1/R_6737_1136470638_PSOGL2_11.jpg", ScreenshotType.unknown, "description not available"));
		releaseGroupPlaystation.addScreenshot(new Screenshot("residentevil/ps1/R_6737_1136470639_PSOGL2_12.jpg", ScreenshotType.unknown, "description not available"));
		releaseGroupPlaystation.addScreenshot(new Screenshot("residentevil/ps1/R_6737_1136470639_PSOGL2_13.jpg", ScreenshotType.unknown, "description not available"));
		releaseGroupPlaystation.addScreenshot(new Screenshot("residentevil/ps1/R_6737_1136470640_PSOGL2_14.jpg", ScreenshotType.unknown, "description not available"));
		releaseGroupPlaystation.addScreenshot(new Screenshot("residentevil/ps1/R_6737_1136470641_PSOGL2_15.jpg", ScreenshotType.unknown, "description not available"));
		releaseGroupPlaystation.addScreenshot(new Screenshot("residentevil/ps1/R_6737_1136470641_PSOGL2_16.jpg", ScreenshotType.unknown, "description not available"));
		releaseGroupPlaystation.addScreenshot(new Screenshot("residentevil/ps1/R_6737_1136470642_PSOGL2_17.jpg", ScreenshotType.unknown, "description not available"));
		releaseGroupPlaystation.addScreenshot(new Screenshot("residentevil/ps1/R_6737_1136470643_PSOGL2_18.jpg", ScreenshotType.unknown, "description not available"));
		releaseGroupPlaystation.addScreenshot(new Screenshot("residentevil/ps1/R_6737_1136470645_PSOGL2_19.jpg", ScreenshotType.unknown, "description not available"));
		releaseGroupPlaystation.addScreenshot(new Screenshot("residentevil/ps1/R_6737_1136470646_PSOGL2_20.jpg", ScreenshotType.unknown, "description not available"));
		releaseGroupPlaystation.addScreenshot(new Screenshot("residentevil/ps1/R_6737_1136470648_PSOGL2_21.jpg", ScreenshotType.unknown, "description not available"));
		releaseGroupPlaystation.addScreenshot(new Screenshot("residentevil/ps1/R_6737_1136470649_PSOGL2_22.jpg", ScreenshotType.unknown, "description not available"));
		releaseGroupPlaystation.addScreenshot(new Screenshot("residentevil/ps1/R_6737_1136470649_PSOGL2_23.jpg", ScreenshotType.unknown, "description not available"));

		Release releasePs1_1 = new Release("Veröffentlichung 1-1 (PSX, CD, DV)", DistributionKey.RegularBox);
		releasePs1_1.addCountryRelease(new CountryRelease(CountryKey.Deutschland, 1986));
		releasePs1_1.addCountryRelease(new CountryRelease(CountryKey.Oesterreich, 1986));
		releaseGroupPlaystation.addRelease(releasePs1_1);

		Release releasePs1_2 = new Release("Veröffentlichung 1-2 (PSX, CD, DV, White Label)", DistributionKey.RegularBox);
		releasePs1_2.addCountryRelease(new CountryRelease(CountryKey.Deutschland, 9999));
		releaseGroupPlaystation.addRelease(releasePs1_2);

		Release releasePs1_3 = new Release("Veröffentlichung 1-3 (PSX, CD, DV, Platinum Edition)", DistributionKey.RegularBox);
		releasePs1_3.addCountryRelease(new CountryRelease(CountryKey.Deutschland, 9999));
		releaseGroupPlaystation.addRelease(releasePs1_3);
		//
		//
		gameResidentEvil.addReleaseGroup(releaseGroupPlaystation);

		ReleaseGroup releaseGroupWindows = new ReleaseGroup("Windows", SystemKey.Windows, ReleaseGroupType.Original);

		releaseGroupWindows.addScreenshot(new Screenshot("residentevil/windows/R_6737_1194880847_ResidentEvil-Screen2800729.jpg", ScreenshotType.unknown, "description not available"));
		releaseGroupWindows.addScreenshot(new Screenshot("residentevil/windows/R_6737_1194880848_ResidentEvil-Screen2800829.jpg", ScreenshotType.unknown, "description not available"));
		releaseGroupWindows.addScreenshot(new Screenshot("residentevil/windows/R_6737_1194880850_ResidentEvil-Screen2801129.jpg", ScreenshotType.unknown, "description not available"));
		releaseGroupWindows.addScreenshot(new Screenshot("residentevil/windows/R_6737_1194880851_ResidentEvil-Screen2801329.jpg", ScreenshotType.unknown, "description not available"));
		releaseGroupWindows.addScreenshot(new Screenshot("residentevil/windows/R_6737_1194880851_ResidentEvil-Screen2801529.jpg", ScreenshotType.unknown, "description not available"));
		releaseGroupWindows.addScreenshot(new Screenshot("residentevil/windows/R_6737_1194880852_ResidentEvil-Screen2801829.jpg", ScreenshotType.unknown, "description not available"));
		releaseGroupWindows.addScreenshot(new Screenshot("residentevil/windows/R_6737_1194880852_ResidentEvil-Screen2802529.jpg", ScreenshotType.unknown, "description not available"));
		releaseGroupWindows.addScreenshot(new Screenshot("residentevil/windows/R_6737_1194880853_ResidentEvil-Screen2802629.jpg", ScreenshotType.unknown, "description not available"));
		releaseGroupWindows.addScreenshot(new Screenshot("residentevil/windows/R_6737_1194880854_ResidentEvil-Screen2803129.jpg", ScreenshotType.unknown, "description not available"));
		releaseGroupWindows.addScreenshot(new Screenshot("residentevil/windows/R_6737_1194880854_ResidentEvil-Screen2803429.jpg", ScreenshotType.unknown, "description not available"));
		releaseGroupWindows.addScreenshot(new Screenshot("residentevil/windows/R_6737_1194880855_ResidentEvil-Screen2803829.jpg", ScreenshotType.unknown, "description not available"));
		releaseGroupWindows.addScreenshot(new Screenshot("residentevil/windows/R_6737_1194880856_ResidentEvil-Screen2804029.jpg", ScreenshotType.unknown, "description not available"));
		releaseGroupWindows.addScreenshot(new Screenshot("residentevil/windows/R_6737_1194880856_ResidentEvil-Screen2804129.jpg", ScreenshotType.unknown, "description not available"));
		releaseGroupWindows.addScreenshot(new Screenshot("residentevil/windows/R_6737_1194880857_ResidentEvil-Screen2804429.jpg", ScreenshotType.unknown, "description not available"));
		releaseGroupWindows.addScreenshot(new Screenshot("residentevil/windows/R_6737_1194880857_ResidentEvil-Screen2805129.jpg", ScreenshotType.unknown, "description not available"));
		releaseGroupWindows.addScreenshot(new Screenshot("residentevil/windows/R_6737_1194880858_ResidentEvil-Screen2805229.jpg", ScreenshotType.unknown, "description not available"));

		gameResidentEvil.addReleaseGroup(releaseGroupWindows);

		gameRepository.save(gameResidentEvil);
	}

	private void addXWingGame() {
		Game gameXWing = new Game();

		gameXWing.setTagLineDescription("X-Wing tld");
		gameXWing.addGameTitle(new GameTitle("Star Wars - X-Wing"));
		gameXWing.addGameTitle(new GameTitle("Star Wars - X-Wing: Space Combat Simulator"));

		ReleaseGroup rgDos = new ReleaseGroup("DOS", SystemKey.MSDOS, ReleaseGroupType.Original);
		gameXWing.addReleaseGroup(rgDos);

		Release rgDos1_1 = new Release("Release 1-1 (PC, 3,5, EV mit dt. Handbuch))", DistributionKey.RegularBox);
		rgDos1_1.addCountryRelease(new CountryRelease(CountryKey.Deutschland, 1993));
		rgDos.addRelease(rgDos1_1);

		Release rgDos1_2 = new Release("Release 1-2 (PC, 3,5, DV)", DistributionKey.RegularBox);
		rgDos1_2.addCountryRelease(new CountryRelease(CountryKey.Deutschland, 1993));
		rgDos.addRelease(rgDos1_2);

		Release rgDos1_3 = new Release("Release 1-3 (PC, 3,5, US)", DistributionKey.RegularBox);
		rgDos1_3.addCountryRelease(new CountryRelease(CountryKey.USA, 1993));
		rgDos.addRelease(rgDos1_3);

		Release rgDos1_4 = new Release("Release 1-4 (PC, 3,5, UK)", DistributionKey.RegularBox);
		rgDos1_4.addCountryRelease(new CountryRelease(CountryKey.UK, 1993));
		rgDos.addRelease(rgDos1_4);

		ReleaseGroup rgDosEnhanced = new ReleaseGroup("DOS", SystemKey.MSDOS, ReleaseGroupType.Enhanced);
		gameXWing.addReleaseGroup(rgDosEnhanced);

		ReleaseGroup rgWinEnhanced = new ReleaseGroup("Windows", SystemKey.Windows, ReleaseGroupType.Enhanced);
		gameXWing.addReleaseGroup(rgWinEnhanced);

		ReleaseGroup rgMacEnhanced = new ReleaseGroup("Apple Macintosh", SystemKey.AppleMacintosh, ReleaseGroupType.Enhanced);
		gameXWing.addReleaseGroup(rgMacEnhanced);

		gameRepository.save(gameXWing);
	}

	private void addUsers() {

		if (userRepository.findOne(1L)!=null) return;
		
		User userAdmin = new User();
		userAdmin.setUsername("admin");
		userAdmin.setEmail("gene@kultpower.de");
		userAdmin.setPasswordAndEncryptIt("admin");
		userAdmin.getRoleList().add(Role.createRole(RoleKey.Admin));
		userAdmin.getRoleList().add(Role.createRole(RoleKey.User));

		User user = new User();
		user.setUsername("user");
		user.setEmail("gene@kultpower.de");
		user.setPasswordAndEncryptIt("user");
		user.getRoleList().add(Role.createRole(RoleKey.User));

		userRepository.save(userAdmin);
		userRepository.save(user);

	}
	
	private void addPlatforms() {
		
		if (platformRepository.findOne(1L)!=null) return;
		
		platformRepository.save(new Platform("Amiga"));
		platformRepository.save(new Platform("Atari ST"));
		platformRepository.save(new Platform("MS-Dos"));
		platformRepository.save(new Platform("Windows"));
		
	}
	
	
	private void addGames() {
		
		if (gameRepository.findOne(1L)!=null) return;
		
		addMonkeyIsland();
		addResidentEvilGame();
		addXWingGame();
		
	}
	
	@Transactional
	public void initData() {
		addUsers();
		addPlatforms();
		addGames();
	}


}
