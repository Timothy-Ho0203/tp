package seedu.address.logic.commands;

import static java.util.Objects.requireNonNull;
import static seedu.address.logic.parser.CliSyntax.PREFIX_APPLICATION_STATUS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_JOB_COMPANY;
import static seedu.address.logic.parser.CliSyntax.PREFIX_JOB_TITLE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;

import java.util.List;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.application.Application;
import seedu.address.model.job.Job;
import seedu.address.model.person.Person;

/**
 * Adds an {@code Application} to the address book.
 */
public class AddApplicationCommand extends Command {
    public static final String COMMAND_WORD = "addapp";
    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Adds an application to the model manager. "
            + "Parameters: " + PREFIX_PHONE + "CANDIDATE'S PHONE NUMBER "
            + PREFIX_JOB_TITLE + "JOB TITLE "
            + PREFIX_JOB_COMPANY + "COMPANY'S NAME "
            + PREFIX_APPLICATION_STATUS + "APPLICATION STATUS";
    public static final String MESSAGE_SUCCESS = "New application added: %1$s";
    public static final String MESSAGE_DUPLICATE_APPLICATION = "This application already exists in the address book";
    public static final String MESSAGE_INVALID_PERSON = "This application's person does not exist in the address book";
    public static final String MESSAGE_INVALID_JOB = "This application's job does not exist in the address book";
    public static final String MESSAGE_NONUNIQUE_PERSON = "This application's person is non-unique in the address book";
    public static final String MESSAGE_NONUNIQUE_JOB = "This application's job is non-unique in the address book";

    private final Application applicationToAdd;

    /**
     * Creates an AddApplicationCommand to add the specified {@code Application}.
     * @param application Application parsed from {@code AddApplicationCommandParser::parse}.
     */
    public AddApplicationCommand(Application application) {
        requireNonNull(application);
        this.applicationToAdd = application;
    }

    /**
     * Executes {@code AddApplicationCommand} and returns the resulting success or failure message.
     * @param model {@code Model} which the command should operate on, BEWARE dependencies on {@code UniquePersonList},
     *                           {@code uniqueJobList}, and {@code uniqueApplicationList} exists here only for checks
     *                           while {@code AddApplicationCommandParser} lacks {@code Model}'s subclass's import.
     * @return feedback message of the operation result for display.
     * @throws CommandException If an error occurs during command execution.
     */
    @Override
    public CommandResult execute(Model model) throws CommandException {
        requireNonNull(model);
        // 1st guard condition below: No invalid person given person's identifier i.e. Name.
        if (!model.hasPerson(applicationToAdd.applicant())) {
            throw new CommandException(MESSAGE_INVALID_PERSON);
        }
        List<Person> matchingPersons = model.getPersonsByPhone(applicationToAdd.applicant().getPhone());
        assert matchingPersons.size() == 1 : MESSAGE_NONUNIQUE_PERSON;
        this.applicationToAdd.setApplicant(matchingPersons.get(0)); // Update dummyPerson to valid person in-place.
        // 2nd guard condition: No invalid job given job's identifier i.e. JobTitle and JobCompany.
        if (!model.hasJob(this.applicationToAdd.job())) {
            throw new CommandException(MESSAGE_INVALID_JOB);
        }
        List<Job> matchingJobs = model.getJobsByTitleAndCompany(applicationToAdd.job().jobTitle(),
                applicationToAdd.job().jobCompany());
        assert matchingJobs.size() == 1 : MESSAGE_NONUNIQUE_JOB;
        this.applicationToAdd.setJob(matchingJobs.get(0)); // Update dummyJob to valid job in-place.
        // 3rd guard condition below: No preexisting duplicate application.
        if (model.hasApplication(this.applicationToAdd)) { // Code ultimately traces to {Application::equals}.
            throw new CommandException(MESSAGE_DUPLICATE_APPLICATION);
        }
        // Finally apply main logic of adding new valid application to model.
        model.addApplication(this.applicationToAdd);
        return new CommandResult(String.format(MESSAGE_SUCCESS, this.applicationToAdd));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        // instanceof handles nulls
        if (!(other instanceof AddApplicationCommand otherAddApplicationCommand)) {
            return false;
        }
        return this.applicationToAdd.equals(otherAddApplicationCommand.applicationToAdd);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).add("toAddApplication", this.applicationToAdd).toString();
    }
}
