package com.example.loulo.applicationmadrental;

import java.lang.reflect.Array;

public class Vehicule {

    private String nom;
    private int prixjournalierbase;
    private String categorieco2;
    private int promotion;
    private String image;
    private Array equipements;

    public Vehicule() {
    }

    public Vehicule(String nom, int prixjournalierbase, String categorieco2, int promotion, String image, Array equipements) {
        this.nom = nom;
        this.prixjournalierbase = prixjournalierbase;
        this.categorieco2 = categorieco2;
        this.promotion = promotion;
        this.image = image;
        this.equipements = equipements;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getPrixjournalierbase() {
        return prixjournalierbase;
    }

    public void setPrixjournalierbase(int prixjournalierbase) {
        this.prixjournalierbase = prixjournalierbase;
    }

    public String getCategorieco2() {
        return categorieco2;
    }

    public void setCategorieco2(String categorieco2) {
        this.categorieco2 = categorieco2;
    }

    public int getPromotion() {
        return promotion;
    }

    public void setPromotion(int promotion) {
        this.promotion = promotion;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Array getEquipements() {
        return equipements;
    }

    public void setEquipements(Array equipements) {
        this.equipements = equipements;
    }
}
