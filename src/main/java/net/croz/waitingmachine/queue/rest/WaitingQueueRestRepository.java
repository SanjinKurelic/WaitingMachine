package net.croz.waitingmachine.queue.rest;

import net.croz.waitingmachine.queue.entity.WaitingQueue;
import net.croz.waitingmachine.status.model.QueueStatus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(path = "queue")
public interface WaitingQueueRestRepository extends CrudRepository<WaitingQueue, Long> {

    List<WaitingQueue> findAllByStatusOrderByArrivalTimeAsc(QueueStatus status);

    List<WaitingQueue> findAllByStatus(QueueStatus status);
}
