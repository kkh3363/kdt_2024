package sec12.exam03_move_animation.list;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import sec12.exam03_move_animation.AppMain;
import sec12.exam03_move_animation.util.Animation;


public class ListController implements Initializable {
	@FXML private Button btnLeft;
	@FXML private Button btnRight;
	@FXML private StackPane listStackPane;	
	@FXML private Button btnHome;
	private int currentPage = 1;
	private int totalPage = 4;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		btnLeft.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				handleBtnLeft(event);
			}
		});
		
		btnRight.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				handleBtnRight(event);
			}
		});
		
		btnHome.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				handleBtnHome(event);
			}
		});		
		
		listView = getList(currentPage);
		listStackPane.getChildren().add(listView);
		showButton();
	}
	
	private ListView listView;
	
	public void handleBtnLeft(ActionEvent event) {
		if(currentPage>1) { 
			currentPage--; 
			ListView<BorderPane> listView = getList(currentPage);
			listStackPane.getChildren().add(0, listView);
			Animation.slide(listStackPane.getChildren().get(1), 0, 350, new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					listStackPane.getChildren().remove(1);
				}
			});
			showButton();
		}
	}	
	
	public void handleBtnRight(ActionEvent event) {
		if(currentPage<totalPage) {
			currentPage++;
			ListView<BorderPane> listView = getList(currentPage);
			listStackPane.getChildren().add(listView);
			Animation.slide(listView, 350, 0, new EventHandler<ActionEvent>() {
				@Override
				public void handle(ActionEvent event) {
					listStackPane.getChildren().remove(0);
				}
			});
			showButton();
		}
	}
	
	public void handleBtnHome(ActionEvent event) {
		Animation.fade(AppMain.stackPane.getChildren().get(1), 1, 0, new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent event) {
				AppMain.stackPane.getChildren().remove(1);
			}
		});
	}	
	
	private void showButton() {
		if(currentPage == 1) {
			btnLeft.setVisible(false);
		} else {
			btnLeft.setVisible(true);
		}
		if(currentPage == totalPage) {
			btnRight.setVisible(false);
		} else {
			btnRight.setVisible(true);
		}
	}
	
	private ListView<BorderPane> getList(int page) {
		ListView<BorderPane> listView = new ListView<BorderPane>();
		int start = (page-1)*5 + 1;
		int end = page*5;
		for(int i=start; i<=end; i++) {
			BorderPane borderPane = new BorderPane();
			
			Image image = new Image(AppMain.class.getResource("images/phone" + ((i<10)?("0" + i):i)+ ".png").toString());
			ImageView imageView = new ImageView(image);
			imageView.setFitWidth(50);
			imageView.setFitHeight(75);
			borderPane.setLeft(imageView);
			
			HBox hbox = new HBox();
			hbox.setPadding(new Insets(10));
			hbox.setAlignment(Pos.CENTER_LEFT);
			Label label = new Label("스마트폰 0"+i);
			label.setFont(new Font(15));
			hbox.getChildren().add(label);
			borderPane.setCenter(hbox);
			
			Button button = new Button("상세보기");
			borderPane.setRight(button);
			BorderPane.setAlignment(button, Pos.CENTER);
			
			listView.getItems().add(borderPane);
		}
		return listView;
	}
}
