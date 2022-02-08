package com.example.montp;

public class EmploeModel {
    Integer id;
    String nom;
    String pass;
    String email;
    String matricule;


    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "EmploeModel{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", pass='" + pass + '\'' +
                ", email='" + email + '\'' +
                ", matricule='" + matricule + '\'' +
                '}';
    }

    public EmploeModel(Integer id, String nom, String matricule, String email, String pass) {
        this.id = id;
        this.nom = nom;
        this.pass = pass;
        this.email = email;
        this.matricule = matricule;
    }
}
