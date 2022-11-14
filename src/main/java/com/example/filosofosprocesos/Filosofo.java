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

public class Filosofo extends Task<Color> {
    private Label filosofo;
    private Tenedor tenedor1,tenedor2;
    private int id;
    int comida=10;
    public Filosofo(Label filosofo,int id,Tenedor tenedor1,Tenedor tenedor2) {
        this.filosofo=filosofo;
        this.tenedor1=tenedor1;
        this.tenedor2=tenedor2;
        this.id=id;

        valueProperty().addListener(new ChangeListener<Color>() {
            @Override
            public void changed(ObservableValue<? extends Color> observableValue, Color color, Color t1) {
                filosofo.setBackground(new Background(new BackgroundFill(t1, new CornerRadii(0), new Insets(0))));
            }
        });
    }


    @Override
    protected Color call() throws Exception {
        while (comida>0){
            setWhite();
            if(tenedor1.coger()){
                setOrange();
                tenedor1.setOrange();
                Thread.sleep(200);
                System.out.println("Tenedor"+tenedor1.getId()+" cogido por "+id);

                if (tenedor2.coger()){
                    setGreen();
                    tenedor1.setGreen();
                    tenedor2.setGreen();
                    System.out.println("Tenedor"+tenedor2.getId()+" cogido por"+id);
                    comida--;
                    Thread.sleep(200);
                    try {
                        tenedor1.soltar();
                        tenedor2.soltar();
                        tenedor1.setWhite();
                        tenedor2.setWhite();
                        setRed();
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else {
                    setWhite();
                    tenedor1.soltar();
                }
            }else {
                setWhite();
                tenedor1.soltar();
            }
        }
        return  null;
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
}
