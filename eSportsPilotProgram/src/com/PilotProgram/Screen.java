package com.PilotProgram;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.IOException;
/**
 * 
 * @author Oliver Dickins and Abdullah Malik
 * consists of all methods that have to use the screenshots
 *
 */
public class Screen {
	static BufferedImage screenFullImage = null;

	private static Rectangle captureRect = new Rectangle(0, 0, 0, 0);
	/**
	 * returns the dimensions/location to take the screenshot
	 * @return
	 */
	public static Rectangle getCaptureRect() {
		return captureRect;
	}
	/**
	 * sets the dimensions/location to take the screenshot
	 */
	public static void setCaptureRect() {
		captureRect = new Rectangle(Config.getX(), Config.getY(), Config.getLength(), Config.getWidth());
	}
	/**
	 * another methods to set the dimensions/location
	 * @param x
	 * @param y
	 * @param length
	 * @param width
	 */
	public static void setCaptureRectGUI(int x, int y, int length, int width) {
		captureRect = new Rectangle(x, y, length, width);
	}
	/**
	 * takes the screenshot
	 * @return
	 */
	public static BufferedImage getBufferedImage() {
		Robot robot = null;
		try {
			robot = new Robot();
		} catch (AWTException e) {
			e.printStackTrace();
		}

		BufferedImage screenFullImage = robot.createScreenCapture(getCaptureRect());
		return screenFullImage;
	}
	/**
	 * counts the amount of healthbar pixels in apex across a horizontal line 1 pixel tall
	 * @return
	 */
	public static int countHealthApex() {
		screenFullImage = getBufferedImage();
		int countHealth = 0;

		for (int j = 0; j < (screenFullImage.getWidth()); j++) {
			int c = screenFullImage.getRGB(j, 1);

			int red = (c & 0xff0000) >> 16;
			int green = (c & 0xff00) >> 8;
			int blue = c & 0xff;

			// System.out.println("x: " + j + " Red: " + red + " Green: " + green + " Blue:
			// " + blue);

			if (red >= Config.getR() && green >= Config.getG() && blue >= Config.getB()) {
				countHealth++;
			}

		}

		return countHealth;
	}
/**
 * counts the amount of healthbar pixels in apex on a vertical line 1 pixel wide
 * @return
 */
	public static int countHealthApexY() {
		screenFullImage = Screen.getBufferedImage();
		int countHealthY = 0;

		for (int k = 0; k < (screenFullImage.getHeight()); k++) {
			int c = screenFullImage.getRGB(1, k);

			int blue = c & 0xff;
			int green = (c & 0xff00) >> 8;
			int red = (c & 0xff0000) >> 16;

			if (red >= Config.getR() && green >= Config.getG() && blue >= Config.getB()) {
				countHealthY++;
			}
		}

		return countHealthY;

	}
	/**
	 * counts healthbar pixels in Destiny 2
	 * @return
	 */
	public static int countHealthD2() {
		screenFullImage = getBufferedImage();
		int countHealth = 0;

		for (int j = 0; j < (screenFullImage.getWidth()); j++) {
			int c = screenFullImage.getRGB(j, 1);

			int red = (c & 0xff0000) >> 16;
			int green = (c & 0xff00) >> 8;
			int blue = c & 0xff;

			if (red >= Config.getR() && green >= Config.getG() && blue >= Config.getB()) {
				countHealth++;
			}

		}

		return countHealth;
	}
	/**
	 * counts healthbar pixels in Valheim
	 * @return
	 */
	public static int countHealthValhiem() {
		screenFullImage = getBufferedImage();
		int countHealth = 0;

		for (int j = 0; j < (screenFullImage.getHeight()); j++) {
			int c = screenFullImage.getRGB(1, j);

			int red = (c & 0xff0000) >> 16;
			int green = (c & 0xff00) >> 8;
			int blue = c & 0xff;

			// System.out.println("x: " + j + " Red: " + red + " Green: " + green + " Blue:
			// " + blue);

			if (red >= Config.getR() && green <= Config.getG() && blue <= Config.getB()) {
				countHealth++;
			}

		}

		return countHealth;
	}
	/**
	 * counts healthbar pixels in Fortnite
	 * @return
	 */
	public static int countHealthFortnite() throws Exception {
		screenFullImage = getBufferedImage();
		int countHealth = 0;

		for (int j = 0; j < (screenFullImage.getWidth()); j++) {
			int c = screenFullImage.getRGB(j, 1);

			int red = (c & 0xff0000) >> 16;
			int green = (c & 0xff00) >> 8;
			int blue = c & 0xff;

			if (red <= Config.getR() && green >= Config.getG() && blue <= Config.getB()) {
				countHealth++;
			}

		}

		return countHealth;
	}
/**
 * counts the score in FIFA with OCR (so horrible to make so many errors)
 * @param i
 * @return
 * @throws IOException
 */
	public static int countScoreFifa(int i) throws IOException {
		screenFullImage = getBufferedImage();
		int countGoals = 0;

		String doneOCR = OCR.getOCR(screenFullImage);
		//System.out.println(doneOCR);
		char temp = '0';
		if (doneOCR != null) {
			temp = doneOCR.charAt(0);
			doneOCR = String.valueOf(temp);

			if (doneOCR.equals("D")) {
				countGoals = 0;

			} else if (doneOCR.equals("0") || doneOCR.equals("1") || doneOCR.equals("2") || doneOCR.equals("3")
					|| doneOCR.equals("4") || doneOCR.equals("5") || doneOCR.equals("6") || doneOCR.equals("7")
					|| doneOCR.equals("8") || doneOCR.equals("9")) {
				countGoals = Integer.valueOf(doneOCR);

			} else {
				countGoals = i;
			}

		} else {
			countGoals = 1000;
		}
		return countGoals;
	}
/**
 * boolean to check if the "scoreboard" is open in FIFA
 * @return
 */
	public static boolean isBarOpenFifa() {
		screenFullImage = Screen.getBufferedImage();
		int barCounter = 0;
		int textCounter = 0;

		for (int k = 0; k < (screenFullImage.getHeight()); k++) {
			int c = screenFullImage.getRGB(13, k);

			int blue = c & 0xff;
			int green = (c & 0xff00) >> 8;
			int red = (c & 0xff0000) >> 16;

			if (red >= Config.getR() && green <= Config.getG() && blue <= Config.getB()) {
				barCounter++;
			}
			if (red <= 70 && green <= 40 && blue <= 40) {
				textCounter++;
			}

		}
		
		if (barCounter >= 13 && textCounter != 0) {
			return true;
		}
		return false;

	}
/**
 * counts the healthbar pixels in minecraft
 * @return
 */
	public static int countHealthMinecraft() {
		screenFullImage = getBufferedImage();
		int countHealth = 0;

		for (int j = 0; j < (screenFullImage.getWidth()); j++) {
			for (int k = 0; k < (screenFullImage.getHeight()); k++) {
				int c = screenFullImage.getRGB(j, k);

				int red = (c & 0xff0000) >> 16;
				int green = (c & 0xff00) >> 8;
				int blue = c & 0xff;
				// System.out.println(red + " " + green + " " + blue);
				if (red >= Config.getR() && green <= Config.getG() && blue <= Config.getB()) {
					countHealth++;
				}

			}
		}

		return countHealth;
	}

}
