package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.model.Model;
import seedu.address.model.application.JobContainsKeywordsPredicate;

/**
 * Finds and lists all persons in address book whose name contains any of the argument keywords.
 * Keyword matching is case-insensitive.
 */
public class JobSearchCommand extends Command {

    public static final String COMMAND_WORD = "jobsearch";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Finds all applications' JobTitle that contains any of "
            + "the specified keywords (case-insensitive) and displays them as a list with index numbers.\n"
            + "Parameters: KEYWORD [MORE_KEYWORDS]...\n"
            + "Example: " + COMMAND_WORD + " Software Engineering";

    private final JobContainsKeywordsPredicate predicate;

    public JobSearchCommand(JobContainsKeywordsPredicate predicate) {
        this.predicate = predicate;
    }

    @Override
    public CommandResult execute(Model model) {
        requireNonNull(model);
        model.updateFilteredApplicationList(this.predicate);
        return new CommandResult(
                String.format(Messages.MESSAGE_PERSONS_LISTED_OVERVIEW, model.getFilteredApplicationList().size()));
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof JobSearchCommand otherJobSearchCommand)) {
            return false;
        }
        return this.predicate.equals(otherJobSearchCommand.predicate);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("predicate", this.predicate)
                .toString();
    }
}
