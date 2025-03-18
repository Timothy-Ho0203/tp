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
import static seedu.address.logic.commands.CommandTestUtil.VALID_SCHOOL_AMY;
import static seedu.address.logic.commands.CommandTestUtil.VALID_SCHOOL_BOB;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_FRIEND;
import static seedu.address.logic.commands.CommandTestUtil.VALID_TAG_HUSBAND;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.model.AddressBook;
import seedu.address.model.ApplicationsManager;
import seedu.address.model.application.Application;
import seedu.address.model.application.ApplicationStatus;
import seedu.address.model.job.CompanyName;
import seedu.address.model.job.Job;
import seedu.address.model.job.JobRounds;
import seedu.address.model.job.JobTitle;
import seedu.address.model.person.Person;

/**
 * A utility class containing a list of {@code Person} objects to be used in
 * tests.
 */
public class TypicalPersons {

        public static final Person ALICE = new PersonBuilder().withName("Alice Pauline").withSchool("NUS")
                        .withDegree("Computer Science").withAddress("123, Jurong West Ave 6, #08-111")
                        .withEmail("alice@example.com").withPhone("94351253").withPhone("94351253") // Duplicate
                                                                                                    // withPhone to test
                                                                                                    // robustness too.
                        .withPhone("94351253").withTags("friends").build();
        public static final Person BENSON = new PersonBuilder().withName("Benson Meier").withSchool("NTU")
                        .withDegree("Business Analytics").withAddress("311, Clementi Ave 2, #02-25")
                        .withEmail("johnd@example.com").withPhone("98765432").withDegree("Business Analytics")
                        .withTags("owesMoney", "friends").build();
        public static final Person CARL = new PersonBuilder().withName("Carl Kurz").withSchool("SMU")
                        .withDegree("Mathematics").withAddress("wall street").withPhone("95352563")
                        .withEmail("heinz@example.com").build();
        public static final Person DANIEL = new PersonBuilder().withName("Daniel Meier").withSchool("SIM")
                        .withDegree("Physics").withAddress("10th street").withPhone("87652533")
                        .withEmail("cornelia@example.com").withTags("friends").build();
        public static final Person ELLE = new PersonBuilder().withName("Elle Meyer").withSchool("SIT")
                        .withDegree("Accounting").withAddress("michegan ave").withPhone("9482224")
                        .withEmail("werner@example.com").build();
        public static final Person FIONA = new PersonBuilder().withName("Fiona Kunz").withSchool("NTU")
                        .withDegree("Civil Engineering").withAddress("little tokyo").withPhone("9482427")
                        .withEmail("lydia@example.com").build();
        public static final Person GEORGE = new PersonBuilder().withName("George Best").withSchool("NUS")
                        .withDegree("Computer Engineering").withAddress("4th street").withPhone("9482442")
                        .withEmail("anna@example.com").build();

        // Manually added
        public static final Person HOON = new PersonBuilder().withName("Hoon Meier").withSchool("NUS")
                        .withDegree("Computer Science").withPhone("8482424").withEmail("stefan@example.com")
                        .withAddress("little india").build();
        public static final Person IDA = new PersonBuilder().withName("Ida Mueller").withSchool("NUS")
                        .withDegree("Computer Science").withPhone("8482131").withEmail("hans@example.com")
                        .withAddress("chicago ave").build();

        // Manually added - Person's details found in {@code CommandTestUtil}
        public static final Person AMY = new PersonBuilder().withName(VALID_NAME_AMY).withSchool(VALID_SCHOOL_AMY)
                        .withDegree(VALID_DEGREE_AMY).withPhone(VALID_PHONE_AMY).withEmail(VALID_EMAIL_AMY)
                        .withAddress(VALID_ADDRESS_AMY).withSchool(VALID_SCHOOL_AMY).withTags(VALID_TAG_FRIEND).build();
        public static final Person BOB = new PersonBuilder().withName(VALID_NAME_BOB).withSchool(VALID_SCHOOL_BOB)
                        .withDegree(VALID_DEGREE_BOB).withPhone(VALID_PHONE_BOB).withEmail(VALID_EMAIL_BOB)
                        .withAddress(VALID_ADDRESS_BOB).withSchool(VALID_SCHOOL_BOB)
                        .withTags(VALID_TAG_HUSBAND, VALID_TAG_FRIEND).build();

        // Typical jobs
        public static final Job SOFTWARE_ENGINEER_GOOGLE = new Job(new JobTitle("Software Engineer"),
                        new CompanyName("Google"), new JobRounds(5));

        public static final Job DATA_SCIENTIST_MICROSOFT = new Job(new JobTitle("Data Scientist"),
                        new CompanyName("Microsoft"), new JobRounds(4));

        public static final Job PRODUCT_MANAGER_APPLE = new Job(new JobTitle("Product Manager"),
                        new CompanyName("Apple"), new JobRounds(3));

        public static final Job UX_DESIGNER_META = new Job(new JobTitle("UX Designer"), new CompanyName("Meta"),
                        new JobRounds(3));

        public static final Job DEVOPS_ENGINEER_AMAZON = new Job(new JobTitle("DevOps Engineer"),
                        new CompanyName("Amazon"), new JobRounds(4));

        public static final Job FULLSTACK_DEVELOPER_NETFLIX = new Job(new JobTitle("Full Stack Developer"),
                        new CompanyName("Netflix"), new JobRounds(4));

        // Typical applications
        public static final Application ALICE_GOOGLE_APPLICATION = new Application(ALICE, SOFTWARE_ENGINEER_GOOGLE,
                        new ApplicationStatus(2));

        public static final Application BENSON_MICROSOFT_APPLICATION = new Application(BENSON, DATA_SCIENTIST_MICROSOFT,
                        new ApplicationStatus(3));

        public static final Application CARL_APPLE_APPLICATION = new Application(CARL, PRODUCT_MANAGER_APPLE,
                        new ApplicationStatus(1));

        public static final Application DANIEL_META_APPLICATION = new Application(DANIEL, UX_DESIGNER_META,
                        new ApplicationStatus(2));

        public static final Application ELLE_AMAZON_APPLICATION = new Application(ELLE, DEVOPS_ENGINEER_AMAZON,
                        new ApplicationStatus(1));

        public static final Application FIONA_NETFLIX_APPLICATION = new Application(FIONA, FULLSTACK_DEVELOPER_NETFLIX,
                        new ApplicationStatus(3));

        public static final Application ALICE_MICROSOFT_APPLICATION = new Application(ALICE, DATA_SCIENTIST_MICROSOFT,
                        new ApplicationStatus(1));

        public static final Application BENSON_GOOGLE_APPLICATION = new Application(BENSON, SOFTWARE_ENGINEER_GOOGLE,
                        new ApplicationStatus(4));

        private TypicalPersons() {
        } // prevents instantiation

        /**
         * Returns an {@code AddressBook} with all the typical persons.
         */
        public static AddressBook getTypicalAddressBook() {
                AddressBook ab = new AddressBook();

                // Add all typical persons
                for (Person person : getTypicalPersons()) {
                        ab.addPerson(person);
                }

                // Add all typical jobs
                for (Job job : getTypicalJobs()) {
                        ab.addJob(job);
                }

                return ab;
        }

        /**
         * Returns an {@code ApplicationsManager} with all the typical applications.
         */
        public static ApplicationsManager getTypicalApplicationsManager() {
                ApplicationsManager am = new ApplicationsManager();

                // Add all typical applications
                for (Application application : getTypicalApplications()) {
                        am.addApplication(application);
                }

                return am;
        }

        /**
         * Returns a list of typical persons.
         */
        public static List<Person> getTypicalPersons() {
                return new ArrayList<>(Arrays.asList(ALICE, BENSON, CARL, DANIEL, ELLE, FIONA, GEORGE));
        }

        /**
         * Returns a list of typical jobs.
         */
        public static List<Job> getTypicalJobs() {
                return new ArrayList<>(
                                Arrays.asList(SOFTWARE_ENGINEER_GOOGLE, DATA_SCIENTIST_MICROSOFT, PRODUCT_MANAGER_APPLE,
                                                UX_DESIGNER_META, DEVOPS_ENGINEER_AMAZON, FULLSTACK_DEVELOPER_NETFLIX));
        }

        /**
         * Returns a list of typical applications.
         */
        public static List<Application> getTypicalApplications() {
                return new ArrayList<>(Arrays.asList(ALICE_GOOGLE_APPLICATION, BENSON_MICROSOFT_APPLICATION,
                                CARL_APPLE_APPLICATION, DANIEL_META_APPLICATION, ELLE_AMAZON_APPLICATION,
                                FIONA_NETFLIX_APPLICATION, ALICE_MICROSOFT_APPLICATION, BENSON_GOOGLE_APPLICATION));
        }
}
