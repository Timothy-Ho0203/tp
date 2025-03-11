package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class DegreeTest {
    @Test
    public void equals() {
        Degree degree = new Degree("Computer Science");

        // same object -> returns true
        assertTrue(degree.equals(degree));

        // same values -> returns true
        Degree degreeCopy = new Degree(degree.value);
        assertTrue(degree.equals(degreeCopy));

        // different types -> returns false
        assertFalse(degree.equals(1));

        // null -> returns false
        assertFalse(degree.equals(null));

        // different degree -> returns false
        Degree differentRemark = new Degree("Business Analytics");
        assertFalse(degree.equals(differentRemark));
    }
}
