package seedu.address.model.person;

import static java.util.Objects.requireNonNull;

/**
 * Represents a Person's role in the address book.
 * Guarantees: immutable; is valid always.
 */
public class Role {
    public static final String MESSAGE_CONSTRAINTS = "Roles can take on any values, and it should not be blank";
    public final String roleValue;

    /**
     * Construct a {@code role}
     * @param newRoleValue A valid role.
     */
    public Role(String newRoleValue) {
        requireNonNull(newRoleValue.trim());
        this.roleValue = newRoleValue.trim();
    }

    @Override
    public String toString() {
        return this.roleValue;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Role role)) {
            return false;
        }
        return this.roleValue.equals(role.roleValue);
    }
}
