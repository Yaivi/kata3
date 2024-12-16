package software.ulpgc.kata3.control;

import software.ulpgc.kata3.model.Title;

import java.io.IOException;
import java.util.List;

public interface TitleReader {
    List<Title> readTitles() throws IOException;
}
