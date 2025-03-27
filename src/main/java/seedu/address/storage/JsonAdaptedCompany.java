package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import javafx.collections.ObservableList;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.company.Company;
import seedu.address.model.company.CompanyName;
import seedu.address.model.job.Job;

public class JsonAdaptedCompany {
    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Company's %s field is missing!";

    private final String name;

    /**
     * Constructs a {@code JsonAdaptedCompany} with the given job details.
     */
    @JsonCreator
    public JsonAdaptedCompany(@JsonProperty("companyName") String name) {
        this.name = name;
    }

    /**
     * Converts a given {@code Company} into this class for Jackson use.
     */
    public JsonAdaptedCompany(Company source) {
        this.name = source.getName().name(); // CompanyName record class has an implicit accessor
    }

    /**
     * Converts this Jackson-friendly adapted company object into the model's
     * {@code Company} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted company.
     */
    public Company toModelType() throws IllegalValueException {
        if (this.name == null) {
            throw new IllegalValueException(
                    String.format(MISSING_FIELD_MESSAGE_FORMAT, CompanyName.class.getSimpleName()));
        }
        if (!CompanyName.isValidJobCompany(this.name)) {
            throw new IllegalValueException(CompanyName.MESSAGE_CONSTRAINTS);
        }
        final CompanyName companyName = new CompanyName(this.name);

        return new Company(companyName);
    }
}
