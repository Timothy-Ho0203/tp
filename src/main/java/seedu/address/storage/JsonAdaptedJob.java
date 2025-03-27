package seedu.address.storage;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import javafx.collections.ObservableList;
import seedu.address.commons.exceptions.IllegalValueException;
import seedu.address.model.job.Job;
import seedu.address.model.job.JobRounds;
import seedu.address.model.job.JobSkills;
import seedu.address.model.job.JobTitle;
import seedu.address.model.job.JobType;

/**
 * Jackson-friendly version of {@link Job}.
 */
class JsonAdaptedJob {

    public static final String MISSING_FIELD_MESSAGE_FORMAT = "Job's %s field is missing!";

    private final String jobTitle;
    private final Integer jobRounds;
    private final ObservableList<String> jobSkills;
    private final String jobType;

    /**
     * Constructs a {@code JsonAdaptedJob} with the given job details.
     */
    @JsonCreator
    public JsonAdaptedJob(@JsonProperty("jobTitle") String jobTitle,
                          @JsonProperty("jobRounds") Integer jobRounds,
                          @JsonProperty("jobSkills") ObservableList<String> jobSkills,
                          @JsonProperty("jobType") String jobType) {
        this.jobTitle = jobTitle;
        this.jobRounds = jobRounds;
        this.jobSkills = jobSkills;
        this.jobType = jobType;
    }

    /**
     * Converts a given {@code Job} into this class for Jackson use.
     */
    public JsonAdaptedJob(Job source) {
        this.jobTitle = source.jobTitle().jobTitle(); // JobTitle record class has implicit accessor.
        this.jobRounds = source.jobRounds().jobRounds;
        this.jobSkills = source.jobSkills().value;
        this.jobType = source.jobType().toString();
    }

    /**
     * Converts this Jackson-friendly adapted job object into the model's
     * {@code Job} object.
     *
     * @throws IllegalValueException if there were any data constraints violated in the adapted job.
     */
    public Job toModelType() throws IllegalValueException {
        // Check valid job title below.
        if (this.jobTitle == null) {
            throw new IllegalValueException(
                    String.format(MISSING_FIELD_MESSAGE_FORMAT, JobTitle.class.getSimpleName()));
        }
        if (!JobTitle.isValidJobTitle(this.jobTitle)) {
            throw new IllegalValueException(JobTitle.MESSAGE_CONSTRAINTS);
        }
        final JobTitle modelJobTitle = new JobTitle(this.jobTitle);
        // Check valid max job rounds below.
        if (this.jobRounds == null) {
            throw new IllegalValueException(
                    String.format(MISSING_FIELD_MESSAGE_FORMAT, JobRounds.class.getSimpleName()));
        }
        if (!JobRounds.isValidJobRounds(this.jobRounds)) {
            throw new IllegalValueException(JobRounds.MESSAGE_CONSTRAINTS);
        }
        final JobRounds modelJobRounds = new JobRounds(this.jobRounds);
        // Check valid requisite job skills below.
        if (this.jobSkills == null) {
            throw new IllegalValueException(
                    String.format(MISSING_FIELD_MESSAGE_FORMAT, JobSkills.class.getSimpleName()));
        }
        if (!JobSkills.areValidIndividualJobSkills(this.jobSkills)) {
            throw new IllegalValueException(JobSkills.MESSAGE_CONSTRAINTS);
        }
        final JobSkills modelJobSkills = new JobSkills(this.jobSkills);
        // Check valid job type below.
        if (this.jobType == null) {
            throw new IllegalValueException(
                    String.format(MISSING_FIELD_MESSAGE_FORMAT, JobType.class.getSimpleName()));
        }
        if (!JobType.isValidDisplayType(this.jobType)) {
            throw new IllegalValueException(JobType.MESSAGE_CONSTRAINTS);
        }
        final JobType modelJobType = JobType.fromDisplayType(this.jobType);
        return new Job(modelJobTitle, modelJobRounds, modelJobSkills, modelJobType);
    }
}
