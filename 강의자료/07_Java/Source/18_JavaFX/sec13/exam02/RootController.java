package sec13.exam02;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sec13.exam03.Student;

public class RootController implements Initializable {
	@FXML private Button btnAdd;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btnAdd.setOnAction(event->handleBtnAddAction(event));
	}

	private void handleBtnAddAction(ActionEvent event) {
		try {		
			Stage dialog = new Stage(StageStyle.UTILITY);
			dialog.initModality(Modality.WINDOW_MODAL);
			dialog.initOwner(btnAdd.getScene().getWindow());
			dialog.setTitle("추가");
		
			Parent parent = FXMLLoader.load(getClass().getResource("form.fxml"));

			Button btnFormCancel = (Button) parent.lookup("#btnFormCancel");
			btnFormCancel.setOnAction(e->dialog.close());
			
			Scene scene = new Scene(parent);
			dialog.setScene(scene);
			dialog.setResizable(false);
			dialog.show();	
		} catch (IOException e) {}	
	}
}







