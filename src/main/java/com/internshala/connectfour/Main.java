package com.internshala.connectfour;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application {

    private Controller controller;

    @Override
    public void start(Stage primaryStage) throws Exception{

        FXMLLoader loader = new FXMLLoader(Main.class.getResource("game.fxml"));
        GridPane rootGridPane=loader.load();

        controller = loader.getController();
        controller.createPlayground();

        Pane menuPane = (Pane) rootGridPane.getChildren().get(0);
        MenuBar menuBar= createMenu();
        menuBar.prefWidthProperty().bind(primaryStage.widthProperty());

        menuPane.getChildren().add(menuBar);

        Scene scene = new Scene(rootGridPane);

        primaryStage.setScene(scene);
        primaryStage.setTitle("Connect Four");
        primaryStage.setResizable(false);
        primaryStage.show();
        createMenu();
    }

    private MenuBar createMenu(){
        MenuBar menuBar= new MenuBar();

        Menu file= new Menu("File");
        MenuItem newGame= new MenuItem("New Game");

        newGame.setOnAction(event -> controller.resetGame());

        MenuItem resetGame = new MenuItem("Reset Game");

        resetGame.setOnAction(event -> controller.resetGame());

        SeparatorMenuItem separatorMenuItem= new SeparatorMenuItem();
        MenuItem exit = new MenuItem("Exit");

        exit.setOnAction(event -> {
            Platform.exit();
            System.exit(0);
        });
        file.getItems().addAll(newGame,resetGame,separatorMenuItem,exit);

        Menu help = new Menu("Help");
        MenuItem aboutGame=new MenuItem("About Connect Four Game");

        aboutGame.setOnAction(event -> AboutConnectFourGame());

        SeparatorMenuItem separatorMenuItem1= new SeparatorMenuItem();
        MenuItem about= new MenuItem("About Me");

        about.setOnAction(event -> aboutMe());

        help.getItems().addAll(aboutGame,separatorMenuItem1,about);

        menuBar.getMenus().addAll(file,help);
        return menuBar;



    }

    private void aboutMe() {
        Alert aboutGame= new Alert(Alert.AlertType.INFORMATION);
        aboutGame.setTitle("About the Developer");
        aboutGame.setHeaderText("Varshini S Raj");
        aboutGame.setContentText(" An Assignment to complete the Core Java Course\n");
        aboutGame.show();
    }

    private void AboutConnectFourGame() {

        Alert aboutGame= new Alert(Alert.AlertType.INFORMATION);
        aboutGame.setTitle("About Game");
        aboutGame.setHeaderText("How to play the game: Connect Four");
        aboutGame.setContentText("Connect Four is a two-player strategy game where the objective is to be the first to form a line of four of your own colored discs horizontally, vertically, or diagonally on a 7x6 grid. Players take turns dropping their colored discs from the top into any of the seven columns. The discs fall to the lowest available space within the column. The game continues until one player achieves four in a row or the board is full, resulting in a draw.....\n" + "\n");
        aboutGame.show();
    }




    public static void main(String[] args) {
        launch(args);
    }
}
