package com.PilotProgram;

import com.phidget22.RCServo;

public class Servo {

	public static void main(String[] args) throws Exception {
		RCServo rcServo0 = new RCServo();
		rcServo0.setDeviceSerialNumber(622280);
		rcServo0.setChannel(0);
		rcServo0.open(5000);

		rcServo0.setTargetPosition(45);
		rcServo0.setEngaged(true);
		Thread.sleep(200);
		rcServo0.setEngaged(false);

		rcServo0.setTargetPosition(0);
		rcServo0.setEngaged(true);
		Thread.sleep(200);
		rcServo0.setEngaged(false);

		rcServo0.close();

	}

	public static void activateServo() throws Exception {
		RCServo rcServo0 = new RCServo();
		rcServo0.setDeviceSerialNumber(622280);
		rcServo0.setChannel(0);
		rcServo0.open(5000);

		rcServo0.setTargetPosition(45);
		rcServo0.setEngaged(true);
		Thread.sleep(200);
		rcServo0.setEngaged(false);

		rcServo0.setTargetPosition(0);
		rcServo0.setEngaged(true);
		Thread.sleep(200);
		rcServo0.setEngaged(false);

		rcServo0.close();
	}

	public static void setServo() throws Exception {
		RCServo rcServo0 = new RCServo();
		rcServo0.setDeviceSerialNumber(622280);
		rcServo0.setChannel(0);
		rcServo0.open(5000);

		rcServo0.setTargetPosition(0);
		rcServo0.setEngaged(true);
		Thread.sleep(200);
		rcServo0.setEngaged(false);

		rcServo0.close();

	}

}
