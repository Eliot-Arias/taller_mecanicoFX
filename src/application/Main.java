package application;
	
import java.io.IOException;

import Interfaz.I_loginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class Main extends Application {
	
	
	@Override
	public void start(Stage primaryStage) throws Exception {	
		
		try {
			//BorderPane root = new BorderPane();
			Parent root = FXMLLoader.load(getClass().getResource("../Interfaz/I_login.fxml"));
			Scene scene = new Scene(root);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setTitle("Inicio Sesion");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}	
		
	}
	
	public void load(Stage seconStage, String fxml) throws Exception{
		try {
			Parent root = FXMLLoader.load(getClass().getResource("../Interfaz/I_" + fxml +".fxml"));
			Scene scene = new Scene(root);
			seconStage.setScene(scene);
			seconStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}	
	}
	
	
	
	public static void main(String[] args) {
		launch(args);
	}
}
/*
FXMLLoader loader = new FXMLLoader(loader.getClass().getResource("../Interfaz/I_inicio.fxml"));
Parent root = loader.load();
I_inicioController controlador = loader.getController();
Scene scene = new Scene(root);
Stage stage = new Stage();
stage.setScene(scene);
stage.show();
*/