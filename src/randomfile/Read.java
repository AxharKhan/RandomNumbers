/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package randomfile;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Ashar Ali
 */
public class Read {

    public int[] retarr(int seed) {
        // Reads and Stores in an array and returns that array when called
        int[] arr = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        BufferedReader in;
        try {
            in = new BufferedReader(new FileReader(".\\output\\" + seed + ".txt"));

            String line;
            try {
                int i = 0;
                while ((line = in.readLine()) != null) {

                    String[] splited = line.split("\\s+");
                    arr[i] = Integer.parseInt(splited[4]);
                    i++;
                    if (i == 10) {
                        break;
                    }
                }
                for (int k = 0; k < 10; k++) {
                    System.out.println(arr[k]);
                }
                in.close();

            } catch (IOException ex) {
                Logger.getLogger(Graphgui.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Graphgui.class.getName()).log(Level.SEVERE, null, ex);
        }

        return (arr);
    }

    public int[] retarr2(int seed) {
        // Reads and Stores in an array and returns that array when called
        int[] arr = new int[10000];
        BufferedReader in;
        String line2 = "";
        try {
            in = new BufferedReader(new FileReader(".\\output\\" + seed + ".txt"));

            String line;
            try {
                int i = 0;
                while ((line = in.readLine()) != null) {

                    i++;
                    if (i == 10) {
                        break;
                    }
                }
                line2 = in.readLine();
                String[] splited2 = line2.split(",");
                for (int k = 0; k < 10000; k++) {
                    arr[k] = Integer.parseInt(splited2[k]);
                }
                in.close();

            } catch (IOException ex) {
                Logger.getLogger(Graphgui.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Graphgui.class.getName()).log(Level.SEVERE, null, ex);
        }

        return (arr);
    }

}
