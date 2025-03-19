package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;

import java.util.Arrays;

import seedu.address.logic.commands.FindCommand;
import seedu.address.logic.commands.JobSearchCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.application.JobContainsKeywordsPredicate;

/**
 * Parses input arguments and creates a new JobSearchCommand object
 */
public class JobSearchCommandParser implements Parser<JobSearchCommand> {

    /**
     * Parses the given {@code String} of arguments in the context of the JobSearchCommand
     * and returns a JobSearchCommand object for execution.
     * @throws ParseException if the user input does not conform the expected format
     */
    public JobSearchCommand parse(String args) throws ParseException {
        String trimmedArgs = args.trim();
        if (trimmedArgs.isEmpty()) {
            throw new ParseException(
                    String.format(MESSAGE_INVALID_COMMAND_FORMAT, JobSearchCommand.MESSAGE_USAGE));
        }

        String[] nameKeywords = trimmedArgs.split("\\s+");

        return new JobSearchCommand(new JobContainsKeywordsPredicate(Arrays.asList(nameKeywords)));
    }

}
