/*
THIS IS THE LAUNCH SCREEN
THIS IS THE LAUNCH SCREEN
THIS IS THE LAUNCH SCREEN
THIS IS THE LAUNCH SCREEN
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.*;
import java.io.File;
import java.io.IOException;


public class launch extends JFrame implements ActionListener {

    Image logo;
    JButton close, minimize, book;
    Font lemon;

    launch(){


        //logo file
        logo = new ImageIcon("launch_logo.PNG").getImage();

        try{
            lemon = Font.createFont(Font.TRUETYPE_FONT, new File("LemonMilk.ttf")).deriveFont(25f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("LemonMilk.ttf")));
        }
        catch (IOException | FontFormatException e){
            //test
        }

        //close button
        close = new JButton();
        close.setBounds(974,20,30,30);
        close.setOpaque(false);
        close.setContentAreaFilled(false);
        close.setBorderPainted(false);
        close.addActionListener(this);

        //minimize button
        minimize = new JButton();
        minimize.setBounds(934,20,30,30);
        minimize.setOpaque(false);
        minimize.setContentAreaFilled(false);
        minimize.setBorderPainted(false);
        minimize.addActionListener(this);

        //Book Now button
        book = new JButton();
        book.setBounds(420,435,175,40);
        book.setOpaque(false);
        book.setContentAreaFilled(false);
        book.setBorderPainted(false);
        book.addActionListener(this);

        //Launch Frame
        this.setUndecorated(true);
        this.setResizable(false);
        this.setSize(1025,755);
        this.setBackground(new Color(0, 0, 0, 0));
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.add(close);
        this.add(minimize);
        this.add(book);
    }

    //title bar buttons
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==close){
            System.exit(0);
        }

        else if(e.getSource()==minimize){
            this.setState(1);
        }
        else if(e.getSource()==book){
            System.out.print("BOOK!");
        }
    }

    //design
    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;

        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        //BACKGROUND
        g2D.setColor(new Color(0xffffff));
        RoundRectangle2D frame_background = new RoundRectangle2D.Float(0, 0, 1025, 755, 50, 50);
        g2D.fill(frame_background);

        //CLOSE BUTTON
        g2D.setColor(new Color(0xff4444));
        g2D.fillOval(974, 20, 30, 30);

        //MINIMIZE BUTTON
        g2D.setColor(new Color(0x1a78fd));
        g2D.fillOval(934,20,30,30);

        //LOGO
        g2D.drawImage(logo,225,285,null);

        //Button Shadow
        g2D.setColor(new Color(0,0,0,20));
        RoundRectangle2D button_shadow = new RoundRectangle2D.Float(417, 438, 175, 40, 20, 20);
        g2D.fill(button_shadow);

        //Button
        g2D.setColor(new Color(0x48dcf1));
        RoundRectangle2D book_button = new RoundRectangle2D.Float(420, 435, 175, 40, 20, 20);
        g2D.fill(book_button);
        g2D.setColor(new Color(0xffffff));
        g2D.setFont(lemon);
        g2D.drawString("BOOK NOW!",435,465);
    }
}
