package readability.scoring;

public enum GradeLevel {
    ZERO ("0-4"),
    KINDERGARTEN("5-6"),
    FIRST_SECOND_GRADE("6-7"),
    THIRD_GRADE ("7-9"),
    FOURTH_GRADE ("9-10"),
    FIFTH_GRADE ("10-11"),
    SIXTH_GRADE ("11-12"),
    SEVENTH_GRADE("12-13"),
    EIGHTH_GRADE("13-14"),
    NINTH_GRADE ("14-15"),
    TENTH_GRADE("15-16"),
    ELEVENTH_GRADE("16-17"),
    TWELFTH_GRADE("17-18"),
    COLLEGE_STUDENT("18-24"),
    PROFESSOR("24+");

    private final String ageRange;
    private final static int lastValueIndex = values().length - 1;
    GradeLevel(String ageRange) {
        this.ageRange = ageRange;
    }

    public static GradeLevel getGradeLevel(int age) {
        var index = Math.min(lastValueIndex, age);
        return values()[index];
    }

    @Override
    public String toString() {
        return ageRange;
    }
}
