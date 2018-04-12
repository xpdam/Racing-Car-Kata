package tddmicroexercises.textconvertor;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class HtmlTextConverterTest {
    private String tempFileName = "foo.txt";

    @Before
    public void setUp() throws IOException {
        String content = "First \"line\"\n'r1 < 2 & 2 > 1'";

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
        HtmlTextConverter converter = new HtmlTextConverter(tempFileName);
        assertEquals(tempFileName, converter.getFilename());
    }

    @Test
    public void convertToHtmlShouldReturnEscapedHtmlWithNewLineBreaks() throws IOException {
        HtmlTextConverter converter = new HtmlTextConverter(tempFileName);

        String expected = "First &quot;line&quot;<br />&quot;r1 &lt; 2 &amp; 2 &gt; 1&quot;<br />";
        assertEquals(expected, converter.convertToHtml());
    }
}
