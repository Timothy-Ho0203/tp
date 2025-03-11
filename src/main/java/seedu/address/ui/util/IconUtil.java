package seedu.address.ui.util;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.scene.paint.Color;

/**
 * Utility class for creating FontAwesome icons.
 */
public class IconUtil {

    /**
     * Creates a FontAwesome icon with the specified properties.
     */
    public static FontAwesomeIconView createIcon(FontAwesomeIcon icon, String color, int size) {
        FontAwesomeIconView iconView = new FontAwesomeIconView(icon);
        iconView.setFill(Color.web(color));
        iconView.setGlyphSize(size);
        return iconView;
    }

    /**
     * Creates a default-sized FontAwesome icon with the specified properties.
     */
    public static FontAwesomeIconView createIcon(FontAwesomeIcon icon, String color) {
        return createIcon(icon, color, 16);
    }

    /**
     * Creates a default FontAwesome icon (black, size 16).
     */
    public static FontAwesomeIconView createIcon(FontAwesomeIcon icon) {
        return createIcon(icon, "#000", 16);
    }
}
