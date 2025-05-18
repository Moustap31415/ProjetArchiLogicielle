package sn.edu.ugb.curriculum.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

public class CurriculumTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));

    public static Curriculum getCurriculumSample1() {
        return new Curriculum().id(1L).anneeAcademique("anneeAcademique1").filiereId(1L).uniteId(1L).semestreId(1L);
    }

    public static Curriculum getCurriculumSample2() {
        return new Curriculum().id(2L).anneeAcademique("anneeAcademique2").filiereId(2L).uniteId(2L).semestreId(2L);
    }

    public static Curriculum getCurriculumRandomSampleGenerator() {
        return new Curriculum()
            .id(longCount.incrementAndGet())
            .anneeAcademique(UUID.randomUUID().toString())
            .filiereId(longCount.incrementAndGet())
            .uniteId(longCount.incrementAndGet())
            .semestreId(longCount.incrementAndGet());
    }
}
