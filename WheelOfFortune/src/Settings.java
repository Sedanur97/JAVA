import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.*;
import java.util.Optional;
import java.util.Random;

public class Settings extends Application {
    ListView<String> rview = null;
    ListView<String> lview = null;
    Button lrBut = new Button(" \u2192 ");
    Button rlBut = new Button(" \u2190 ");
    Button add =new Button(" + ");
    ObservableList<String> right = FXCollections.observableArrayList();
    ObservableList<String> left = FXCollections.observableArrayList();
    NewGame newGame1=new NewGame();

    BorderPane root = new BorderPane();
    Scene scene = new Scene(root, 700, 650);

    int random =0;
    String randomvalue;


    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setTitle("Settings");
        TextInputDialog dialog = new TextInputDialog();
        dialog.setContentText("Please enter a word: ");
        dialog.setTitle("New Word");
        dialog.setHeaderText("New Word");

        DropShadow dropShadow = new DropShadow();
        dropShadow.setOffsetX(5.0f);
        dropShadow.setOffsetY(5.0f);
        dropShadow.setColor(Color.rgb(0, 0, 0,1.0));


        HBox hbox =new HBox(7);
        Text w = new Text("W");
        w.setFont(Font.font("Cambria", FontWeight.BOLD, FontPosture.REGULAR, 50));
        w.setFill(Color.BLUE);
        w.setEffect(dropShadow);

        Text h = new Text("H");
        h.setFont(Font.font("Cambria", FontWeight.BOLD, FontPosture.REGULAR, 50));
        h.setFill(Color.BLUEVIOLET);
        h.setEffect(dropShadow);

        Text e1 = new Text("E");
        e1.setFont(Font.font("Cambria", FontWeight.BOLD, FontPosture.REGULAR, 50));
        e1.setEffect(dropShadow);
        e1.setFill(Color.DEEPSKYBLUE);


        Text e2 = new Text("E");
        e2.setFont(Font.font("Cambria", FontWeight.BOLD, FontPosture.REGULAR, 50));
        e2.setEffect(dropShadow);
        e2.setFill(Color.MEDIUMORCHID);

        Text l = new Text("L");
        l.setFont(Font.font("Cambria", FontWeight.BOLD, FontPosture.REGULAR, 50));
        l.setEffect(dropShadow);
        l.setFill(Color.MAGENTA);

        Text sp1 = new Text(" ");

        Text o1 = new Text("O");
        o1.setFont(Font.font("Cambria", FontWeight.BOLD, FontPosture.REGULAR, 50));
        o1.setEffect(dropShadow);
        o1.setFill(Color.DEEPPINK);

        Text f1 = new Text("F");
        f1.setFont(Font.font("Cambria", FontWeight.BOLD, FontPosture.REGULAR, 50));
        f1.setEffect(dropShadow);
        f1.setFill(Color.RED);


        Text sp2 = new Text(" ");

        Text f2 = new Text("F");
        f2.setFont(Font.font("Cambria", FontWeight.BOLD, FontPosture.REGULAR, 50));
        f2.setEffect(dropShadow);
        f2.setFill(Color.ORANGERED);

        Text o2 = new Text("O");
        o2.setFont(Font.font("Cambria", FontWeight.BOLD, FontPosture.REGULAR, 50));
        o2.setEffect(dropShadow);
        o2.setFill(Color.ORANGE);

        Text r = new Text("R");
        r.setFont(Font.font("Cambria", FontWeight.BOLD, FontPosture.REGULAR, 50));
        r.setEffect(dropShadow);
        r.setFill(Color.YELLOW);

        Text t = new Text("T");
        t.setFont(Font.font("Cambria", FontWeight.BOLD, FontPosture.REGULAR, 50));
        t.setEffect(dropShadow);
        t.setFill(Color.GREENYELLOW);

        Text u = new Text("U");
        u.setFont(Font.font("Cambria", FontWeight.BOLD, FontPosture.REGULAR, 50));
        u.setEffect(dropShadow);
        u.setFill(Color.LIGHTGREEN);

        Text n = new Text("N");
        n.setFont(Font.font("Cambria", FontWeight.BOLD, FontPosture.REGULAR, 50));
        n.setEffect(dropShadow);
        n.setFill(Color.FORESTGREEN);

        Text e = new Text("E");
        e.setFont(Font.font("Cambria", FontWeight.BOLD, FontPosture.REGULAR, 50));
        e.setEffect(dropShadow);
        e.setFill(Color.DARKSLATEGREY);
        hbox.setAlignment(Pos.CENTER);
        hbox.setPadding(new Insets(5));
        hbox.setPrefSize(120,125);




        hbox.getChildren().addAll(w,h,e1,e2,l,sp1,o1,f1,sp2,f2,o2,r,t,u,n,e);

        FadeTransition ef1 = new FadeTransition(Duration.seconds(1.74), w);
        ef1.setFromValue(5.0);
        ef1.setToValue(0.0);
        ef1.setCycleCount(Animation.INDEFINITE);
        ef1.play();
        FadeTransition ef2 = new FadeTransition(Duration.seconds(1.76), h);
        ef2.setFromValue(5.0);
        ef2.setToValue(0.0);
        ef2.setCycleCount(Animation.INDEFINITE);
        ef2.play();
        FadeTransition ef3 = new FadeTransition(Duration.seconds(1.78), e1);
        ef3.setFromValue(5.0);
        ef3.setToValue(0.0);
        ef3.setCycleCount(Animation.INDEFINITE);
        ef3.play();
        FadeTransition ef4 = new FadeTransition(Duration.seconds(1.80), e2);
        ef4.setFromValue(5.0);
        ef4.setCycleCount(Animation.INDEFINITE);
        ef4.setToValue(0.0);
        ef4.play();
        FadeTransition ef5 = new FadeTransition(Duration.seconds(1.82), l);
        ef5.setToValue(0.0);
        ef5.setFromValue(5.0);
        ef5.setCycleCount(Animation.INDEFINITE);
        ef5.play();
        FadeTransition ef6 = new FadeTransition(Duration.seconds(1.84), o1);
        ef6.setFromValue(5.0);
        ef6.setCycleCount(Animation.INDEFINITE);
        ef6.setToValue(0.0);
        ef6.play();
        FadeTransition ef7 = new FadeTransition(Duration.seconds(1.86), f1);
        ef7.setFromValue(5.0);
        ef7.setCycleCount(Animation.INDEFINITE);
        ef7.setToValue(0.0);
        ef7.play();
        FadeTransition ef8 = new FadeTransition(Duration.seconds(1.88), f2);
        ef8.setFromValue(5.0);
        ef8.setCycleCount(Animation.INDEFINITE);
        ef8.setToValue(0.0);
        ef8.play();
        FadeTransition ef9 = new FadeTransition(Duration.seconds(1.90), o2);
        ef9.setFromValue(5.0);
        ef9.setCycleCount(Animation.INDEFINITE);
        ef9.setToValue(0.0);
        ef9.play();
        FadeTransition ef10 = new FadeTransition(Duration.seconds(1.92),r);
        ef10.setFromValue(5.0);
        ef10.setCycleCount(Animation.INDEFINITE);
        ef10.setToValue(0.0);
        ef10.play();
        FadeTransition ef11 = new FadeTransition(Duration.seconds(1.94), t);
        ef11.setFromValue(5.0);
        ef11.setCycleCount(Animation.INDEFINITE);
        ef11.setToValue(0.0);
        ef11.play();
        FadeTransition ef12 = new FadeTransition(Duration.seconds(1.96), u);
        ef12.setFromValue(5.0);
        ef12.setCycleCount(Animation.INDEFINITE);
        ef12.setToValue(0.0);
        ef12.play();
        FadeTransition ef13 = new FadeTransition(Duration.seconds(1.98), n);
        ef13.setFromValue(5.0);
        ef13.setCycleCount(Animation.INDEFINITE);
        ef13.setToValue(0.0);
        ef13.play();
        FadeTransition ef14 = new FadeTransition(Duration.seconds(2.0), e);
        ef14.setFromValue(5.0);
        ef14.setCycleCount(Animation.INDEFINITE);
        ef14.setToValue(0.0);
        ef14.play();

        String path1 ="C:\\Users\\aysen\\Downloads\\open.mp3";
        Media media1 = new Media(new File(path1).toURI().toString());
        MediaPlayer mediaPlayer1 = new MediaPlayer(media1);
        mediaPlayer1.setAutoPlay(true);




        Button newGame =new Button("NEW GAME");

        newGame.setOnAction(event -> {
//            random = (int) Math.random()*left.size();
//            randomvalue =left.get(random);
            if(left.size()!=0) {
                Random random = new Random();
                int randomval = random.nextInt(left.size());
                //newGame1.iii = left.get(randomval);
                String ccc = left.get(randomval);
                newGame1.iii = ccc;
                System.out.println(ccc);

                Stage stage8 =new Stage();

               // primaryStage.getScene().getWindow().hide();
                try {
                    newGame1.start(stage8);
                    newGame1.score =0;
                    newGame1.labelingo.setText(" SCORE : " + newGame1.score);
                    newGame1.chance= 3;
                } catch (Exception exp) {
                    exp.printStackTrace();
                }
                //mediaPlayer1.setMute(true);
                mediaPlayer1.stop();
                primaryStage.close();

            }else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Warning !");
                alert.setHeaderText("Please choose words !");
                //alert.setContentText("Careful with the next step!");

                alert.showAndWait();
            }
        });
        newGame.setMinWidth(100);
        newGame.setMinHeight(50);
        newGame.setTextFill(Color.DEEPPINK);
        newGame.setFont(Font.font("Cambria", FontWeight.BOLD, FontPosture.REGULAR, 23));


        Background bg =new Background(new BackgroundFill(Color.rgb(223, 249, 251),CornerRadii.EMPTY, Insets.EMPTY));
        root.setBackground(bg);
        newGame.setBackground(bg);





        VBox vb = new VBox();
        rlBut.setOnAction(
                (m) -> {
                    String a = rview.getSelectionModel().getSelectedItem();
             if (a != null) {
                 rview.getSelectionModel().clearSelection();
                 right.remove(a);
                 left.add(a);
             }
        });
        rlBut.setMinWidth(80);
        rlBut.setMinHeight(30);
        rlBut.setFont(Font.font("Cambria", FontWeight.BOLD, FontPosture.REGULAR, 23));

        lrBut.setOnAction(
                 k -> {
                     String a = lview.getSelectionModel().getSelectedItem();
                     if (a != null) {
                          lview.getSelectionModel().clearSelection();
                          right.add(a);
                          left.remove(a);

                    }
                }
        );
        lrBut.setMinWidth(80);
        lrBut.setMinHeight(30);
        lrBut.setFont(Font.font("Cambria", FontWeight.BOLD, FontPosture.REGULAR, 23));

        add.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {

                Optional<String> result = dialog.showAndWait();
                if (result.isPresent()){
                    String word = result.get();
                    right.add(word);
                    dialog.getEditor().setText("");
                    try (FileWriter writer = new FileWriter("C:\\Users\\aysen\\IdeaProjects\\WheelOfFortune\\src\\Phrases",true);
                         BufferedWriter bw = new BufferedWriter(writer)) {

                        bw.write(word+"\n");
                    } catch (IOException e1) {
                        System.err.format("IOException: %s%n", e1);
                    }

                }
            }
        });
        add.setMinWidth(80);
        add.setMinHeight(30);
        add.setFont(Font.font("Cambria", FontWeight.BOLD, FontPosture.REGULAR, 23));


        vb.setSpacing(10);
        vb.setAlignment(Pos.TOP_CENTER);
        vb.getChildren().addAll(lrBut, rlBut,add);

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(6));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
       // ColumnConstraints col1 =new ColumnConstraints(100,100,Double.MAX_VALUE);
       // ColumnConstraints col2 =new ColumnConstraints(30);
       // ColumnConstraints col3 =new ColumnConstraints(100,100,Double.MAX_VALUE);
       // col1.setHgrow(Priority.ALWAYS);
       // col3.setHgrow(Priority.ALWAYS);
       // gridPane.getColumnConstraints().addAll(col1, col2, col3);


        BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\aysen\\IdeaProjects\\WheelOfFortune\\src\\Phrases"));
        String s;
        while((s =br.readLine())!=null)

            {
            if (!s.equals("")) {
                  right.add(s);
                        }
                    }
        br.close();
        rview=new ListView<>(right);
        lview =new ListView<>(left);
        rview.setStyle(
                "-fx-font-size: 18 px;" +
                "-fx-font-family: 'SketchFlow Print';" +
                "-fx-control-inner-background: #c7ecee;-fx-text-fill: white;-fx-border-color: #3a8029");
        lview.setStyle(
                "-fx-font-size: 18 px; -fx-font-family: 'SketchFlow Print'; -fx-control-inner-background: #c7ecee;-fx-border-color: #3a8029");
        gridPane.add(lview,1,1);
        gridPane.add(rview,3,1);
        gridPane.add(vb,2,1);
        gridPane.add(newGame,2,3);

        root.setCenter(gridPane);
        root.setTop(hbox);
        BorderPane.setAlignment(hbox,Pos.TOP_CENTER);
        primaryStage.setResizable(false);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

}

