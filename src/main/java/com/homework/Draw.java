package com.homework;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Draw {

    public void drawImages(JPanel panel,String path,int[] position) throws IOException {
        Graphics graphics = panel.getGraphics();
        Image image =  ImageIO.read(new File(path));
        graphics.drawImage(image,position[0],position[1],80,97,panel);
    }

    public void drawString(JPanel panel,String n,int[] position) throws IOException {
        Graphics graphics = panel.getGraphics();
        graphics.drawString(n,position[0],position[1]);
    }
}
