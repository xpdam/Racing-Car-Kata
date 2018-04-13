package tddmicroexercises.textconvertor;

import java.io.*;

public class HtmlTextConverter
{
    private LinesReader reader;

    public HtmlTextConverter(String fullFilenameWithPath) {
        this(new FileLinesReader(fullFilenameWithPath));
    }

    public HtmlTextConverter(LinesReader reader) {
        this.reader = reader;
    }

    public String convertToHtml() throws IOException {
	    String line = reader.readLine();
	    String html = "";
	    while (line != null)
	    {
	    	html += StringEscapeUtils.escapeHtml(line);
	        html += "<br />";
	        line = reader.readLine();
	    }
	    return html;
    }

	public String getFilename() {
		return reader.getFilename();
	}
}
