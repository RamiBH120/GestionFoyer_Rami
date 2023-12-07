package tn.esprit.gestionfoyer_rami.exceptions;

public class EntityObjectAlreadyExistsException extends RuntimeException{
    public EntityObjectAlreadyExistsException(String message){
        super(message);
    }
}