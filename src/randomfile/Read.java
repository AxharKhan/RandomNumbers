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

    public int[] retarr() {
        // Reads and Stores in an array and returns that array when called
        int[] arr = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
        BufferedReader in;
        try {
            in = new BufferedReader(new FileReader("C:\\Users\\wante\\Desktop\\output.txt"));

            String line;
            try {
                int i = 0;
                while ((line = in.readLine()) != null) {
                    System.out.println(line);
                    String[] splited = line.split("\\s+");
                    arr[i] = Integer.parseInt(splited[4]);
                    i++;
                    if (i == 10) {
                        break;
                    }
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
