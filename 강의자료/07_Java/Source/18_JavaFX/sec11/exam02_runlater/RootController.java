package sec11.exam02_runlater;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;

public class RootController implements Initializable {
	@FXML private ProgressBar progressBar;
	@FXML private Label lblWorkDone;
	@FXML private Label lblResult;
	@FXML private Button btnStart;
	@FXML private Button btnStop;
	
	private Thread thread;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btnStart.setOnAction(event->handleBtnStart(event));
		btnStop.setOnAction(event->handleBtnStop(event));
	}
	
	public void handleBtnStart(ActionEvent e) {		
		thread = new Thread() {
			@Override
			public void run() {
				int result = 0;
				for(int i=0; i<=100; i++) {
					result += i;
					
					double progress = i/100.0;
					String workDone = String.valueOf(i);
					Platform.runLater(() -> {
						progressBar.setProgress(progress);
						lblWorkDone.setText(workDone);
					});
					
					try {Thread.sleep(100); } catch(InterruptedException e) {
						break;
					}
				}
				
				String strResult = String.valueOf(result);
				Platform.runLater(() -> {
					lblResult.setText(String.valueOf(strResult));
				});
			}
		};
		thread.setDaemon(true);
		thread.start();
	}
	
	public void handleBtnStop(ActionEvent e) {
		thread.interrupt();
	}
}








