package it.unimi.di.prog2.esame.model;

import it.unimi.di.prog2.esame.Main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class QuestionModel implements Subject<List<Domanda>>{

    private List<Observer<List<Domanda>>> observers = new ArrayList<>();

    //private Map<String,Domanda> map = new HashMap<>();

    private List<Domanda> map = new ArrayList<>();

    @Override
    public void notifyObservers() {
        // TODO Auto-generated method stub
        for (Observer<List<Domanda>> observer : observers) {
            observer.update(this,this.getState());
        }
        
    }

    @Override
    public void addObserver(Observer<List<Domanda>> obs) {
        // TODO Auto-generated method stub
        observers.add(obs);
    }

    @Override
    public List<Domanda> getState() {
        // TODO Auto-generated method stub
        return new ArrayList<>(map);
    }
/*
    public void add(String s) {
        assert !s.isEmpty();
        s = s.trim();
        map.put(s,map.getOrDefault(s,new Domanda(s,0,0)));
        System.err.println(map);
        notifyObservers();
    }

 */

    public void add(String s) {
        assert(map.size() < Main.NUM_QUESTIONS);
        assert !s.isEmpty();

        s = s.trim();
        int cont = 0;
        for (Domanda domanda : map) {
            if (!domanda.getDomanda().equals(s)){//se è presente
                cont++;
            }
        }
        if(cont == map.size()){//non c'è
            map.add(new Domanda(s,0));
        }
        System.out.println(map);
        notifyObservers();
    }

    public void vote(int i) {
        assert i >=0 && i <=6;
        assert i < map.size() : "ERRORE NON ESISTE LA DOMANDA";
        map.set(i,new Domanda(map.get(i).getDomanda(),map.get(i).getNumVoti()+1));
        notifyObservers();
    }
}
