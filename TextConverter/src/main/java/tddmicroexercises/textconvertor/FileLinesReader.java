package tddmicroexercises.textconvertor;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileLinesReader {
    private String fullFilenameWithPath;
    private BufferedReader reader;

    FileLinesReader(String fullFilenameWithPath) {
        this.fullFilenameWithPath = fullFilenameWithPath;
    }

    public String readLine() throws IOException {
        if (reader == null) {
            reader = new BufferedReader(new FileReader(fullFilenameWithPath));
        }
        return reader.readLine();
    }

    public String getFilename() {
        return fullFilenameWithPath;
    }
}
