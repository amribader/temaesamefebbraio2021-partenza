package it.unimi.di.prog2.esame.view;

import static it.unimi.di.prog2.esame.Main.NUM_QUESTIONS;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.paint.Color;
import org.jetbrains.annotations.NotNull;

public class GeneralDisplayView extends Region {

  private final Label[] questions = new Label[NUM_QUESTIONS];

  public GeneralDisplayView() {
    setBackground(new Background(
        new BackgroundFill(Color.LIGHTBLUE, new CornerRadii(5.0), Insets.EMPTY)));
    setBorder(new Border(
        new BorderStroke(null, BorderStrokeStyle.SOLID, new CornerRadii(5.0), new BorderWidths(2))));

    GridPane grid = new GridPane();
    grid.setPadding(new Insets(10, 10, 10, 10));
    for (int i = 0; i < NUM_QUESTIONS; i++) {
      questions[i] = new Label("Question #" + i + " : 0");
      questions[i].setPadding(new Insets(10, 10, 10, 10));
      grid.add(questions[i], 0, i);
    }
    this.getChildren().add(grid);
  }

  public void set(int i, @NotNull String s) {
    questions[i].setText(s);
  }
}
