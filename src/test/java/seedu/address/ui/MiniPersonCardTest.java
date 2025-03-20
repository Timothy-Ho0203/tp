package seedu.address.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationTest;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;
import seedu.address.model.person.Person;
import seedu.address.testutil.PersonBuilder;

public class MiniPersonCardTest extends ApplicationTest {
    private MiniPersonCard miniPersonCard;
    private Person testPerson;
    private FxRobot robot;

    @Override
    public void start(Stage stage) {
        robot = new FxRobot();
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
        // Verify that the card shows correct information using TestFX
        Label nameLabel = robot.lookup("#name").queryAs(Label.class);
        Label schoolLabel = robot.lookup("#school").queryAs(Label.class);
        FlowPane skillsPane = robot.lookup("#skills").queryAs(FlowPane.class);

        assertEquals(testPerson.getName().toString(), nameLabel.getText());
        assertEquals(testPerson.getSchool().toString(), schoolLabel.getText());
        // Verify skills are displayed
        assertEquals(2, skillsPane.getChildren().size());
    }
}
