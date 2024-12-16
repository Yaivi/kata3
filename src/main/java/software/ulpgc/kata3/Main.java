package software.ulpgc.kata3;


import software.ulpgc.kata3.control.TitleReader;
import software.ulpgc.kata3.control.TitleTypeHistogram;
import software.ulpgc.kata3.control.TsvFileTitleReader;
import software.ulpgc.kata3.model.Histogram;
import software.ulpgc.kata3.view.MainFrame;

import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        TitleReader reader = new TsvFileTitleReader(new File("content.txt"));
        Histogram histogram = new TitleTypeHistogram(reader.readTitles());
        MainFrame mainFrame = new MainFrame();
        mainFrame.showHistogramDisplay(histogram);
        mainFrame.setVisible(true);
    }

}
