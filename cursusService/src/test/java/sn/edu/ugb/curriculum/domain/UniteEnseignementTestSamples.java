package sn.edu.ugb.curriculum.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class UniteEnseignementTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));
    private static final AtomicInteger intCount = new AtomicInteger(random.nextInt() + (2 * Short.MAX_VALUE));

    public static UniteEnseignement getUniteEnseignementSample1() {
        return new UniteEnseignement().id(1L).nom("nom1").code("code1").credits(1).filiereId(1L);
    }

    public static UniteEnseignement getUniteEnseignementSample2() {
        return new UniteEnseignement().id(2L).nom("nom2").code("code2").credits(2).filiereId(2L);
    }

    public static UniteEnseignement getUniteEnseignementRandomSampleGenerator() {
        return new UniteEnseignement()
            .id(longCount.incrementAndGet())
            .nom(UUID.randomUUID().toString())
            .code(UUID.randomUUID().toString())
            .credits(intCount.incrementAndGet())
            .filiereId(longCount.incrementAndGet());
    }
}
