package tutorilal;

import javafx.animation.*;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileInputStream;

public
class Main
        extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {

        Group root = new Group();
        Scene scene = new Scene( root, 600, 600);

        Rectangle rect = new Rectangle(250, 250);
        root.getChildren().add(rect);
        rect.setLayoutX(scene.getWidth()/2-rect.getWidth()/2);
        rect.setLayoutY(scene.getHeight()/2-rect.getHeight()/2);

        Rectangle rect1 = new Rectangle(250, 250);
        root.getChildren().add(rect1);
        rect1.setLayoutX(scene.getWidth()/2-rect.getWidth()/2);
        rect1.setLayoutY(scene.getHeight()/2-rect.getHeight()/2);

        Timeline timeline = new Timeline();

        timeline.setCycleCount(-1);
        timeline.setAutoReverse(true);

        KeyFrame kfRect1_0 = new KeyFrame(
                Duration.seconds(0),
                new KeyValue( rect.rotateProperty(), 0, Interpolator.LINEAR),
                new KeyValue( rect.fillProperty(), Color.RED),
                new KeyValue( rect1.rotateProperty(), 360, Interpolator.EASE_IN),
                new KeyValue( rect1.fillProperty(), Color.BLUE)
        );
        KeyFrame kfRect1_5 = new KeyFrame(
                Duration.seconds(5),
                new KeyValue( rect.rotateProperty(), 360, Interpolator.EASE_OUT),
                new KeyValue( rect.fillProperty(), Color.BLUE),
                new KeyValue( rect1.rotateProperty(), 0, Interpolator.EASE_BOTH),
                new KeyValue( rect1.fillProperty(), Color.RED)
        );

        timeline.getKeyFrames().addAll(kfRect1_0, kfRect1_5);

        primaryStage.setScene(scene);
        primaryStage.show();

        timeline.play();
    }


/*
    @Override
    public void start(Stage primaryStage) throws Exception {

        BorderPane root = new BorderPane();
        Scene scene = new Scene( root, 600, 600);

        Image img = new Image(
            new FileInputStream(
                "C:\\Users\\tomaszew\\Downloads\\sO1PvSra.jpg"
            )
        );

        ImageView imageView = new ImageView(img);

        RotateTransition rotateTransition = new RotateTransition();
        rotateTransition.setNode(imageView);
        rotateTransition.setFromAngle(0);
        rotateTransition.setToAngle(360);

        rotateTransition.setDuration(
            Duration.seconds(5)
        );

        rotateTransition.setCycleCount(-1);

        root.setCenter(imageView);

        primaryStage.setScene(scene);
        primaryStage.show();

        rotateTransition.play();
    }
*/

    public static void main(String[] args) {
        launch(args);
    }
}
