package com.example.realmdb.crud;

import android.util.Log;

import com.example.realmdb.model.Profesor;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class CrudProfesor {
    private final static int calculateIndex(){
        Realm realm = Realm.getDefaultInstance();
        Number currentId = realm.where(Profesor.class).max("id");
        int nextId;
        if (currentId == null){
            nextId = 0;
        }else{
            nextId = currentId.intValue()+1;
        }
        return nextId;
    }

    public final static void addProfesor(final Profesor profesor){
        Realm realm = Realm.getDefaultInstance();
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                int index = CrudProfesor.calculateIndex();
                Profesor realmProfesor = realm.createObject(Profesor.class, index);
                realmProfesor.setName(profesor.getName());
                realmProfesor.setEmail(profesor.getEmail());
            }
        });
    }

    public final static List<Profesor> getAllProfesor(){
        Realm realm = Realm.getDefaultInstance();
        RealmResults<Profesor> profesors = realm.where(Profesor.class).findAll();
        for (Profesor profesor: profesors){
            Log.d("Profesores", "id: " + profesor.getId() + " Nombre: " + profesor.getName() +
                    " Email: " + profesor.getEmail());
        }
        return profesors;
    }

    public final static Profesor getProfesorByName(String name){
        Realm realm = Realm.getDefaultInstance();
        Profesor profesor = realm.where(Profesor.class).equalTo("name", name).findFirst();
        if (profesor != null){
            Log.d("Profesores", "id: " + profesor.getId() + " Nombre: " + profesor.getName() +
                    " Email: " + profesor.getEmail());
        } else {
            Log.d("No existe", "El registro no existe");
        }
        return profesor;
    }

    public final static Profesor getProfesorByID(int id){
        Realm realm = Realm.getDefaultInstance();
        Profesor profesor = realm.where(Profesor.class).equalTo("id", id).findFirst();
        if (profesor != null){
            Log.d("Profesores", "id: " + profesor.getId() + " Nombre: " + profesor.getName() +
                    " Email: " + profesor.getEmail());
        } else {
            Log.d("No existe", "El registro no existe");
        }
        return profesor;
    }

}
