package sec09.exam01_dialog;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.DirectoryChooser;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Modality;
import javafx.stage.Popup;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class RootController implements Initializable {
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}
	
	private Stage primaryStage;	
	public void setPrimaryStage(Stage primaryStage) {
		this.primaryStage = primaryStage;
	}	
	
	//파일 열기 다이얼로그 실행
	public void handleOpenFileChooser(ActionEvent e) {
		FileChooser fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().addAll(
			new ExtensionFilter("Text Files", "*.txt"),
			new ExtensionFilter("Image Files", "*.png", "*.jpg", "*.gif"),
			new ExtensionFilter("Audio Files", "*.wav", "*.mp3", "*.aac"),
			new ExtensionFilter("All Files", "*.*"));
		File selectedFile = fileChooser.showOpenDialog(primaryStage);
		if (selectedFile != null) {
			System.out.println(selectedFile.getPath());
		}
	}
	
	//파일 저장 다이얼로그 실행
	public void handleSaveFileChooser(ActionEvent e) {	
		 FileChooser fileChooser = new FileChooser();
		 fileChooser.getExtensionFilters().add(new ExtensionFilter("All Files", "*.*"));
		 File selectedFile = fileChooser.showSaveDialog(primaryStage);
		 if (selectedFile != null) {
			 System.out.println(selectedFile.getPath());
		 }		
	}
	
	//디렉토리 선택 다이얼로그 실행
	public void handleDirectoryChooser(ActionEvent e) {
		DirectoryChooser directoryChooser = new DirectoryChooser();
		File selectedDir = directoryChooser.showDialog(primaryStage);
		if (selectedDir != null) {
			 System.out.println(selectedDir.getPath());
		 }	
	}
	
	//Popup 다이얼로그 실행
	public void handlePopup(ActionEvent e) throws Exception {
		Popup popup = new Popup();
		
		Parent parent = FXMLLoader.load(getClass().getResource("popup.fxml"));
		ImageView imageView = (ImageView) parent.lookup("#imgMessage");
		imageView.setImage(new Image(
				getClass().getResource("images/dialog-info.png").toString()));
		imageView.setOnMouseClicked(event->popup.hide());
		Label lblMessage = (Label)parent.lookup("#lblMessage");
		lblMessage.setText("메시지가 왔습니다.");
		
		popup.getContent().add(parent);
		popup.setAutoHide(true);	
		popup.show(primaryStage);
	}
	
	//커스텀 다이얼로그 실행
	public void handleCustom(ActionEvent e) throws Exception {
		Stage dialog = new Stage(StageStyle.UTILITY);
		dialog.initModality(Modality.WINDOW_MODAL);
		dialog.initOwner(primaryStage);
		dialog.setTitle("확인");
		
		Parent parent = FXMLLoader.load(getClass().getResource("custom_dialog.fxml"));
		Label txtTitle = (Label) parent.lookup("#txtTitle");
		txtTitle.setText("확인하셨습니까?");
		Button btnOk = (Button) parent.lookup("#btnOk");
		btnOk.setOnAction(event->dialog.close());	
		Scene scene = new Scene(parent);
		
		dialog.setScene(scene);
		dialog.setResizable(false);
		dialog.show();
	}
}







