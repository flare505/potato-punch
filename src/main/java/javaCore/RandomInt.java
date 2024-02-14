package javaCore;

import java.time.LocalDateTime;
import java.util.Random;

public class RandomInt {
    public static void main(String[] args) {
        Random rn = new Random();
        for (int i = 0; i < 10; i++) {
            System.out.println(rn.nextInt(10));
        }

        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime localDateTime1 = LocalDateTime.of(2021, 03, 01, 0, 0, 0);
    }
}
