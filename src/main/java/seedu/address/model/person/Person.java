package seedu.address.model.person;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import seedu.address.commons.util.ToStringBuilder;
import seedu.address.model.tag.Tag;

/**
 * Represents a Person in the address book.
 * Guarantees: details are present and not null, field values are validated, immutable.
 */
public class Person {
    private final Name name;
    private final Phone phone;
    private final Email email;
    private final Address address;
    private final Role role;
    private final Remark remark;
    private final Set<Tag> tags = new HashSet<>();

    /**
     * Every field must be present and not null.
     */
    public Person(Name newName, Phone newPhone, Email newEmail, Address newAddress, Role newRole,
                  Remark newRemark, Set<Tag> newTags) {
        requireAllNonNull(newName, newPhone, newEmail, newAddress, newRole, newRemark, newTags);
        this.name = newName;
        this.phone = newPhone;
        this.email = newEmail;
        this.address = newAddress;
        this.role = newRole;
        this.remark = newRemark;
        this.tags.addAll(newTags);
    }

    public Name getName() {
        return this.name;
    }

    public Phone getPhone() {
        return this.phone;
    }

    public Email getEmail() {
        return this.email;
    }

    public Address getAddress() {
        return this.address;
    }

    public Remark getRemark() {
        return this.remark;
    }

    public Role getRole() {
        return this.role;
    }
    /**
     * Returns an immutable tag set, which throws {@code UnsupportedOperationException}
     * if modification is attempted.
     */
    public Set<Tag> getTags() {
        return Collections.unmodifiableSet(this.tags);
    }

    /**
     * Returns true if both persons have the same name.
     * This defines a weaker notion of equality between two persons.
     */
    public boolean isSamePerson(Person otherPerson) {
        return otherPerson != null && otherPerson.getName().equals(this.getName());
    }

    /**
     * Returns true if both persons have the same identity and data fields.
     * This defines a stronger notion of equality between two persons.
     */
    @Override
    public boolean equals(Object other) {
        if (!(other instanceof Person otherPerson)) {
            return false;
        }
        return this.name.equals(otherPerson.name)
                && this.phone.equals(otherPerson.phone)
                && this.email.equals(otherPerson.email)
                && this.address.equals(otherPerson.address)
                && this.role.equals(otherPerson.role)
                && this.remark.equals(otherPerson.remark)
                && this.tags.equals(otherPerson.tags);
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(this.name, this.phone, this.email, this.address, this.role, this.tags, this.remark);
    }

    /**
     * Order the different attributes of Person to be optimally displayed in either CLI or GUI mode.
     * @return String representation of Person's application data.
     */
    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .add("name", this.name)
                .add("phone", this.phone)
                .add("email", this.email)
                .add("address", this.address)
                .add("role", this.role)
                .add("remark", this.remark)
                .add("tags", this.tags)
                .toString();
    }

}
