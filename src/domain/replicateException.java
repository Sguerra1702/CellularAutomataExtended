package domain;

public class replicateException extends Exception{
    static String OPCION_EN_CONSTRUCCION = "Opcion en construccion";


    public replicateException(String message){
        super(message);
    }

    
}
