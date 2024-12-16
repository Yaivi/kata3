package software.ulpgc.kata3.control;

import software.ulpgc.kata3.model.Title;

public interface TitleDeserializer {
    Title deserialize(String data);
}

