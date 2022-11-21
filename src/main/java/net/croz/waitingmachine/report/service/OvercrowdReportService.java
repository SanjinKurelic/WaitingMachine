package net.croz.waitingmachine.report.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.croz.waitingmachine.queue.rest.WaitingQueueRestRepository;
import net.croz.waitingmachine.status.model.QueueStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class OvercrowdReportService {

    private final WaitingQueueRestRepository queueRepository;

    @Scheduled(fixedRate = 1000)
    public void checkForOvercrowdedQueue() {
        var peopleInWaitingList = queueRepository.findAllByStatus(QueueStatus.WAITING);

        if (peopleInWaitingList.size() > 10) {
            log.error("We have overcrowded queue here");
        }
    }
}
