package seedu.address.model.application;

import seedu.address.commons.util.StringUtil;
import seedu.address.commons.util.ToStringBuilder;

import java.util.List;
import java.util.function.Predicate;

/**
 * Tests that am {@code Application}'s {@code Job} matches any of the keywords given.
 */
public class JobContainsKeywordsPredicate implements Predicate<Application> {
    private final List<String> keywords;

    public JobContainsKeywordsPredicate(List<String> keywords) {
        this.keywords = keywords;
    }

    @Override
    public boolean test(Application app) {
        return keywords.stream()
                .anyMatch(keyword -> StringUtil.containsWordIgnoreCase(app.getJob().getJobTitle().toString(), keyword));
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof JobContainsKeywordsPredicate)) {
            return false;
        }

        JobContainsKeywordsPredicate otherJobContainsKeywordsPredicate = (JobContainsKeywordsPredicate) other;
        return keywords.equals(otherJobContainsKeywordsPredicate.keywords);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).add("keywords", keywords).toString();
    }
}
