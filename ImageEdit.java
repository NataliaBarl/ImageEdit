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
	// Режим рисования 
   // int  rezhim=0; 
    MyFrame f;
    // поверхность рисования
    //BufferedImage imag;

    public ImageEdit()
    {
        f=new MyFrame("ГрафPед");
        f.setSize(350,350);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       // maincolor=Color.black;
        
        JMenuBar menuBar = new  JMenuBar();
        f.setJMenuBar(menuBar);
        menuBar.setBounds(0,0,350,30);
        JMenu fileMenu = new  JMenu("Файл");
        menuBar.add(fileMenu);
        
        
        JToolBar toolbar = new  JToolBar("Toolbar", JToolBar.VERTICAL);
        
        JButton penbutton = new  JButton(new  ImageIcon("pen.png"));
        toolbar.add(penbutton);
        
        JButton brushbutton = new  JButton(new  ImageIcon("brush.png"));
        toolbar.add(brushbutton);
         
        JButton lasticbutton = new JButton(new  ImageIcon("lastic.png"));
        toolbar.add(lasticbutton);
         
        JButton textbutton = new  JButton(new  ImageIcon("text.png"));
        toolbar.add(textbutton);
         
        JButton linebutton = new  JButton(new  ImageIcon("line.png"));
        toolbar.add(linebutton);
         
        JButton elipsbutton = new  JButton(new  ImageIcon("elips.png"));
        toolbar.add(elipsbutton);
         
        JButton rectbutton = new  JButton(new  ImageIcon("rect.png"));
        toolbar.add(rectbutton);
         
        toolbar.setBounds(0, 0, 30, 300);
        f.add(toolbar);
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
    
  }


        

