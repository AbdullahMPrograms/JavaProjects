package com.PilotProgram;

import com.phidget22.Hub;
import com.phidget22.Phidget;
import com.phidget22.PhidgetException;
/**
 * class for things concerning haptics
 * @author Oliver Dickins and Abdullah Malik
 *
 */
public class Haptics {
	static int errorCount = 0;
/**
 * this method activates the haptic device that is attached to users arm
 * @throws Exception
 */
	public static void activateHaptics() throws Exception {
		try {
			Hub ch = new Hub();
			ch.open(Phidget.DEFAULT_TIMEOUT);

			ch.setPortPower(3, true);

			Thread.sleep(300);

			ch.setPortPower(3, false);

			ch.close();
		} catch (PhidgetException ex) {
			errorCount++;
			System.out.println("Error: " + ex);
		}
	}
	/**
	 * returns the amount of errors
	 * @return
	 */
	public static int getErrorCount() {
		return errorCount;

	}

}
