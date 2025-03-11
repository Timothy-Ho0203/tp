package seedu.address.ui.util;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.scene.paint.Color;

public class IconUtilTest {

    @Test
    public void createIcon_withDefaultValues_returnsCorrectIcon() {
        FontAwesomeIconView icon = IconUtil.createIcon(FontAwesomeIcon.USER);

        assertNotNull(icon);
        assertEquals(16, icon.getGlyphSize());
        assertEquals(Color.web("#000"), icon.getFill());
    }

    @Test
    public void createIcon_withCustomColor_returnsCorrectIcon() {
        FontAwesomeIconView icon = IconUtil.createIcon(FontAwesomeIcon.USER, "white");

        assertNotNull(icon);
        assertEquals(16, icon.getGlyphSize());
        assertEquals(Color.web("white"), icon.getFill());
    }

    @Test
    public void createIcon_withCustomColorAndSize_returnsCorrectIcon() {
        FontAwesomeIconView icon = IconUtil.createIcon(FontAwesomeIcon.USER, "red", 24);

        assertNotNull(icon);
        assertEquals(24, icon.getGlyphSize());
        assertEquals(Color.web("red"), icon.getFill());
    }
}
