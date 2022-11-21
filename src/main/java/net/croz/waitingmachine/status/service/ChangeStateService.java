package net.croz.waitingmachine.status.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.croz.waitingmachine.queue.rest.WaitingQueueRestRepository;
import net.croz.waitingmachine.status.model.QueueStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class ChangeStateService {

    private final WaitingQueueRestRepository queueRepository;

    @Scheduled(fixedRate = 5000)
    public void changeWaitingState() {
        finishRide();
        putCustomersOnRide();
    }

    private void finishRide() {
        var ridingCustomers = queueRepository.findAllByStatus(QueueStatus.RIDING);
        log.info("Finishing ride for {} customers", ridingCustomers.size());

        ridingCustomers.stream()
            .filter(peopleOnRide -> QueueStatus.RIDING.equals(peopleOnRide.getStatus()))
            .forEach(finishRide -> finishRide.setStatus(QueueStatus.FINISHED));

        queueRepository.saveAll(ridingCustomers);
    }

    private void putCustomersOnRide() {
        var putCustomersToRide = queueRepository.findAllByStatusOrderByArrivalTimeAsc(QueueStatus.WAITING);
        log.info("Putting {} customers to ride", putCustomersToRide.size());

        putCustomersToRide.stream()
            .filter(peopleInQueue -> QueueStatus.WAITING.equals(peopleInQueue.getStatus()))
            .limit(5)
            .forEach(putPeopleOnRide -> putPeopleOnRide.setStatus(QueueStatus.RIDING));

        queueRepository.saveAll(putCustomersToRide);
    }
}
