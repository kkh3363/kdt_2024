package sec12.exam02_move_animation;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

public class RootController implements Initializable {
	@FXML private Button btnLogin;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btnLogin.setOnAction(e->handleBtnLogin(e));
	}
	
	public void  handleBtnLogin(ActionEvent event) {
		try {
			Parent login= FXMLLoader.load(getClass().getResource("login.fxml"));
			StackPane root = (StackPane) btnLogin.getScene().getRoot();
			root.getChildren().add(login);
			
			//로그인 화면의 x좌표를 350(윈도우 폭) 만큼 이동시켜 놓음(안보이게 하기 위해서)
			login.setTranslateX(350);

			//Timeline 객체 생성
			Timeline timeline = new Timeline();
			//로그인 화면의 x 좌표 종료값으로 0을 설정
			KeyValue keyValue = new KeyValue(login.translateXProperty(), 0);
			//0.1초간 종료값까지 x 좌료를 변화시키도록(0 <-- 350) KeyFrame 생성
			KeyFrame keyFrame = new KeyFrame(Duration.millis(100), keyValue);
			//Timeline에 KeyFrame 추가
			timeline.getKeyFrames().add(keyFrame);
			//애니메이션 시작
			timeline.play();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
