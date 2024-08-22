package minichatting.client;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

public class RootControllerClient implements Initializable {
	@FXML private TextField txtMessage;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}
	public void connectServer(ActionEvent e) {
		ChatClient.clientControl.connectServer();
	}
	
	public void closeServer(ActionEvent e) {
		ChatClient.clientControl.stopClient();
	}
	
	public void sendData(ActionEvent e) {
		ChatClient.clientControl.send(txtMessage.getText());
	}
}
