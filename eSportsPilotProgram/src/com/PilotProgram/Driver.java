package com.PilotProgram;

import java.util.Scanner;
/**
 * 
 * @author Oliver Dickins and Abdullah Malik
 *Driver used to input game name and resolution through console, not used anymore
 */
public class Driver {
/**
 * main to gain input from user
 * @param args
 * @throws Exception
 */
	public static void main(String[] args) throws Exception {
		Boolean loop = false;

		Scanner in = new Scanner(System.in);

		System.out.println("Enter Game Name");
		String gameName = in.nextLine();
		System.out.println("Enter Game Res");
		String gameRes = in.nextLine();

		in.close();
		Game.setGameInfo(gameName, gameRes);

		Config.readConfig();
		Screen.setCaptureRect();

		while (!loop) {
			if (Game.damageTaken()) {
				System.out.println("Damage Taken");
				Haptics.activateHaptics();
			} else {
				System.out.println("Damage not Taken");
			}

		}

	}
}
