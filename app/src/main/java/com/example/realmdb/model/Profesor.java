package com.example.realmdb.model;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Profesor extends RealmObject {
    @PrimaryKey
    private int id;

    private String name;
    private String email;
    private RealmList<Curso> cursos;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public RealmList<Curso> getCursos() {
        return cursos;
    }

    public void setCursos(RealmList<Curso> cursos) {
        this.cursos = cursos;
    }
}
