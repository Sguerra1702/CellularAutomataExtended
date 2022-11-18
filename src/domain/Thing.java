package domain;
import java.awt.Color;

/*No olviden adicionar la documentacion*/
public interface Thing{
  int ROUND = 1;
  int SQUARE = 2;


  void decide();
   
  default void change(){
  };
   default void faseuno(){  
    };
  default void fasedos(){
    };
  default void fasetres(){
    };
  default int shape(){
      return SQUARE;
  }
  
  default Color getColor(){
      return Color.green;
  };
  
  default boolean isActive(){
      return false;
  }
  
  default void ayuda(AManufacturing am){
    
    }
}
