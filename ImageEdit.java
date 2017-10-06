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
    public ImageEdit()
    {
        f=new MyFrame("ÃנאפPוה");
        f.setSize(350,350);
        f.setVisible(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          }
    public static void main(String[] args) {
        
       // SwingUtilities.invokeLater(new  Runnable() {
    // public void run() {
        new  ImageEdit();
     // }
    //});        
    }
    class MyFrame extends JFrame
    {
        public MyFrame(String title)
        {
           super(title);
        }
    }
    
  }


        

