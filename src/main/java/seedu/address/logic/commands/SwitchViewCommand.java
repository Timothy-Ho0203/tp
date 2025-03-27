package seedu.address.logic.commands;

import seedu.address.model.Model;

/**
 * Switches the view between person and job.
 */
public class SwitchViewCommand extends Command {
    public static final String COMMAND_WORD = "switchview";

    @Override
    public CommandResult execute(Model model) {
        return new CommandResult("Switched view",
                false, false, true, false);
    }
}
