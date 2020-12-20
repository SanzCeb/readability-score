package readability.scoring.grades;


public enum GradeLevel {

    KINDERGARTEN("6"),
    FIRST_SECOND_GRADE("7"),
    THIRD_GRADE("9"),
    FOURTH_GRADE("10"),
    FIFTH_GRADE("11"),
    SIXTH_GRADE("12"),
    SEVENTH_GRADE("13"),
    EIGHTH_GRADE("14"),
    NINTH_GRADE("15"),
    TENTH_GRADE("16"),
    ELEVENTH_GRADE("17"),
    TWELFTH_GRADE("18"),
    COLLEGE_STUDENT("24"),
    PROFESSOR("24+");


    private final String ageRange;

    GradeLevel(String ageRange) {
        this.ageRange = ageRange;
    }

    @Override
    public String toString() {
        return ageRange;
    }
}




