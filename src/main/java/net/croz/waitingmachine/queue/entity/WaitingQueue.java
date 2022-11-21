package net.croz.waitingmachine.queue.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import net.croz.waitingmachine.status.model.QueueStatus;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "waiting_queue")
@SuppressWarnings("JpaDataSourceORMInspection")
public class WaitingQueue {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "ticket_number")
    private Long ticketNumber;

    @Column(name = "arrival_time")
    private LocalDateTime arrivalTime;

    @Enumerated(value = EnumType.STRING)
    private QueueStatus status;
}
