package seedu.address.model.job;

import static java.util.Objects.requireNonNull;
import static seedu.address.commons.util.AppUtil.checkArgument;

/**
 * Represents a company name in a {@Code Job}.
 */
public class CompanyName {
    public static final String MESSAGE_CONSTRAINTS = "Company name should only contain alphanumeric "
            + "characters and spaces, and it should not be blank";

    /**
     * The first character of the company name must not be a whitespace, otherwise "
     * " (a blank string) becomes a valid input.
     */
    public static final String VALIDATION_REGEX = "[\\p{Alnum}][\\p{Alnum} ]*";

    public final String companyName;

    /**
     * Constructs a {@code CompanyName}.
     *
     * @param companyName A valid company name.
     */
    public CompanyName(String companyName) {
        requireNonNull(companyName);
        checkArgument(isValidCompanyName(companyName), MESSAGE_CONSTRAINTS);
        this.companyName = companyName;
    }

    /**
     * Returns true if a given string is a valid company name.
     *
     * @param test The string to validate.
     * @return True if the given string is a valid company name.
     */
    public static boolean isValidCompanyName(String test) {
        return test.matches(VALIDATION_REGEX);
    }

    /**
     * Returns the string representation of this company name.
     *
     * @return The string representation.
     */
    @Override
    public String toString() {
        return companyName;
    }

    /**
     * Returns true if this company name is the same as the specified object.
     *
     * @param other The object to compare to.
     * @return True if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof CompanyName)) {
            return false;
        }
        CompanyName otherCompanyName = (CompanyName) other;
        return companyName.equals(otherCompanyName.companyName);
    }

    /**
     * Returns the hash code of this company name.
     *
     * @return The hash code.
     */
    @Override
    public int hashCode() {
        return companyName.hashCode();
    }
}
