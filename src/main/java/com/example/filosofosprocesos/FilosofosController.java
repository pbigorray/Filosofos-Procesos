package com.example.filosofosprocesos;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class FilosofosController {
    @FXML
    private Label filosofo1;
    @FXML
    private Label filosofo2;
    @FXML
    private Label filosofo3;
    @FXML
    private Label filosofo4;
    @FXML
    private Label filosofo5;

    @FXML
    private Label tenedor1;
    @FXML
    private Label tenedor2;
    @FXML
    private Label tenedor3;
    @FXML
    private Label tenedor4;
    @FXML
    private Label tenedor5;



    @FXML
    protected void onHelloButtonClick() {

        Tenedor t1=new Tenedor(tenedor1,1);
        Tenedor t2=new Tenedor(tenedor2,2);
        Tenedor t3=new Tenedor(tenedor3,3);
        Tenedor t4=new Tenedor(tenedor4,4);
        Tenedor t5=new Tenedor(tenedor5,5);



        Thread f1 = new Thread(new Filosofo(filosofo1,1,t1,t5));
        Thread f2 = new Thread(new Filosofo(filosofo2,2,t2,t1));
        Thread f3 = new Thread(new Filosofo(filosofo3,3,t3,t2));
        Thread f4 = new Thread(new Filosofo(filosofo4,4,t4,t3));
        Thread f5 = new Thread(new Filosofo(filosofo5,5,t5,t4));



        f1.start();
        f2.start();
        f3.start();
        f4.start();
        f5.start();
    }
}