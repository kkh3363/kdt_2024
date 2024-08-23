package client;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ChatClient extends Application {
	 static ClientControl clientControl = null;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Parent root = (Parent)FXMLLoader.load(getClass().getResource("RootClient.fxml"));
		
		Scene scene = new Scene(root);
		
		primaryStage.setTitle("클라이언트");
		primaryStage.setScene(scene);
		primaryStage.show();
		clientControl = new ClientControl("127.0.0.1", 9876, root);

	}

	public static void main(String[] args) {
		
		launch(args);

	}

}
