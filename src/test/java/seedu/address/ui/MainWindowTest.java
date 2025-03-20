package seedu.address.ui;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.testfx.framework.junit5.ApplicationTest;

import javafx.scene.Scene;
import javafx.stage.Stage;
import seedu.address.logic.Logic;
import seedu.address.logic.LogicManager;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;

public class MainWindowTest extends ApplicationTest {
    private MainWindow mainWindow;
    private Logic logic;
    private Model model;

    @Override
    public void start(Stage stage) {
        model = new ModelManager();
        logic = new LogicManager(model);
        mainWindow = new MainWindow(stage, logic);
        stage.setScene(new Scene(mainWindow.getRoot()));
        stage.show();
    }

    @Test
    public void switchView() {
        // Test switching to jobs view
        mainWindow.handleSwitchToJobs();
        assertNotNull(mainWindow.getJobListPanel());
        assertTrue(mainWindow.getJobListPanelPlaceholder().isVisible());

        // Test switching to persons view
        mainWindow.handleSwitchToPersons();
        assertNotNull(mainWindow.getPersonListPanel());
        assertTrue(mainWindow.getPersonListPanelPlaceholder().isVisible());
    }
} 