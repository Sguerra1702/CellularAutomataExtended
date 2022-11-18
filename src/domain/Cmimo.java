package domain;
import java.awt.Color;

/**
 * Write a description of class Cmimos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Cmimo extends Cell{
    private AManufacturing aManufacturing;
    private int row,column;
    private int matenme;

    /**
     * Constructor for objects of class Cmimos
     */
    
    public Cmimo(AManufacturing am,int row, int column, boolean active){
        super(am,row,column,active);
        aManufacturing=am;
        this.row=row;
        this.column=column;
        color=Color.orange;
        matenme=0;
    }
    
    @Override
    public void decide(){
        if(aManufacturing.getThing(row-1,column) != null && matenme == 0){
            nextState=(aManufacturing.getThing(row-1,column).isActive() == true ? Artefact.ACTIVE:Artefact.INACTIVE);
        }
        else if(aManufacturing.getThing(row-1,column+1)!= null && matenme == 1){
            nextState=(aManufacturing.getThing(row-1,column+1).isActive() == true ? Artefact.ACTIVE:Artefact.INACTIVE);
        }
        else if(aManufacturing.getThing(row,column+1)!= null && matenme == 2){
            nextState=(aManufacturing.getThing(row,column+1).isActive() == true ? Artefact.ACTIVE:Artefact.INACTIVE);
        }
        else if(aManufacturing.getThing(row+1,column+1)!= null && matenme == 3){
            nextState=(aManufacturing.getThing(row+1,column+1).isActive() == true ? Artefact.ACTIVE:Artefact.INACTIVE);
        }
        else if(aManufacturing.getThing(row+1,column)!= null && matenme == 4){
            nextState=(aManufacturing.getThing(row+1,column).isActive() == true ? Artefact.ACTIVE:Artefact.INACTIVE);           
        }
        else if(aManufacturing.getThing(row+1,column-1)!= null && matenme == 5){
            nextState=(aManufacturing.getThing(row-1,column-1).isActive() == true ? Artefact.ACTIVE:Artefact.INACTIVE);
        }
        else if(aManufacturing.getThing(row,column-1)!= null && matenme == 6){
            nextState=(aManufacturing.getThing(row,column-1).isActive() == true ? Artefact.ACTIVE:Artefact.INACTIVE);          
        }
        else if(aManufacturing.getThing(row-1,column-1)!= null && matenme == 7){
            nextState=(aManufacturing.getThing(row-1,column-1).isActive() == true ? Artefact.ACTIVE:Artefact.INACTIVE);        
        }
        if( matenme == 7){
            matenme = -1;
        }
        matenme +=1;
    }

}
