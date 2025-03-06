package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;
import static seedu.address.testutil.TypicalPersons.getTypicalAddressBook;

import org.junit.jupiter.api.Test;

import seedu.address.model.AddressBook;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;
import seedu.address.model.person.Person;
import seedu.address.testutil.PersonBuilder;
import seedu.address.testutil.TypicalIndexes;

public class RemarkCommandTest {
    // private static final String VALID_REMARK_AMY = "Like coding.";
    private Model model = new ModelManager(getTypicalAddressBook(), new UserPrefs());
    @Test
    public void equals() {
        final RemarkCommand testCommand = new RemarkCommand(
                INDEX_FIRST_PERSON, CommandTestUtil.VALID_REMARK_AMY);

        // Comparing same-valued objects returns true even if they are separate objects. Symmetry is handled implicitly.
        assertEquals(new RemarkCommand(
                INDEX_FIRST_PERSON, CommandTestUtil.VALID_REMARK_AMY), testCommand);
        assertEquals(new RemarkCommand(
                INDEX_FIRST_PERSON, CommandTestUtil.VALID_REMARK_BOB), testCommand);

        // Comparing any such command object to null returns true.
        assertNotEquals(null, testCommand);

        // Comparing distinct-valued objects returns false.
        assertNotEquals(new RemarkCommand(
                INDEX_FIRST_PERSON, CommandTestUtil.VALID_REMARK_CHARLIE), testCommand);
        assertNotEquals(new RemarkCommand(
                TypicalIndexes.INDEX_SECOND_PERSON, CommandTestUtil.VALID_REMARK_AMY), testCommand);
        assertNotEquals(new ListCommand(), testCommand);
    }

    public void execute_addRemarkUnfilteredList_success() {
        Person firstPerson = model.getFilteredPersonList().get(INDEX_FIRST_PERSON.getZeroBased());
        Person editedPerson = new PersonBuilder(firstPerson).withRemark(CommandTestUtil.VALID_REMARK_AMY).build();
        RemarkCommand remarkCommand = new RemarkCommand(INDEX_FIRST_PERSON, editedPerson.getRemark().value);

        String expectedMessage = String.format(RemarkCommand.MESSAGE_ADD_REMARK_SUCCESS, editedPerson);

        Model expectedModel = new ModelManager(new AddressBook(model.getAddressBook()), new UserPrefs());
        expectedModel.setPerson(firstPerson, editedPerson);

        assertCommandSuccess(remarkCommand, model, expectedMessage, expectedModel);
    }
}
