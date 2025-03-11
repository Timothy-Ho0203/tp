package seedu.address.model.person;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class SchoolTest {

    @Test
    public void equals() {
        School school = new School("NUS");

        // same object -> returns true
        assertTrue(school.equals(school));

        // same values -> returns true
        School schoolCopy = new School(school.value);
        assertTrue(school.equals(schoolCopy));

        // different types -> returns false
        assertFalse(school.equals(1));

        // null -> returns false
        assertFalse(school.equals(null));

        // different school -> returns false
        School differentRemark = new School("NTU");
        assertFalse(school.equals(differentRemark));
    }
}
