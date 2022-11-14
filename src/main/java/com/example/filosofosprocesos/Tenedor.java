package com.example.filosofosprocesos;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;

public class Tenedor extends Task<Color> {
    private Label tenedor;
    private int id;
    private boolean cogido;

    public Tenedor(Label tenedor,int id) {
        this.tenedor = tenedor;
        this.id=id;
        this.cogido = false;

        valueProperty().addListener(new ChangeListener<Color>() {
            @Override
            public void changed(ObservableValue<? extends Color> observableValue, Color color, Color t1) {
                tenedor.setBackground(new Background(new BackgroundFill(t1, new CornerRadii(0), new Insets(0))));
            }
        });
        setRed();
    }

    public  boolean coger(){
        if (!isCogido()){
            cogido=true;
            System.out.println("tenedor cogido "+ id+ "cogido="+cogido);
            return true;
        }
        return false;

    }

    public  boolean isCogido() {
        System.out.println("esta cogido?? "+cogido);
        return cogido;
    }
    public  void soltar() {
        cogido=false;
        System.out.println("soltado "+id);
    }

    public synchronized void setRed(){
        updateValue(Color.RED);
    }
    public synchronized void setGreen(){
        updateValue(Color.GREEN);
    }
    public synchronized void setOrange(){
        updateValue(Color.ORANGE);
    }
    public synchronized void setWhite(){
        updateValue(Color.WHITE);
    }

    public synchronized int getId() {
        return id;
    }
    @Override
    protected Color call() throws Exception {
        return null;
    }
}
