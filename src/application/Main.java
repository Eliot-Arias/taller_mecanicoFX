package application;
	

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
	
	public void load(Stage seconStage, String fxml, String tittle) throws Exception{
		try {
			Parent root = FXMLLoader.load(getClass().getResource("../Interfaz/I_" + fxml +".fxml"));
			Scene scene = new Scene(root);
			seconStage.setTitle(tittle);
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