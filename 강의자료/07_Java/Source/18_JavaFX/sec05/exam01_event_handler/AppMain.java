package sec05.exam01_event_handler;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class AppMain extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		HBox root = new HBox();
		root.setPrefSize(200, 50);
		root.setAlignment(Pos.CENTER);
		root.setSpacing(20);

		Button btn1 = new Button("버튼1");
		btn1.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				System.out.println("버튼1 클릭");
			}
		});

		Button btn2 = new Button("버튼2");
		btn2.setOnAction(event -> System.out.println("버튼2 클릭"));

		root.getChildren().addAll(btn1, btn2);
		Scene scene = new Scene(root);

		primaryStage.setTitle("AppMain");
		primaryStage.setScene(scene);
		primaryStage.setOnCloseRequest(event -> System.out.println("종료 클릭"));
		primaryStage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}
}
