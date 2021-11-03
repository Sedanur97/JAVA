import javafx.animation.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.io.*;
import java.util.ArrayList;
import java.util.Optional;


public class NewGame extends Application {

    int value;
    Group group = new Group();
    String iii;
    Label[] array;
    BorderPane root = new BorderPane();
    static int chance = 3;
    GridPane gp = new GridPane();
    Circle c1 = new Circle(15, 15, 15);
    Circle c2 = new Circle(15, 15, 15);
    Circle c3 = new Circle(15, 15, 15);
    static int score = 0;
    Label labelingo = new Label();
    Button back = new Button("\u2190 " + " Settings ");
    String upper;
    Stage stage;
    Scene scene = new Scene(root, 685, 650);
    int count = 0;
    int point = 0;
    Text[] textar = new Text[10];
    int end;
    int start;
    int from;
    ArrayList<Character> chararray = new ArrayList<>();
    TextInputDialog dialog = new TextInputDialog();
    Media media3;
    Media media4;
    Media media5;
    Media media6;
    Media media7;
    Media media8;




    @Override
    public void start(Stage primaryStage) throws Exception {
        upper = iii.toUpperCase();
        //System.out.println(upper);
        stage = primaryStage;


        Label label = new Label();
        label.setPrefHeight(100);
        label.setText(upper);

        label.setFont(new Font("Cambria", 34));

        labelingo.setText(" SCORE : " + score);
        labelingo.setFont(Font.font("Cambria", FontWeight.BOLD, FontPosture.REGULAR, 23));
        labelingo.setAlignment(Pos.CENTER);

        back.setFont(Font.font("Cambria", 16));


        HBox hbox = new HBox(10);
        hbox.setAlignment(Pos.CENTER);

        array = new Label[upper.length()];

        Background bg = new Background(new BackgroundFill(Color.MAGENTA, CornerRadii.EMPTY, Insets.EMPTY));
        for (int i = 0; i < upper.length(); i++) {

            array[i] = new Label("  " + upper.charAt(i));
            array[i].setPrefSize(38, 38);
            array[i].setBackground(bg);
            array[i].setFont(Font.font("Cambria", FontWeight.BOLD, FontPosture.REGULAR, 25));
            array[i].setTextFill(Color.rgb(255, 255, 255, 0));
            hbox.getChildren().add(array[i]);
        }

        Polygon triangle = new Polygon();
        triangle.getPoints().addAll(
                0.0, 0.0, 25.0, 12.5, 0.0, 25.0);


        group.resize(300, 300);


        Text tf1 = new Text(180, -10, "1\n0\n0");
        tf1.setFont(Font.font("Cambria", FontWeight.BOLD, FontPosture.REGULAR, 23));
        // tf1.setX(180);
        // tf1.setY(-10);
        tf1.setRotate(75);
        textar[5] = tf1;
        Text tf2 = new Text(-37, -90, "2\n0\n0");
        tf2.setFont(Font.font("Cambria", FontWeight.BOLD, FontPosture.REGULAR, 23));
        tf2.setRotate(-35);
        textar[2] = tf2;
        Text tf3 = new Text(46, 175, "3\n0\n0");
        tf3.setFont(Font.font("Cambria", FontWeight.BOLD, FontPosture.REGULAR, 23));
        tf3.setRotate(180);
        textar[8] = tf3;
        Text tf4 = new Text(44, -115, "4\n0\n0");
        tf4.setFont(Font.font("Cambria", FontWeight.BOLD, FontPosture.REGULAR, 23));
        tf4.setRotate(0);
        textar[3] = tf4;
        Text tf5 = new Text(177, 76, "5\n0\n0");
        tf5.setFont(Font.font("Cambria", FontWeight.BOLD, FontPosture.REGULAR, 23));
        tf5.setRotate(110);
        textar[6] = tf5;
        Text tf6 = new Text(-43, 148, "6\n0\n0");
        tf6.setFont(Font.font("Cambria", FontWeight.BOLD, FontPosture.REGULAR, 23));
        tf6.setRotate(-145);
        textar[9] = tf6;
        Text tf7 = new Text(126, 144, "7\n0\n0");
        tf7.setFont(Font.font("Cambria", FontWeight.BOLD, FontPosture.REGULAR, 23));
        tf7.setRotate(143);
        textar[7] = tf7;
        Text tf8 = new Text(133, -85, "8\n0\n0");
        tf8.setFont(Font.font("Cambria", FontWeight.BOLD, FontPosture.REGULAR, 23));
        tf8.setRotate(40);
        textar[4] = tf8;
        Text tf9 = new Text(-93, -10, "9\n0\n0");
        tf9.setFont(Font.font("Cambria", FontWeight.BOLD, FontPosture.REGULAR, 23));
        tf9.setRotate(-70);
        textar[1] = tf9;
        Text bnkrpt = new Text("B\nA\nN\nK\nR\nU\nP\nT");
        bnkrpt.setX(-60);
        bnkrpt.setY(20);
        bnkrpt.setRotate(-110);
        bnkrpt.setFont(Font.font("Cambria", FontWeight.BOLD, FontPosture.REGULAR, 17));
        textar[0] = bnkrpt;
        back.setOnAction(new EventHandler<ActionEvent>() {

            Stage stage4 = new Stage();

            @Override
            public void handle(ActionEvent event) {

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("settings");
                alert.setHeaderText("Do you want to quit?");
                alert.setContentText("If you turn back to the settings , the game will end.");

                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK){
                   // primaryStage.getScene().getWindow().hide();
                    primaryStage.close();
                    try {
                        chararray.removeAll(chararray);
                        new Settings().start(stage4);
                    } catch (Exception exp) {
                        exp.printStackTrace();
                    }
                } else {

                }


            }
        });

        Arc p1 = new Arc(50.0f, 50, 200, 200, 0, 36);
        p1.setFill(Color.LIGHTGREEN);
        p1.setType(ArcType.ROUND);
        Arc p2 = new Arc(50, 50, 200, 200, 36, 36);
        p2.setFill(Color.LIGHTBLUE);
        p2.setType(ArcType.ROUND);
        Arc p3 = new Arc(50, 50, 200, 200, 72, 36);
        p3.setFill(Color.BLUE);
        p3.setType(ArcType.ROUND);
        Arc p4 = new Arc(50, 50, 200, 200, 108, 36);
        p4.setFill(Color.MAGENTA);
        p4.setType(ArcType.ROUND);
        Arc p5 = new Arc(50, 50, 200, 200, 144, 36);
        p5.setFill(Color.rgb(255, 0, 171));
        p5.setType(ArcType.ROUND);
        Arc p6 = new Arc(50, 50, 200, 200, 180, 36);
        p6.setFill(Color.RED);
        p6.setType(ArcType.ROUND);
        Arc p7 = new Arc(50, 50, 200, 200, 216, 36);
        p7.setFill(Color.DARKORANGE);
        p7.setType(ArcType.ROUND);
        Arc p8 = new Arc(50, 50, 200, 200, 252, 36);
        p8.setFill(Color.YELLOW);
        p8.setType(ArcType.ROUND);
        Arc p9 = new Arc(50, 50, 200, 200, 288, 36);
        p9.setFill(Color.BROWN);
        p9.setType(ArcType.ROUND);
        Arc p10 = new Arc(50, 50, 200, 200, 324, 36);
        p10.setFill(Color.GREEN);
        p10.setType(ArcType.ROUND);


        Button spin = new Button(" LET'S BEGIN ! ");
        spin.setFont(new Font("Cambria", 25));
        spin.setTextFill(Color.rgb(255, 0, 171));
        spin.setFont(Font.font("Cambria", FontWeight.BOLD, FontPosture.REGULAR, 23));


        spin.setOnAction(e -> {
            spintheWheel();
        });
        HBox ball = new HBox(10);

        c1.setStroke(Color.BLACK);
        c1.setStrokeWidth(3);

        c2.setStroke(Color.BLACK);
        c2.setStrokeWidth(3);

        c3.setStroke(Color.BLACK);
        c3.setStrokeWidth(3);
        ball.getChildren().addAll(c1, c2, c3);
        ball.setAlignment(Pos.CENTER);

        BorderPane.setAlignment(hbox, Pos.CENTER);
        BorderPane.setAlignment(spin, Pos.BOTTOM_CENTER);


        try {
            group.getChildren().addAll(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8, tf9, bnkrpt);

            gp.setPadding(new Insets(6));
            gp.setHgap(10);
            gp.setVgap(10);
            gp.setHalignment(spin, HPos.CENTER);
            gp.setHalignment(ball, HPos.CENTER);
            gp.setHalignment(labelingo, HPos.CENTER);
            gp.setHalignment(triangle, HPos.RIGHT);
            gp.add(triangle, 1, 5);
            gp.add(hbox, 3, 1);
            gp.add(group, 3, 5);
            gp.add(spin, 3, 8);
            gp.add(ball, 3, 6);
            gp.add(labelingo, 3, 3);
            gp.add(back, 1, 1);
            // gp.add(canvas,12,9);4
            primaryStage.setResizable(false);
           // gp.setGridLinesVisible(true);
        } catch (Exception error) {
            group.getChildren().removeAll(p1, p2, p3, p4, p5, p6, p7, p8, p9, p10, tf1, tf2, tf3, tf4, tf5, tf6, tf7, tf8, tf9, bnkrpt);
        }

    /*    ColumnConstraints col1 =new ColumnConstraints(100,100,Double.MAX_VALUE);
        ColumnConstraints col2 =new ColumnConstraints(30);
        ColumnConstraints col3 =new ColumnConstraints(100,100,Double.MAX_VALUE);
        col1.setHgrow(Priority.ALWAYS);
        col3.setHgrow(Priority.ALWAYS);
        gp.getColumnConstraints().addAll(col1, col2, col3);*/
       /* root.setCenter(group);
        root.setBottom(spin);
        root.setTop(hbox);
        root.setLeft(rec);*/
        root.setCenter(gp);


        primaryStage.setScene(scene);
        primaryStage.setTitle("  LET'S PLAY!!! ");
        primaryStage.show();
    }


    void spintheWheel() {
        String path2 ="C:\\Users\\aysen\\Downloads\\wheel.mp3";
        Media media2 = new Media(new File(path2).toURI().toString());
        MediaPlayer mediaPlayer2 = new MediaPlayer(media2);
        mediaPlayer2.setAutoPlay(true);

        Timeline timeline = new Timeline();
        //timeline.setCycleCount(Timeline.INDEFINITE);
        //timeline.setRate(3);
        timeline.setAutoReverse(false);
        value += (int) (1600 + (Math.random()) * 800);
        KeyFrame kf = new KeyFrame(
                Duration.seconds(4),
                new KeyValue(group.rotateProperty(), value, Interpolator.EASE_OUT)
                //new KeyValue( arc.fillProperty(), Color.BLUE)
        );
        start = 0;
        from = value % 360;
        end = start - from / 36;
        if (end < 0) {

            end = textar.length + end;

        }
        //System.out.println(textar[end]);
        //System.out.println(value);

        timeline.getKeyFrames().addAll(kf);
        timeline.playFromStart();
        timeline.setOnFinished(new EventHandler<ActionEvent>() {
                                   @Override
                                   public void handle(ActionEvent event) {

                                      // mediaPlayer2.setMute(true);
                                        mediaPlayer2.stop();
                                       //System.out.println(" finished ");

                                       Platform.runLater(NewGame.this::dialogshow);
                                       if (textar[end] == textar[1]) {
                                           point = 900;
                                          // System.out.println(point);
                                       } else if (textar[end] == textar[2]) {
                                           point = 200;
                                           //System.out.println(point);
                                       } else if (textar[end] == textar[3]) {

                                           point = 400;
                                          // System.out.println(point);
                                       } else if (textar[end] == textar[4]) {
                                           point = 800;
                                          // System.out.println(point);
                                       } else if (textar[end] == textar[5]) {
                                           point = 100;
                                           //System.out.println(point);
                                       } else if (textar[end] == textar[6]) {
                                           point = 500;
                                          // System.out.println(point);
                                       } else if (textar[end] == textar[7]) {
                                           point = 700;
                                          // System.out.println(point);
                                       } else if (textar[end] == textar[8]) {
                                           point = 300;
                                           //System.out.println(point);
                                       } else if (textar[end] == textar[9]) {
                                           point = 600;
                                          // System.out.println(point);
                                       } else if (textar[end] == textar[0]) {
                                           score = 0;
                                          // System.out.println(point);
                                           labelingo.setText(" SCORE : " + score);

                                           String path3 ="C:\\Users\\aysen\\Downloads\\bankrupt.mp3";
                                           media3 = new Media(new File(path3).toURI().toString());
                                           MediaPlayer mediaPlayer3 = new MediaPlayer(media3);
                                           mediaPlayer3.setAutoPlay(true);


                                       }
                                   }
                               }
        );
    }


    private void dialogshow() {

        // dialog.show();
        dialog.setContentText("Please enter a letter: ");
        dialog.setTitle(" Letter ");
        dialog.setHeaderText("New Letter");

        if(textar[end]==textar[0]){
         /*   Alert alert3 = new Alert(Alert.AlertType.WARNING);
            alert3.setTitle("Ups!");
            alert3.setHeaderText(" maybe next ");
            alert3.setContentText("  Please try another letter. ");
            alert3.showAndWait();*/

        }else{
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()) {
            String letter = result.get();
            if (letter.length() > 1) {
                Alert alert3 = new Alert(Alert.AlertType.WARNING);
                alert3.setTitle("Ups!!");
                alert3.setHeaderText("please enter only a letter");
                alert3.setContentText(" not more than a letter .");
                alert3.showAndWait();
            } else {

                String upp = letter.toUpperCase();

                int say = 0;

                if (upper.contains(upp)) {
                    char let = upp.charAt(0);
                    if (!chararray.contains(let)) {


                        chararray.add(let);

                        for (int i = 0; i < upper.length(); i++) {
                            if (upper.charAt(i) == let) {

                                count++;
                                // int index = upper.indexOf(let);
                                String path4 = "C:\\Users\\aysen\\Downloads\\word.mp3";
                                media4 = new Media(new File(path4).toURI().toString());
                                MediaPlayer mediaPlayer4 = new MediaPlayer(media4);
                                mediaPlayer4.setAutoPlay(true);
                                array[i].setTextFill(Color.rgb(255, 255, 255, 1));
                            }


                        }

                        this.score += point * count;
                        labelingo.setText(" SCORE : " + score);
                    } else {
                        Alert alert2 = new Alert(Alert.AlertType.WARNING);
                        alert2.setTitle("Ups!");
                        alert2.setHeaderText(" You have already tried that letter. ");
                        alert2.setContentText("  Please try another letter. ");
                        alert2.showAndWait();
                    }

                } else {
                    chance--;
                    switch (chance) {
                        case 2:
                            String path5 = "C:\\Users\\aysen\\Downloads\\wrong.mp3";
                            media5 = new Media(new File(path5).toURI().toString());
                            MediaPlayer mediaPlayer5 = new MediaPlayer(media5);
                            mediaPlayer5.setAutoPlay(true);
                            c1.setFill(Color.RED);
                            break;
                        case 1:
                            String path6 = "C:\\Users\\aysen\\Downloads\\wrong.mp3";
                            media6 = new Media(new File(path6).toURI().toString());
                            MediaPlayer mediaPlayer6 = new MediaPlayer(media6);
                            mediaPlayer6.setAutoPlay(true);
                            c2.setFill(Color.RED);
                            break;
                        case 0:
                           /* String path9 ="C:\\Users\\aysen\\Downloads\\wrong.mp3";
                            Media media9 = new Media(new File(path9).toURI().toString());
                            MediaPlayer mediaPlayer9 = new MediaPlayer(media9);
                            mediaPlayer9.setAutoPlay(true);*/

                            c3.setFill(Color.RED);
                            break;
                    }

                    if (chance == 0) {
                        try {

                            String path7 = "C:\\Users\\aysen\\Downloads\\fail.mp3";
                            media7 = new Media(new File(path7).toURI().toString());
                            MediaPlayer mediaPlayer7 = new MediaPlayer(media7);
                            mediaPlayer7.setAutoPlay(true);
                            Image image1 = new Image(new FileInputStream("C:\\Users\\aysen\\IdeaProjects\\WheelOfFortune\\src\\transparent-sad-rain-cloud-6.gif"));
                            ImageView imageView1 = new ImageView(image1);

                            imageView1.setY(-50);
                            imageView1.setX(-100);
                            imageView1.setFitWidth(650);
                            imageView1.setFitHeight(595);
                            imageView1.setPreserveRatio(true);
                            TranslateTransition transition = new TranslateTransition();
                            transition.setDuration(Duration.seconds(2));
                            /*transition.setFromX(60);
                            transition.setFromY(700);
                            transition.setToX(60);
                            transition.setToY(0);*/
                            transition.setToX(250);
                            transition.setToY(0);
                            transition.setAutoReverse(true);
                            transition.setNode(imageView1);
                            transition.setCycleCount(Animation.INDEFINITE);
                            transition.play();
                            gp.add(imageView1, 0, 0, 10, 10);

                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }


                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Sorry but ... ");
                        alert.setHeaderText("  OUT OF CHANCE :( ");
                        alert.setContentText("  Please try again  ... ");

                        alert.showAndWait();

                        Stage newstage1 = new Stage();
                        stage.getScene().getWindow().hide();
                        try {
                            new Settings().start(newstage1);
                        } catch (Exception exp) {
                            exp.printStackTrace();
                        }

                        //stage.close();
                    }
                }
                count = 0;
                for (int i = 0; i < upper.length(); i++) {

                    if (array[i].getTextFill().isOpaque()) {
                        say++;
                    }

                    if (say == upper.length()) {

                        try {
                            Image image = new Image(new FileInputStream("C:\\Users\\aysen\\IdeaProjects\\WheelOfFortune\\src\\moneyy.gif"));
                            ImageView imageView = new ImageView(image);
                            imageView.setX(-100);
                            imageView.setY(-50);

                            imageView.setFitHeight(560);
                            imageView.setFitWidth(600);
                            imageView.setPreserveRatio(true);
                            TranslateTransition transition = new TranslateTransition();
                            transition.setDuration(Duration.seconds(2));
                            transition.setToX(250);
                            transition.setToY(0);
                            transition.setAutoReverse(true);
                            transition.setCycleCount(Animation.INDEFINITE);
                            transition.setNode(imageView);
                            transition.play();
                            gp.add(imageView, 0, 0, 10, 10);

                        } catch (FileNotFoundException e) {
                            e.printStackTrace();
                        }

                        //imageView.setImage(new Image(this.getClass().getResource("C:\\Users\\aysen\\IdeaProjects\\WheelOfFortune\\src\\moneyy.gif").toExternalForm()));
                        //gp.add(imageView,2,3,2,3);
                        System.out.println("you winnn !!!");

                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
                        alert.setTitle("winner");
                        alert.setHeaderText(" CONGRATULATIONS !!!!!!");
                        alert.setContentText(" YOUR SCORE : " + score);

                        String path8 = "C:\\Users\\aysen\\Downloads\\alkis.mp3";
                        media8 = new Media(new File(path8).toURI().toString());
                        MediaPlayer mediaPlayer8 = new MediaPlayer(media8);
                        mediaPlayer8.setAutoPlay(true);

                        alert.showAndWait();

                        Stage newstage = new Stage();
                        stage.getScene().getWindow().hide();
                        try {
                            new Settings().start(newstage);
                        } catch (Exception exp) {
                            exp.printStackTrace();
                        }


                    }
                }
            }

                dialog.getEditor().setText("");
            }else {
            dialog.getEditor().setText("");
            }

        }

    }
}
