package tn.esprit.gestionfoyer_rami.exceptions;

public class EntityObjectNotFoundException extends RuntimeException{
    public EntityObjectNotFoundException(String message){
        super(message);
    }
}