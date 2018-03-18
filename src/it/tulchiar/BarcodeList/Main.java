package it.tulchiar.BarcodeList;
	
import it.tulchiar.BarcodeList.Model.Model;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			
			Properties_BarcodeList.inizialize();
			
			
			FXMLLoader loader = new FXMLLoader(getClass().getResource("BarcodeList.fxml"));		
			BorderPane root = (BorderPane) loader.load();
			
			BarcodeListController controller = loader.getController();
			
			Model model = new Model();
			controller.setModel(model);
						
			Scene scene = new Scene(root,1024,768);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
