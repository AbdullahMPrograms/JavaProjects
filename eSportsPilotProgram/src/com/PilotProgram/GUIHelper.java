package com.PilotProgram;

import java.awt.AWTException;
import java.awt.image.BufferedImage;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.image.WritableImage;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

/**
 *
 * @author Abdullah Malik
 * @version 1.0
 * this helps to find the right placement/size of the screenshots for input into the cfg file for each games and their respective resolutions
 */
public class GUIHelper extends Application {

	@Override
	public void start(Stage stage) throws Exception {
		Scanner in = new Scanner(System.in);

		System.out.println("Enter Game Name");
		String gameName = in.nextLine();
		System.out.println("Enter Game Res");
		String gameRes = in.nextLine();

		in.close();
		Game.setGameInfo(gameName, gameRes);

		Config.readConfig();
		Screen.setCaptureRect();

		Font font = new Font("Arial", 24);
		Label title = new Label("Helper Program");
		title.setFont(font);

		VBox vbox = new VBox(20);
		vbox.setAlignment(Pos.CENTER);

		// Vertical Box for Fraction 1
		VBox var1 = new VBox(5);
		TextField num1 = new TextField();
		num1.setPrefColumnCount(4);
		num1.setFont(font);
		num1.setPrefSize(80, 80);

		VBox var2 = new VBox(5);
		TextField num2 = new TextField();
		num2.setPrefColumnCount(4);
		num2.setFont(font);
		num2.setPrefSize(80, 80);

		VBox var3 = new VBox(5);
		TextField num3 = new TextField();
		num3.setPrefColumnCount(4);
		num3.setFont(font);
		num3.setPrefSize(80, 80);

		VBox var4 = new VBox(5);
		TextField num4 = new TextField();
		num4.setPrefColumnCount(4);
		num4.setFont(font);
		num4.setPrefSize(80, 80);

		var1.getChildren().add(num1);
		var2.getChildren().add(num2);
		var3.getChildren().add(num3);
		var4.getChildren().add(num4);

		// Place both Vboxes in Hbox for display
		HBox inFraction = new HBox(20);
		inFraction.getChildren().addAll(var1, var2, var3, var4);
		inFraction.setAlignment(Pos.CENTER);

		Label msg = new Label();
		msg.setFont(font);

		// Create and display Buttons to trigger actions
		HBox buttons = new HBox(10);
		Button btnU = new Button("Update");
		btnU.setFont(font);
		buttons.setAlignment(Pos.CENTER);
		buttons.getChildren().addAll(btnU);

		Timer timer = new Timer();

		timer.scheduleAtFixedRate(new TimerTask() {
			@Override
			public void run() {
				Platform.runLater(() -> {
					BufferedImage b = Screen.getBufferedImage();
					WritableImage i = SwingFXUtils.toFXImage(b, null);

					ImageView v = new ImageView(i);
					vbox.getChildren().set(0, v);
					;
				});
			}
		}, 0, 1000);

		// button to update
		btnU.setOnAction(e -> {
			int xVar = Integer.valueOf(num1.getText());
			int yVar = Integer.valueOf(num2.getText());
			int length = Integer.valueOf(num3.getText());
			int width = Integer.valueOf(num4.getText());

			Screen.setCaptureRectGUI(xVar, yVar, length, width);
		});

		vbox.getChildren().add(title);
		vbox.getChildren().add(inFraction);
		vbox.getChildren().add(buttons);
		vbox.getChildren().add(msg);

		Scene scene = new Scene(vbox, 400, 400);
		vbox.setStyle("-fx-background-color: #000000;");
		/*
		 * timer.schedule(new TimerTask() {
		 * 
		 * @Override public void run() { try { if (Game.damageTaken()) {
		 * vbox.setStyle("-fx-background-color: #FF0000;"); } else {
		 * vbox.setStyle("-fx-background-color: #000000;"); } } catch (Exception e) {
		 * e.printStackTrace(); } } }, 0, 1 * 500); // x * 1000 = seconds
		 */
		stage.setScene(scene);
		stage.setTitle("Culminating Helper");
		stage.show();

	}
/**
 * runs GUIHelper
 * @param args
 * @throws AWTException
 */
	public static void main(String[] args) throws AWTException {
		launch(args);

	}

}
