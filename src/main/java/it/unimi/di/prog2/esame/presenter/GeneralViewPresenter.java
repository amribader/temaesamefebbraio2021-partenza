package it.unimi.di.prog2.esame.presenter;

import it.unimi.di.prog2.esame.Main;
import it.unimi.di.prog2.esame.model.Domanda;
import it.unimi.di.prog2.esame.model.Observer;
import it.unimi.di.prog2.esame.model.QuestionModel;
import it.unimi.di.prog2.esame.model.Subject;
import it.unimi.di.prog2.esame.view.GeneralDisplayView;
import org.jetbrains.annotations.NotNull;

import java.util.Comparator;
import java.util.List;

public class GeneralViewPresenter implements Observer<List<Domanda>> {
    private final @NotNull GeneralDisplayView view;
    private final @NotNull QuestionModel model;

    public GeneralViewPresenter(@NotNull GeneralDisplayView view, @NotNull QuestionModel model) {
        this.view = view;
        this.model = model;
        model.addObserver(this);
    }

    @Override
    public void update(Subject<List<Domanda>> subject, List<Domanda> state) {
        state.sort(Comparator.comparing(Domanda::getNumVoti).reversed());
        int i = 0;
        for (Domanda domanda : state) {
            view.set(i++, domanda.getDomanda()+domanda.getNumVoti());
        }
        while(i< Main.NUM_QUESTIONS){
            view.set(i++,"");
        }
    }
}
