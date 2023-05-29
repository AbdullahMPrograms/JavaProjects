package com.PilotProgram;

import java.io.FileInputStream;

import javafx.application.Application;
import javafx.concurrent.Task;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
/**
 * This guiDriver is the main controller of the program, used to select games, along with their resolution, and start each games damage detection. 
 * also includes settings to test haptics ,and exit button
 * @author Oliver Dickins and Abdullah Malik
 *
 */
public class GUIDriver extends Application {
	static Boolean done = false;

	@Override
	public void start(Stage stage) throws Exception {

		Font titleFont = new Font("System Bold", 48);
		// <----------- GENERAL VBOX ------------->

		VBox vbox = new VBox(30);
		vbox.setAlignment(Pos.CENTER);

		// <----------- /GENERAL VBOX ------------->

		// <----------- MENUBAR ------------->
		VBox menu = new VBox(10);

		Image imgUser = new Image(new FileInputStream("images\\user.png"));
		ImageView imgViewUser = new ImageView(imgUser);
		// creating buttons

		Button btnSettings = new Button(null);
		btnSettings.setStyle("-fx-background-color : #05071f;");
		Image imgSettings = new Image(new FileInputStream("images\\settings.png"));
		ImageView imgViewSettings = new ImageView(imgSettings);
		btnSettings.setGraphic(imgViewSettings);

		Button btnExit = new Button(null);
		btnExit.setStyle("-fx-background-color : #05071f;");
		Image imgExit = new Image(new FileInputStream("images\\exit.png"));
		ImageView imgViewExit = new ImageView(imgExit);
		btnExit.setGraphic(imgViewExit);

		// add items
		menu.getChildren().addAll(imgViewUser, btnSettings, btnExit);

		menu.setStyle("-fx-background-color : #05071f;");

		// <----------- /MENUBAR ------------->

		// <----------- BUTTONS ------------->
		VBox buttons = new VBox(75);

		// add hboxes for upper and lower row of buttons
		HBox buttonsHigh = new HBox(10);
		HBox buttonsLow = new HBox(10);

		// input for three upper buttons
		Button btnApex = new Button(null);
		Image imgApex = new Image(new FileInputStream("coverart\\Apex_legends_cover.jpg"));
		ImageView imgViewApex = new ImageView(imgApex);
		btnApex.setGraphic(imgViewApex);

		Button btnD2 = new Button(null);
		Image imgD2 = new Image(new FileInputStream("coverart\\Destiny_2_artwork.jpg"));
		ImageView imgViewD2 = new ImageView(imgD2);
		btnD2.setGraphic(imgViewD2);

		Button btnFN = new Button(null);
		Image imgFN = new Image(new FileInputStream("coverart\\FortniteCover.jpg"));
		ImageView imgViewFN = new ImageView(imgFN);
		btnFN.setGraphic(imgViewFN);

		// input for three lower buttons
		Button btnMC = new Button(null);
		Image imgMC = new Image(new FileInputStream("coverart\\Minecraft_cover.png"));
		ImageView imgViewMC = new ImageView(imgMC);
		btnMC.setGraphic(imgViewMC);

		Button btnVal = new Button(null);
		Image imgVal = new Image(new FileInputStream("coverart\\valheimcover.jpg"));
		ImageView imgViewVal = new ImageView(imgVal);
		btnVal.setGraphic(imgViewVal);

		Button btnFIF = new Button(null);
		Image imgFIF = new Image(new FileInputStream("coverart\\FIFAcover.jpg"));
		ImageView imgViewFIF = new ImageView(imgFIF);
		btnFIF.setGraphic(imgViewFIF);

		// align hboxes and give them the button values
		buttonsHigh.setAlignment(Pos.CENTER);
		buttonsHigh.getChildren().addAll(btnApex, btnD2, btnFN);
		buttonsLow.setAlignment(Pos.CENTER);
		buttonsLow.getChildren().addAll(btnMC, btnVal, btnFIF);

		buttons.setStyle("-fx-background-color : #ffffff;");

		// <----------- /BUTTONS ------------->

		// add hboxes to the main vbox
		buttons.getChildren().addAll(buttonsHigh, buttonsLow);
		buttons.setPadding(new Insets(50, 50, 50, 50));
		HBox hbox = new HBox(menu, buttons);

		vbox.getChildren().addAll(hbox);
		// set scene for home/game selection

		Scene sceneMain = new Scene(vbox, 1240, 890);

		stage.setScene(sceneMain);
		stage.setTitle("eSports Pilot Program");
		stage.setResizable(false);

		stage.show();

		// this code below is for scenes after "game buttons" are pressed

		// master vbox when apex is selected apex apex apex apex apex apex apex apex
		// apex apex apex apex apex apex apex apex apexapex apex apex apex apex

		// <----------- SETTINGS ------------->
		VBox vboxSettings = new VBox(20);
		Label titleSettings = new Label("Settings");
		titleSettings.setFont(titleFont);

		// Font to use for all textfields
		Font txtFont = new Font("System Bold", 32);

		// Hbox for text fields for input check
		HBox txtHaptics = new HBox(20);

		Label hapticFeedSettings = new Label();
		// TextField hapticFeedApex = new TextField();
		hapticFeedSettings.setFont(txtFont);
		hapticFeedSettings.setMinSize(300, 100);
		hapticFeedSettings.setText("HAPTIC FEED");
		hapticFeedSettings.setAlignment(Pos.CENTER);
		hapticFeedSettings.setDisable(true);

		// Input txt field values into hbox
		txtHaptics.getChildren().addAll(hapticFeedSettings);
		txtHaptics.setAlignment(Pos.CENTER);

		// Font to use in all buttons on each scene
		Font buttonFont = new Font("Animo", 24);

		// horizontal for the two buttons
		HBox buttonsSettings = new HBox(20);

		// inputs values for the buttons
		buttonsSettings.setAlignment(Pos.BOTTOM_CENTER);
		Button backBtnSettings = new Button("BACK");
		backBtnSettings.setFont(buttonFont);
		backBtnSettings.setMinSize(200, 80);

		Button hapticsBtnSettings = new Button("TEST HAPTICS");
		hapticsBtnSettings.setMinSize(200, 80);
		hapticsBtnSettings.setFont(buttonFont);

		// adds button values to hbox
		buttonsSettings.getChildren().addAll(backBtnSettings, hapticsBtnSettings);

		// adds all hboxes etc. to master vbox
		vboxSettings.setAlignment(Pos.TOP_CENTER);
		vboxSettings.getChildren().add(titleSettings);
		vboxSettings.getChildren().add(txtHaptics);
		vboxSettings.getChildren().add(buttonsSettings);

		// <----------- /SETTINGS ------------->

		VBox vboxApex = new VBox(20);
		Label titleApex = new Label("Apex Legends");
		titleApex.setFont(titleFont);

		// resolution dropdown menu
		ComboBox<String> resListApex = new ComboBox<>();
		resListApex.getItems().addAll("1920x1080", "1920x1200", "1920x1440", "2560x1440");
		resListApex.setPromptText("Select A Resolution");

		// Hbox for text fields for input check
		HBox txtApex = new HBox(20);

		// input txt field size and values etc.
		// Label hapticFeedApex = new Label();
		TextField hapticFeedApex = new TextField();
		hapticFeedApex.setFont(txtFont);
		hapticFeedApex.setMinSize(300, 100);
		hapticFeedApex.setText("HAPTIC FEED");
		hapticFeedApex.setAlignment(Pos.CENTER);
		hapticFeedApex.setDisable(true);

		// Label damageFeedApex = new Label();
		TextField damageFeedApex = new TextField();
		damageFeedApex.setFont(txtFont);
		damageFeedApex.setMinSize(300, 100);
		damageFeedApex.setText("DAMAGE FEED");
		damageFeedApex.setAlignment(Pos.CENTER);
		damageFeedApex.setDisable(true);

		// Input txt field values into hbox
		txtApex.getChildren().addAll(hapticFeedApex, damageFeedApex);
		txtApex.setAlignment(Pos.CENTER);

		// horizontal for the two buttons
		HBox buttonsApex = new HBox(20);

		// inputs values for the buttons
		buttonsApex.setAlignment(Pos.BOTTOM_CENTER);
		Button backBtnApex = new Button("BACK");
		backBtnApex.setFont(buttonFont);
		backBtnApex.setMinSize(200, 80);

		Button startBtnApex = new Button("START");
		startBtnApex.setMinSize(200, 80);
		startBtnApex.setFont(buttonFont);

		// adds button values to hbox
		buttonsApex.getChildren().addAll(backBtnApex, startBtnApex);

		// adds all hboxes etc. to master vbox
		vboxApex.setAlignment(Pos.TOP_CENTER);
		vboxApex.getChildren().add(titleApex);
		vboxApex.getChildren().add(resListApex);
		vboxApex.getChildren().add(txtApex);
		vboxApex.getChildren().add(buttonsApex);

		// add master vbox for D2 screen DESTINY 2 DESTINY 2 DESTINY 2 DESTINY 2 DESTINY
		// 2 DESTINY 2 DESTINY 2 DESTINY 2 DESTINY 2 DESTINY 2 DESTINY 2 DESTINY 2
		// DESTINY 2 DESTINY 2
		VBox vboxD2 = new VBox(20);
		Label titleD2 = new Label("Destiny 2");
		titleD2.setFont(titleFont);

		// resolution dropdown menu
		ComboBox<String> resListD2 = new ComboBox<>();
		resListD2.getItems().addAll("1920x1080", "2560x1440");
		resListD2.setPromptText("Select A Resolution");

		// Hbox for text fields for input check
		HBox txtD2 = new HBox(20);

		// input txt field size and values etc.
		Label hapticFeedD2 = new Label();
		hapticFeedD2.setFont(txtFont);
		hapticFeedD2.setMinSize(300, 100);
		hapticFeedD2.setText("HAPTIC FEED");
		hapticFeedD2.setAlignment(Pos.CENTER);
		hapticFeedD2.setDisable(true);

		Label damageFeedD2 = new Label();
		damageFeedD2.setFont(txtFont);
		damageFeedD2.setMinSize(300, 100);
		damageFeedD2.setText("DAMAGE FEED");
		damageFeedD2.setAlignment(Pos.CENTER);
		damageFeedD2.setDisable(true);

		// Input txt field values into hbox
		txtD2.getChildren().addAll(hapticFeedD2, damageFeedD2);
		txtD2.setAlignment(Pos.CENTER);

		// horizontal for the two buttons
		HBox buttonsD2 = new HBox(20);

		// inputs values for the buttons
		buttonsD2.setAlignment(Pos.BOTTOM_CENTER);
		Button backBtnD2 = new Button("BACK");
		backBtnD2.setFont(buttonFont);
		backBtnD2.setMinSize(200, 80);

		Button startBtnD2 = new Button("START");
		startBtnD2.setMinSize(200, 80);
		startBtnD2.setFont(buttonFont);

		// adds button values to hbox
		buttonsD2.getChildren().addAll(backBtnD2, startBtnD2);

		// adds all hboxes etc. to master vbox
		vboxD2.setAlignment(Pos.TOP_CENTER);
		vboxD2.getChildren().add(titleD2);
		vboxD2.getChildren().add(resListD2);
		vboxD2.getChildren().add(txtD2);
		vboxD2.getChildren().add(buttonsD2);

		// screen when Fornite is selected FORTINTE FORNITE FORTINTE FORNITE FORTINTE
		// FORNITE FORTINTE FORNITE FORTINTE FORNITE FORTINTE FORNITE
		VBox vboxFN = new VBox(20);
		Label titleFN = new Label("Fortnite");
		titleFN.setFont(titleFont);

		// resolution dropdown menu
		ComboBox<String> resListFN = new ComboBox<>();
		resListFN.getItems().addAll("1920x1080", "2560x1440");
		resListFN.setPromptText("Select A Resolution");

		// Hbox for text fields for input check
		HBox txtFN = new HBox(20);

		// input txt field size and values etc.
		TextField hapticFeedFN = new TextField();
		hapticFeedFN.setFont(txtFont);
		hapticFeedFN.setMinSize(300, 100);
		hapticFeedFN.setText("HAPTIC FEED");
		hapticFeedFN.setAlignment(Pos.CENTER);
		hapticFeedFN.setDisable(true);

		TextField damageFeedFN = new TextField();
		damageFeedFN.setFont(txtFont);
		damageFeedFN.setMinSize(300, 100);
		damageFeedFN.setText("DAMAGE FEED");
		damageFeedFN.setAlignment(Pos.CENTER);
		damageFeedFN.setDisable(true);

		// Input txt field values into hbox
		txtFN.getChildren().addAll(hapticFeedFN, damageFeedFN);
		txtFN.setAlignment(Pos.CENTER);

		// horizontal for the two buttons
		HBox buttonsFN = new HBox(20);

		// inputs values for the buttons
		buttonsFN.setAlignment(Pos.BOTTOM_CENTER);
		Button backBtnFN = new Button("BACK");
		backBtnFN.setFont(buttonFont);
		backBtnFN.setMinSize(200, 80);

		Button startBtnFN = new Button("START");
		startBtnFN.setMinSize(200, 80);
		startBtnFN.setFont(buttonFont);

		// adds button values to hbox
		buttonsFN.getChildren().addAll(backBtnFN, startBtnFN);

		// adds all hboxes etc. to master vbox
		vboxFN.setAlignment(Pos.TOP_CENTER);
		vboxFN.getChildren().add(titleFN);
		vboxFN.getChildren().add(resListFN);
		vboxFN.getChildren().add(txtFN);
		vboxFN.getChildren().add(buttonsFN);

		// vbox for minecraft screen minecraft minecraft minecraft minecraft minecraft
		// minecraft minecraft minecraft minecraft minecraft minecraft minecraft
		// minecraft
		VBox vboxMC = new VBox(20);
		Label titleMC = new Label("Minecraft");
		titleMC.setFont(titleFont);

		// resolution dropdown menu
		ComboBox<String> resListMC = new ComboBox<>();
		resListMC.getItems().addAll("1920x1080", "2560x1440");
		resListMC.setPromptText("Select A Resolution");

		// Hbox for text fields for input check
		HBox txtMC = new HBox(20);

		// input txt field size and values etc.
		Label hapticFeedMC = new Label();
		hapticFeedMC.setFont(txtFont);
		hapticFeedMC.setMinSize(300, 100);
		hapticFeedMC.setText("HAPTIC FEED");
		hapticFeedMC.setAlignment(Pos.CENTER);
		hapticFeedMC.setDisable(true);

		Label damageFeedMC = new Label();
		damageFeedMC.setFont(txtFont);
		damageFeedMC.setMinSize(300, 100);
		damageFeedMC.setText("DAMAGE FEED");
		damageFeedMC.setAlignment(Pos.CENTER);
		damageFeedMC.setDisable(true);

		// Input txt field values into hbox
		txtMC.getChildren().addAll(hapticFeedMC, damageFeedMC);
		txtMC.setAlignment(Pos.CENTER);

		// horizontal for the two buttons
		HBox buttonsMC = new HBox(20);

		// inputs values for the buttons
		buttonsMC.setAlignment(Pos.BOTTOM_CENTER);
		Button backBtnMC = new Button("BACK");
		backBtnMC.setFont(buttonFont);
		backBtnMC.setMinSize(200, 80);

		Button startBtnMC = new Button("START");
		startBtnMC.setMinSize(200, 80);
		startBtnMC.setFont(buttonFont);

		// adds button values to hbox
		buttonsMC.getChildren().addAll(backBtnMC, startBtnMC);

		// adds all hboxes etc. to master vbox
		vboxMC.setAlignment(Pos.TOP_CENTER);
		vboxMC.getChildren().add(titleMC);
		vboxMC.getChildren().add(resListMC);
		vboxMC.getChildren().add(txtMC);
		vboxMC.getChildren().add(buttonsMC);

		// master vbox for Valheim Valheim Valheim Valheim Valheim Valheim Valheim
		// Valheim Valheim Valheim Valheim Valheim Valheim Valheim Valheim Valheim
		// Valheim Valheim
		VBox vboxVal = new VBox(20);
		Label titleVal = new Label("Valhiem");
		titleVal.setFont(titleFont);

		// resolution dropdown menu
		ComboBox<String> resListVal = new ComboBox<>();
		resListVal.getItems().addAll("1920x1080", "2560x1440");
		resListVal.setPromptText("Select A Resolution");

		// Hbox for text fields for input check
		HBox txtVal = new HBox(20);

		// input txt field size and values etc.
		Label hapticFeedVal = new Label();
		hapticFeedVal.setFont(txtFont);
		hapticFeedVal.setMinSize(300, 100);
		hapticFeedVal.setText("HAPTIC FEED");
		hapticFeedVal.setAlignment(Pos.CENTER);
		hapticFeedVal.setDisable(true);

		Label damageFeedVal = new Label();
		damageFeedVal.setFont(txtFont);
		damageFeedVal.setMinSize(300, 100);
		damageFeedVal.setText("DAMAGE FEED");
		damageFeedVal.setAlignment(Pos.CENTER);
		damageFeedVal.setDisable(true);

		// Input txt field values into hbox
		txtVal.getChildren().addAll(hapticFeedVal, damageFeedVal);
		txtVal.setAlignment(Pos.CENTER);

		// horizontal for the two buttons
		HBox buttonsVal = new HBox(20);

		// inputs values for the buttons
		buttonsVal.setAlignment(Pos.BOTTOM_CENTER);
		Button backBtnVal = new Button("BACK");
		backBtnVal.setFont(buttonFont);
		backBtnVal.setMinSize(200, 80);

		Button startBtnVal = new Button("START");
		startBtnVal.setMinSize(200, 80);
		startBtnVal.setFont(buttonFont);

		// adds button values to hbox
		buttonsVal.getChildren().addAll(backBtnVal, startBtnVal);

		// adds all hboxes etc. to master vbox
		vboxVal.setAlignment(Pos.TOP_CENTER);
		vboxVal.getChildren().add(titleVal);
		vboxVal.getChildren().add(resListVal);
		vboxVal.getChildren().add(txtVal);
		vboxVal.getChildren().add(buttonsVal);

		// master vbox for FIFA FIFA FIFA FIFA FIFA FIFA FIFA FIFA FIFA FIFA FIFA FIFA
		// FIFA FIFA FIFA FIFA FIFA FIFA FIFA FIFA FIFA FIFA FIFA FIFA FIFA FIFA
		VBox vboxFIF = new VBox(20);
		Label titleFIF = new Label("FIFA");
		titleFIF.setFont(titleFont);

		// resolution dropdown menu
		ComboBox<String> resListFIF = new ComboBox<>();
		resListFIF.getItems().addAll("1920x1080", "2560x1440");
		resListFIF.setPromptText("Select A Resolution");

		// Hbox for text fields for input check
		HBox txtFIF = new HBox(20);

		// input txt field size and values etc.
		TextField hapticFeedFIF = new TextField();
		hapticFeedFIF.setFont(txtFont);
		hapticFeedFIF.setMinSize(300, 100);
		hapticFeedFIF.setText("HAPTIC FEED");
		hapticFeedFIF.setAlignment(Pos.CENTER);
		hapticFeedFIF.setDisable(true);

		TextField damageFeedFIF = new TextField();
		damageFeedFIF.setFont(txtFont);
		damageFeedFIF.setMinSize(300, 100);
		damageFeedFIF.setText("GOAL FEED");
		damageFeedFIF.setAlignment(Pos.CENTER);
		damageFeedFIF.setDisable(true);

		// Input txt field values into hbox
		txtFIF.getChildren().addAll(hapticFeedFIF, damageFeedFIF);
		txtFIF.setAlignment(Pos.CENTER);

		// horizontal for the two buttons
		HBox buttonsFIF = new HBox(20);

		// inputs values for the buttons
		buttonsFIF.setAlignment(Pos.BOTTOM_CENTER);
		Button backBtnFIF = new Button("BACK");
		backBtnFIF.setFont(buttonFont);
		backBtnFIF.setMinSize(200, 80);

		Button startBtnFIF = new Button("START");
		startBtnFIF.setMinSize(200, 80);
		startBtnFIF.setFont(buttonFont);

		// adds button values to hbox
		buttonsFIF.getChildren().addAll(backBtnFIF, startBtnFIF);

		// adds all hboxes etc. to master vbox
		vboxFIF.setAlignment(Pos.TOP_CENTER);
		vboxFIF.getChildren().add(titleFIF);
		vboxFIF.getChildren().add(resListFIF);
		vboxFIF.getChildren().add(txtFIF);
		vboxFIF.getChildren().add(buttonsFIF);

		// seperate scenes for each game selection
		Scene sceneSettings = new Scene(vboxSettings, 1240, 890);
		Scene sceneApex = new Scene(vboxApex, 1240, 890);
		Scene sceneD2 = new Scene(vboxD2, 1240, 890);
		Scene sceneFN = new Scene(vboxFN, 1240, 890);
		Scene sceneMC = new Scene(vboxMC, 1240, 890);
		Scene sceneVal = new Scene(vboxVal, 1240, 890);
		Scene sceneFIF = new Scene(vboxFIF, 1240, 890);

		// <----------- BUTTON ACTIONS ------------->
		btnSettings.setOnAction(e -> {
			try {
				stage.setScene(sceneSettings);
				stage.setTitle("Settings");
				hapticFeedSettings.setText("HAPTIC FEED");
				stage.show();
			} catch (Exception f) {
				System.out.println("An error has occured");
				System.out.println(f.getMessage());
			}
		});

		// button to go back to main
		hapticsBtnSettings.setOnAction(e -> {
			try {
				Haptics.activateHaptics();
				if (Haptics.getErrorCount() > 0) {
					hapticFeedSettings.setText("Not Connected");
				} else {
					hapticFeedSettings.setText("Connected");
				}
			} catch (Exception f) {
				System.out.println("An error has occured");
				System.out.println(f.getMessage());
			}
		});
		// button to go back to main
		backBtnSettings.setOnAction(e -> {
			try {
				stage.setScene(sceneMain);
				stage.setTitle("eSports Pilot Program");
				stage.show();
			} catch (Exception f) {
				System.out.println("An error has occured");
				System.out.println(f.getMessage());
			}
		});

		btnExit.setOnAction(e -> {
			System.exit(0);
		});

		// <----------- APEX ------------->
		// mouse hover effects for game selection
		btnApex.setOnMouseEntered(event -> {
			btnApex.setStyle("-fx-background-color : #0A0E3F; -fx-text-fill: white; -fx-font-size: 28px;");
			imgViewApex.setOpacity(0.5);
			btnApex.setText("Apex Legends");
			btnApex.setContentDisplay(ContentDisplay.CENTER);
		});
		btnApex.setOnMouseExited(event -> {
			btnApex.setStyle("-fx-background-color : #ffffff");
			imgViewApex.setOpacity(1);
			btnApex.setText("");
		});
		// button to open apex screen
		btnApex.setOnAction(e -> {
			try {
				stage.setScene(sceneApex);
				stage.setTitle("Apex Legends");
				stage.show();
			} catch (Exception f) {
				System.out.println("An error has occured");
				System.out.println(f.getMessage());
			}
		});
		// button to go back to main
		backBtnApex.setOnAction(e -> {
			try {
				stage.setScene(sceneMain);
				stage.setTitle("eSports Pilot Program");
				stage.show();
				done = true;
			} catch (Exception f) {
				System.out.println("An error has occured");
				System.out.println(f.getMessage());
			}
		});
		// button to start damage detection
		startBtnApex.setOnAction(e -> {
			try {
				Game.setGameInfo("Apex", resListApex.getValue());
				Config.readConfig();
				Screen.setCaptureRect();
				done = false;

				Task<Void> task = new Task<Void>() {
					@Override
					public Void call() throws Exception {

						while (!done) {
							if (isCancelled()) {
								break;
							}

							if (Game.damageTaken()) {
								damageFeedApex.setText("Damage Taken");
								System.out.println("Damage Taken");
								Haptics.activateHaptics();
								if (Haptics.getErrorCount() > 0) {
									hapticFeedSettings.setText("Not Connected");
								} else {
									hapticFeedApex.setText("Haptic Enabled");
								}
								Thread.sleep(150);
							} else {

								if (Haptics.getErrorCount() > 0) {
									hapticFeedApex.setText("Haptic Disabled");
								} else {
									damageFeedApex.setText("Damage Not Taken");
									hapticFeedApex.setText("Haptic Disabled");
								}
								System.out.println("Damage Not Taken");

							}

						}
						return null;
					}
				};
				new Thread(task).start();
			} catch (Exception f) {
				System.out.println("An error has occured");
				System.out.println(f.getMessage());
			}
		});

		// <----------- /APEX ------------->

		// <----------- Destiny 2 ------------->
		// mouse hover effects for game selection
		btnD2.setOnMouseEntered(event -> {
			btnD2.setStyle("-fx-background-color : #0A0E3F; -fx-text-fill: white; -fx-font-size: 28px;");
			imgViewD2.setOpacity(0.5);
			btnD2.setText("Destiny 2");
			btnD2.setContentDisplay(ContentDisplay.CENTER);
		});
		btnD2.setOnMouseExited(event -> {
			btnD2.setStyle("-fx-background-color : #ffffff");
			imgViewD2.setOpacity(1);
			btnD2.setText("");
		});

		// button to go to destiny screen
		btnD2.setOnAction(e -> {
			try {
				stage.setScene(sceneD2);
				stage.setTitle("Destiny 2");
				stage.show();
			} catch (Exception f) {
				System.out.println("An error has occured");
				System.out.println(f.getMessage());
			}
		});
		// button to go back to main
		backBtnD2.setOnAction(e -> {
			try {
				stage.setScene(sceneMain);
				stage.setTitle("eSports Pilot Program");
				stage.show();
			} catch (Exception f) {
				System.out.println("An error has occured");
				System.out.println(f.getMessage());
			}
		});
		// button to start damage detection
		startBtnD2.setOnAction(e -> {
			try {
				Game.setGameInfo("Destiny 2", resListD2.getValue());
				Config.readConfig();
				Screen.setCaptureRect();
				done = false;

				Task<Void> task = new Task<Void>() {
					@Override
					public Void call() throws Exception {
						while (!done) {
							if (isCancelled()) {
								break;
							}
							if (Game.damageTaken()) {
								damageFeedD2.setText("Damage Taken");
								System.out.println("Damage Taken");
								// Haptics.activateHaptics();
								hapticFeedD2.setText("Haptics Enabled");
								Thread.sleep(150);
							} else {
								damageFeedD2.setText("Damage Not Taken");
								System.out.println("Damage Not Taken");
								hapticFeedD2.setText("Haptics Disabled");
							}

						}
						return null;
					}
				};
				new Thread(task).start();
			} catch (Exception f) {
				System.out.println("An error has occured");
				System.out.println(f.getMessage());
			}
		});
		// <----------- /Destiny 2 ------------->

		// <----------- FORTNITE ------------->
		// mouse hover effects for game selection
		btnFN.setOnMouseEntered(event -> {
			btnFN.setStyle("-fx-background-color : #0A0E3F; -fx-text-fill: white; -fx-font-size: 28px;");
			imgViewFN.setOpacity(0.5);
			btnFN.setText("Fortnite");
			btnFN.setContentDisplay(ContentDisplay.CENTER);
		});
		btnFN.setOnMouseExited(event -> {
			btnFN.setStyle("-fx-background-color : #ffffff");
			imgViewFN.setOpacity(1);
			btnFN.setText("");
		});

		// button to go to destiny screen
		btnFN.setOnAction(e -> {
			try {
				stage.setScene(sceneFN);
				stage.setTitle("Fortnite");
				stage.show();
			} catch (Exception f) {
				System.out.println("An error has occured");
				System.out.println(f.getMessage());
			}
		});
		// button to go back to main
		backBtnFN.setOnAction(e -> {
			try {
				stage.setScene(sceneMain);
				stage.setTitle("eSports Pilot Program");
				stage.show();
			} catch (Exception f) {
				System.out.println("An error has occured");
				System.out.println(f.getMessage());
			}
		});
		// button to start damage detection
		startBtnFN.setOnAction(e -> {
			try {
				Game.setGameInfo("Fortnite", resListFN.getValue());
				Config.readConfig();
				Screen.setCaptureRect();
				done = false;

				Task<Void> task = new Task<Void>() {
					@Override
					public Void call() throws Exception {
						while (!done) {
							if (isCancelled()) {
								break;
							}
							if (Game.damageTaken()) {
								damageFeedFN.setText("Damage Taken");
								System.out.println("Damage Taken");
								hapticFeedFN.setText("Haptics Enabled");
								Haptics.activateHaptics();
								Thread.sleep(150);
							} else {
								damageFeedFN.setText("Damage Not Taken");
								System.out.println("Damage Not Taken");
								hapticFeedFN.setText("Haptics Disabled");
							}

						}
						return null;
					}
				};
				new Thread(task).start();
			} catch (Exception f) {
				System.out.println("An error has occured");
				System.out.println(f.getMessage());
			}
		});
		// <----------- /FORTNITE------------->

		// <----------- MINECRAFT ------------->
		// mouse hover effects for game selection
		btnMC.setOnMouseEntered(event -> {
			btnMC.setStyle("-fx-background-color : #0A0E3F; -fx-text-fill: white; -fx-font-size: 28px;");
			imgViewMC.setOpacity(0.5);
			btnMC.setText("Minecraft");
			btnMC.setContentDisplay(ContentDisplay.CENTER);
		});
		btnMC.setOnMouseExited(event -> {
			btnMC.setStyle("-fx-background-color : #ffffff");
			imgViewMC.setOpacity(1);
			btnMC.setText("");
		});

		// button to go to destiny screen
		btnMC.setOnAction(e -> {
			try {
				stage.setScene(sceneMC);
				stage.setTitle("Minecraft");
				stage.show();
			} catch (Exception f) {
				System.out.println("An error has occured");
				System.out.println(f.getMessage());
			}
		});
		// button to go back to main
		backBtnMC.setOnAction(e -> {
			try {
				stage.setScene(sceneMain);
				stage.setTitle("eSports Pilot Program");
				stage.show();
			} catch (Exception f) {
				System.out.println("An error has occured");
				System.out.println(f.getMessage());
			}
		});
		// button to start damage detection
		startBtnMC.setOnAction(e -> {
			try {
				Game.setGameInfo("Minecraft", resListMC.getValue());
				Config.readConfig();
				Screen.setCaptureRect();
				done = false;

				Task<Void> task = new Task<Void>() {
					@Override
					public Void call() throws Exception {
						while (!done) {
							if (isCancelled()) {
								break;
							}
							if (Game.damageTaken()) {
								damageFeedMC.setText("Damage Taken");
								System.out.println("Damage Taken");
								// Haptics.activateHaptics();
								hapticFeedMC.setText("Haptics Enabled");
								Thread.sleep(150);
							} else {
								damageFeedMC.setText("Damage Not Taken");
								System.out.println("Damage Not Taken");
								hapticFeedMC.setText("Haptics Disabled");
							}

						}
						return null;
					}
				};
				new Thread(task).start();
			} catch (Exception f) {
				System.out.println("An error has occured");
				System.out.println(f.getMessage());
			}
		});
		// <----------- /MINECRAFT ------------->

		// <----------- VALHIEM ------------->
		btnVal.setOnMouseEntered(event -> {
			btnVal.setStyle("-fx-background-color : #0A0E3F; -fx-text-fill: white; -fx-font-size: 28px;");
			imgViewVal.setOpacity(0.5);
			btnVal.setText("Valhiem");
			btnVal.setContentDisplay(ContentDisplay.CENTER);
		});
		btnVal.setOnMouseExited(event -> {
			btnVal.setStyle("-fx-background-color : #ffffff");
			imgViewVal.setOpacity(1);
			btnVal.setText("");
		});

		// button to open Valheim screen
		btnVal.setOnAction(e -> {
			stage.setScene(sceneVal);
			stage.setTitle("Valheim");
			damageFeedVal.setText("DAMAGE FEED");
			hapticFeedVal.setText("HAPTIC FEED");
			stage.show();
		});
		// button to go back to main from Valheim screen
		backBtnVal.setOnAction(e -> {
			stage.setScene(sceneMain);
			stage.setTitle("eSports Pilot Program");
			stage.show();
			done = true;
		});

		// button to start damage detection
		startBtnVal.setOnAction(e -> {
			done = false;
			try {
				Game.setGameInfo("Valheim", resListVal.getValue());
				Config.readConfig();
				Screen.setCaptureRect();
				Task<Void> task = new Task<Void>() {
					@Override
					public Void call() throws Exception {
						while (!done) {
							if (isCancelled()) {
								break;
							}
							if (Game.damageTaken()) {
								damageFeedVal.setText("Damage Taken");
								System.out.println("Damage Taken");
								// Haptics.activateHaptics();
								hapticFeedVal.setText("Haptics Enabled");
								Thread.sleep(150);
							} else {
								damageFeedVal.setText("Damage Not Taken");
								System.out.println("Damage Not Taken");
								hapticFeedVal.setText("Haptics Disabled");
							}

						}
						return null;
					}
				};
				new Thread(task).start();
			} catch (Exception f) {
				System.out.println("An error has occured");
				System.out.println(f.getMessage());
			}
		});

		// <----------- /VALHIEM ------------->

		// <----------- FIFA ------------->
		btnFIF.setOnMouseEntered(event -> {
			btnFIF.setStyle("-fx-background-color : #0A0E3F; -fx-text-fill: white; -fx-font-size: 28px;");
			imgViewFIF.setOpacity(0.5);
			btnFIF.setText("FIFA");
			btnFIF.setContentDisplay(ContentDisplay.CENTER);
		});
		btnFIF.setOnMouseExited(event -> {
			btnFIF.setStyle("-fx-background-color : #ffffff");
			imgViewFIF.setOpacity(1);
			btnFIF.setText("");
		});
		// button to open FIFA screen
		btnFIF.setOnAction(e -> {
			stage.setScene(sceneFIF);
			stage.setTitle("FIFA");
			damageFeedFIF.setText("OPPONENT GOAL FEED");
			hapticFeedVal.setText("Haptics Feed");
			stage.show();
		});
		// button to go back to main from FIFA screen
		backBtnFIF.setOnAction(e -> {
			stage.setScene(sceneMain);
			stage.setTitle("eSports Pilot Program");
			stage.show();
			done = true;
		});

		// button to start goals detection FIFA
		startBtnFIF.setOnAction(e -> {
			done = false;
			try {
				Game.setGameInfo("Fifa", resListFIF.getValue());
				Config.readConfig();
				Screen.setCaptureRect();
				//allow for time to open game
				Thread.sleep(3000);
				//Screen.isBarOpenFifa();
				Task<Void> task = new Task<Void>() {
					@Override
					public Void call() throws Exception {
						while (!done) {
							if (isCancelled()) {
								break;
							}
							if (Game.damageTaken()) {
								damageFeedFIF.setText("Goal Conceded");
								System.out.println("Goal Conceded");
								// Haptics.activateHaptics();
								hapticFeedFIF.setText("Haptics Enabled");
								Thread.sleep(300);
							} else {
								damageFeedFIF.setText("No Goal Conceded");
								System.out.println("No Goal Conceded");
								hapticFeedFIF.setText("Haptics Disabled");
							}

						}
						return null;
					}
				};
				new Thread(task).start();
			} catch (Exception f) {
				System.out.println("An error has occured");
				System.out.println(f.getMessage());
			}
		});

		// <----------- /FIFA ------------->

	}
	/**
	 * runs GUIDriver
	 * @param args
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
