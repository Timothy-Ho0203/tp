package seedu.address.testutil;

import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ADDRESS_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_DEGREE_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_DEGREE_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_EMAIL_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_NAME_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_PHONE_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ROLE_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_ROLE_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_SCHOOL_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_SCHOOL_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_FRIEND;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.AddressBook;
import seedu.address.model.person.Person;

/**
 * A utility class containing a list of {@code Person} objects to be used in tests.
 */
public class TypicalPersons {

    public static final Person ALICE = new PersonBuilder()
            .withName("Alice Pauline")
            .withSchool("NUS")
            .withDegree("Computer Science")
            .withAddress("123, Jurong West Ave 6, #08-111")
            .withEmail("alice@example.com")
            .withPhone("94351253")
            .withPhone("94351253") // Duplicate withPhone to test robustness too.
            .withRole("janitor")
            .withPhone("94351253")
            .withTags("friends").build();
    public static final Person BENSON = new PersonBuilder()
            .withName("Benson Meier")
            .withSchool("NTU")
            .withDegree("Business Analytics")
            .withAddress("311, Clementi Ave 2, #02-25")
            .withEmail("johnd@example.com")
            .withPhone("98765432")
            .withDegree("Business Analytics")
            .withRole("janitor")
            .withTags("owesMoney", "friends").build();
    public static final Person CARL = new PersonBuilder()
            .withName("Carl Kurz")
            .withSchool("SMU")
            .withDegree("Mathematics")
            .withAddress("wall street")
            .withPhone("95352563")
            .withRole("janitor")
            .withEmail("heinz@example.com").build();
    public static final Person DANIEL = new PersonBuilder()
            .withName("Daniel Meier")
            .withSchool("SIM")
            .withDegree("Physics")
            .withAddress("10th street")
            .withPhone("87652533")
            .withRole("janitor")
            .withEmail("cornelia@example.com")
            .withTags("friends").build();
    public static final Person ELLE = new PersonBuilder()
            .withName("Elle Meyer")
            .withSchool("SIT")
            .withDegree("Accounting")
            .withAddress("michegan ave")
            .withPhone("9482224")
            .withRole("janitor")
            .withEmail("werner@example.com").build();
    public static final Person FIONA = new PersonBuilder()
            .withName("Fiona Kunz")
            .withSchool("NTU")
            .withDegree("Civil Engineering")
            .withAddress("little tokyo")
            .withPhone("9482427")
            .withRole("janitor")
            .withEmail("lydia@example.com").build();
    public static final Person GEORGE = new PersonBuilder()
            .withName("George Best")
            .withSchool("NUS")
            .withDegree("Computer Engineering")
            .withAddress("4th street")
            .withPhone("9482442")
            .withRole("janitor")
            .withEmail("anna@example.com").build();

    // Manually added
    public static final Person HOON = new PersonBuilder()
            .withName("Hoon Meier")
            .withSchool("NUS")
            .withDegree("Computer Science")
            .withPhone("8482424")
            .withEmail("stefan@example.com")
            .withAddress("little india")
            .build();
    public static final Person IDA = new PersonBuilder()
            .withName("Ida Mueller")
            .withSchool("NUS")
            .withDegree("Computer Science")
            .withRole("janitor")
            .withPhone("8482131")
            .withEmail("hans@example.com")
            .withAddress("chicago ave")
            .withRole("janitor")
            .build();

    // Manually added - Person's details found in {@code CommandTestUtil}
    public static final Person AMY = new PersonBuilder()
            .withName(VALID_NAME_AMY)
            .withSchool(VALID_SCHOOL_AMY)
            .withDegree(VALID_DEGREE_AMY)
            .withPhone(VALID_PHONE_AMY)
            .withEmail(VALID_EMAIL_AMY)
            .withAddress(VALID_ADDRESS_AMY)
            .withSchool(VALID_SCHOOL_AMY)
            .withRole(VALID_ROLE_AMY)
            .withTags(VALID_TAG_FRIEND).build();
    public static final Person BOB = new PersonBuilder()
            .withName(VALID_NAME_BOB)
            .withSchool(VALID_SCHOOL_BOB)
            .withDegree(VALID_DEGREE_BOB)
            .withPhone(VALID_PHONE_BOB)
            .withEmail(VALID_EMAIL_BOB)
            .withAddress(VALID_ADDRESS_BOB)
            .withRole(VALID_ROLE_BOB)
            .withSchool(VALID_SCHOOL_BOB)
            .withTags(VALID_TAG_HUSBAND, VALID_TAG_FRIEND).build();
    private TypicalPersons() {} // prevents instantiation

    /**
     * Returns an {@code AddressBook} with all the typical persons.
     */
    public static AddressBook getTypicalAddressBook() {
        AddressBook ab = new AddressBook();
        for (Person person : getTypicalPersons()) {
            ab.addPerson(person);
        }
        return ab;
    }

    public static List<Person> getTypicalPersons() {
        return new ArrayList<>(Arrays.asList(ALICE, BENSON, CARL, DANIEL, ELLE, FIONA, GEORGE));
    }
}
