package domain;

public class ReplicateException extends Exception{
    public static  String OPCION_EN_CONSTRUCCION = "Opcion en construccion";


    public ReplicateException(String message){
        super(message);
    }

    
}
