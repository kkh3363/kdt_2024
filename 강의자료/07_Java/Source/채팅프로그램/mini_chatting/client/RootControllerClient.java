package client;

import java.net.URL;
import java.util.ResourceBundle;

import org.json.JSONObject;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import model.MessageJson;

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
		String strMsg = MessageJson.makeMessage(txtMessage.getText());
		
		ChatClient.clientControl.send( strMsg );
	}
}
