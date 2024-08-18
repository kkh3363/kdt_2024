package sec03.exam01_programmatical_layout;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;
import javafx.geometry.Insets;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;
import javafx.scene.Scene;
import javafx.collections.ObservableList;

public class AppMain extends Application {
	@Override
	public void start(Stage primaryStage) throws Exception {
		HBox hbox = new HBox(); // HBox 컨테이너 생성
		hbox.setPadding(new Insets(10, 10, 10, 10)); // 안쪽 여백 설정
		hbox.setSpacing(10); // 컨트롤간의 수평 간격 설정

		TextField textField = new TextField(); // TextField 컨트롤 생성
		textField.setPrefWidth(200); // TextField의 폭 설정

		Button button = new Button(); // Button 컨트롤 생성
		button.setText("확인"); // Button 글자 설정

		ObservableList list = hbox.getChildren(); // HBox의 ObservableList 얻기
		list.add(textField); // TextField 컨트롤 배치
		list.add(button); // Button의 컨트롤 배치

		Scene scene = new Scene(hbox); // 화면의 루트 컨테이너로 HBox 지정

		primaryStage.setTitle("AppMain"); // 윈도우 창 제목 설정
		primaryStage.setScene(scene); // 윈도우 창에 화면 설정
		primaryStage.show(); // 윈도우 창 보여주기
	}

	public static void main(String[] args) {
		launch(args);
	}
}
