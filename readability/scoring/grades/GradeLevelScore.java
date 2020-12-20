package readability.scoring.grades;

import java.util.AbstractMap;
import java.util.Map;

public class GradeLevelScore {
    private final static Map<Long, GradeLevel> gradeLevel;

    static {
        gradeLevel = Map.ofEntries(new AbstractMap.SimpleImmutableEntry<>(1L, GradeLevel.KINDERGARTEN)
                ,new AbstractMap.SimpleImmutableEntry<>(2L, GradeLevel.FIRST_SECOND_GRADE)
                ,new AbstractMap.SimpleImmutableEntry<>(3L, GradeLevel.THIRD_GRADE)
                ,new AbstractMap.SimpleImmutableEntry<>(4L, GradeLevel.FOURTH_GRADE)
                ,new AbstractMap.SimpleImmutableEntry<>(5L, GradeLevel.FIFTH_GRADE)
                ,new AbstractMap.SimpleImmutableEntry<>(6L, GradeLevel.SIXTH_GRADE)
                ,new AbstractMap.SimpleImmutableEntry<>(7L, GradeLevel.SEVENTH_GRADE)
                ,new AbstractMap.SimpleImmutableEntry<>(8L, GradeLevel.EIGHTH_GRADE)
                ,new AbstractMap.SimpleImmutableEntry<>(9L, GradeLevel.NINTH_GRADE)
                ,new AbstractMap.SimpleImmutableEntry<>(10L,GradeLevel.TENTH_GRADE)
                ,new AbstractMap.SimpleImmutableEntry<>(11L, GradeLevel.ELEVENTH_GRADE)
                ,new AbstractMap.SimpleImmutableEntry<>(12L, GradeLevel.TWELFTH_GRADE)
                ,new AbstractMap.SimpleImmutableEntry<>(13L, GradeLevel.COLLEGE_STUDENT)
                ,new AbstractMap.SimpleImmutableEntry<>(14L, GradeLevel.PROFESSOR));
    }

    public static GradeLevel getGradeLevel(long score) {
        return gradeLevel.getOrDefault(score, GradeLevel.KINDERGARTEN);
    }
}
