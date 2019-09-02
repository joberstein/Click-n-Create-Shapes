package utils;

import java.awt.*;

public class ColorUtils {

    public static int getRGB(String hex) {
        return Color.decode(hex).getRGB();
    }
}
