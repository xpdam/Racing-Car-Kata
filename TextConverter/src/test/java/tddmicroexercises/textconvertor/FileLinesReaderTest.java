package tddmicroexercises.textconvertor;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class FileLinesReaderTest {
    private String tempFileName = "foo.txt";

    @Before
    public void setUp() throws IOException {
        String content = "First line\nSecond line";

        File tempFile = new File(tempFileName);
        FileWriter fileWriter = new FileWriter(tempFile);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(content);
        bufferedWriter.close();
    }

    @After
    public void tearDown() {
        File file = new File(tempFileName);
        file.delete();
    }

    @Test
    public void getFileNameShouldReturnTheGivenFileName() {
        FileLinesReader reader = new FileLinesReader(tempFileName);
        assertEquals(tempFileName, reader.getFilename());
    }

    @Test(expected = IOException.class)
    public void readLineShouldThrowIOExceptionIfFileDoesNotExist() throws IOException {
        FileLinesReader reader = new FileLinesReader("/path/to/nonExistent/file");
        reader.readLine();
    }

    @Test
    public void readLineShouldReturnTheNextLine() throws IOException {
        FileLinesReader reader = new FileLinesReader(tempFileName);

        String line1 = reader.readLine();
        String line2 = reader.readLine();

        assertEquals("First line", line1);
        assertEquals("Second line", line2);
    }

    @Test
    public void readLineShouldReturnNullAfterAllLinesHaveBeenRead() throws IOException {
        FileLinesReader reader = new FileLinesReader(tempFileName);

        reader.readLine();
        reader.readLine();

        assertEquals(null, reader.readLine());
    }
}
