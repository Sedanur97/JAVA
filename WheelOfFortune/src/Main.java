import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.*;
import javafx.stage.Stage;


public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    Stage stage=new Stage();


    @Override
    public void start(Stage primaryStage) throws Exception {

        BorderPane root =new BorderPane();

        Scene scene =new Scene(root,700,650);


        primaryStage.setTitle(" WHEEL OF FORTUNE ");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
