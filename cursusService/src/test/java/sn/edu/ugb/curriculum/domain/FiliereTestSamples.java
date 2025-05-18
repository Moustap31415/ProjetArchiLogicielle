package sn.edu.ugb.curriculum.domain;

import java.util.Random;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

public class FiliereTestSamples {

    private static final Random random = new Random();
    private static final AtomicLong longCount = new AtomicLong(random.nextInt() + (2 * Integer.MAX_VALUE));
    private static final AtomicInteger intCount = new AtomicInteger(random.nextInt() + (2 * Short.MAX_VALUE));

    public static Filiere getFiliereSample1() {
        return new Filiere().id(1L).nom("nom1").code("code1").creditsTotaux(1);
    }

    public static Filiere getFiliereSample2() {
        return new Filiere().id(2L).nom("nom2").code("code2").creditsTotaux(2);
    }

    public static Filiere getFiliereRandomSampleGenerator() {
        return new Filiere()
            .id(longCount.incrementAndGet())
            .nom(UUID.randomUUID().toString())
            .code(UUID.randomUUID().toString())
            .creditsTotaux(intCount.incrementAndGet());
    }
}
