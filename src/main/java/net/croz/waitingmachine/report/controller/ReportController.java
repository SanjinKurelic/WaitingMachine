package net.croz.waitingmachine.report.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/report")
public class ReportController {

    private final Random random = new Random();

    @GetMapping
    public ResponseEntity<Map<String, String>> getSomeReport() throws InterruptedException {
        Thread.sleep((random.nextInt(10) + 6) * 1000L);

        if (random.nextBoolean()) {
            throw new InternalError("Some error");
        }

        return ResponseEntity.ok(Map.of("status", "ok"));
    }
}
