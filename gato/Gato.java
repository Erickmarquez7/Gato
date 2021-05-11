import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Gato implements ActionListener{

    Random r = new Random();
    JFrame frame = new JFrame();
    JPanel panelTitulo = new JPanel();
    JPanel panelBoton = new JPanel();
    JLabel texto = new JLabel();
    JButton[] botones = new JButton[9];
    boolean jugador1Juega;

    Gato(){
        //forma al marco
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());
        //frame.setTitle("Gsto");
        frame.setVisible(true);

        //Forma al texto
        texto.setBackground(new Color(25, 25, 25));  
        //color del texto  
        texto.setForeground(new Color(25, 220, 0));
        texto.setFont(new Font("Ink Free", Font.BOLD, 75));    
        texto.setHorizontalAlignment(JLabel.CENTER);
        texto.setText("Gato");
        texto.setOpaque(true);

        //donde pondremos el titulo 
        panelTitulo.setLayout(new BorderLayout());
        panelTitulo.setBounds(0, 0, 500, 100);

        //Donde pintaremos los botones
        panelBoton.setLayout(new GridLayout(3,3));
        panelBoton.setBackground(new Color(150,150,150));

        //agragmos los botones
        for(int i = 0; i<9;i++ ){
            botones[i]=new JButton();
            panelBoton.add(botones[i]);
            botones[i].setFont(new Font("MV Boli", Font.BOLD, 120));
            botones[i].setFocusable(false);
            botones[i].addActionListener(this);
        }

        panelTitulo.add(texto);
        frame.add(panelTitulo, BorderLayout.NORTH);
        frame.add(panelBoton);

        primerTurno();

    }

    //se manda a llamar cada vez que hacemos click en un botón
    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0; i<9; i++ ){
            if(e.getSource()==botones[i]){
                if(jugador1Juega){
                    // para que solo pueda tirar en una casilla que esté vacía
                    if(botones[i].getText()==""){
                        botones[i].setForeground(new Color(255, 0, 0));
                        botones[i].setText("X");
                        jugador1Juega=false;
                        texto.setText("Juega O");
                        revisa();
                    }
                } 
                else {
                    if(botones[i].getText()==""){
                        botones[i].setForeground(new Color(0, 0, 255));
                        botones[i].setText("O");
                        jugador1Juega=true;
                        texto.setText("Juega X");
                        revisa();
                    }

                }
            }
        }
        
    }

    //Determina que jugador va primero
    public void primerTurno(){

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        if(r.nextInt(2)==0){
            jugador1Juega = true;
            texto.setText("Juega X");
        } else{
            jugador1Juega = false;
            texto.setText("Juega O");
        }

    }

    //revisa quien ganó
    public void revisa(){
        //para las X
        //Horizontales -- -- -- 
        if((botones[0].getText()=="X") && 
        (botones[1].getText()=="X") && 
        (botones[2].getText()=="X")){
            xGana(0, 1, 2);
        }

        if((botones[3].getText()=="X") &&
        (botones[4].getText()=="X") &&
        (botones[5].getText()=="X")){
            xGana(3, 4, 5);
        }

        if((botones[6].getText()=="X") &&
        (botones[7].getText()=="X") &&
        (botones[8].getText()=="X")){
            xGana(6, 7, 8);
        }

        //verticales | | |
        if((botones[0].getText()=="X") &&
        (botones[3].getText()=="X") && 
        (botones[6].getText()=="X")){
            xGana(0, 3, 6);
        }

        if((botones[1].getText()=="X") &&
        (botones[4].getText()=="X") && 
        (botones[7].getText()=="X")){
            xGana(1, 4, 7);
        }

        if((botones[2].getText()=="X") && 
        (botones[5].getText()=="X") &&
        (botones[8].getText()=="X")){
            xGana(2, 5, 8);
        }

        //diagonal  \  /
        if((botones[0].getText()=="X") && 
        (botones[4].getText()=="X") &&
        (botones[8].getText()=="X")){
            xGana(0, 4, 8);
        }

        if((botones[2].getText()=="X") && 
        (botones[4].getText()=="X") &&
        (botones[6].getText()=="X")){
            xGana(2, 4, 6);
        }

        //Para las O
        // Horizontales -- --
        if((botones[0].getText()=="O") && 
        (botones[1].getText()=="O") && 
        (botones[2].getText()=="O")){
            oGana(0, 1, 2);
        }

        if((botones[3].getText()=="O") &&
        (botones[4].getText()=="O") &&
        (botones[5].getText()=="O")){
            oGana(3, 4, 5);
        }

        if((botones[6].getText()=="O") &&
        (botones[7].getText()=="O") &&
        (botones[8].getText()=="O")){
            oGana(6, 7, 8);
        }

        //verticales | | |
        if((botones[0].getText()=="O") &&
        (botones[3].getText()=="O") && 
        (botones[6].getText()=="O")){
            oGana(0, 3, 6);
        }

        if((botones[1].getText()=="O") &&
        (botones[4].getText()=="O") && 
        (botones[7].getText()=="O")){
            oGana(1, 4, 7);
        }

        if((botones[2].getText()=="O") && 
        (botones[5].getText()=="O") &&
        (botones[8].getText()=="O")){
            oGana(2, 5, 8);
        }

        //diagonal  \  /
        if((botones[0].getText()=="O") && 
        (botones[4].getText()=="O") &&
        (botones[8].getText()=="O")){
            oGana(0, 4, 8);
        }

        if((botones[2].getText()=="O") && 
        (botones[4].getText()=="O") &&
        (botones[6].getText()=="O")){
            oGana(2, 4, 6);
        }
    }

    //revisa si la x gana
    public void xGana(int a, int b, int c){
        botones[a].setBackground(new Color(156, 250, 36));
        botones[b].setBackground(new Color(156, 250, 36));
        botones[c].setBackground(new Color(156, 250, 36));
        //deshabilitamos los botones
        for(int i =0; i<9; i++)
            botones[i].setEnabled(false);
        texto.setText("X gana");
    }

    //revisa si la o gana
    public void oGana(int a, int b, int c){
        botones[a].setBackground(new Color(156, 250, 36));
        botones[b].setBackground(new Color(156, 250, 36));
        botones[c].setBackground(new Color(156, 250, 36));
        //deshabilitamos los botones
        for (int i = 0; i<9; i++)
            botones[i].setEnabled(false);
        texto.setText("O Gana");

    }
}
