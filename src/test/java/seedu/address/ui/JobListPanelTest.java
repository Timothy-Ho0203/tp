package seedu.address.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Stage;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.job.Job;
import seedu.address.testutil.JobBuilder;

public class JobListPanelTest extends ApplicationTest {
    private JobListPanel jobListPanel;
    private Model model;

    @Override
    public void start(Stage stage) {
        model = new ModelManager();
        ObservableList<Job> jobList = FXCollections.observableArrayList();
        jobListPanel = new JobListPanel(jobList, model);
        
        stage.setScene(new Scene(jobListPanel.getRoot()));
        stage.show();
    }

    @Test
    public void display() {
        // Create and add test jobs
        Job testJob1 = new JobBuilder().withTitle("Software Engineer").build();
        Job testJob2 = new JobBuilder().withTitle("Product Manager").build();
        
        ObservableList<Job> jobList = FXCollections.observableArrayList(testJob1, testJob2);
        jobListPanel = new JobListPanel(jobList, model);

        // Verify that the list view is not null and contains correct number of items
        assertNotNull(jobListPanel.jobListView);
        assertEquals(2, jobListPanel.jobListView.getItems().size());
    }
} 