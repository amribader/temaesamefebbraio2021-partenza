package it.unimi.di.prog2.esame.model;

public interface Subject<T> {
	void notifyObservers();
	void addObserver(Observer<T> obs);
	T getState();
}
