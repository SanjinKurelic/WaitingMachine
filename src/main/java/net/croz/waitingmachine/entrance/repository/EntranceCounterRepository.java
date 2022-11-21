package net.croz.waitingmachine.entrance.repository;

import net.croz.waitingmachine.entrance.entity.EntranceCounter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntranceCounterRepository extends JpaRepository<EntranceCounter, Long> {
}
