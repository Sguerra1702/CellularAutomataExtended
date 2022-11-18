package domain;
import java.awt.Color;

/**
 * Write a description of class Rfplicbte here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rfplicbte extends Cell
{
    // instance variables - replace the example below with your own
    private AManufacturing aManufacturing;
    private int row,column;

    /**
     * Constructor for objects of class Rfplicbte
     */
    public Rfplicbte(AManufacturing am,int row, int column, boolean active)
    {
        super(am,row,column,active);
        this.aManufacturing=am;
        this.row=row;
        this.column=column;
        color=Color.blue;
    }
    @Override
    public void decide(){
        if(this.isActive()){
            for(int i=-1; i < 2;i++){
                for (int j =-1; j < 2;j++){
                    if((i+row !=row || j+column != column) && aManufacturing.isEmpty(i+row, j+column)){
                            Rfplicbte res = new Rfplicbte(aManufacturing, row+i, column+j, false);
                    }
                }
            }
        }
    }
    public void faseuno(){
        if(aManufacturing.neighborsActive(row, column) %2 == 0  ){
            nextState=Artefact.INACTIVE;   
        }else{
            nextState=Artefact.ACTIVE;         
        } 
    }
    
    public void fasedos(){
        if(nextState == Artefact.INACTIVE){
            aManufacturing.setThing(row, column, null);
        }
    }
    
    public void fasetres(){
        Rfplicbte fase = new Rfplicbte(aManufacturing, row, column, true);
    }

}
