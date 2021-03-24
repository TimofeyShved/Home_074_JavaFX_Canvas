package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));

        Canvas canvas = new Canvas(400,300); // место для рисования
        GraphicsContext context = canvas.getGraphicsContext2D(); // что отрисовать?
        drawShapes(context); // закидываем его в класс

        Group root = new Group(); // добавляем саму панель
        root.getChildren().addAll(canvas); // добавляем на панель

        primaryStage.setTitle("Canvas"); // заголовок
        primaryStage.setScene(new Scene(root, 400, 300));
        primaryStage.show();
    }

    private void drawShapes(GraphicsContext gc){
        gc.setFill(Color.GREEN); // заливка
        gc.setStroke(Color.BLUE); // линия
        gc.setLineWidth(5); // толщина линий
        gc.strokeLine(40,0,10, 40); // просто линия
        gc.fillOval(10,60,30,30); // заливка овала
        gc.strokeOval(60,60,30,30); // границы овала
        gc.fillRoundRect(110,60,30,30,10,10); // заливка квадрата
        gc.strokeRoundRect(160,60,30,30,10,10); // границы квадрата
        gc.fillArc(10, 110, 30, 30, 45, 240, ArcType.OPEN);// залитая открытая заливка, образанный круг
        gc.fillArc(60, 110, 30, 30, 45, 240, ArcType.CHORD);// залитая закрыта заливка, образанный круг
        gc.fillArc(110, 110, 30, 30, 45, 240, ArcType.ROUND);// залитая закрытая, через центр заливка, образанный круг
        gc.strokeArc(10, 160, 30, 30, 45, 240, ArcType.OPEN);// граница открытая заливка, образанный круг
        gc.strokeArc(60, 160, 30, 30, 45, 240, ArcType.CHORD);// граница закрыта заливка, образанный круг
        gc.strokeArc(110, 160, 30, 30, 45, 240, ArcType.ROUND);// граница закрытая, через центр заливка, образанный круг
        gc.fillPolygon(new double[]{10,40,10,40}, new double[]{210,210,240,240}, 4); // залитай многогранник
        gc.strokePolygon(new double[]{60,90,60,90}, new double[]{210,210,240,240}, 4);// граница многогранника
        gc.strokePolyline(new double[]{110,140,110,140}, new double[]{210,210,240,240}, 4);// линии многогранника
    }

    public static void main(String[] args) {
        launch(args);
    }
}
