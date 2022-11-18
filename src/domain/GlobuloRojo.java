package domain;
import java.awt.Color;


/**
 * Write a description of class GlobuloRojo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GlobuloRojo extends Artefact implements Thing
{
    // instance variables - replace the example below with your own
    protected Color color;
    private AManufacturing am;
    private int row,column;
    protected char nextState;
    private boolean active;
    /**
     * Constructor for objects of class GlobuloRojo
     */
    public GlobuloRojo(AManufacturing am, int row, int column, boolean active){
        this.am =am;
        this.row=row;
        this.column=column;
        color = Color.red;
        am.setThing(row,column,(Thing)this);
    }
    
    public int shape(){
        return ROUND;
    }
    public Color getColor(){
        return color;
    }
    public final void change(){
        step();
        state = nextState;
    }
    @Override
    public void decide(){
        if(am.neighborsActive(row, column)> 0){
            nextState = Artefact.ACTIVE;
            for(int i = row - 1; i<row+2;i++){
                for(int j = column-1; j<column+2;j++){
                    if(am.inLatice(i,j)&&j<am.getSize()&&(i!=row||j!=column)&&am.getThing(i,j)==null){
                        GlobuloRojo kryptobro = new GlobuloRojo(am, i, j, false);
                    }
                }
            }
        }
        else{
            nextState = Artefact.INACTIVE;
        }
    }
}
