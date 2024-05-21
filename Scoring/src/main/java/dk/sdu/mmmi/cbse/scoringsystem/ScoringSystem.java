package dk.sdu.mmmi.cbse.scoringsystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

@SpringBootApplication
@RestController
public class ScoringSystem {
    private long score = 0;

    public static void main(String[] args) {
        SpringApplication.run(ScoringSystem.class, args);
    }

    @GetMapping("/score")
    public long getScore() {
        return score;
    }

    @GetMapping("/score/increment")
    public long incrementScore() {
        this.score++;
        return score;
    }

    @GetMapping("/score/decrement")
    public long decrementScore() {
        this.score--;
        return score;
    }

    @PutMapping("/score/add/{value}")
    public void addScore(@PathVariable long value) {
        if(value > 0) {
            score += value;
        }
    }


}
