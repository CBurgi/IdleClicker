/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idleclicker;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

/**
 *
 * @author s201066866
 */
public class IdleClickerDay1 extends Application {

    TextArea text;
    
    Button clickAddBtn = new Button();
    Button click = new Button();
    Button autoClick1Btn = new Button(); 
    Button autoClick2Btn = new Button(); 
    Button autoClick3Btn = new Button(); 
    Button autoClick4Btn = new Button(); 
    Button autoClick5Btn = new Button(); 
    Button autoClick6Btn = new Button(); 
    
    Button perk1Btn = new Button(); //
    Button perk2Btn = new Button(); //
    Button perk3Btn = new Button(); //
    Button perk4Btn = new Button(); //
    Button perk5Btn = new Button(); //
    
    Button clear = new Button();
    
    Rectangle winRec = new Rectangle(0, 0, 600, 450);
    
    Rectangle cursor = new Rectangle(300, 370, 10, 60);

    String clickName = "Clicks";
    double clicks = 0;
    double clickAmount = 1;
    double clickAmountReal = 1;

    Label clickLabel = new Label(clicks + " " + clickName);

    Label clickAddsLabel = new Label("0 clickAdds");

    int clickAdds = 0;
    double clickAddsPrice = 10;

    int autoClick1 = 0; 
    double autoClick1Price = 40; 
    double autoClick1Amount = 1; 
    long autoClick1Time = 2000; 
    int autoClick1Upgrade = 0; 
    
    int autoClick2 = 0; 
    double autoClick2Price = 100; 
    double autoClick2Amount = 4; 
    long autoClick2Time = 5000; 
    int autoClick2Upgrade = 0; 
    
    int autoClick3 = 0; 
    double autoClick3Price = 500; 
    double autoClick3Amount = 10; 
    long autoClick3Time = 10000; 
    int autoClick3Upgrade = 0; 
    
    int autoClick4 = 0; 
    double autoClick4Price = 2500; 
    double autoClick4Amount = 30; 
    long autoClick4Time = 20000; 
    int autoClick4Upgrade = 0; 
    
    int autoClick5 = 0; 
    double autoClick5Price = 4000; 
    double autoClick5Amount = 50; 
    long autoClick5Time = 30000; 
    int autoClick5Upgrade = 0; 
    
    int autoClick6 = 0; 
    double autoClick6Price = 500000; 
    double autoClick6Amount = 100; 
    long autoClick6Time = 40000; 
    int autoClick6Upgrade = 0; 
    
    
    int perk1 = 0;//
    int perk1Price = 1000;//
    int perk1Level = 1;//
    
    int perk2 = 0;//
    int perk2Price = 10000;//
    int perk2Level = 1;//
    
    int perk3 = 0;//
    int perk3Price = 100000;//
    int perk3Level = 1;//
    
    int perk4 = 0;//
    int perk4Price = 1000000;//
    int perk4Level = 1;//
    
    int perk5 = 0;//
    int perk5Price = 1000000000;//
    
    boolean cursorL;
    
    Label autoClick1Label = new Label("0 autoClick1s"); 
    Label autoClick2Label = new Label("0 autoClick2s"); 
    Label autoClick3Label = new Label("0 autoClick3s"); 
    Label autoClick4Label = new Label("0 autoClick4s"); 
    Label autoClick5Label = new Label("0 autoClick5s"); 
    Label autoClick6Label = new Label("0 autoClick6s"); 
    
        Rectangle line1 = new Rectangle(210, 49, 400, 2);
        Rectangle line2 = new Rectangle(210, 99, 400, 2); 
        Rectangle line3 = new Rectangle(210, 149, 400, 2); 
        Rectangle line4 = new Rectangle(0, 199, 600, 2); 
        Rectangle line5 = new Rectangle(0, 249, 600, 2); 
        Rectangle line6 = new Rectangle(0, 299, 600, 2); 
        Rectangle line7 = new Rectangle(0, 349, 600, 2); 
        Rectangle line8 = new Rectangle(0, 399, 210, 2); 
        Rectangle line9 = new Rectangle(0, 449, 600, 2); 
        Rectangle midVert = new Rectangle(209, 0, 2, 500);
        
    Label perk1Label = new Label("Click Cost Cutter " + perk1Level); //
    Label perk2Label = new Label("Efecency " + perk2Level); //
    Label perk3Label = new Label("Better Buying " + perk3Level); //
    Label perk4Label = new Label("Stronger Clickers " + perk4Level); //
    Label perk5Label = new Label("Become King"); //

    @Override
    public void start(Stage primaryStage) {

        Rectangle ll = new Rectangle(300, 375, 40, 50);
        ll.setFill(Color.LIGHTBLUE);
        Rectangle l = new Rectangle(340, 375, 35, 50);
        l.setFill(Color.BLUE);
        Rectangle ml = new Rectangle(375, 375, 30, 50);
        ml.setFill(Color.ORANGE);
        Rectangle m = new Rectangle(405, 375, 20, 50);
        m.setFill(Color.RED);
        Rectangle mr = new Rectangle(425, 375, 30, 50);
        mr.setFill(Color.ORANGE);
        Rectangle r = new Rectangle(455, 375, 35, 50);
        r.setFill(Color.BLUE);
        Rectangle rr = new Rectangle(490, 375, 40, 50);
        rr.setFill(Color.LIGHTBLUE);
        Rectangle cursorOut = new Rectangle(295, 370, 240, 60);
        cursorOut.setStroke(Color.BLACK);
        
        text = new TextArea();
        String textString = " ";
        
        winRec.setFill(Color.GOLD);
        winRec.setVisible(false);
        
        clickLabel.setLayoutX(80);
        clickLabel.setLayoutY(50);

        click.setText("  + " + clickAmount + "  ");
        click.setLayoutX(80);
        click.setLayoutY(100);

        clickAddBtn.setText(Double.toString(clickAddsPrice));
        clickAddBtn.setLayoutX(230);
        clickAddBtn.setLayoutY(10);

        clickAddsLabel.setLayoutX(450);
        clickAddsLabel.setLayoutY(15);
        
        autoClick1Btn.setText(Double.toString(autoClick1Price)); 
        autoClick1Btn.setLayoutX(230); 
        autoClick1Btn.setLayoutY(60); 

        autoClick1Label.setLayoutX(450); 
        autoClick1Label.setLayoutY(65); 
                
        autoClick2Btn.setText(Double.toString(autoClick2Price)); 
        autoClick2Btn.setLayoutX(230); 
        autoClick2Btn.setLayoutY(110); 

        autoClick2Label.setLayoutX(450); 
        autoClick2Label.setLayoutY(115); 
        
        autoClick3Btn.setText(Double.toString(autoClick3Price)); 
        autoClick3Btn.setLayoutX(230); 
        autoClick3Btn.setLayoutY(160); 

        autoClick3Label.setLayoutX(450); 
        autoClick3Label.setLayoutY(165); 
                
        autoClick4Btn.setText(Double.toString(autoClick4Price)); 
        autoClick4Btn.setLayoutX(230); 
        autoClick4Btn.setLayoutY(210); 

        autoClick4Label.setLayoutX(450); 
        autoClick4Label.setLayoutY(215); 
                
        autoClick5Btn.setText(Double.toString(autoClick5Price)); 
        autoClick5Btn.setLayoutX(230); 
        autoClick5Btn.setLayoutY(260); 

        autoClick5Label.setLayoutX(450); 
        autoClick5Label.setLayoutY(265); 
                
        autoClick6Btn.setText(Double.toString(autoClick6Price)); 
        autoClick6Btn.setLayoutX(230); 
        autoClick6Btn.setLayoutY(310); 

        autoClick6Label.setLayoutX(450); 
        autoClick6Label.setLayoutY(315); 
        
        perk1Btn.setText(Double.toString(perk1Price));//
        perk1Btn.setLayoutX(10); //
        perk1Btn.setLayoutY(210); //

        perk1Label.setLayoutX(100); //
        perk1Label.setLayoutY(215); //
        
        perk2Btn.setText(Double.toString(perk2Price));//
        perk2Btn.setLayoutX(10); //
        perk2Btn.setLayoutY(260); //

        perk2Label.setLayoutX(100); //
        perk2Label.setLayoutY(265); //
        
        perk3Btn.setText(Double.toString(perk3Price));//
        perk3Btn.setLayoutX(10); //
        perk3Btn.setLayoutY(310); //

        perk3Label.setLayoutX(100); //
        perk3Label.setLayoutY(315); //
        
        perk4Btn.setText(Double.toString(perk4Price));//
        perk4Btn.setLayoutX(10); //
        perk4Btn.setLayoutY(360); //

        perk4Label.setLayoutX(100); //
        perk4Label.setLayoutY(365); //
        
        perk5Btn.setText(Double.toString(perk5Price));//
        perk5Btn.setLayoutX(10); //
        perk5Btn.setLayoutY(410); //

        perk5Label.setLayoutX(100); //
        perk5Label.setLayoutY(415); //
        
        clear.setText("Clear");
        clear.setLayoutX(80);
        clear.setLayoutY(150);
        
        try{
            //the file reader defaults to the project directory, not the src folder
            BufferedReader reader = new BufferedReader(new FileReader("score.txt"));
            if(reader.ready()){
                String lineRead = reader.readLine();
                String[] arrayRead = lineRead.split(" ");
                double[] nums = new double[arrayRead.length];
                for(int i = 0; i < arrayRead.length; i++){
                    nums[i] = Double.parseDouble(arrayRead[i]);
                 }
                clicks = nums[0];
                clickAmount = nums[1];
                clickAdds = (int) nums[2];
                clickAddsPrice = nums[3];
                
                autoClick1 = (int) nums[4];
                autoClick1Price = nums[5];
                autoClick1Amount = nums[6];
                autoClick1Time = (long) nums[7];
                autoClick1Upgrade = (int) nums[8];
                
                autoClick2 = (int) nums[9];
                autoClick2Price = nums[10];
                autoClick2Amount = nums[11];
                autoClick2Time = (long) nums[12];
                autoClick2Upgrade = (int) nums[13];
                
                autoClick3 = (int) nums[14];
                autoClick3Price = nums[15];
                autoClick3Amount = nums[16];
                autoClick3Time = (long) nums[17];
                autoClick3Upgrade = (int) nums[18];
                
                autoClick4 = (int) nums[19];
                autoClick4Price = nums[20];
                autoClick4Amount = nums[21];
                autoClick4Time = (long) nums[22];
                autoClick4Upgrade = (int) nums[23];
                
                autoClick5 = (int) nums[24];
                autoClick5Price = nums[25];
                autoClick5Amount = nums[26];
                autoClick5Time = (long) nums[27];
                autoClick5Upgrade = (int) nums[28];
                
                autoClick6 = (int) nums[29];
                autoClick6Price = nums[20];
                autoClick6Amount = nums[31];
                autoClick6Time = (long) nums[32];
                autoClick6Upgrade = (int) nums[33];
                
                perk1 = (int) nums[34];
                perk1Price = (int) nums[35];
                perk1Level = (int) nums[36];
                
                perk2 = (int) nums[37];
                perk2Price = (int) nums[38];
                perk2Level = (int) nums[39];
                
                perk3 = (int) nums[40];
                perk3Price = (int) nums[41];
                perk3Level = (int) nums[42];
                
                perk4 = (int) nums[43];
                perk4Price = (int) nums[44];
                perk4Level = (int) nums[45];
            }
            reader.close();
        }catch(Exception e){
            //System.out.println("E
            
        }
        
        text.setText(textString);
        
        
        checkClickAdds();
        checkAutoClick1();
        checkAutoClick2();
        checkAutoClick3();
        checkAutoClick4();
        checkAutoClick5();
        checkAutoClick6();
        checkPerk1(); //
        checkPerk2(); //
        checkPerk3(); //
        checkPerk4(); //
        checkPerk5(); //
        
        Timer timer1 = new Timer();
        TimerTask task1 = new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(new Runnable() {

                    @Override
                    public void run() {
                        checkClickAdds();
                        checkAutoClick1();
                        checkAutoClick2();
                        checkAutoClick3();
                        checkAutoClick4();
                        checkAutoClick5();
                        checkAutoClick6();
                        checkPerk1(); //
                        checkPerk2(); //
                        checkPerk3(); //
                        checkPerk4(); //
                        checkPerk5(); //
                        
                    }
                });
            }

        };
        timer1.scheduleAtFixedRate(task1, 1000, 100);

        
        Timer autoClick1Timer = new Timer(); 
        TimerTask autoClick1Task = new TimerTask() { 
            @Override
            public void run() {
                clicks = clicks + (autoClick1Amount * autoClick1);
                
                
            }
        };
        autoClick1Timer.scheduleAtFixedRate(autoClick1Task, 0, autoClick1Time); 
        
        Timer autoClick2Timer = new Timer(); 
        TimerTask autoClick2Task = new TimerTask() { 
            @Override
            public void run() {
                clicks = clicks + (autoClick2Amount * autoClick2);
                
                
            }
        };
        autoClick2Timer.scheduleAtFixedRate(autoClick2Task, 0, autoClick2Time); 
        
        Timer autoClick3Timer = new Timer(); 
        TimerTask autoClick3Task = new TimerTask() { 
            @Override
            public void run() {
                clicks = clicks + (autoClick3Amount * autoClick3);
                
                
            }
        };
        autoClick3Timer.scheduleAtFixedRate(autoClick3Task, 0, autoClick3Time); 
                
        Timer autoClick4Timer = new Timer(); 
        TimerTask autoClick4Task = new TimerTask() { 
            @Override
            public void run() {
                clicks = clicks + (autoClick4Amount * autoClick4);
                
                
            }
        };
        autoClick4Timer.scheduleAtFixedRate(autoClick4Task, 0, autoClick4Time); 
        
        Timer autoClick5Timer = new Timer(); 
        TimerTask autoClick5Task = new TimerTask() { 
            @Override
            public void run() {
                clicks = clicks + (autoClick5Amount * autoClick5);
                
                
            }
        };
        autoClick5Timer.scheduleAtFixedRate(autoClick5Task, 0, autoClick5Time); 
        
        Timer autoClick6Timer = new Timer(); 
        TimerTask autoClick6Task = new TimerTask() { 
            @Override
            public void run() {
                clicks = clicks + (autoClick6Amount * autoClick6);
                
                
            }
        };
        autoClick6Timer.scheduleAtFixedRate(autoClick6Task, 0, autoClick6Time); 
        
        Timer minigame = new Timer();
        TimerTask minigameTask = new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(new Runnable() {

                    @Override
                    public void run() {
                        
                        if(cursor.getX() <= 295){
                            cursorL = true;
                            System.out.println("right");
                        }
                        if(cursor.getX() >= 525){
                            cursorL = false;
                            System.out.println("left");
                        }
                        
                        if (cursorL == false){
                            cursor.setX(cursor.getX() - 1);
                        }
                        if (cursorL == true){
                            cursor.setX(cursor.getX() + 1);
                        }
                        
                        if (cursor.getX() >= 290 && cursor.getX() < 335 || cursor.getX() > 485 && cursor.getX() <= 530){
                            clickAmountReal = -clickAmount / 2;
                        }
                        if (cursor.getX() >= 335 && cursor.getX() < 370 || cursor.getX() > 450 && cursor.getX() <= 485){
                            clickAmountReal = clickAmount / 4;
                        }
                        if (cursor.getX() >= 370 && cursor.getX() < 400 || cursor.getX() > 420 && cursor.getX() <= 450){
                            clickAmountReal = clickAmount / 2;
                        }
                        if (cursor.getX() >= 400 && cursor.getX() < 420){
                            clickAmountReal = clickAmount;
                        }
                    }
                });
            }

        };
        minigame.scheduleAtFixedRate(minigameTask, 1000, 5);
        
        
        
        click.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                clicks = clicks + clickAmountReal;

                
                System.out.println(clicks);
            }
        }); 

        clickAddBtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {

                clicks = clicks - clickAddsPrice;
                clickAmount = clickAmount * 1.10;
                clickAddsPrice = clickAddsPrice * 1.5;
                clickAdds++;

                clickAddsLabel.setText(clickAdds + " clickAdds");
            }
        });

        autoClick1Btn.setOnAction(new EventHandler<ActionEvent>() { 

            @Override
            public void handle(ActionEvent event) {

                clicks = clicks - autoClick1Price;
                autoClick1++;

                autoClick1Price = autoClick1Price * 1.5;

                autoClick1Label.setText(autoClick1 + " clickAdds");
                
                autoClick1Upgrade++;
                if(autoClick1Upgrade == 4){
                    autoClick1Time = (long) (autoClick1Time / 1.1);
                    autoClick1Upgrade = 0;
                    System.out.println(autoClick1Time);
                }
            }
        }); 
        
        autoClick2Btn.setOnAction(new EventHandler<ActionEvent>() { 

            @Override
            public void handle(ActionEvent event) {

                clicks = clicks - autoClick2Price;
                autoClick2++;

                autoClick2Price = autoClick2Price * 1.4;

                autoClick2Label.setText(autoClick2 + " clickAdd2s");
                
                autoClick2Upgrade++;
                if(autoClick2Upgrade == 4){
                    autoClick2Time = (long) (autoClick2Time / 1.2);
                    autoClick2Upgrade = 0;
                    System.out.println(autoClick2Time);
                }
            }
        }); 
        
        autoClick3Btn.setOnAction(new EventHandler<ActionEvent>() { 

            @Override
            public void handle(ActionEvent event) {

                clicks = clicks - autoClick3Price;
                autoClick3++;

                autoClick3Price = autoClick3Price * 1.3;

                autoClick3Label.setText(autoClick3 + " clickAdd3s");
                
                autoClick3Upgrade++;
                if(autoClick3Upgrade == 4){
                    autoClick3Time = (long) (autoClick3Time / 1.25);
                    autoClick3Upgrade = 0;
                    System.out.println(autoClick3Time);
                }
            }
        }); 
        
        autoClick4Btn.setOnAction(new EventHandler<ActionEvent>() { 

            @Override
            public void handle(ActionEvent event) {

                clicks = clicks - autoClick4Price;
                autoClick4++;

                autoClick4Price = autoClick4Price * 1.25;

                autoClick4Label.setText(autoClick4 + " clickAdd4s");
                
                autoClick4Upgrade++;
                if(autoClick4Upgrade == 4){
                    autoClick4Time = (long) (autoClick4Time / 1.3);
                    autoClick4Upgrade = 0;
                    System.out.println(autoClick4Time);
                }
            }
        }); 
        
         autoClick5Btn.setOnAction(new EventHandler<ActionEvent>() { 

            @Override
            public void handle(ActionEvent event) {

                clicks = clicks - autoClick5Price;
                autoClick5++;

                autoClick5Price = autoClick5Price * 1.2;

                autoClick5Label.setText(autoClick5 + " clickAdd5s");
                
                autoClick5Upgrade++;
                if(autoClick5Upgrade == 4){
                    autoClick5Time = (long) (autoClick5Time / 1.4);
                    autoClick5Upgrade = 0;
                    System.out.println(autoClick5Time);
                }
            }
        }); 
         
         autoClick6Btn.setOnAction(new EventHandler<ActionEvent>() { 

            @Override
            public void handle(ActionEvent event) {

                clicks = clicks - autoClick6Price;
                autoClick6++;

                autoClick6Price = autoClick6Price * 1.1;

                autoClick6Label.setText(autoClick6 + " clickAdd6s");
                
                autoClick6Upgrade++;
                if(autoClick6Upgrade == 4){
                    autoClick6Time = (long) (autoClick6Time / 1.4);
                    autoClick6Upgrade = 0;
                    System.out.println(autoClick6Time);
                }
            }
        }); 

         perk1Btn.setOnAction(new EventHandler<ActionEvent>() { //

            @Override
            public void handle(ActionEvent event) {

                
                perk1Level++;
                    
                clicks = clicks - perk1Price;
                perk1Price = perk1Price * 2;
                
                clickAddsPrice = clickAddsPrice / 2;
                
            }
        }); //
         
         perk2Btn.setOnAction(new EventHandler<ActionEvent>() { //

            @Override
            public void handle(ActionEvent event) {

                
                perk2Level++;
                clicks = clicks - perk2Price;
                perk2Price = perk2Price * 2;
                
                autoClick1Time = (long) (autoClick1Time / 2);
                autoClick2Time = (long) (autoClick2Time / 2);
                autoClick3Time = (long) (autoClick3Time / 2);
                autoClick4Time = (long) (autoClick4Time / 2);
                autoClick5Time = (long) (autoClick5Time / 2);
                autoClick6Time = (long) (autoClick6Time / 2);
                
            }
        }); //
         
         perk3Btn.setOnAction(new EventHandler<ActionEvent>() { //

            @Override
            public void handle(ActionEvent event) {

                
                perk3Level++;
                clicks = clicks - perk3Price;
                perk3Price = perk3Price * 2;
                
                clickAddsPrice /= 1.25;
                autoClick1Price /= 1.25;
                autoClick2Price /= 1.25;
                autoClick3Price /= 1.25;
                autoClick4Price /= 1.25;
                autoClick5Price /= 1.25;
                autoClick6Price /= 1.25;
                
            }
        }); //
         
         perk4Btn.setOnAction(new EventHandler<ActionEvent>() { //

            @Override
            public void handle(ActionEvent event) {

                
                perk4Level++;
                clicks = clicks - perk4Price;
                perk4Price = perk4Price * 2;
                
                autoClick1 *= 2;
                autoClick2 *= 2;
                autoClick3 *= 2;
                autoClick4 *= 2;
                autoClick5 *= 2;
                autoClick6 *= 2;
                
            }
        }); //
         
         perk5Btn.setOnAction(new EventHandler<ActionEvent>() { //

            @Override
            public void handle(ActionEvent event) {

                clicks = 0;
                
                clickAdds = 0;
                autoClick1 = 0;
                autoClick2 = 0;
                autoClick3 = 0;
                autoClick4 = 0;
                autoClick5 = 0;
                autoClick6 = 0;
                
                clickAddsPrice = 10;
                autoClick1Price = 40;
                autoClick2Price = 100;
                autoClick3Price = 500;
                autoClick4Price = 2500;
                autoClick5Price = 40000;
                autoClick6Price = 500000;
                
                winRec.setVisible(true);
            }
        }); //   
         
        clear.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                    clicks = 0;
                    clickAmount = 1;
                clickAdds = 0;
                clickAddsPrice = 10;
                    autoClick1 = 0; 
                    autoClick1Price = 40; 
                    autoClick1Amount = 1; 
                    autoClick1Time = 2000; 
                    autoClick1Upgrade = 0; 
                autoClick2 = 0; 
                autoClick2Price = 100; 
                autoClick2Amount = 4; 
                autoClick2Time = 5000; 
                autoClick2Upgrade = 0; 
                    autoClick3 = 0; 
                    autoClick3Price = 500; 
                    autoClick3Amount = 10; 
                    autoClick3Time = 10000; 
                    autoClick3Upgrade = 0; 
                autoClick4 = 0; 
                autoClick4Price = 2500; 
                autoClick4Amount = 30; 
                autoClick4Time = 20000; 
                autoClick4Upgrade = 0; 
                    autoClick5 = 0; 
                    autoClick5Price = 4000; 
                    autoClick5Amount = 50; 
                    autoClick5Time = 30000; 
                    autoClick5Upgrade = 0; 
                autoClick6 = 0; 
                autoClick6Price = 500000; 
                autoClick6Amount = 100; 
                autoClick6Time = 40000; 
                autoClick6Upgrade = 0; 
                    perk1 = 0;//
                    perk1Price = 1000;//
                    perk1Level = 1;//
                perk2 = 0;//
                perk2Price = 10000;//
                perk2Level = 1;//
                    perk3 = 0;//
                    perk3Price = 100000;//
                    perk3Level = 1;//
                perk4 = 0;//
                perk4Price = 1000000;//
                perk4Level = 1;//
                    perk5 = 0;//
                    perk5Price = 1000000000;//
            }
        }); 
         
        Group root = new Group();
        root.getChildren().add(winRec);
        
        root.getChildren().add(click);
        root.getChildren().add(clickLabel);

        root.getChildren().add(midVert);

        root.getChildren().add(clickAddBtn);
        root.getChildren().add(clickAddsLabel);
        
        root.getChildren().add(line1);

        root.getChildren().add(autoClick1Btn); 
        root.getChildren().add(autoClick1Label); 
        
        root.getChildren().add(line2); 
        
        root.getChildren().add(autoClick2Btn); 
        root.getChildren().add(autoClick2Label); 
        
        root.getChildren().add(line3); 
        
        root.getChildren().add(autoClick3Btn); 
        root.getChildren().add(autoClick3Label); 
        
        root.getChildren().add(line4); 
        
        root.getChildren().add(autoClick4Btn); 
        root.getChildren().add(autoClick4Label); 
        
        root.getChildren().add(line5); 
        
        root.getChildren().add(autoClick5Btn); 
        root.getChildren().add(autoClick5Label); 
        
        root.getChildren().add(line6); 

        root.getChildren().add(autoClick6Btn); 
        root.getChildren().add(autoClick6Label); 
        
        root.getChildren().add(line7); 
        
        root.getChildren().add(perk1Btn); //
        root.getChildren().add(perk1Label); //
 
        root.getChildren().add(line8); 
        
        root.getChildren().add(perk2Btn); //
        root.getChildren().add(perk2Label); //

        root.getChildren().add(line9); 
        
        root.getChildren().add(perk3Btn); //
        root.getChildren().add(perk3Label); //
        
        root.getChildren().add(perk4Btn); //
        root.getChildren().add(perk4Label); //
        
        root.getChildren().add(perk5Btn); //
        root.getChildren().add(perk5Label); //
        
        root.getChildren().add(clear); //
        
        root.getChildren().add(cursorOut);
        root.getChildren().add(ll);
        root.getChildren().add(l);
        root.getChildren().add(ml);
        root.getChildren().add(m);
        root.getChildren().add(mr);
        root.getChildren().add(r);
        root.getChildren().add(rr);
        root.getChildren().add(cursor);
        
        Scene scene = new Scene(root, 600, 450);

        primaryStage.setTitle("Generic Clicker");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                 if (event.getCode() == KeyCode.UP) {
                     System.out.println("1");
                     scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
                        @Override
                        public void handle(KeyEvent event) {
                    if (event.getCode() == KeyCode.UP) {
                        System.out.println("2");
                        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
                            @Override
                            public void handle(KeyEvent event) {
                        if (event.getCode() == KeyCode.DOWN) {
                            System.out.println("3");
                            scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
                                @Override
                                public void handle(KeyEvent event) {
                            if (event.getCode() == KeyCode.DOWN) {
                                System.out.println("4");
                                scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
                                    @Override
                                    public void handle(KeyEvent event) {
                                if (event.getCode() == KeyCode.LEFT) {
                                    System.out.println("5");
                                    scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
                                        @Override
                                        public void handle(KeyEvent event) {
                                    if (event.getCode() == KeyCode.RIGHT) {
                                        System.out.println("6");
                                        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
                                            @Override
                                            public void handle(KeyEvent event) {
                                        if (event.getCode() == KeyCode.LEFT) {
                                            System.out.println("7");
                                            scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
                                                @Override
                                                public void handle(KeyEvent event) {
                                            if (event.getCode() == KeyCode.RIGHT) {
                                                System.out.println("8");
                                                scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
                                                    @Override
                                                    public void handle(KeyEvent event) {
                                                if (event.getCode() == KeyCode.B) {
                                                    System.out.println("9");
                                                    scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
                                                        @Override
                                                        public void handle(KeyEvent event) {
                                                    if (event.getCode() == KeyCode.A) {
                                                        System.out.println("10");
                                                        scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
                                                            @Override
                                                            public void handle(KeyEvent event) {
                                                        if (event.getCode() == KeyCode.ENTER) {
                                                            System.out.println("go");
                                                            clicks = 69420666;
                                                            scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
                                                                @Override
                                                                public void handle(KeyEvent event) {
                                                                    
                                                                }
                                                            });
                                                        }
                                                            }
                                                        });
                                                    }
                                                        }
                                                    });
                                                }
                                                    }
                                                });
                                            }
                                                }
                                            });
                                        }
                                            }
                                        });
                                    }
                                        }
                                    });
                                }
                                    }
                                });
                            }
                                }
                            });
                        }
                            
                            }
                        });
                    }
                     }
        });
                } 
            }
        });
    }

    private void checkClickAdds() {

        if (clicks < clickAddsPrice) {
            clickAddBtn.setDisable(true);

        } else if (clicks >= clickAddsPrice) {
            clickAddBtn.setDisable(false);

        }
        click.setText("  + " + Math.round(clickAmount) + "  ");
        clickAddBtn.setText(Double.toString(Math.round(clickAddsPrice)));
        clickLabel.setText(Math.round(clicks) + " " + clickName);
        
        clickAddsLabel.setText(clickAdds + " Clickers");
    }

    private void checkAutoClick1() { 

        if (clicks < autoClick1Price) {
            autoClick1Btn.setDisable(true);

        } else if (clicks >= autoClick1Price) {
            autoClick1Btn.setDisable(false);

        }

        autoClick1Btn.setText(Double.toString(Math.round(autoClick1Price)));
        
        autoClick1Label.setText(autoClick1 + " Windows Phones");
    } 
    
    private void checkAutoClick2() { 

        if (clicks < autoClick2Price) {
            autoClick2Btn.setDisable(true);

        } else if (clicks >= autoClick2Price) {
            autoClick2Btn.setDisable(false);

        }

        autoClick2Btn.setText(Double.toString(Math.round(autoClick2Price)));
        
        autoClick2Label.setText(autoClick2 + " Android Phones");
    } 
    
    private void checkAutoClick3() { 

        if (clicks < autoClick3Price) {
            autoClick3Btn.setDisable(true);

        } else if (clicks >= autoClick3Price) {
            autoClick3Btn.setDisable(false);

        }

        autoClick3Btn.setText(Double.toString(Math.round(autoClick3Price)));
        
        autoClick3Label.setText(autoClick3 + " ChromeBooks");
    } 
    
    private void checkAutoClick4() { 

        if (clicks < autoClick4Price) {
            autoClick4Btn.setDisable(true);

        } else if (clicks >= autoClick4Price) {
            autoClick4Btn.setDisable(false);

        }

        autoClick4Btn.setText(Double.toString(Math.round(autoClick4Price)));
        
        autoClick4Label.setText(autoClick4 + " iPhones");
    } 
    
    private void checkAutoClick5() { 

        if (clicks < autoClick5Price) {
            autoClick5Btn.setDisable(true);

        } else if (clicks >= autoClick5Price) {
            autoClick5Btn.setDisable(false);

        }

        autoClick5Btn.setText(Double.toString(Math.round(autoClick5Price)));
        
        autoClick5Label.setText(autoClick5 + " Macs");
    } 
    
    private void checkAutoClick6() { 

        if (clicks < autoClick6Price) {
            autoClick6Btn.setDisable(true);

        } else if (clicks >= autoClick6Price) {
            autoClick6Btn.setDisable(false);

        }

        autoClick6Btn.setText(Double.toString(Math.round(autoClick6Price)));
        
        autoClick6Label.setText(autoClick6 + " PCs");
    } 

    private void checkPerk1(){//
        if (clicks < perk1Price) {
            perk1Btn.setDisable(true);

        } else if (clicks >= perk1Price) {
            perk1Btn.setDisable(false);

        }

        perk1Btn.setText(Double.toString(Math.round(perk1Price)));
        
        perk1Label.setText("Click Cost Cutter " + perk1Level); //
    perk2Label.setText("More RAM " + perk2Level); //
    perk3Label.setText("Better Buying " + perk3Level); //
    perk4Label.setText("Stronger CPUs " + perk4Level); //
    perk5Label.setText("Gold Computer"); //
    }//
    
    private void checkPerk2(){//
        if (clicks < perk2Price) {
            perk2Btn.setDisable(true);

        } else if (clicks >= perk2Price) {
            perk2Btn.setDisable(false);

        }

        perk2Btn.setText(Double.toString(Math.round(perk2Price)));
    }//
    
    private void checkPerk3(){//
        if (clicks < perk3Price) {
            perk3Btn.setDisable(true);

        } else if (clicks >= perk3Price) {
            perk3Btn.setDisable(false);

        }

        perk3Btn.setText(Double.toString(Math.round(perk3Price)));
    }//
    
    private void checkPerk4(){//
        if (clicks < perk4Price) {
            perk4Btn.setDisable(true);

        } else if (clicks >= perk4Price) {
            perk4Btn.setDisable(false);

        }

        perk4Btn.setText(Double.toString(Math.round(perk4Price)));
    }//
    
    private void checkPerk5(){//
        if (clicks < perk5Price) {
            perk5Btn.setDisable(true);

        } else if (clicks >= perk5Price) {
            perk5Btn.setDisable(false);

        }

        perk5Btn.setText(Double.toString(Math.round(perk5Price)));
    }//
    
        
    @Override
    public void stop(){
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("score.txt"));
            writer.write(clicks + " " + clickAmount + " " + clickAdds + " " + clickAddsPrice + " " + autoClick1 + " " + autoClick1Price + " " + autoClick1Amount + " " + autoClick1Time + " " + autoClick1Upgrade + " " + autoClick2 + " " + autoClick2Price + " " + autoClick2Amount + " " + autoClick2Time + " " + autoClick2Upgrade + " " + autoClick3 + " " + autoClick3Price + " " + autoClick3Amount + " " + autoClick3Time + " " + autoClick3Upgrade + " " + autoClick4 + " " + autoClick4Price + " " + autoClick4Amount + " " + autoClick4Time + " " + autoClick4Upgrade + " " + autoClick5 + " " + autoClick5Price + " " + autoClick5Amount + " " + autoClick5Time + " " + autoClick5Upgrade + " " + autoClick6 + " " + autoClick6Price + " " + autoClick6Amount + " " + autoClick6Time + " " + autoClick6Upgrade + " " + perk1 + " " + perk1Price + " " + perk1Level + " " + perk2 + " " + perk2Price + " " + perk2Level + " " + perk3 + " " + perk3Price + " " + perk3Level + " " + perk4 + " " + perk4Price + " " + perk4Level + " " + perk5 + " " + perk5Price);
            writer.close();
            System.exit(0);
        } catch (IOException e) {
            System.err.print("Error saving the file. ");
            System.exit(1); //exit with error code 1. 
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
