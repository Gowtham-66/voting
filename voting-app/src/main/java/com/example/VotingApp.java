package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
public class VotingApp {

    private static Map<String, Integer> candidates = new HashMap<>();

    public static void main(String[] args) {
        SpringApplication.run(VotingApp.class, args);
    }

    @GetMapping("/entercandidate")
    public String enterCandidate(@RequestParam String name) {
        candidates.put(name, 0);
        return "Candidate " + name + " entered successfully!";
    }

    @GetMapping("/castvote")
    public String castVote(@RequestParam String name) {
        if (candidates.containsKey(name)) {
            candidates.put(name, candidates.get(name) + 1);
            return "Vote casted successfully for " + name + ". Total votes: " + candidates.get(name);
        } else {
            return "Invalid candidate name";
        }
    }

    @GetMapping("/countvote")
    public String countVote(@RequestParam String name) {
        if (candidates.containsKey(name)) {
            return "Vote count for " + name + ": " + candidates.get(name);
        } else {
            return "Invalid candidate name";
        }
    }

    @GetMapping("/listvote")
    public Map<String, Integer> listVotes() {
        return candidates;
    }

    @GetMapping("/getwinner")
    public String getWinner() {
        if (candidates.isEmpty()) {
            return "No candidates entered yet.";
        }

        String winner = candidates.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .get()
                .getKey();

        return "The winner is: " + winner;
    }
}

