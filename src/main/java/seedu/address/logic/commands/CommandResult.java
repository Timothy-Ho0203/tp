package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import java.util.Objects;

import seedu.address.commons.util.ToStringBuilder;

/**
 * Represents the result of a command execution.
 */
public class CommandResult {

    private final String feedbackToUser;

    /** Help information should be shown to the user. */
    private final boolean showHelp;

    /** The application should exit. */
    private final boolean exit;

    /** Whether the job view should be shown. */
    private final boolean toggleJobView;

    /** Whether applications have been updated and need to be refreshed. */
    private final boolean refreshApplications;

    /**
     * Constructs a {@code CommandResult} with the specified fields.
     */
    public CommandResult(String feedbackToUser, boolean showHelp, boolean exit, boolean toggleJobView,
            boolean refreshApplications) {
        this.feedbackToUser = requireNonNull(feedbackToUser);
        this.showHelp = showHelp;
        this.exit = exit;
        this.toggleJobView = toggleJobView;
        this.refreshApplications = refreshApplications;
    }

    /**
     * Constructs a {@code CommandResult} with the specified fields, without refreshing applications.
     */
    public CommandResult(String feedbackToUser, boolean showHelp, boolean exit, boolean toggleJobView) {
        this(feedbackToUser, showHelp, exit, toggleJobView, false);
    }

    /**
     * Constructs a {@code CommandResult} with the specified {@code feedbackToUser},
     * and other fields set to their default value.
     */
    public CommandResult(String feedbackToUser) {
        this(feedbackToUser, false, false, false, false);
    }

    /**
     * Constructs a {@code CommandResult} with the specified {@code feedbackToUser},
     * with refreshApplications set to true, and other fields set to their default value.
     */
    public CommandResult(String feedbackToUser, boolean refreshApplications) {
        this(feedbackToUser, false, false, false, refreshApplications);
    }

    public String getFeedbackToUser() {
        return feedbackToUser;
    }

    public boolean isShowHelp() {
        return showHelp;
    }

    public boolean isExit() {
        return exit;
    }

    public boolean setToggleView() {
        return toggleJobView;
    }

    public boolean isRefreshApplications() {
        return refreshApplications;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof CommandResult)) {
            return false;
        }

        CommandResult otherCommandResult = (CommandResult) other;
        return feedbackToUser.equals(otherCommandResult.feedbackToUser)
                && showHelp == otherCommandResult.showHelp
                && exit == otherCommandResult.exit
                && toggleJobView == otherCommandResult.toggleJobView
                && refreshApplications == otherCommandResult.refreshApplications;
    }

    @Override
    public int hashCode() {
        return Objects.hash(feedbackToUser, showHelp, exit, toggleJobView, refreshApplications);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("feedbackToUser", feedbackToUser)
                .add("showHelp", showHelp)
                .add("exit", exit)
                .add("toggleJobView", toggleJobView)
                .add("refreshApplications", refreshApplications)
                .toString();
    }
}
