package sec06.exam02_property_bind;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.binding.Bindings;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

public class RootController implements Initializable {
	@FXML private TextArea textArea1;
	@FXML private TextArea textArea2;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Bindings.bindBidirectional(textArea1.textProperty(), textArea2.textProperty());
	}
}
