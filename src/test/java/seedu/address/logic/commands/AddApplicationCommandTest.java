package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandFailure;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;
import static seedu.address.testutil.TypicalIndexes.INDEX_SECOND_PERSON;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;
import static seedu.address.testutil.TypicalPersons.getTypicalApplicationsManager;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.index.Index;
import seedu.address.model.ApplicationsManager;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.application.Application;
import seedu.address.model.application.ApplicationStatus;
import seedu.address.model.job.Job;
import seedu.address.model.person.Person;

public class AddApplicationCommandTest {
    private final Model model = new ModelManager(
            getTypicalAddressBook(), getTypicalApplicationsManager(), new UserPrefs());

    /**
     * Tests constructing via valid person index and valid job index executes successfully in multiple dispatch.
     */
    @Test
    public void execute_validIndexesUnfilteredList_success() {
        // Test command instantiated from indices.
        ApplicationStatus applicationStatus = ApplicationStatus.DEFAULT_ADDAPPLICATIONSTATUS;
        AddApplicationCommand addApplicationCommand = new AddApplicationCommand(
                INDEX_FIRST_PERSON, INDEX_FIRST_PERSON, applicationStatus);
        // Construct expected model to base off the test. Beware Application lacks multiple dispatch vs AddApplication.
        Person applicant = this.model.getFilteredPersonList().get(INDEX_FIRST_PERSON.getZeroBased());
        Job job = this.model.getFilteredJobList().get(INDEX_FIRST_PERSON.getZeroBased());
        Application expectedApplication = new Application(applicant, job, applicationStatus);
        String expectedMessage = String.format(AddApplicationCommand.MESSAGE_SUCCESS, expectedApplication);
        ModelManager expectedModel = new ModelManager(this.model.getAddressBook(),
                new ApplicationsManager(this.model.getApplicationsManager()), new UserPrefs());
        assert !expectedModel.getApplicationsManager().getApplicationList().contains(expectedApplication)
                : "Application should not already exist before addition.";
        expectedModel.addApplication(expectedApplication);
        assertCommandSuccess(addApplicationCommand, this.model, expectedMessage, expectedModel);
    }

    /**
     * Tests constructing via valid person phone number and valid job title executes successfully in multiple dispatch.
     */
    @Test
    public void execute_validIdentifiersUnfilteredList_success() {
        // Test command instantiated from unique identifiers.
        Person applicant = this.model.getFilteredPersonList().get(INDEX_FIRST_PERSON.getZeroBased());
        Job job = this.model.getFilteredJobList().get(INDEX_FIRST_PERSON.getZeroBased());
        ApplicationStatus applicationStatus = ApplicationStatus.DEFAULT_ADDAPPLICATIONSTATUS;
        Application application = new Application(applicant, job, applicationStatus);
        AddApplicationCommand addApplicationCommand = new AddApplicationCommand(application); // Fulfill Law of Demeter.
        // Construct expected model to base off the test. Beware Application lacks multiple dispatch vs AddApplication.
        String expectedMessage = String.format(AddApplicationCommand.MESSAGE_SUCCESS, application);
        ModelManager expectedModel = new ModelManager(this.model.getAddressBook(),
                new ApplicationsManager(this.model.getApplicationsManager()), new UserPrefs());
        assert !expectedModel.getApplicationsManager().getApplicationList().contains(application)
                : "Application should not already exist before addition.";
        expectedModel.addApplication(application);
        assertCommandSuccess(addApplicationCommand, this.model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_invalidPersonIndex_throwsCommandException() {
        Index outOfBoundPersonIndex = Index.fromOneBased(model.getFilteredPersonList().size() + 1);
        AddApplicationCommand addApplicationCommand = new AddApplicationCommand(
                outOfBoundPersonIndex, INDEX_FIRST_PERSON, ApplicationStatus.DEFAULT_ADDAPPLICATIONSTATUS);
        assertCommandFailure(addApplicationCommand, this.model, AddApplicationCommand.MESSAGE_INVALID_PERSON);
    }

    @Test
    public void execute_invalidJobIndex_throwsCommandException() {
        Index outOfBoundJobIndex = Index.fromOneBased(model.getFilteredJobList().size() + 1);
        AddApplicationCommand addApplicationCommand = new AddApplicationCommand(
                INDEX_FIRST_PERSON, outOfBoundJobIndex, ApplicationStatus.DEFAULT_ADDAPPLICATIONSTATUS);
        assertCommandFailure(addApplicationCommand, this.model, AddApplicationCommand.MESSAGE_INVALID_JOB);
    }

    @Test
    public void execute_duplicateApplication_throwsCommandException() {
        Person applicant = this.model.getFilteredPersonList().get(INDEX_SECOND_PERSON.getZeroBased());
        Job job = this.model.getFilteredJobList().get(INDEX_SECOND_PERSON.getZeroBased());
        ApplicationStatus applicationStatus = ApplicationStatus.DEFAULT_ADDAPPLICATIONSTATUS;
        Application application = new Application(applicant, job, applicationStatus);
        assert !this.model.getApplicationsManager().getApplicationList().contains(application)
                : "Application should not already exist before addition.";
        this.model.addApplication(application); // Adds 1 application first successfully.
        AddApplicationCommand addApplicationCommand = new AddApplicationCommand(application); // Test same application.
        assertCommandFailure(addApplicationCommand, this.model, AddApplicationCommand.MESSAGE_DUPLICATE_APPLICATION);
    }

    @Test
    public void equals() {
        AddApplicationCommand addFirstApplicationCommand = new AddApplicationCommand(
                INDEX_FIRST_PERSON, INDEX_FIRST_PERSON, ApplicationStatus.DEFAULT_ADDAPPLICATIONSTATUS);
        AddApplicationCommand addSecondApplicationCommand = new AddApplicationCommand(
                INDEX_SECOND_PERSON, INDEX_SECOND_PERSON, ApplicationStatus.DEFAULT_ADDAPPLICATIONSTATUS);
        // Test 1: Same object -> returns true.
        assertEquals(addFirstApplicationCommand, addFirstApplicationCommand);
        // Test 2: Same values -> returns true.
        AddApplicationCommand addFirstApplicationCommandCopy = new AddApplicationCommand(
                INDEX_FIRST_PERSON, INDEX_FIRST_PERSON, ApplicationStatus.DEFAULT_ADDAPPLICATIONSTATUS);
        assertEquals(addFirstApplicationCommand, addFirstApplicationCommandCopy);
        // Test 3: Different application status -> returns false. This highlights the transitivity of dummy applications
        // which must not be exposed (i.e. encapsulation must not leak).
        AddApplicationCommand addFirstDummyApplicationCommand = new AddApplicationCommand(
                INDEX_FIRST_PERSON, INDEX_FIRST_PERSON, ApplicationStatus.DEFAULT_ADVANCEAPPLICATIONSTATUS);
        assertNotEquals(addFirstApplicationCommand, addFirstDummyApplicationCommand);
        // Test 4: Different types -> returns false.
        assertNotEquals(new Object(), addFirstApplicationCommand);
        assertNotEquals(null, addFirstApplicationCommand);
        // Test 5: Different commands -> returns false.
        assertNotEquals(addFirstApplicationCommand, addSecondApplicationCommand);
    }
}
