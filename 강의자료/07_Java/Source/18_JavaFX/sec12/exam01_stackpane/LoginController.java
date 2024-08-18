package sec12.exam01_stackpane;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

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
			root.getChildren().remove(login);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
