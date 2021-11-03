package test;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.MultipleSelectionModel;
import javafx.scene.control.TextField;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;


public
class test
        extends Application {
    ObservableList<String> heros;

    @Override
    public void start(Stage primaryStage) throws Exception {
        BufferedReader in = new BufferedReader(new FileReader("C:\\Users\\aysen\\IdeaProjects\\WheelOfFortune\\src\\Phrases"));
        String s;
        heros= FXCollections.observableArrayList();

        while((s = in.readLine()) != null ){
            if(!s.equals("")){
                heros.add(s);}
        }
        in.close();

        ObservableList<String> candidates = FXCollections.observableArrayList();

        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 640, 480);

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setPrefHeight(Double.MAX_VALUE);

        ColumnConstraints column1 = new ColumnConstraints(150, 150, Double.MAX_VALUE);
        ColumnConstraints column2 = new ColumnConstraints(50);
        ColumnConstraints column3 = new ColumnConstraints(150, 150, Double.MAX_VALUE);

        column1.setHgrow(Priority.ALWAYS);
        column3.setHgrow(Priority.ALWAYS);

        gridPane.getColumnConstraints().addAll(column1, column2, column3);

        ListView<String> candidateListView = new ListView<>(candidates);
        gridPane.add(candidateListView, 0, 1);

        ListView<String> herosListView = new ListView<>(heros);
        gridPane.add(herosListView, 2, 1);

        Button sendRight = new Button(">");
        Button sendLeft = new Button("<");
        Button add=new Button("add");
        Button delete=new Button("del");
        Button clearall = new Button("AC");
        sendRight.setOnAction(
                (ActionEvent e) -> {
                    String potential = candidateListView.getSelectionModel().getSelectedItem();
                    if (potential != null) {
                        candidateListView.getSelectionModel().clearSelection();
                        candidates.remove(potential);
                        //heros.add(potential);
                    }
                }
        );

        sendLeft.setOnAction(
                (ActionEvent e) -> {
                    String potential = herosListView.getSelectionModel().getSelectedItem();
                    if (potential != null&&!candidates.contains(potential)) {
                        herosListView.getSelectionModel().clearSelection();
                        //heros.remove(potential);
                        candidates.add(potential);
                    }
                }
        );
        add.setOnAction(e->{
            Stage addstage= new Stage();
            BorderPane root2=new BorderPane();
            Scene scene2 = new Scene(root2,150,150);
            GridPane gridPane1=new GridPane();
            TextField textField=new TextField();
            Button add2=new Button("add2");
            gridPane1.setPadding(new Insets(10));
            gridPane1.setHgap(10);
            gridPane1.setVgap(10);
            gridPane1.setPrefHeight(Double.MAX_VALUE);

            add2.setOnAction(event->{
                String text=textField.getText();
                try (FileWriter writer = new FileWriter("C:\\Users\\aysen\\IdeaProjects\\WheelOfFortune\\src\\Phrases",true);
                     BufferedWriter bw = new BufferedWriter(writer)) {

                    bw.write(text+"\n");
                    heros.add(text);
                } catch (IOException e1) {
                    System.err.format("IOException: %s%n", e1);
                }
                textField.setText("");
                addstage.getScene().getWindow().hide();
            });

            VBox vBox = new VBox(5);
            vBox.getChildren().addAll(textField,add2);
            gridPane1.add(vBox, 1, 1);

            root2.setCenter(gridPane1);
            addstage.setScene(scene2);
            addstage.show();

        });
        delete.setOnAction(event -> {
            String deleteVal=herosListView.getSelectionModel().getSelectedItem();
            herosListView.getSelectionModel().clearSelection();
            heros.remove(deleteVal);

            /*heros.clear();



            BufferedReader in2 = null;
            try {
                in2 = new BufferedReader(new FileReader("C:\\Users\\andre\\LET_THE_HELL_BEGIN\\src\\useful_files\\words"));
                String string;

            while((string = in2.readLine()) != null ){
                try (
                     BufferedWriter bw1 = new BufferedWriter(new FileWriter("C:\\Users\\andre\\LET_THE_HELL_BEGIN\\src\\useful_files\\words",true))) {
                    if(string.equals(deleteVal)){
                        continue;
                    }else{
                        bw1.write("");

                    }



                } catch (IOException e1) {
                    System.err.format("IOException: %s%n", e1);
                }

                *//*if(!string.equals("")){
                    heros.add(string);}*//*

            }
                while((string = in2.readLine()) != null ){

                    if(!string.equals("")){
                    heros.add(string);}
                }

            in2.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }*/

            /*List<String> lines = FileUtils.readLines(file);
            List<String> updatedLines = lines.stream().filter(s -> !s.contains(searchString)).collect(Collectors.toList());
            FileUtils.writeLines(file, updatedLines, false);*/

            File file=new File("C:\\Users\\aysen\\IdeaProjects\\WheelOfFortune\\src\\Phrases");
            List<String> out = null;
            try {
                out = Files.lines(file.toPath())
                        .filter(line -> !line.contains(deleteVal))
                        .collect(Collectors.toList());
                Files.write(file.toPath(), out, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
                heros.removeAll(deleteVal);
                herosListView.refresh();
            } catch (IOException e) {
                e.printStackTrace();
            }
            /*heros.clear();
            try {
                BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\andre\\LET_THE_HELL_BEGIN\\src\\useful_files\\words"));
                String str;

                while((str = br.readLine()) != null ){
                    if(!str.equals("")){
                        heros.add(str);}
                }
                in.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }*/



            /*File inputFile = new File("C:\\Users\\andre\\LET_THE_HELL_BEGIN\\src\\useful_files\\words");
            File tempFile = new File("myTempFile.txt");
BufferedReader reader = null;
            try {
                reader = new BufferedReader(new FileReader(inputFile));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            BufferedWriter writer = null;
            try {
                writer = new BufferedWriter(new FileWriter(tempFile));

                String string=null;

                while(( string= reader.readLine()) != null) {
                    // trim newline when comparing with lineToRemove
                    String trimmedLine = deleteVal.trim();
                    if(trimmedLine.equals(deleteVal)) continue;
                    writer.write(string + System.getProperty("line.separator"));
                }
                writer.close();
                reader.close();
                //boolean successful = tempFile.renameTo(inputFile);
            } catch (IOException e) {
                e.printStackTrace();
            }*/

        });

        clearall.setOnAction(e->{
            Random random =new Random();
            int randomval=random.nextInt(candidates.size());
            String randomstr=candidates.get(randomval);
            System.out.println(randomstr);
        });

        VBox vBox = new VBox(5);
        vBox.getChildren().addAll(sendRight, sendLeft,add,delete,clearall);
        gridPane.add(vBox, 1, 1);

        root.setCenter(gridPane);

        primaryStage.setScene(scene);
        primaryStage.show();

        Task<Boolean> worker = new Task<Boolean>(){
            protected  Boolean call() throws Exception{

                return true;
            }
        };

        Executors.newFixedThreadPool(1).submit(
                worker
        );

    }

    public static void main(String[] args) {
        launch(args);
    }
}
