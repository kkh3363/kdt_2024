package sec12.exam03_move_animation.util;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.util.Duration;

public class Animation {
	/**
	 * @param
	 * start: 0.0~width
	 * end: 0.0~width
	 */		
	public static void slide(Node node, double start, double end) {
		node.setTranslateX(start);
		Timeline timeline = new Timeline();
        KeyValue keyValue = new KeyValue(node.translateXProperty(), end);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(300), keyValue);
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
	}
	
	public static void slide(Node node, double start, double end, EventHandler<ActionEvent> onFinish) {
		node.setTranslateX(start);
		Timeline timeline = new Timeline();
        KeyValue keyValue = new KeyValue(node.translateXProperty(), end);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(300), onFinish, keyValue);
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
	}

	/**
	 * @param
	 * start: 0.0~1.0
	 * end: 0.0~1.0
	 */	
	public static void fade(Node node, double start, double end) {
		node.setOpacity(start);
		Timeline timeline = new Timeline();
        KeyValue keyValue = new KeyValue(node.opacityProperty(), end);
        KeyFrame keyFrame = new KeyFrame(Duration.millis(500), keyValue);
        timeline.getKeyFrames().add(keyFrame);
        timeline.play();
	}
	
	public static void fade(Node node, double start, double end, EventHandler<ActionEvent> onFinish) {
		node.setOpacity(start);
		Timeline timeline = new Timeline();
		KeyValue keyValue = new KeyValue(node.opacityProperty(), end);
		KeyFrame keyFrame = new KeyFrame(Duration.millis(500), onFinish, keyValue);
		timeline.getKeyFrames().add(keyFrame);
		timeline.play();
	}		
}
