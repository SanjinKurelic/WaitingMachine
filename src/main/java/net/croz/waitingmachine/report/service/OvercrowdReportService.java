package net.croz.waitingmachine.report.service;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Metrics;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.croz.waitingmachine.queue.rest.WaitingQueueRestRepository;
import net.croz.waitingmachine.status.model.QueueStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Slf4j
@Service
@RequiredArgsConstructor
public class OvercrowdReportService {

    private final WaitingQueueRestRepository queueRepository;
    private final MeterRegistry meterRegistry;

    private static final String OVERCROWD_SITUATION = "overcrowd_situation";

    @PostConstruct
    public void init() {
        Counter.builder(OVERCROWD_SITUATION).description("Some test").register(meterRegistry);
    }

    @Scheduled(fixedRate = 1000)
    public void checkForOvercrowdedQueue() {
        var peopleInWaitingList = queueRepository.findAllByStatus(QueueStatus.WAITING);

        if (peopleInWaitingList.size() > 10) {
            Metrics.counter(OVERCROWD_SITUATION).increment();
            log.error("We have overcrowded queue here");
        }
    }
}
