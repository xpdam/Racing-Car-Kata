package tddmicroexercises.textconvertor;

import java.io.IOException;

public interface LinesReader {
    String readLine() throws IOException;
    String getFilename();
}
