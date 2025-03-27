package seedu.address.model.company;

import java.util.Objects;

import static java.util.Objects.requireNonNull;

/**
 * Represents a Company with a name
 */
public class Company {
    private final CompanyName name;

    public Company(CompanyName name) {
        requireNonNull(name);
        this.name = name;
    }

    public CompanyName getName() {
        return this.name;
    }

    /**
     * Returns true if this Company is the same as the specified object.
     *
     * @param other The object to compare to.
     * @return True if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Company otherCompany)) {
            return false;
        }
        return this.name.equals(otherCompany.name);
    }

    /**
     * Returns the hash code of this company.
     *
     * @return The hash code.
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.name);
    }
}
