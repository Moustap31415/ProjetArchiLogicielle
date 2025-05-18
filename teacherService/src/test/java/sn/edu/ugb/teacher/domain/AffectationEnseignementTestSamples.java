package sn.edu.ugb.teacher.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class AffectationEnseignementTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));
    private static final AtomicInteger intCount = new AtomicInteger(random.nextInt() + (2 * Short.MAX_VALUE));

    public static AffectationEnseignement getAffectationEnseignementSample1() {
        return new AffectationEnseignement().id(1L).anneeAcademique("anneeAcademique1").chargeHoraire(1).coursId(1L);
    }

    public static AffectationEnseignement getAffectationEnseignementSample2() {
        return new AffectationEnseignement().id(2L).anneeAcademique("anneeAcademique2").chargeHoraire(2).coursId(2L);
    }

    public static AffectationEnseignement getAffectationEnseignementRandomSampleGenerator() {
        return new AffectationEnseignement()
            .id(longCount.incrementAndGet())
            .anneeAcademique(UUID.randomUUID().toString())
            .chargeHoraire(intCount.incrementAndGet())
            .coursId(longCount.incrementAndGet());
    }
}
