package com.PilotProgram;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author Oliver Dickins and Abdullah Malik
 *controls all methods that concern the cfg files and their content
 */
public class Config {
    static int x = 0;
    static int y = 0;
    static int length = 0;
    static int width = 0;
    static int r = 0;
    static int g = 0;
    static int b = 0;
/**
 * reads the cfg file for a given game
 * @throws Exception
 */
    public static void readConfig() throws Exception {
        // list that holds strings of a file
        List<String> listOfStrings = new ArrayList<String>();

        // load data from file
        BufferedReader bf = new BufferedReader(new FileReader("cfg" + Game.getGameInfo() + ".cfg"));

        // read entire line as string
        String line = bf.readLine();

        // checking for end of file
        while (line != null) {
            listOfStrings.add(line);
            line = bf.readLine();
        }

        // closing buffer reader object
        bf.close();

        // storing the data in arraylist to array
        String[] vars = listOfStrings.toArray(new String[0]);

        x = Integer.parseInt(vars[1]);
        y = Integer.parseInt(vars[3]);
        length = Integer.parseInt(vars[5]);
        width = Integer.parseInt(vars[7]);
        r = Integer.parseInt(vars[9]);
        g = Integer.parseInt(vars[11]);
        b = Integer.parseInt(vars[13]);
    }
/**
 * returns the x value for the screenshot
 * @return
 */
    public static int getX() {
        return x;
    }
    /**
     * returns the y value for the screenshot
     * @return
     */
    public static int getY() {
        return y;
    }
    /**
     * returns the length of the screenshot
     * @return
     */
    public static int getLength() {
        return length;
    }
    /**
     * returns the width of the screenshot
     * @return
     */
    public static int getWidth() {
        return width;
    }
/**
 * returns the red value in cfg file
 * @return
 */
    public static int getR() {
        return r;
    }
    /**
     * returns the green value in cfg file
     * @return
     */
    public static int getG() {
        return g;
    }
    /**
     * returns the blue value in cfg file
     * @return
     */
    public static int getB() {
        return b;
    }

}
