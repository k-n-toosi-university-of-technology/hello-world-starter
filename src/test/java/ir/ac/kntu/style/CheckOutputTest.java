/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ir.ac.kntu.style;

import ir.ac.kntu.HelloWorld;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintStream;
import static java.lang.System.in;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author mhrimaz
 */
public class CheckOutputTest {

    @Test
    public void testOutput() {
        PrintStream printStream = null;
        try {
            File output = new File("output.txt");
            printStream = new PrintStream(output);
            try (BufferedReader reader = new BufferedReader(new FileReader(output))) {
                System.setOut(printStream);
                HelloWorld.main(new String[]{});
                Assert.assertTrue(reader.readLine().equalsIgnoreCase("Hello World!"));
            } catch (Exception ex) {
                Assert.fail(ex.getMessage());
            }
        } catch (Exception ex) {
            Assert.fail(ex.getMessage());

        } finally {
            printStream.close();
        }
    }
}
