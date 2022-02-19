package it.unimi.di.prog2.esame.presenter;

import it.unimi.di.prog2.esame.Main;
import it.unimi.di.prog2.esame.model.Domanda;
import it.unimi.di.prog2.esame.model.Observer;
import it.unimi.di.prog2.esame.model.QuestionModel;
import it.unimi.di.prog2.esame.model.Subject;
import it.unimi.di.prog2.esame.view.PersonalView;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class PersonalViewPresenter  implements Observer<List<Domanda>> {

  private final PersonalView view;
  private final QuestionModel model;

  public PersonalViewPresenter(@NotNull PersonalView view, QuestionModel model) {
    this.view = view;
    this.model = model;
    view.addHandlers(this);
    model.addObserver(this);
    //TODO
  }

  public void addQuestion(@NotNull String s) {//updateModel action
    System.err.println("nuova domanda: " + s);
    //TODO
    assert(model.getState().size() < Main.NUM_QUESTIONS);
    assert !s.isEmpty();

    if(s.isEmpty()){
      return;
    }

    if(model.getState().size() >= Main.NUM_QUESTIONS){
      return;
    }

    model.add(s);
  }

  public void voteQuestion(int i) {//action updateModel
    System.err.println("voto per " + i);
    //TODO
    assert i < model.getState().size();
    System.err.println(model.getState().size()+"  "+i);
    if (! (i < model.getState().size())){
      return;
    }
    model.vote(i);
  }

  @Override
  public void update(Subject<List<Domanda>> subject, List<Domanda> state) {
    System.err.println("metodo update");
    System.err.println(state);
    int i = 0;
    for (Domanda domanda : state) {
      view.set(i++, domanda.getDomanda()+domanda.getNumVoti());
    }
    while(i< Main.NUM_QUESTIONS){
      view.set(i++,"");
    }
  }
}
