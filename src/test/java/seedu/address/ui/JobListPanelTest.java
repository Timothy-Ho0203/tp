package seedu.address.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.nio.file.Path;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.testfx.framework.junit5.ApplicationTest;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Stage;
import seedu.address.logic.Logic;
import seedu.address.logic.LogicManager;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.job.Job;
import seedu.address.storage.JsonAddressBookStorage;
import seedu.address.storage.JsonApplicationsManagerStorage;
import seedu.address.storage.JsonUserPrefsStorage;
import seedu.address.storage.StorageManager;
import seedu.address.testutil.JobBuilderFX;

public class JobListPanelTest extends ApplicationTest {
    @TempDir
    public Path temporaryFolder;

    private JobListPanel jobListPanel;
    private Logic logic;



    @Override
    public void start(Stage stage) {
        Model model = new ModelManager();
        StorageManager storage = new StorageManager(
            new JsonAddressBookStorage(temporaryFolder.resolve("addressBook.json")),
            new JsonApplicationsManagerStorage(temporaryFolder.resolve("applicationsManager.json")),
            new JsonUserPrefsStorage(temporaryFolder.resolve("userPrefs.json"))
        );
        this.logic = new LogicManager(model, storage);
        ObservableList<Job> jobList = FXCollections.observableArrayList();
        jobListPanel = new JobListPanel(jobList, logic);
        stage.setScene(new Scene(jobListPanel.getRoot()));
        stage.show();
    }

    @Test
    public void display() {
        // Create and add test jobs
        Job testJob1 = new JobBuilderFX().withTitle("Software Engineer").build();
        Job testJob2 = new JobBuilderFX().withTitle("Product Manager").build();
        ObservableList<Job> jobList = FXCollections.observableArrayList(testJob1, testJob2);
        jobListPanel = new JobListPanel(jobList, logic);

        // Verify that the list view is not null and contains correct number of items
        assertNotNull(jobListPanel.getJobList());
        assertEquals(2, jobListPanel.getJobList().size());
    }
}
