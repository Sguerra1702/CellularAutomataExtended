package presentation;
import domain.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class AManufacturingGUI extends JFrame{  
    public static final int SIDE=11;

    public final int SIZE;
    private JButton ticTacButton;
    private JPanel  controlPanel;
    private PhotoAManufacturing photo;
    private AManufacturing aManufacturing;

    private JMenu menuwu;

    private JMenuBar yasaquenmedepoobporfavor;

    private JMenuItem newFile, open, saveAs, importFile, exportFile, rageQuit;
   
    
    private AManufacturingGUI() {
        aManufacturing=new AManufacturing();
        SIZE=aManufacturing.getSize();
        prepareElements();
        prepareActions();
        
    }
    
    private void prepareElements() {
        setTitle("aManufacturing celular");
        photo=new PhotoAManufacturing(this);
        ticTacButton=new JButton("Tic-tac");
        setLayout(new BorderLayout());
        add(photo,BorderLayout.NORTH);
        add(ticTacButton,BorderLayout.SOUTH);
        setSize(new Dimension(SIDE*SIZE+15,SIDE*SIZE+72));
        prepareElementsMenu();
        setResizable(false);
        photo.repaint();
    }

    public void prepareElementsMenu(){
        yasaquenmedepoobporfavor = new JMenuBar();
        menuwu = new JMenu("Archivo");
        yasaquenmedepoobporfavor.add(menuwu);
        newFile = new JMenuItem("Nuevo");
        open = new JMenuItem("Abrir");
        saveAs = new JMenuItem("Guardar cómo");
        importFile = new JMenuItem("Importar");
        exportFile = new JMenuItem("Exportar como");
        rageQuit = new JMenuItem("Salir");
        menuwu.add(newFile);
        menuwu.add(open);
        menuwu.add(saveAs);
        menuwu.add(importFile);
        menuwu.add(exportFile);
        menuwu.add(rageQuit);
        setJMenuBar(yasaquenmedepoobporfavor);
    }

    private void prepareActions(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);       
        ticTacButton.addActionListener(
            new ActionListener(){
                public void actionPerformed(ActionEvent e) {
                    ticTacButtonAction();
                }
            });
        prepareActionsMenu();

    }
    private void ticTacButtonAction() {
        aManufacturing.ticTac();
        photo.repaint();
    }

    public void prepareActionsMenu(){
        newFile.addActionListener(e -> opcionNuevo());
        open.addActionListener(e -> opcionAbrir());
        saveAs.addActionListener(e -> opcionGuardar());
        importFile.addActionListener(e -> opcionImportar());
        exportFile.addActionListener(e -> opcionExportar());
        rageQuit.addActionListener(e -> opcionSalir());
    }

    public AManufacturing getaManufacturing(){
        return aManufacturing;
    }
    
    public static void main(String[] args) {
        AManufacturingGUI ca=new AManufacturingGUI();
        ca.setVisible(true);
    }

    private void opcionNuevo(){

    }

    private void opcionAbrir(){

    }
    private void opcionGuardar(){

    }

    private void opcionImportar(){

    }

    private void opcionExportar(){

    }

    private void opcionSalir(){
        if (JOptionPane.showConfirmDialog(rootPane, "Are you sure you want to exit? :c", "Pls don't go TwT", JOptionPane.YES_NO_OPTION
        ) == JOptionPane.YES_OPTION) {
            System.exit(0);
        }else {
            setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        }
    }

}

class PhotoAManufacturing extends JPanel{
    private AManufacturingGUI gui;

    public PhotoAManufacturing(AManufacturingGUI gui) {
        this.gui=gui;
        setBackground(Color.white);
        setPreferredSize(new Dimension(gui.SIDE*gui.SIZE+10, gui.SIDE*gui.SIZE+10));         
    }


    public void paintComponent(Graphics g){
        AManufacturing aManufacturing=gui.getaManufacturing();
        super.paintComponent(g);
         
        for (int c=0;c<=aManufacturing.getSize();c++){
            g.drawLine(c*gui.SIDE,0,c*gui.SIDE,aManufacturing.getSize()*gui.SIDE);
        }
        for (int f=0;f<=aManufacturing.getSize();f++){
            g.drawLine(0,f*gui.SIDE,aManufacturing.getSize()*gui.SIDE,f*gui.SIDE);
        }       
        for (int f=0;f<aManufacturing.getSize();f++){
            for(int c=0;c<aManufacturing.getSize();c++){
                if (aManufacturing.getThing(f,c)!=null){
                    g.setColor(aManufacturing.getThing(f,c).getColor());
                    if (aManufacturing.getThing(f,c).shape()==Thing.SQUARE){                  
                        if (aManufacturing.getThing(f,c).isActive()){
                            g.fillRoundRect(gui.SIDE*c+1,gui.SIDE*f+1,gui.SIDE-2,gui.SIDE-2,2,2);
                        }else{
                            g.drawRoundRect(gui.SIDE*c+1,gui.SIDE*f+1,gui.SIDE-2,gui.SIDE-2,2,2);    
                        }
                    }else {
                        if (aManufacturing.getThing(f,c).isActive()){
                            g.fillOval(gui.SIDE*c+1,gui.SIDE*f+1,gui.SIDE-2,gui.SIDE-2);
                        } else {
                            g.drawOval(gui.SIDE*c+1,gui.SIDE*f+1,gui.SIDE-2,gui.SIDE-2);
                        }
                    }
                }
            }
        }
    }
}