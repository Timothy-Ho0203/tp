package seedu.address.logic.commands;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.job.Job;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_COMPANY_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_JOB_ROUNDS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_JOB_TITLE;

/**
 * Deletes a Job from the address book.
 */
public class DeleteJobCommand extends Command {
    public static final String COMMAND_WORD = "deletejob";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Deletes the specified Job.\n"
            + "Parameters: " + PREFIX_JOB_TITLE + "JOB TITLE " + PREFIX_COMPANY_NAME + "COMPANY'S NAME"
            + PREFIX_JOB_ROUNDS + "NUMBER OF ROUNDS OF INTERVIEWS " + "Example: " + COMMAND_WORD
            + "jt/Software Engineering cn/TikTok jr/3";

    public static final String MESSAGE_DELETE_JOB_SUCESS = "Deleted Job: %1$s";

    public static final String MESSAGE_INVALID_JOB = "This Job does not exist in the address book";

    private final Job toDelete;

    public DeleteJobCommand(Job toDelete) {
        this.toDelete = toDelete;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);

        if (!model.hasJob(toDelete)) {
            throw new CommandException(MESSAGE_INVALID_JOB);
        }

        model.deleteJob(toDelete);
        return new CommandResult(String.format(MESSAGE_DELETE_JOB_SUCESS, Messages.format(toDelete)));
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof DeleteJobCommand otherDeleteJobCommand)) {
            return false;
        }
        return this.toDelete.equals(otherDeleteJobCommand.toDelete);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("Job: ", this.toDelete)
                .toString();
    }

}
