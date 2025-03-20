package seedu.address.ui;

import java.util.List;
import java.util.logging.Logger;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.Region;
import seedu.address.commons.core.LogsCenter;
import seedu.address.model.application.Application;
import seedu.address.model.job.Job;
import seedu.address.model.Model;
/**
 * Panel containing the list of jobs.
 */
public class JobListPanel extends UiPart<Region> {
    private static final String FXML = "JobListPanel.fxml";
    private final Logger logger = LogsCenter.getLogger(JobListPanel.class);
    private Model model;
    @FXML
    private ListView<Job> jobListView;

    /**
     * Creates a {@code JobListPanel} with the given {@code ObservableList}.
     */
    public JobListPanel(ObservableList<Job> jobList, Model model) {
        super(FXML);
        this.model = model;
        jobListView.setItems(jobList);
        jobListView.setCellFactory(listView -> new JobListViewCell());
    }

    /**
     * Custom {@code ListCell} that displays the graphics of a {@code Job} using a {@code JobCard}.
     */
    class JobListViewCell extends ListCell<Job> {
        @Override
        protected void updateItem(Job job, boolean empty) {
            super.updateItem(job, empty);

            if (empty || job == null) {
                setGraphic(null);
                setText(null);
            } else {
                List<Application> applications = model.getApplicationsByJob(job);
                setGraphic(new JobCard(job, applications, getIndex() + 1).getRoot());
            }
        }
    }
}
