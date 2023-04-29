import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BasicInputStreamTest {

    @Test
    public void readDataFromInputStream() throws IOException {
        try (InputStream basicInputStream = new FileInputStream("dummy.txt")) {
            int totalByteRead = 0;
            while (basicInputStream.read() > 0) {
                totalByteRead++;
            }
            System.out.println("Total byte read = " + totalByteRead);
            assertTrue(totalByteRead > 0);
        }
    }

    @Test
    public void writeToOutputStream() throws IOException {
        var originalString = "This is my first output to stream";
        try (OutputStream basicOutputStream = new FileOutputStream("dummy_out.txt")) {
            basicOutputStream.write(originalString.getBytes(StandardCharsets.UTF_8));
        }

        try (InputStream input = new FileInputStream("dummy_out.txt")) {
            var result = new String(input.readAllBytes());
            assertEquals(originalString, result);
        }
    }
    
    @Test
    public void combiningStream() throws IOException {
        var expectedOutput = """
                Hello, from someone reading this file.
                This is another line
                """;
        var inputStream = new BufferedInputStream(new FileInputStream("dummy.txt"));
        var fileContent = new String(inputStream.readAllBytes());
        assertEquals(expectedOutput, fileContent);
    }
}
