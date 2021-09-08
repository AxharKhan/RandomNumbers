package randomfile;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Axhar Ali
 */
public class GenerateStore {

    public GenerateStore() {

        RandomFile rf;
        rf = new RandomFile();

        PrintStream outs = null;
        try {

            outs = new PrintStream(new FileOutputStream("C:\\Users\\wante\\Desktop\\output.txt"));
            Random random = new Random();

            // Generating Random data
            for (int i = 0; i < 10000; i++) {
                char c = rf.chars[random.nextInt(rf.chars.length)];
                int d = Character.getNumericValue(c);
                rf.arr[d] = rf.arr[d] + 1;
            }

            // For Display in Console
            for (int i = 0; i < 10; i++) {
                System.out.println("Occurance of " + i + " ------>" + rf.arr[i]);
                String str = "Occurance of " + i + " ------> " + rf.arr[i];
                outs.println(str);
            }

            System.setOut(outs);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(RandomFile.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            outs.close();
        }

    }

}
