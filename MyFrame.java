package com.jextercaber;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class MyFrame extends JFrame implements ActionListener {

    int cnt = 1;
    int AT = 0;
    int passengerAmount;
    int page2CurrentNumberValue;

    JButton leftbutton;
    JButton rightbutton;

    JButton page2ListConfirm;

    Font lemonMilk;
    JRadioButton priv;
    JRadioButton business;
    JRadioButton regular;
    JPanel leftPanel;
    JPanel rightPanel;

    JLabel pageCount;

    JComboBox<String> numberList;

    ImageIcon unselected;
    ImageIcon selected;

    MyFrame() {

        leftPanel = new JPanel();
        leftPanel.setBackground(Color.cyan);
        leftPanel.setPreferredSize(new Dimension(512,500));

        rightPanel = new JPanel();
        rightPanel.setBackground(Color.white);
        rightPanel.setPreferredSize(new Dimension(512,500));

        rightSide();
        page1();

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

    void rightSide() {

        rightPanel.removeAll();
        rightPanel.revalidate();
        rightPanel.repaint();

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
        pageCount = new JLabel(pageCounting(cnt));
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
    }

    void page1() {

        leftPanel.removeAll();
        leftPanel.revalidate();
        leftPanel.repaint();

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

    void page2() {

        leftPanel.removeAll();
        leftPanel.revalidate();
        leftPanel.repaint();

        try {
            lemonMilk = Font.createFont(Font.TRUETYPE_FONT, new File("LemonMilk.ttf")).deriveFont(20f);
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        try {
            ge.registerFont(Font.createFont(Font.TRUETYPE_FONT, new File("LemonMilk.ttf")));
        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }

        //CREATE TOP, CENTER, AND BOTTOM PANES IN LEFT PANE
        JPanel page2TopPane = new JPanel();
        JPanel page2CenterPane = new JPanel();
        JPanel page2BottomPane = new JPanel();


        //CREATE LABEL
        JLabel label1 = new JLabel("Input number of passengers: ");
        label1.setFont(lemonMilk);
        label1.setForeground(Color.white);


        //CREATE COMBO BOX
        passengerAmount = passengerNumber(AT);
        String[] comboBoxElements = comboBoxItems(passengerAmount);
        numberList = new JComboBox<>(comboBoxElements);

        //CREATE BUTTON
        page2ListConfirm = new JButton("Confirm");
        page2ListConfirm.addActionListener(this);

        //CREATE HORIZONTAL BOX 1
        Box horizontalBox = Box.createHorizontalBox();

        horizontalBox.add(label1);
        horizontalBox.add(Box.createRigidArea(new Dimension(15,0)));
        horizontalBox.add(numberList);
        horizontalBox.add(Box.createRigidArea(new Dimension(15,0)));
        horizontalBox.add(page2ListConfirm);

        //SET LEFT PANE TO BORDER LAYOUT
        leftPanel.setLayout(new BorderLayout());
        leftPanel.add(page2TopPane, BorderLayout.NORTH);
        leftPanel.add(page2CenterPane, BorderLayout.CENTER);
        leftPanel.add(page2BottomPane, BorderLayout.SOUTH);

        //SET COLOR OF PANES
        page2TopPane.setBackground(Color.cyan);
        page2CenterPane.setBackground(Color.cyan);
        page2BottomPane.setBackground(Color.cyan);

        //SET PREFERRED SIZE OF PANES
        page2TopPane.setPreferredSize(new Dimension(512, 200));
        page2CenterPane.setPreferredSize(new Dimension(512, 400));
        page2BottomPane.setPreferredSize(new Dimension(512, 150));

        //INSERT COMPONENTS IN TOP PANE
        page2TopPane.add(horizontalBox);

    }

    public int passengerNumber(int AT) {
        int amount=0;

        if(AT==1) {
            amount=14;
        } else if (AT==2) {
            amount=23;
        } else if (AT==3) {
            amount=38;
        } else {
            System.out.println("Invalid Input.");
        }

        return amount;
    }

    public String[] comboBoxItems(int passengerAmount) {
       String[] array = new String[passengerAmount];
       String holding;
       int i = 0;

       do{
           holding = String.valueOf(i+1);
           array[i] = holding;
           i++;
       }while(i<passengerAmount);

        return array;
    }

    public String pageCounting(int cnt) {
        String count = "";

        if(cnt==1) {
            count = "1/4";
        } else if (cnt==2) {
            count = "2/4";
        } else if (cnt==3) {
            count = "3/4";
        } else if (cnt==4) {
            count = "4/4";
        } else {
            System.out.println("Invalid cnt");
        }

        return count;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //PAGE1
        if(e.getSource()==leftbutton) {
            if (cnt == 1){
                System.out.println("Can't Go Left!");
            } else if (cnt == 2) {
                cnt = cnt - 1;
                page1();
                rightSide();
                System.out.println("Went to Page 1");
            } else if (cnt == 3) {
                System.out.println("Not Implemented");
            } else if (cnt == 4) {
                System.out.println("Not Implemented");
            }
        }
        if(e.getSource()==rightbutton) {
            if (cnt == 1){
                cnt = cnt + 1;
                page2();
                rightSide();
                System.out.println("Went to Page 2");
            } else if (cnt == 2) {
                System.out.println("Not Implemented");
            } else if (cnt == 3) {
                System.out.println("Not Implemented");
            } else if (cnt == 4) {
                System.out.println("Can't Go Right!");
            }
        }

        //RIGHT PANE
        if(e.getSource()==priv) {
            priv.setIcon(selected);
            business.setIcon(unselected);
            regular.setIcon(unselected);

            AT = 1;
            System.out.println("You have chosen a Private Airline Type!");
        } else if (e.getSource()==business) {
            business.setIcon(selected);
            regular.setIcon(unselected);
            priv.setIcon(unselected);

            AT = 2;
            System.out.println("You have chosen a Business Airline Type!");
        } else if (e.getSource()==regular) {
            regular.setIcon(selected);
            business.setIcon(unselected);
            priv.setIcon(unselected);

            AT = 3;
            System.out.println("You have chosen a Regular Airline Type!");
        }

        //PAGE2
        if(e.getSource()==page2ListConfirm) {
            page2CurrentNumberValue = numberList.getSelectedIndex() + 1;
        }
    }
}
