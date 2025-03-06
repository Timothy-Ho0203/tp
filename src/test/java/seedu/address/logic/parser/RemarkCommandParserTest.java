package seedu.address.logic.parser;

import static seedu.address.logic.Messages.MESSAGE_INVALID_COMMAND_FORMAT;
import static seedu.address.logic.parser.CliSyntax.PREFIX_REMARK;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseFailure;
import static seedu.address.logic.parser.CommandParserTestUtil.assertParseSuccess;
import static seedu.address.testutil.TypicalIndexes.INDEX_FIRST_PERSON;

import org.junit.jupiter.api.Test;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.RemarkCommand;
import seedu.address.logic.parser.exceptions.ParseException;

public class RemarkCommandParserTest {
    private RemarkCommandParser parser = new RemarkCommandParser();
    private String validRemark = "Birthday Boy next month";
    @Test
    public void parse_indexSpecified_success() throws ParseException {
        Index targetIndex = INDEX_FIRST_PERSON;
        String nonEmptyUserInput = targetIndex.getOneBased() + " " + PREFIX_REMARK + validRemark;
        assertParseSuccess(parser, nonEmptyUserInput, new RemarkCommand(INDEX_FIRST_PERSON, validRemark));

        // Tentatively don't work for contacts without remark. May likely modify this feature to allow for optionality.
        // String emptyUserInput = targetIndex.getOneBased() + " " + PREFIX_REMARK;
        // assertParseSuccess(parser, emptyUserInput, new RemarkCommand(INDEX_FIRST_PERSON, ""));
    }

    @Test
    public void parse_missingMandatoryField_failure() {
        String usageMessage = String.format(MESSAGE_INVALID_COMMAND_FORMAT, RemarkCommand.MESSAGE_USAGE);
        assertParseFailure(parser, RemarkCommand.COMMAND_WORD, usageMessage); // No parameter.
        assertParseFailure(parser, RemarkCommand.COMMAND_WORD + " " + validRemark, usageMessage); // No index.
    }
}
