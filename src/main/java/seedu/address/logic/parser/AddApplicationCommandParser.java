package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_APPLICATION_STATUS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_JOB_COMPANY;
import static seedu.address.logic.parser.CliSyntax.PREFIX_JOB_TITLE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;

import java.util.stream.Stream;

import seedu.address.logic.commands.AddApplicationCommand;
import seedu.address.logic.parser.exceptions.ParseException;
import seedu.address.model.application.Application;
import seedu.address.model.application.ApplicationStatus;
import seedu.address.model.job.Job;
import seedu.address.model.job.JobAddress;
import seedu.address.model.job.JobCompany;
import seedu.address.model.job.JobRounds;
import seedu.address.model.job.JobSkills;
import seedu.address.model.job.JobTitle;
import seedu.address.model.job.JobType;
import seedu.address.model.person.Address;
import seedu.address.model.person.Degree;
import seedu.address.model.person.Email;
import seedu.address.model.person.Name;
import seedu.address.model.person.Person;
import seedu.address.model.person.Phone;
import seedu.address.model.person.School;

/**
 * Parses input arguments and creates a new AddApplicationCommand object with dummy Person and dummy Job later updated
 * in {@code AddApplicationCommand::execute}.
 */
public class AddApplicationCommandParser implements Parser<AddApplicationCommand> {
    /**
     * Parses the given {@code String} of arguments in the context of the AddApplicationCommand
     * and returns an AddApplicationCommand object for execution.
     * @param args Raw user input comprising 4 mandatory unique prefix identifiers to tokenize.
     * @throws ParseException if the user input does not conform the expected format
     */
    public AddApplicationCommand parse(String args) throws ParseException {
        ArgumentMultimap argMultimap = ArgumentTokenizer.tokenize(args, PREFIX_PHONE, PREFIX_JOB_TITLE,
                PREFIX_JOB_COMPANY, PREFIX_APPLICATION_STATUS);
        if (!arePrefixesPresent(argMultimap, PREFIX_PHONE, PREFIX_JOB_TITLE, PREFIX_JOB_COMPANY,
                PREFIX_APPLICATION_STATUS) || !argMultimap.getPreamble().isEmpty()) {
            throw new ParseException(String.format(MESSAGE_INVALID_COMMAND_FORMAT,
                    AddApplicationCommand.MESSAGE_USAGE));
        }
        argMultimap.verifyNoDuplicatePrefixesFor(PREFIX_PHONE, PREFIX_JOB_TITLE, PREFIX_JOB_COMPANY,
                PREFIX_APPLICATION_STATUS);
        Phone phone = ParserUtil.parsePhone(argMultimap.getValue(PREFIX_PHONE).get());
        JobTitle jobTitle = ParserUtil.parseJobTitle(argMultimap.getValue(PREFIX_JOB_TITLE).get());
        JobCompany jobCompany = ParserUtil.parseJobCompany(argMultimap.getValue(PREFIX_JOB_COMPANY).get());
        ApplicationStatus applicationStatus = ParserUtil.parseApplicationStatus(
                argMultimap.getValue(PREFIX_APPLICATION_STATUS).get());
        Person dummyPerson = new Person(Name.DEFAULT_NAME, phone, Email.DEFAULT_EMAIL, Address.DEFAULT_ADDRESS,
                School.DEFAULT_SCHOOL, Degree.DEFAULT_DEGREE, Person.DEFAULT_TAGS);
        Job dummyJob = new Job(jobTitle, jobCompany, JobRounds.DEFAULT_JOBROUNDS,
                JobSkills.DEFAULT_JOBSKILLS, JobAddress.DEFAULT_JOBADDRESS, JobType.DEFAULT_JOBTYPE);
        Application application = new Application(dummyPerson, dummyJob, applicationStatus);
        return new AddApplicationCommand(application);
    }

    /**
     * Returns true if none of the mandatory prefixes maps to empty {@code optional} values in {@code ArgumentMultimap}.
     */
    private static boolean arePrefixesPresent(ArgumentMultimap argumentMultimap, Prefix... prefixes) {
        return Stream.of(prefixes).allMatch(prefix -> argumentMultimap.getValue(prefix).isPresent());
    }
}
