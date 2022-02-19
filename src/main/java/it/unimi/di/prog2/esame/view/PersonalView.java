package it.unimi.di.prog2.esame.view;

import it.unimi.di.prog2.esame.Main;
import it.unimi.di.prog2.esame.presenter.PersonalViewPresenter;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
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

public class PersonalView extends Region {
  private final TextField newQuestion = new TextField();
  private final Button add = new Button("ADD");

  private final Label[] questions = new Label[Main.NUM_QUESTIONS];
  private final Button[] votes = new Button[Main.NUM_QUESTIONS];

  public PersonalView() {
    setBackground(new Background(
        new BackgroundFill(Color.LIGHTBLUE, new CornerRadii(5.0), Insets.EMPTY)));
    setBorder(new Border(
        new BorderStroke(null, BorderStrokeStyle.SOLID, new CornerRadii(5.0), new BorderWidths(2))));


    GridPane grid = new GridPane();

    grid.setPadding(new Insets(10, 10, 10, 10));
    grid.add(newQuestion, 0, 0);
    grid.add(add, 1, 0);

    for (int i = 0; i < Main.NUM_QUESTIONS; i++) {
      questions[i] = new Label("Question #" + i);
      votes[i] = new Button("VOTE");
      grid.add(questions[i], 0, 2 + i);
      grid.add(votes[i], 1, 2 + i);
    }
    this.getChildren().add(grid);
  }

  public void addHandlers(@NotNull PersonalViewPresenter presenter) {
    add.setOnAction(eh -> presenter.addQuestion(newQuestion.getText()));

    for (int i = 0; i < Main.NUM_QUESTIONS; i++) {
      final int id = i;
      votes[i].setOnAction(eh -> presenter.voteQuestion(id));
    }

  }

  public void set(int i, @NotNull String s) {
    //votes[i] = new Button("VOTE");
    questions[i].setText(s);
    //grid.add(votes[i], 1, 2 + i);
  }
}
