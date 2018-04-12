package tddmicroexercises.textconvertor;

import static org.junit.Assert.*;

import org.junit.Test;

public class HtmlTextConverterTest {
    private String tempFileName = "foo.txt";

    @Test
    public void getFileNameShouldReturnTheGivenFileName() {
        HtmlTextConverter converter = new HtmlTextConverter(tempFileName);
        assertEquals(tempFileName, converter.getFilename());
    }
}
