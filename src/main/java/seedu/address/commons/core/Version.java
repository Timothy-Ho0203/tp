package seedu.address.commons.core;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Represents a version with major, minor and patch number
 */
public record Version(int major, int minor, int patch, boolean isEarlyAccess) implements Comparable<Version> {

    public static final String VERSION_REGEX = "V(\\d+)\\.(\\d+)\\.(\\d+)(ea)?";

    private static final String EXCEPTION_STRING_NOT_VERSION = "String is not a valid Version. %s";

    private static final Pattern VERSION_PATTERN = Pattern.compile(VERSION_REGEX);

    /**
     * Constructs a {@code Version} with the given version details.
     */
    public Version {
    }

    /**
     * Parses a version number string in the format V1.2.3.
     *
     * @param versionString version number string
     * @return a Version object
     */
    @JsonCreator
    public static Version fromString(String versionString) throws IllegalArgumentException {
        Matcher versionMatcher = VERSION_PATTERN.matcher(versionString);

        if (!versionMatcher.find()) {
            throw new IllegalArgumentException(String.format(EXCEPTION_STRING_NOT_VERSION, versionString));
        }

        return new Version(Integer.parseInt(versionMatcher.group(1)),
                Integer.parseInt(versionMatcher.group(2)),
                Integer.parseInt(versionMatcher.group(3)),
                versionMatcher.group(4) != null);
    }

    @JsonValue
    public String toString() {
        return String.format("V%d.%d.%d%s", major, minor, patch, isEarlyAccess ? "ea" : "");
    }

    @Override
    public int compareTo(Version other) {
        if (this.major != other.major) {
            return this.major - other.major;
        }
        if (this.minor != other.minor) {
            return this.minor - other.minor;
        }
        if (this.patch != other.patch) {
            return this.patch - other.patch;
        }
        if (this.isEarlyAccess == other.isEarlyAccess()) {
            return 0;
        }
        if (this.isEarlyAccess) {
            return -1;
        }
        return 1;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }

        // instanceof handles nulls
        if (!(other instanceof Version otherVersion)) {
            return false;
        }

        return this.major == otherVersion.major
                && this.minor == otherVersion.minor
                && this.patch == otherVersion.patch
                && this.isEarlyAccess == otherVersion.isEarlyAccess;
    }

    @Override
    public int hashCode() {
        String hash = String.format("%03d%03d%03d", this.major, this.minor, this.patch);
        if (!this.isEarlyAccess) {
            hash = "1" + hash;
        }
        return Integer.parseInt(hash);
    }
}
