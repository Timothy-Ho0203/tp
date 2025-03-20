package seedu.address.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationTest;

import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import seedu.address.model.application.Application;
import seedu.address.model.job.Job;
import seedu.address.testutil.JobBuilderFX;

public class JobCardTest extends ApplicationTest {
    private JobCard jobCard;
    private Job testJob;
    private FxRobot robot;

    @Override
    public void start(Stage stage) {
        robot = new FxRobot();
        testJob = new JobBuilderFX()
            .withTitle("Software Engineer")
            .withCompany("Google")
            .withRounds(3)
            .build();
        List<Application> applications = new ArrayList<>();
        jobCard = new JobCard(testJob, applications, 1);
        stage.setScene(new Scene(jobCard.getRoot()));
        stage.show();
    }

    @Test
    public void display() {
        // Verify basic information display using TestFX
        assertCardDisplay(jobCard, testJob, 1);
    }

    /**
     * Asserts that {@code jobCard} displays the details of {@code expectedJob} correctly and matches
     * {@code expectedId}.
     */
    private void assertCardDisplay(JobCard jobCard, Job expectedJob, int expectedId) {
        Label idLabel = robot.lookup("#id").queryAs(Label.class);
        Label titleLabel = robot.lookup("#jobTitle").queryAs(Label.class);
        Label companyLabel = robot.lookup("#company").queryAs(Label.class);
        Label roundsLabel = robot.lookup("#jobRounds").queryAs(Label.class);
        Label applicationsLabel = robot.lookup("#applications").queryAs(Label.class);

        assertEquals(expectedId + ". ", idLabel.getText());
        assertEquals(expectedJob.getJobTitle().jobTitle(), titleLabel.getText());
        assertEquals(expectedJob.getJobCompany().jobCompany(), companyLabel.getText());
        assertEquals("Rounds: " + expectedJob.getJobRounds().jobRounds, roundsLabel.getText());
        assertEquals("Applications: 0", applicationsLabel.getText());
    }

    @Test
    public void equals() {
        // Same job, same index -> returns true
        JobCard copy = new JobCard(testJob, new ArrayList<>(), 1);
        assertTrue(jobCard.equals(copy));

        // Same object -> returns true
        assertTrue(jobCard.equals(jobCard));

        // Different types -> returns false
        assertFalse(jobCard.equals(1));

        // Different job, same index -> returns false
        Job differentJob = new JobBuilderFX().withTitle("Different Job").build();
        JobCard differentCard = new JobCard(differentJob, new ArrayList<>(), 1);
        assertFalse(jobCard.equals(differentCard));
    }
}
