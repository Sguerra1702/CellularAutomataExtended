package domain;
import java.awt.Color;

/**
 * Write a description of class Cpoob here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Cosax extends Cell{
    private AManufacturing aManufacturing;
    private int row,column;
    private int matenme;
    private int i = 1;
    private int j = 1;
    public Cosax(AManufacturing am,int row, int column, boolean active)
    {
        super(am,row,column,active);
        aManufacturing=am;
        this.row=row;
        this.column=column;
        color=Color.magenta;
    }

    public int shape(){
        return ROUND;
    }

    /**Decide its next state
     */
    public void decide(){
        int min = 0;  
        int max = 49; 
        nextState=((getSteps()) % 3 == 0 ? Artefact.ACTIVE:Artefact.INACTIVE);
        if (this.isActive()){
            int b = (int)(Math.random()*(max-min+1)+min);
            int c = (int)(Math.random()*(max-min+1)+min);
            Cosax xd = new Cosax(aManufacturing, c,b, true);
        }
    }
}
