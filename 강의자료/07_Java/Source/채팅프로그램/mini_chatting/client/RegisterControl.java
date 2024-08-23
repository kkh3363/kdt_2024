package client;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.MemberDTO;
import model.MessageJson;

public class RegisterControl implements Initializable {
	
	private Stage rootStage = null;
	@FXML
	private TextField txtUserId;
	private PasswordField txtPassword; 
	private TextField txtUserName; 
	private TextField txtNickName; 
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}
	public void setPrimaryStage(Stage rootStage) {
		this.rootStage = rootStage;
	}
	public void btnCancel(ActionEvent e) {
		//((Stage)rootStage.getScene().getWindow()).close();
		rootStage.close();
	}
	
	public void btnRegisterSubmit(ActionEvent e) {
		String sendMsg;
		String userId = txtUserId.getText();
		String userPasswd = txtPassword.getText();
		String userName = txtUserName.getText();
		String nickName = txtNickName.getText();
			
		MemberDTO member = new MemberDTO(userId, userPasswd, userName, nickName); 
		sendMsg = MessageJson.makeMemberDto("register", member);
		System.out.println(sendMsg);
		
		ChatClient.clientControl.connectServer();
		ChatClient.clientControl.send(sendMsg);
		
	}

}
