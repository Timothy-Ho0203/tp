package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.job.CompanyName;
import seedu.address.model.job.Job;
import seedu.address.model.job.JobRounds;
import seedu.address.model.job.JobTitle;

/**
 * Jackson-friendly version of {@link Job}.
 */
class JsonAdaptedJob {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Job's %s field is missing!";

    private final String jobTitle;
    private final String companyName;
    private final Integer jobRounds;

    /**
     * Constructs a {@code JsonAdaptedJob} with the given job details.
     */
    @JsonCreator
    public JsonAdaptedJob(@JsonProperty("jobTitle") String jobTitle, @JsonProperty("companyName") String companyName,
            @JsonProperty("jobRounds") Integer jobRounds) {
        this.jobTitle = jobTitle;
        this.companyName = companyName;
        this.jobRounds = jobRounds;
    }

    /**
     * Converts a given {@code Job} into this class for Jackson use.
     */
    public JsonAdaptedJob(Job source) {
        jobTitle = source.getJobTitle().jobTitle;
        companyName = source.getCompanyName().companyName;
        jobRounds = source.getJobRounds().jobRounds;
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

        if (jobRounds == null) {
            throw new IllegalValueException(
                    String.format(MISSING_FIELD_MESSAGE_FORMAT, JobRounds.class.getSimpleName()));
        }
        if (!JobRounds.isValidJobRounds(jobRounds)) {
            throw new IllegalValueException(JobRounds.MESSAGE_CONSTRAINTS);
        }
        final JobRounds modelJobRounds = new JobRounds(jobRounds);

        return new Job(modelJobTitle, modelCompanyName, modelJobRounds);
    }

}
