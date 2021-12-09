/*
THIS IS THE FIRST PAGE
THIS IS THE FIRST PAGE
THIS IS THE FIRST PAGE
THIS IS THE FIRST PAGE
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.*;
import java.io.File;
import java.io.IOException;


public class first extends JFrame implements ActionListener {

    Image logo;
    JButton close, minimize,rpri,rbus,rreg;
    Font title,body;
    //0 is private, 1 is business, 2 is regular (p.s. I am referring to array position in airtype)
    int[] airtype = {0,0,0};

    first(){


        //logo file
        logo = new ImageIcon("page_logo.PNG").getImage();

        try{
            //title font size
            title = Font.createFont(Font.TRUETYPE_FONT, new File("LemonMilk.ttf")).deriveFont(50f);
            GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("LemonMilk.ttf")));

            //body font size
            body = Font.createFont(Font.TRUETYPE_FONT, new File("LemonMilk.ttf")).deriveFont(40f);
            GraphicsEnvironment ge2 = GraphicsEnvironment.getLocalGraphicsEnvironment();
            ge2.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("LemonMilk.ttf")));
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

        //'radio' button for private (it's not really radio button, it's just a button that acts as a radio button)
        rpri = new JButton();
        rpri.setBounds(135,319,31,31);
        rpri.setOpaque(false);
        rpri.setContentAreaFilled(false);
        rpri.setBorderPainted(false);
        rpri.addActionListener(this);

        //'radio' button for business (it's not really radio button, it's just a button that acts as a radio button)
        rbus = new JButton();
        rbus.setBounds(135,370,31,31);
        rbus.setOpaque(false);
        rbus.setContentAreaFilled(false);
        rbus.setBorderPainted(false);
        rbus.addActionListener(this);

        //'radio' button for business (it's not really radio button, it's just a button that acts as a radio button)
        rreg = new JButton();
        rreg.setBounds(135,420,31,31);
        rreg.setOpaque(false);
        rreg.setContentAreaFilled(false);
        rreg.setBorderPainted(false);
        rreg.addActionListener(this);


        //Launch Frame
        this.setUndecorated(true);
        this.setResizable(false);
        this.setSize(1025,755);
        this.setBackground(new Color(0, 0, 0, 0));
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.add(close);
        this.add(minimize);
        this.add(rpri);
        this.add(rbus);
        this.add(rreg);
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
        else if(e.getSource()==rpri){
            airtype[0] = 1;
            airtype[1] = 0;
            airtype[2] = 0;
        }
        else if(e.getSource()==rbus){
            airtype[0] = 0;
            airtype[1] = 1;
            airtype[2] = 0;
        }
        else if(e.getSource()==rbus){
            airtype[0] = 0;
            airtype[1] = 0;
            airtype[2] = 1;
        }
    }

    //design
    public void paint(Graphics g) {
        Graphics2D g2D = (Graphics2D) g;

        g2D.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        //BACKGROUND 1
        g2D.setColor(new Color(0x48dcf1));
        RoundRectangle2D background1 = new RoundRectangle2D.Float(0, 0, 1025, 755, 50, 50);
        g2D.fill(background1);


        //RIGHT SIDE DESIGN
        //BACKGROUND 2
        g2D.setColor(new Color(0xffffff));
        RoundRectangle2D background2 = new RoundRectangle2D.Float(513, 0, 512, 755, 50, 50);
        g2D.fill(background2);

        //CLOSE BUTTON
        g2D.setColor(new Color(0xff4444));
        g2D.fillOval(974, 20, 30, 30);

        //MINIMIZE BUTTON
        g2D.setColor(new Color(0x1a78fd));
        g2D.fillOval(934,20,30,30);

        //LOGO
        g2D.drawImage(logo,600,285,null);

        //PAGE NUMBER
        g2D.setColor(new Color(0x48dcf1));
        g2D.setFont(title);
        g2D.drawString("1 / 4",730,420);


        //LEFT SIDE DESIGN
        //AIRLINE TYPE DESIGN
        g2D.setColor(new Color(0xffffff));
        g2D.setFont(title);
        g2D.drawString("AIRLINE TYPE",80,280);

        //RADIO BUTTON DESIGN
        //PRIVATE RADIO
        g2D.setStroke(new BasicStroke(10));
        g2D.drawOval(140,324,20,20);
        g2D.setFont(body);
        g2D.drawString("Private",170,350);

        if (airtype[0] == 1 && airtype[1] == 0 && airtype[2] == 0){

            //CHECKED RADIOBUTTON FOR PRIVATE
            g2D.setColor(new Color(0xff4444));
            g2D.fillOval(143, 327, 15, 15);

            //UNCHECKED RADIOBUTTON FOR PRIVATE
            g2D.setColor(new Color(0,0,0,0));
            g2D.fillOval(143, 378, 15, 15);

            //UNCHECKED RADIOBUTTON FOR PRIVATE
            g2D.setColor(new Color(0,0,0,0));
            g2D.fillOval(143, 378, 15, 15);
        }

        //BUSINESS RADIO
        g2D.setStroke(new BasicStroke(10));
        g2D.drawOval(140,375,20,20);
        g2D.setFont(body);
        g2D.drawString("Business",170,400);


        //REGULAR RADIO
        g2D.setStroke(new BasicStroke(10));
        g2D.drawOval(140,425,20,20);
        g2D.setFont(body);
        g2D.drawString("Regular",170,450);

    }
}
