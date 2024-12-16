package software.ulpgc.kata3.control;

import software.ulpgc.kata3.model.Title;

public class TsvTitleDeserializer implements TitleDeserializer {
    @Override
    public Title deserialize(String data) {
        return deserialize_array(data.split("\t"));
    }

    private Title deserialize_array(String[] split) {
        return new Title(split[0],toTilteType(split[1]), split[2], split[3], toInteger(split[4]), toInteger(split[5]), toInteger(split[6]),  toInteger(split[7]));
    }

    private int toInteger(String s) {
        if (s.equals("\\N")) {
            return 0;
        }
        return Integer.parseInt(s);
    }

    private Title.TitleType toTilteType(String s) {
        return Title.TitleType.valueOf(normalize(s));
    }

    private String normalize(String s) {
        String upper = s.toUpperCase();
        String temp = s.replace("-", "");
        return upper.toCharArray()[0] + temp.substring(1);
    }
}
