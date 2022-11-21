package net.croz.waitingmachine.entrance.service;

import lombok.RequiredArgsConstructor;
import net.croz.waitingmachine.entrance.entity.EntranceCounter;
import net.croz.waitingmachine.entrance.repository.EntranceCounterRepository;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Random;

@Service
@RequiredArgsConstructor
public class EntranceCounterService {

    private final EntranceCounterRepository repository;
    private final Random random = new Random();

    @Scheduled(fixedRate = 1000)
    public void readEntranceCounterSensor() {
        var entranceCounter = new EntranceCounter();

        entranceCounter.setCounter((long) random.nextInt(20));
        entranceCounter.setCheckTime(LocalDateTime.now());

        repository.save(entranceCounter);
    }
}
