package seedu.address.storage;

import static java.util.Objects.requireNonNull;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;
import java.util.logging.Logger;

import seedu.address.commons.core.LogsCenter;
import seedu.address.commons.exceptions.DataLoadingException;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.commons.util.FileUtil;
import seedu.address.commons.util.JsonUtil;
import seedu.address.model.ReadOnlyApplicationsManager;

/**
 * A class to access ApplicationsManager data stored as a json file on the hard
 * disk.
 */
public class JsonApplicationsManagerStorage implements ApplicationsManagerStorage {

    private static final Logger logger = LogsCenter.getLogger(JsonApplicationsManagerStorage.class);

    private Path filePath;

    public JsonApplicationsManagerStorage(Path filePath) {
        this.filePath = filePath;
    }

    public Path getApplicationsManagerFilePath() {
        return filePath;
    }

    @Override
    public Optional<ReadOnlyApplicationsManager> readApplicationsManager() throws DataLoadingException {
        return readApplicationsManager(filePath);
    }

    /**
     * Similar to {@link #readApplicationsManager()}.
     *
     * @param filePath location of the data. Cannot be null.
     * @throws DataLoadingException if loading the data from storage failed.
     */
    public Optional<ReadOnlyApplicationsManager> readApplicationsManager(Path filePath) throws DataLoadingException {
        requireNonNull(filePath);

        Optional<JsonSerializableApplicationsManager> jsonApplicationsManager = JsonUtil.readJsonFile(filePath,
                JsonSerializableApplicationsManager.class);
        if (!jsonApplicationsManager.isPresent()) {
            return Optional.empty();
        }

        try {
            return Optional.of(jsonApplicationsManager.get().toModelType());
        } catch (IllegalValueException ive) {
            logger.info("Illegal values found in " + filePath + ": " + ive.getMessage());
            throw new DataLoadingException(ive);
        }
    }

    @Override
    public void saveApplicationsManager(ReadOnlyApplicationsManager applicationsManager) throws IOException {
        saveApplicationsManager(applicationsManager, filePath);
    }

    /**
     * Similar to {@link #saveApplicationsManager(ReadOnlyApplicationsManager)}.
     *
     * @param filePath location of the data. Cannot be null.
     */
    public void saveApplicationsManager(ReadOnlyApplicationsManager applicationsManager, Path filePath)
            throws IOException {
        requireNonNull(applicationsManager);
        requireNonNull(filePath);

        FileUtil.createIfMissing(filePath);
        JsonUtil.saveJsonFile(new JsonSerializableApplicationsManager(applicationsManager), filePath);
    }
}
