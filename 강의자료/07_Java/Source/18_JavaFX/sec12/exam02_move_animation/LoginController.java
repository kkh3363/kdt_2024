package sec12.exam02_move_animation;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class LoginController implements Initializable {
	@FXML private BorderPane login;
	@FXML private Button btnMain;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btnMain.setOnAction(e -> handleBtnMain(e));
	}

	public void handleBtnMain(ActionEvent event) {
		try {
			StackPane root = (StackPane) btnMain.getScene().getRoot();

			//로그인 화면의 x 좌표를 0으로 이동시켜 놓음(원래 0임)
			login.setTranslateX(0);

			//Timeline 객체 생성
			Timeline timeline = new Timeline();
			//로그인 화면의 x 좌표 종료값으로 350을 설정
			KeyValue keyValue = new KeyValue(login.translateXProperty(), 350);
			//0.1초간 종료값까지 x 좌료를 변화시키도록(0 --> 350) KeyFrame 생성
			KeyFrame keyFrame = new KeyFrame(
				Duration.millis(100), 
				new EventHandler<ActionEvent>() {
					@Override
					public void handle(ActionEvent event) {
						//애니메이션이 종료된 후, StackPane에서 로그인 화면 제거
						root.getChildren().remove(login);
					}
				}, 
				keyValue
			);
			//Timeline에 KeyFrame 추가
			timeline.getKeyFrames().add(keyFrame);
			//애니메이션 시작
			timeline.play();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

