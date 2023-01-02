import org.junit.jupiter.api.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

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
}
