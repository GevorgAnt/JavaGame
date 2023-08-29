package BlockGame;

import javax.swing.*;

public class Paint extends JFrame  {
    public Paint(){
        this.add(new PaintPanel());
        this.setTitle(" Game");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.pack();
        this.setVisible(true);
        this.setLocationRelativeTo(null);


    }


}
