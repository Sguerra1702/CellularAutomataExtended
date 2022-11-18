package domain;

public class ReplicateException extends Exception{
    public  static final String OPCION_EN_CONSTRUCCION = "Opcion en construccion";


    public ReplicateException(String message){
        super(message);
    }

    
}
