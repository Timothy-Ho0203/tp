package seedu.address.model.job;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Objects;

/**
 * Represents a job with a job title and company name.
 */
public class Job {
    private final JobTitle jobTitle;
    private final CompanyName companyName;

    /**
     * Constructs a Job with the specified job title and company name.
     *
     * @param jobTitle    The title of the job.
     * @param companyName The name of the company offering the job.
     */
    public Job(JobTitle jobTitle, CompanyName companyName) {
        requireAllNonNull(jobTitle, companyName);
        this.jobTitle = jobTitle;
        this.companyName = companyName;
    }

    /**
     * Returns the job title of this job.
     *
     * @return The job title.
     */
    public JobTitle getJobTitle() {
        return this.jobTitle;
    }

    /**
     * Returns the company name of this job.
     *
     * @return The company name.
     */
    public CompanyName getCompanyName() {
        return this.companyName;
    }

    /**
     * Returns true if this job is the same as the specified object.
     *
     * @param other The object to compare to.
     * @return True if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Job)) {
            return false;
        }
        Job otherJob = (Job) other;
        return jobTitle.equals(otherJob.jobTitle) && companyName.equals(otherJob.companyName);
    }

    /**
     * Returns the hash code of this job.
     *
     * @return The hash code.
     */
    @Override
    public int hashCode() {
        return Objects.hash(jobTitle, companyName);
    }
}
