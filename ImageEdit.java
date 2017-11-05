import  java.awt.*;
import  java.awt.geom.*;
import  java.awt.event.*;
import  java.io.*;

import  javax.swing.*;
import  javax.swing.event.*;

import  java.awt.image.*;

import  javax.imageio.*;
import  javax.swing.filechooser.FileFilter;
import  javax.swing.JFrame;


public class ImageEdit {
    MyFrame f;
    MyPanel japan;
    JButton colorbutton;
 // Режим рисования 
    int  rezhim=0;
    int  xPad;
    int  xf;
    int  yf;
    int  yPad;
    int  thickness;
    boolean pressed=false;
    Color maincolor;
    // поверхность рисования
    BufferedImage imag;


    public ImageEdit()
    {
        f=new MyFrame("Image Edit");
        f.setSize(350,350);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        maincolor=Color.black;
        
        JMenuBar menuBar = new  JMenuBar();
        f.setJMenuBar(menuBar);
        menuBar.setBounds(0,0,350,30);
        JMenu fileMenu = new  JMenu("File");
        menuBar.add(fileMenu);
        
        japan = new  MyPanel();
        japan.setBounds(30,30,260,260);
        japan.setBackground(Color.white);
        japan.setOpaque(true);
        f.add(japan);
        
        JToolBar toolbar = new  JToolBar("Toolbar", JToolBar.VERTICAL);
        
        JButton penbutton = new  JButton(new  ImageIcon("pen.png"));
        penbutton.addActionListener(new  ActionListener()
        {
          public void actionPerformed(ActionEvent event)
          { 
            rezhim=0;
          }
        });
        toolbar.add(penbutton);
        
        JButton brushbutton = new  JButton(new  ImageIcon("brush.png"));
        brushbutton.addActionListener(new  ActionListener()
        {
          public void actionPerformed(ActionEvent event)
          { 
            rezhim=1;
          }
        });
        toolbar.add(brushbutton);
         
        JButton lasticbutton = new JButton(new  ImageIcon("lastic.png"));
        lasticbutton.addActionListener(new  ActionListener()
        {
          public void actionPerformed(ActionEvent event)
          { 
            rezhim=2;
          }
        });
        toolbar.add(lasticbutton);
         
        JButton textbutton = new  JButton(new  ImageIcon("text.png"));
        textbutton.addActionListener(new  ActionListener()
        {
          public void actionPerformed(ActionEvent event)
          { 
            rezhim=3;
          }
        });
        toolbar.add(textbutton);
         
        JButton linebutton = new  JButton(new  ImageIcon("line.png"));
        linebutton.addActionListener(new  ActionListener()
        {
          public void actionPerformed(ActionEvent event)
          { 
            rezhim=4;
          }
        });
        toolbar.add(linebutton);
         
        JButton elipsbutton = new  JButton(new  ImageIcon("elips.png"));
        elipsbutton.addActionListener(new  ActionListener(){
            public void actionPerformed(ActionEvent event)
            { 
              rezhim=5;
            }
          });
        toolbar.add(elipsbutton);
         
        JButton rectbutton = new  JButton(new  ImageIcon("rect.png"));
        rectbutton.addActionListener(new  ActionListener()
        {
          public void actionPerformed(ActionEvent event)
          { 
            rezhim=6;
          }
        });
        toolbar.add(rectbutton);
         
        toolbar.setBounds(0, 0, 30, 300);
        f.add(toolbar);
        
        japan.addMouseListener(new  MouseAdapter()
        {
           public void mouseClicked(MouseEvent e) {
                 
           Graphics g = imag.getGraphics();
           Graphics2D g2 = (Graphics2D)g;
           // установка цвета
              //  g2.setColor(maincolor);
           maincolor=Color.black;
                switch (rezhim)
                {
                    // карандаш
                    case 0:
                        g2.drawLine(xPad, yPad, xPad+1, yPad+1);
                        break;
                    // кисть
                    case 1:
                        g2.setStroke(new  BasicStroke(3.0f));
                        g2.drawLine(xPad, yPad, xPad+1, yPad+1);
                        break;
                     // ластик
                    case 2:
                        g2.setStroke(new  BasicStroke(3.0f));
                         g2.setColor(Color.WHITE);
                         g2.drawLine(xPad, yPad, xPad+1, yPad+1);
                    break;
                    // текст
                    case 3:
                        // устанавливаем фокус для панели,
                        // чтобы печатать на ней текст
                        japan.requestFocus();
                    break;       
                }
                xPad=e.getX();
                yPad=e.getY();
                 
                pressed=true;
                japan.repaint();      
         }
           public void mousePressed(MouseEvent e) {
               xPad=e.getX();
                yPad=e.getY();
                xf=e.getX();
                yf=e.getY();
                pressed=true;
              }
          public void mouseReleased(MouseEvent e) {
               
              Graphics g = imag.getGraphics();
              Graphics2D g2 = (Graphics2D)g;
              // установка цвета
                //g2.setColor(maincolor);
              maincolor=Color.black;
              // Общие рассчеты для овала и прямоугольника
              int  x1=xf, x2=xPad, y1=yf, y2=yPad;
                        if(xf>xPad)
                        {
                           x2=xf; x1=xPad; 
                        }
                        if(yf>yPad)
                        {
                           y2=yf; y1=yPad; 
                        }
              switch(rezhim)
              {
                   // линия
                    case 4:
                       g.drawLine(xf, yf, e.getX(), e.getY());
                        break;
                    // круг
                    case 5:
                        g.drawOval(x1, y1, (x2-x1), (y2-y1));
                        break;
                        // прямоугольник
                    case 6:
                        g.drawRect(x1, y1, (x2-x1), (y2-y1));
                        break;
              }
              xf=0; yf=0;
              pressed=false;
              japan.repaint();
          }
        });
          }
    public static void main(String[] args) {
        
        new  ImageEdit();       
    }
    class MyFrame extends JFrame
    {
        public MyFrame(String title)
        {
           super(title);
        }
    }
    class MyPanel extends JPanel
    {
        public MyPanel()
        { }
      public void paintComponent (Graphics g)
         {
           if(imag==null)
            {
                imag = new  BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_RGB);
                Graphics2D d2 = (Graphics2D) imag.createGraphics();
                d2.setColor(Color.white);
                d2.fillRect(0, 0, this.getWidth(), this.getHeight());
            }
            super.paintComponent(g);
            g.drawImage(imag, 0, 0,this);      
         }
    }
    
  }


        

