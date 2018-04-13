package tddmicroexercises.textconvertor;

import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class HtmlTextConverterTest {
    private String tempFileName = "foo.txt";
    private FileLinesReader reader = mock(FileLinesReader.class);

    @Test
    public void getFileNameShouldReturnTheGivenFileName() {
        HtmlTextConverter converter = new HtmlTextConverter(tempFileName);
        assertEquals(tempFileName, converter.getFilename());
    }

    @Test
    public void convertToHtmlShouldReturnEscapedHtmlWithNewLineBreaks() throws IOException {
        when(reader.readLine()).thenReturn("First \"line\"", "'r1 < 2 & 2 > 1'", null);
        HtmlTextConverter converter = new HtmlTextConverter(reader);

        String expected = "First &quot;line&quot;<br />&quot;r1 &lt; 2 &amp; 2 &gt; 1&quot;<br />";
        assertEquals(expected, converter.convertToHtml());
    }

    @Test
    public void convertToHtmlShouldConvertEmptyStringToSingleBreackLine() throws IOException {
        when(reader.readLine()).thenReturn("", null);
        HtmlTextConverter converter = new HtmlTextConverter(reader);

        assertEquals("<br />", converter.convertToHtml());
    }
}
