package seedu.address.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import javafx.scene.Scene;
import javafx.stage.Stage;
import seedu.address.model.person.Person;
import seedu.address.testutil.PersonBuilder;

public class MiniPersonCardTest extends ApplicationTest {
    private MiniPersonCard miniPersonCard;
    private Person testPerson;

    @Override
    public void start(Stage stage) {
        testPerson = new PersonBuilder()
            .withName("John Doe")
            .withSchool("NUS")
            .withTags("Java", "Python")
            .build();
        miniPersonCard = new MiniPersonCard(testPerson);
        stage.setScene(new Scene(miniPersonCard.getRoot()));
        stage.show();
    }

    @Test
    public void display() {
        // Verify that the card shows correct information
        assertEquals(testPerson.getName().toString(), miniPersonCard.name.getText());
        assertEquals(testPerson.getSchool().toString(), miniPersonCard.school.getText());
        
        // Verify skills are displayed
        assertEquals(2, miniPersonCard.skills.getChildren().size());
    }
} 