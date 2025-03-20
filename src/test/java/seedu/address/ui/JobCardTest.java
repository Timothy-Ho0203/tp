package seedu.address.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import javafx.scene.Scene;
import javafx.stage.Stage;
import seedu.address.model.application.Application;
import seedu.address.model.job.Job;
import seedu.address.testutil.JobBuilder;

public class JobCardTest extends ApplicationTest {
    private JobCard jobCard;
    private Job testJob;

    @Override
    public void start(Stage stage) {
        testJob = new JobBuilder()
            .withTitle("Software Engineer")
            .withCompany("Google")
            .withRounds("3")
            .build();
        List<Application> applications = new ArrayList<>();
        jobCard = new JobCard(testJob, applications, 1);
        stage.setScene(new Scene(jobCard.getRoot()));
        stage.show();
    }

    @Test
    public void display() {
        // Verify basic information display
        assertEquals("1. ", jobCard.id.getText());
        assertEquals(testJob.getJobTitle().jobTitle(), jobCard.jobTitle.getText());
        assertEquals(testJob.getJobCompany().jobCompany(), jobCard.company.getText());
        assertEquals("Rounds: " + testJob.getJobRounds().jobRounds, jobCard.jobRounds.getText());
        assertEquals("Applications: 0", jobCard.applications.getText());
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
        Job differentJob = new JobBuilder().withTitle("Different Job").build();
        JobCard differentCard = new JobCard(differentJob, new ArrayList<>(), 1);
        assertFalse(jobCard.equals(differentCard));
    }
} 