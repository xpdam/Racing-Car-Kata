package tddmicroexercises.textconvertor;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static tddmicroexercises.textconvertor.StringEscapeUtils.escapeHtml;

public class StringEscapeUtilsTest {
    @Test
    public void shouldReturnEmptyStringOnEmptyInput() {
        assertEquals("", escapeHtml(""));
    }
}
