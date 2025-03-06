package seedu.address.logic.commands;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.List;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.Messages;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.Model;
import seedu.address.model.person.Person;

/**
 * Adds remark to a person in the address book.
 */
public class RemarkCommand extends Command {
    public static final String COMMAND_WORD = "remark";
    public static final String MESSAGE_USAGE = RemarkCommand.COMMAND_WORD
            + ": Edits the remark of the person identified "
            + "by the index number used in the last person listing. "
            + "Existing remark will be overwritten by the input.\n"
            + "Parameters: INDEX (must be a positive integer) "
            + "[REMARK] \n"
            + "Example: " + RemarkCommand.COMMAND_WORD + " 1 "
            + "Likes to swim.";
    public static final String MESSAGE_ADD_REMARK_SUCCESS = "Added remark to Person: %1$s";
    public static final String MESSAGE_DELETE_REMARK_SUCCESS = "Removed remark from Person: %1$s";

    private final Index targetIndex;
    private final String targetRemark;

    /**
     * @param newIndex Index of person to add new remark onto.
     * @param newRemark Remark update for a specific person.
     */
    public RemarkCommand(Index newIndex, String newRemark) {
        requireAllNonNull(newIndex, newRemark);
        this.targetIndex = newIndex;
        this.targetRemark = newRemark;
    }

    @Override
    public CommandResult execute(Model model) throws CommandException {
        List<Person> lastShownList = model.getFilteredPersonList();
        if (targetIndex.getZeroBased() >= lastShownList.size()) {
            throw new CommandException(Messages.MESSAGE_INVALID_PERSON_DISPLAYED_INDEX);
        }
        Person personToEdit = lastShownList.get(targetIndex.getZeroBased());
        Person editedPerson = new Person(
                personToEdit.getName(), personToEdit.getPhone(), personToEdit.getEmail(),
                personToEdit.getAddress(), personToEdit.getRemark(), personToEdit.getTags()
        );
        model.setPerson(personToEdit, editedPerson);
        model.updateFilteredPersonList(Model.PREDICATE_SHOW_ALL_PERSONS);
        return new CommandResult(generateSuccessMessage(editedPerson));
    }

    private String generateSuccessMessage(Person personToEdit) {
        String successMessage = !targetRemark.isEmpty() ? MESSAGE_ADD_REMARK_SUCCESS : MESSAGE_DELETE_REMARK_SUCCESS;
        return String.format(successMessage, Messages.format(personToEdit));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof RemarkCommand e)) {
            return false;
        }
        return this.targetIndex.equals(e.targetIndex) && this.targetRemark.equals(e.targetRemark);
    }

    @Override
    public String toString() {
        return this.targetIndex.getOneBased() + " " + this.targetRemark;
    }
}
