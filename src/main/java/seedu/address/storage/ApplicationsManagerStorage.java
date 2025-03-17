package seedu.address.storage;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Optional;

import seedu.address.commons.exceptions.DataLoadingException;
import seedu.address.model.ReadOnlyApplicationsManager;

/**
 * Represents a storage for {@link seedu.address.model.ApplicationsManager}.
 */
public interface ApplicationsManagerStorage {
    /**
     * Returns the file path of the data file.
     */
    Path getApplicationsManagerFilePath();

    /**
     * Returns ApplicationsManager data as a {@link ReadOnlyApplicationsManager}.
     * Returns {@code Optional.empty()} if storage file is not found.
     *
     * @throws DataLoadingException if loading the data from storage failed.
     */
    Optional<ReadOnlyApplicationsManager> readApplicationsManager() throws DataLoadingException;

    /**
     * @see #getApplicationsManagerFilePath()
     */
    Optional<ReadOnlyApplicationsManager> readApplicationsManager(Path filePath) throws DataLoadingException;

    /**
     * Saves the given {@link ReadOnlyApplicationsManager} to the storage.
     * 
     * @param applicationsManager cannot be null.
     * @throws IOException if there was any problem writing to the file.
     */
    void saveApplicationsManager(ReadOnlyApplicationsManager applicationsManager) throws IOException;

    /**
     * @see #saveApplicationsManager(ReadOnlyApplicationsManager)
     */
    void saveApplicationsManager(ReadOnlyApplicationsManager applicationsManager, Path filePath) throws IOException;
}