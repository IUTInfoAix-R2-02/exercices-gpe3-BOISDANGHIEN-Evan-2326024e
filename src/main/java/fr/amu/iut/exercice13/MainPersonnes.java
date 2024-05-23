package fr.amu.iut.exercice13;

import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.scene.paint.Paint;

@SuppressWarnings("Duplicates")
public class MainPersonnes  {

    private static ObservableList<Personne> lesPersonnes;

    private static ListChangeListener<Personne> unChangementListener;

    public static void main(String[] args) {

        lesPersonnes = FXCollections.observableArrayList(personne -> new Observable[] {personne.ageProperty()});


        ListChangeListener<Personne> unChangementListener = change -> {
            while (change.next()) {
                if (change.wasAdded()) {
                    for (Personne addedPerson : change.getAddedSubList()) {
                        System.out.println("Personne ajoutée : " + addedPerson.getNom());
                    }
                }
                if (change.wasRemoved()) {
                    for (Personne removedPerson : change.getRemoved()) {
                        System.out.println("Personne remove : " + removedPerson.getNom());
                    }
                }
                if (change.wasUpdated()) {
                    int index = change.getFrom();
                    Personne p= change.getList().get(index);
                    System.out.println(p.getNom()+" a maintenant"+ p.getAge());
                }
            }
        };


        lesPersonnes.addListener(unChangementListener);
        question5();
    }

    public static void question1() {
        Personne pierre = new Personne("Pierre", 20);
        Personne paul = new Personne("Paul", 40);
        Personne jacques = new Personne("Jacques", 60);
        lesPersonnes.add(pierre);
        lesPersonnes.add(paul);
        lesPersonnes.add(jacques);
    }

    public static void question2() {
        Personne pierre = new Personne("Pierre", 20);
        Personne paul = new Personne("Paul", 40);
        Personne jacques = new Personne("Jacques", 60);
        lesPersonnes.add(pierre);
        lesPersonnes.add(paul);
        lesPersonnes.add(jacques);
        lesPersonnes.remove(paul);
    }

    public static void question3() {
        Personne pierre = new Personne("Pierre", 20);
        Personne paul = new Personne("Paul", 40);
        Personne jacques = new Personne("Jacques", 60);
        lesPersonnes.add(pierre);
        lesPersonnes.add(paul);
        lesPersonnes.add(jacques);
        paul.setAge(5);
    }

    public static void question5() {
        Personne pierre = new Personne("Pierre", 20);
        Personne paul = new Personne("Paul", 40);
        Personne jacques = new Personne("Jacques", 60);
        lesPersonnes.addAll(pierre, paul, jacques);
        for (Personne p : lesPersonnes)
            p.setAge(p.getAge()+10);
        lesPersonnes.removeAll(paul, pierre);
    }
}

