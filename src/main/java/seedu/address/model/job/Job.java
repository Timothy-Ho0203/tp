package seedu.address.model.job;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Objects;

/**
 * Represents a job with a job title and company name.
 */
public class Job {
    private final JobTitle jobTitle;
    private final JobCompany jobCompany;
    private final JobRounds jobRounds;
    private final JobSkills jobSkills;
    private final JobAddress jobAddress;
    private final JobType jobType;

    /**
     * Constructs a Job with the specified job title and company name.
     *
     * @param jobTitle    The title of the job.
     * @param jobCompany The name of the company offering the job.
     * @param jobRounds   The rounds of the job.
     * @param jobSkills   The requisite skills for the job.
     * @param jobAddress    The address of the job.
     * @param jobType   The employment type of the job.
     */
    public Job(JobTitle jobTitle, JobCompany jobCompany, JobRounds jobRounds,
               JobSkills jobSkills, JobAddress jobAddress, JobType jobType) {
        requireAllNonNull(jobTitle, jobCompany);
        this.jobTitle = jobTitle;
        this.jobCompany = jobCompany;
        this.jobRounds = jobRounds;
        this.jobSkills = jobSkills;
        this.jobAddress = jobAddress;
        this.jobType = jobType;
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
    public JobCompany getCompanyName() {
        return this.jobCompany;
    }

    /**
     * Returns the job rounds of this job.
     *
     * @return The job rounds.
     */
    public JobRounds getJobRounds() {
        return this.jobRounds;
    }

    /**
     * Returns the job skills of this job.
     *
     * @return The job skills.
     */
    public JobSkills getJobSkills() {
        return this.jobSkills;
    }

    /**
     * Returns the job address of this job.
     *
     * @return The job address.
     */
    public JobAddress getJobAddress() {
        return this.jobAddress;
    }

    /**
     * Returns the employment type of this job, be it intern, part-time or full-time.
     *
     * @return The employment type of the job.
     */
    public JobType getJobType() {
        return this.jobType;
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
        if (!(other instanceof Job otherJob)) {
            return false;
        }
        return this.jobTitle.equals(otherJob.jobTitle) && this.jobCompany.equals(otherJob.jobCompany)
                && this.jobRounds.equals(otherJob.jobRounds) && this.jobSkills.equals(otherJob.jobSkills)
                && this.jobAddress.equals(otherJob.jobAddress)
                && this.jobType.getDisplayType().equals(otherJob.jobType.getDisplayType());
    }

    /**
     * Returns the hash code of this job.
     *
     * @return The hash code.
     */
    @Override
    public int hashCode() {
        return Objects.hash(this.jobTitle, this.jobCompany, this.jobRounds,
                this.jobSkills, this.jobAddress, this.jobType);
    }
}
