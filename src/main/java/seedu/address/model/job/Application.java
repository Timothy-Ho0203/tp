package seedu.address.model.job;

import static seedu.address.commons.util.CollectionUtil.requireAllNonNull;

import java.util.Objects;

import seedu.address.model.person.Person;

/**
 * Represents a job application with an applicant, job, and status.
 */
public class Application {
    private final Person applicant;
    private final Job job;
    private final ApplicationStatus status;

    /**
     * Constructs an Application with the specified applicant, job, and status.
     * 
     * @param applicant The person applying for the job.
     * @param job       The job being applied for.
     * @param status    The current status of the application.
     */
    public Application(Person applicant, Job job, ApplicationStatus status) {
        requireAllNonNull(applicant, job, status);
        this.applicant = applicant;
        this.job = job;
        this.status = status;
    }

    /**
     * Returns the applicant of this application.
     * 
     * @return The applicant.
     */
    public Person getApplicant() {
        return this.applicant;
    }

    /**
     * Returns the job of this application.
     * 
     * @return The job.
     */
    public Job getJob() {
        return this.job;
    }

    /**
     * Returns the status of this application.
     * 
     * @return The application status.
     */
    public ApplicationStatus getStatus() {
        return this.status;
    }

    /**
     * Returns true if this application is the same as the specified object.
     * 
     * @param other The object to compare to.
     * @return True if the objects are equal, false otherwise.
     */
    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if (!(other instanceof Application)) {
            return false;
        }
        Application otherApplication = (Application) other;
        return applicant.equals(otherApplication.applicant) && job.equals(otherApplication.job)
                && status.equals(otherApplication.status);
    }

    /**
     * Returns the hash code of this application.
     * 
     * @return The hash code.
     */
    @Override
    public int hashCode() {
        return Objects.hash(applicant, job, status);
    }
}