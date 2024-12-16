package software.ulpgc.kata3.control;

import software.ulpgc.kata3.model.Title;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TsvFileTitleReader implements TitleReader {
    private final File file;

    public TsvFileTitleReader(File file) {
        this.file = file;
    }

    @Override
    public List<Title> readTitles() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        reader.readLine();
        return readWith(reader);
    }

    private List<Title> readWith(BufferedReader reader) throws IOException {
        TsvTitleDeserializer deserializer = new TsvTitleDeserializer();
        List<Title> titles = new ArrayList<>();
        while (true) {
            String line = reader.readLine();
            if (line == null) break;
            titles.add(new TsvTitleDeserializer().deserialize(line));
        }
        return titles;
    }
}
