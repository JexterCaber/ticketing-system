package com.jextercaber;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class MyFrame extends JFrame implements ActionListener {

    JButton leftbutton;
    JButton rightbutton;
    Font lemonMilk;
    JRadioButton priv;
    JRadioButton business;
    JRadioButton regular;
    JPanel leftPanel;
    JPanel rightPanel;

    JLabel pageCount;

    ImageIcon unselected;
    ImageIcon selected;

    MyFrame() {

        try {
            lemonMilk = Font.createFont(Font.TRUETYPE_FONT, new File("LemonMilk.ttf")).deriveFont(50f);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        try {
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("LemonMilk.ttf")));
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }


        leftPanel = new JPanel();
        leftPanel.setBackground(Color.cyan);
        leftPanel.setPreferredSize(new Dimension(500,500));

        rightPanel = new JPanel();
        rightPanel.setBackground(Color.white);
        rightPanel.setPreferredSize(new Dimension(500,500));

        page1();

        //CREATE AND SET LOGO ON RIGHT PANE
        ImageIcon logo = new ImageIcon(new ImageIcon("logo.png").getImage().getScaledInstance(450,120, Image.SCALE_DEFAULT));

        JLabel logoImage = new JLabel();
        logoImage.setIcon(logo);

        //CREATE AND SET LEFT BUTTON
        ImageIcon leftButtonImage = new ImageIcon(new ImageIcon("leftButton.png").getImage().getScaledInstance(50,50, Image.SCALE_DEFAULT));

        leftbutton = new JButton();
        leftbutton.addActionListener(this);
        leftbutton.setFocusable(false);
        leftbutton.setIcon(leftButtonImage);
        leftbutton.setOpaque(false);
        leftbutton.setBorder(BorderFactory.createEmptyBorder(4,4,4,4));
        leftbutton.setContentAreaFilled(false);

        //LABEL FOR NUMBER of 1 TO 4
        pageCount = new JLabel("1/4");
        pageCount.setFont(lemonMilk);
        pageCount.setForeground(Color.cyan);

        //CREATE AND SET RIGHT BUTTON
        ImageIcon rightButtonIcon = new ImageIcon(new ImageIcon("rightButton.png").getImage().getScaledInstance(50,50, Image.SCALE_DEFAULT));

        rightbutton = new JButton();
        rightbutton.addActionListener(this);
        rightbutton.setFocusable(false);
        rightbutton.setIcon(rightButtonIcon);
        rightbutton.setOpaque(false);
        rightbutton.setBorder(BorderFactory.createEmptyBorder(4,4,4,4));
        rightbutton.setContentAreaFilled(false);

        //CREATE A BUTTON AND LABEL BOX
        Box horizontalBox = Box.createHorizontalBox();
        horizontalBox.add(leftbutton);
        horizontalBox.add(Box.createRigidArea(new Dimension(20,0)));
        horizontalBox.add(pageCount);
        horizontalBox.add(Box.createRigidArea(new Dimension(20,0)));
        horizontalBox.add(rightbutton);

        //CREATE VERTICAL BOX FOR IMAGE AND BUTTON&LABEL
        Box verticalBox = Box.createVerticalBox();
        verticalBox.add(logoImage);
        verticalBox.add(horizontalBox);


        rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.PAGE_AXIS));
        rightPanel.add(verticalBox);

        //INSERT LABEL AND RADIO BUTTONS
        rightPanel.add(Box.createVerticalGlue());
        rightPanel.add(logoImage);
        rightPanel.add(Box.createRigidArea(new Dimension(0,20)));
        rightPanel.add(verticalBox);
        rightPanel.add(Box.createRigidArea(new Dimension(0,300)));

        //SET X AXIS ALIGNMENT
        logoImage.setAlignmentX(CENTER_ALIGNMENT);
        verticalBox.setAlignmentX(CENTER_ALIGNMENT);


        //CREATE FRAME
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setSize(1024,750);
        this.setLayout(new BorderLayout());
        this.setVisible(true);
        this.add(leftPanel, BorderLayout.WEST);
        this.add(rightPanel, BorderLayout.EAST);

        ImageIcon image = new ImageIcon("icon.png");
        this.setIconImage(image.getImage());
    }

    void page1() {

        JLabel label = new JLabel();
        label.setText("AIRLINE TYPE");
        label.setFont(lemonMilk);
        label.setForeground(Color.white);
        label.setVerticalAlignment(0);
        label.setHorizontalAlignment(JLabel.CENTER);

        //RADIO BUTTONS
        unselected = new ImageIcon(new ImageIcon("unChecked.png").getImage().getScaledInstance(50,50, Image.SCALE_DEFAULT));
        selected = new ImageIcon(new ImageIcon("Checked.png").getImage().getScaledInstance(50,50, Image.SCALE_DEFAULT));

        priv = new JRadioButton("Private");
        business = new JRadioButton("Business");
        regular = new JRadioButton("Regular");

        priv.setBackground(Color.cyan);
        business.setBackground(Color.cyan);
        regular.setBackground(Color.cyan);

        priv.setFont(lemonMilk);
        business.setFont(lemonMilk);
        regular.setFont(lemonMilk);

        priv.setForeground(Color.white);
        business.setForeground(Color.white);
        regular.setForeground(Color.white);

        priv.setFocusable(false);
        business.setFocusable(false);
        regular.setFocusable(false);

        priv.setIcon(unselected);
        business.setIcon(unselected);
        regular.setIcon(unselected);

        ButtonGroup alType = new ButtonGroup();
        alType.add(priv);
        alType.add(business);
        alType.add(regular);

        priv.addActionListener(this);
        business.addActionListener(this);
        regular.addActionListener(this);

        //CREATE BOX
        Box verticalBox = Box.createVerticalBox();
        verticalBox.add(priv);
        verticalBox.add(business);
        verticalBox.add(regular);

        leftPanel.setLayout(new BoxLayout(leftPanel,BoxLayout.PAGE_AXIS));

        //INSERT LABEL AND RADIO BUTTONS
        leftPanel.add(Box.createVerticalGlue());
        leftPanel.add(label);
        leftPanel.add(Box.createRigidArea(new Dimension(0,20)));
        leftPanel.add(verticalBox);
        leftPanel.add(Box.createRigidArea(new Dimension(0,300)));

        //SET X AXIS ALIGNMENT
        label.setAlignmentX(CENTER_ALIGNMENT);
        verticalBox.setAlignmentX(CENTER_ALIGNMENT);

    }




    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==leftbutton) {
            System.out.println("Going Left!");
        }
        if(e.getSource()==rightbutton) {
            System.out.println("Going Right!");
        }

        if(e.getSource()==priv) {
            priv.setIcon(selected);
            business.setIcon(unselected);
            regular.setIcon(unselected);
            System.out.println("You have chosen a Private Airline Type!");
        } else if (e.getSource()==business) {
            business.setIcon(selected);
            regular.setIcon(unselected);
            priv.setIcon(unselected);
            System.out.println("You have chosen a Business Airline Type!");
        } else if (e.getSource()==regular) {
            regular.setIcon(selected);
            business.setIcon(unselected);
            priv.setIcon(unselected);
            System.out.println("You have chosen a Regular Airline Type!");
        }
    }
}
