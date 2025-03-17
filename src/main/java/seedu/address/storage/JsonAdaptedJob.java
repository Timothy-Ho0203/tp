package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.job.CompanyName;
import seedu.address.model.job.Job;
import seedu.address.model.job.JobTitle;

/**
 * Jackson-friendly version of {@link Job}.
 */
class JsonAdaptedJob {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Job's %s field is missing!";

    private final String jobTitle;
    private final String companyName;

    /**
     * Constructs a {@code JsonAdaptedJob} with the given job details.
     */
    @JsonCreator
    public JsonAdaptedJob(@JsonProperty("jobTitle") String jobTitle, @JsonProperty("companyName") String companyName) {
        this.jobTitle = jobTitle;
        this.companyName = companyName;
    }

    /**
     * Converts a given {@code Job} into this class for Jackson use.
     */
    public JsonAdaptedJob(Job source) {
        jobTitle = source.getJobTitle().jobTitle;
        companyName = source.getCompanyName().companyName;
    }

    /**
     * Converts this Jackson-friendly adapted job object into the model's
     * {@code Job} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in
     *                               the adapted job.
     */
    public Job toModelType() throws IllegalValueException {

        if (jobTitle == null) {
            throw new IllegalValueException(
                    String.format(MISSING_FIELD_MESSAGE_FORMAT, JobTitle.class.getSimpleName()));
        }
        if (!JobTitle.isValidJobTitle(jobTitle)) {
            throw new IllegalValueException(JobTitle.MESSAGE_CONSTRAINTS);
        }
        final JobTitle modelJobTitle = new JobTitle(jobTitle);

        if (companyName == null) {
            throw new IllegalValueException(
                    String.format(MISSING_FIELD_MESSAGE_FORMAT, CompanyName.class.getSimpleName()));
        }
        if (!CompanyName.isValidCompanyName(companyName)) {
            throw new IllegalValueException(CompanyName.MESSAGE_CONSTRAINTS);
        }
        final CompanyName modelCompanyName = new CompanyName(companyName);

        return new Job(modelJobTitle, modelCompanyName);
    }

}
