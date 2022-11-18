package domain;
import java.util.*;
import java.awt.Color;

/*No olviden adicionar la documentacion*/
public class AManufacturing{
    static private int SIZE=50;
    private Thing[][] lattice;

    public AManufacturing() {
        lattice=new Thing[SIZE][SIZE];
        for (int r=0;r<SIZE;r++){
            for (int c=0;c<SIZE;c++){
                lattice[r][c]=null;
            }
        }
        someThings();
    }

    public int  getSize(){
        return SIZE;
    }

    public Thing getThing(int r,int c){
        return lattice[r][c];
    }

    public void setThing(int r, int c, Thing e){
        lattice[r][c]=e;
    }

    public void someThings(){
        //Cell simba = new Cell(this, 1,1, true);
        //Cell dala = new Cell(this, 2,2, true);
        //Cmimo mufasa = new Cmimo(this, 5,1, true);
        //Cmimo scar = new Cmimo(this, 5,2, true);
        //Cmimo rafiki = new Cmimo(this, 5,3, true);
        //Kriptonita uone = new Kriptonita(this, 0,0, false);
        //Kriptonita two = new Kriptonita(this, 0,49, true);
        //Kriptonita three = new Kriptonita(this, 49,49, false);
        //Kriptonita four = new Kriptonita(this, 49,0, true);
        //Cosax parra = new Cosax(this, 35,30, true);
        //Cosax guerra = new Cosax(this, 30,35, true);
        //GlobuloRojo puno = new GlobuloRojo(this, 3,3, false);
        //GlobuloRojo pdos = new GlobuloRojo(this, 4,4, true);
        Rfplicbte pruebauno = new Rfplicbte(this,22,22, true);
        Rfplicbte pruebados = new Rfplicbte(this,21,22, true);
        Rfplicbte pruebatres = new Rfplicbte(this,22,21, true);
        
    }

    public int neighborsActive(int r, int c){
        int num=0;
        for(int dr=-1; dr<2;dr++){
            for (int dc=-1; dc<2;dc++){
                if ((dr!=0 || dc!=0) && inLatice(r+dr,c+dc) && 
                (lattice[r+dr][c+dc]!=null) &&  (lattice[r+dr][c+dc].isActive())) num++;
            }
        }
        return (inLatice(r,c) ? num : 0);
    }

    public boolean isEmpty(int r, int c){
        return (inLatice(r,c) && lattice[r][c]==null);
    }    

    public boolean inLatice(int r, int c){
        return ((0<=r) && (r<SIZE) && (0<=c) && (c<SIZE));
    }

    public void ticTac(){
        for(int i = 0; i < lattice.length; i ++){
            for(int j = 0; j < lattice[i].length; j ++){
                if(lattice[i][j] != null){
                    lattice[i][j].decide();
                }
            }    
        }
        for(int i = 0; i < lattice.length; i ++){
            for(int j = 0; j < lattice[i].length; j ++){
                if(lattice[i][j] != null){
                    lattice[i][j].faseuno();
                }    
            }
        }
        for(int i = 0; i < lattice.length; i ++){
            for(int j = 0; j < lattice[i].length; j ++){
                if(lattice[i][j] != null){
                    lattice[i][j].fasedos();
                }    
            }
        }
        for(int i = 0; i < lattice.length; i ++){
            for(int j = 0; j < lattice[i].length; j ++){
                if(lattice[i][j] != null){
                    lattice[i][j].fasetres();
                }    
            }
        }
        for(int i = 0; i < lattice.length; i ++){
            for(int j = 0; j < lattice[i].length; j ++){
                if(lattice[i][j] != null){
                    lattice[i][j].change();
                }
            }    
        }
    }

}
