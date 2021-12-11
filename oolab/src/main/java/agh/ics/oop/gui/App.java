package agh.ics.oop.gui;

import agh.ics.oop.*;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

import java.util.Vector;

import static java.lang.System.exit;
import static java.lang.System.out;

public class App extends Application {
    AbstractWorldMap map;
    MoveDirection[] directions;
    IEngine engine;

    public void init() throws Exception {
        super.init();
        try {
            out.println("Start");
            String[] args = getParameters().getRaw().toArray(new String[0]);
            directions = OptionsParser.parse(args);
            map = new GrassField(10);
            Vector2d[] positions = {new Vector2d(1, 1), new Vector2d(3, 4)};
            engine = new SimulationEngine(directions, map, positions);
            engine.run();
            out.println(map);
            out.println("Stop");
        } catch (IllegalArgumentException exception) {
            exception.printStackTrace();
            out.println("koniec kropka");
            exit(1);
        }

    }

    @Override
    public void start(Stage primaryStage){
        Vector2d leftDownCorner = map.findingLowerCorner();
        Vector2d rightUpCorner = map.findingUpperCorner();
        GridPane grid = new GridPane();

        Label label1 = new Label("y/x");
        grid.add(label1, 0, 0, 1, 1);
        grid.getColumnConstraints().add(new ColumnConstraints(30));
        grid.getRowConstraints().add(new RowConstraints(30));
        GridPane.setHalignment(label1, HPos.CENTER);


        for(int i = leftDownCorner.x; i <= rightUpCorner.x; i++){
            Label label2 = new Label(" "+i+" ");
            grid.add(label2, i - leftDownCorner.x + 1, 0, 1, 1);
            grid.getColumnConstraints().add(new ColumnConstraints(30));
            GridPane.setHalignment(label2, HPos.CENTER);
        }

        for(int i = leftDownCorner.y; i <= rightUpCorner.y; i++){
            Label label3 = new Label(" "+i+" ");
            grid.add(label3, 0, rightUpCorner.y - i + 1, 1, 1);
            grid.getRowConstraints().add(new RowConstraints(30));
            GridPane.setHalignment(label3, HPos.CENTER);
        }

        for(int i = leftDownCorner.x; i <= rightUpCorner.x; i++){
            for(int j = leftDownCorner.y; j <= rightUpCorner.y; j++){
                Vector2d pos = new Vector2d(i, j);
                if(map.objectAt(pos) != null){
                    Label label4 = new Label(map.objectAt(pos).toString());
                    grid.add(label4, pos.x - leftDownCorner.x + 1, rightUpCorner.y - pos.y + 1, 1, 1);
                    GridPane.setHalignment(label4, HPos.CENTER);
                }
            }
        }

        grid.setGridLinesVisible(true);

        Scene scene = new Scene(grid, rightUpCorner.x * 30 + 100 - leftDownCorner.x * 30,  rightUpCorner.y * 30 + 100 - leftDownCorner.y * 30);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Okno aplikacji");
        primaryStage.show();

    }

}
