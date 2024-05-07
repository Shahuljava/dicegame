import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Map;
import java.util.HashMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class DiceGame {
    private int numDice;
    private int numSimulations;
    private Random random;
    private Map<Integer, Integer> results;

    // Constructor to initialize the game with the number of dice and simulations
    public DiceGame(int numDice, int numSimulations) {
        this.numDice = numDice;
        this.numSimulations = numSimulations;
        this.random = new Random();
        this.results = new HashMap<>();
    }
    
    // Simulates playing a single game
    public void playGame() {
        List<Integer> dice = IntStream.range(0, numDice)
                                      .map(i -> random.nextInt(6) + 1)
                                      .boxed()
                                      .collect(Collectors.toList());

        int score = 0;
        while (!dice.isEmpty()) {
            boolean hasThree = dice.stream().anyMatch(die -> die == 3);
            List<Integer> nextRoll = dice.stream().filter(die -> die != 3).collect(Collectors.toList());

            if (!hasThree) {
                int min = nextRoll.stream().min(Integer::compare).orElseThrow(IllegalStateException::new);
                score += min;
                nextRoll.remove(Integer.valueOf(min)); // Remove the first occurrence of the minimum value
            }

            dice = nextRoll.stream().map(die -> random.nextInt(6) + 1).collect(Collectors.toList());
        }

        results.put(score, results.getOrDefault(score, 0) + 1);
    }

    // Runs the simulation for the specified number of times
    public void simulateResults() {
        IntStream.range(0, numSimulations).forEach(i -> playGame());
    }

    // Outputs the results of all simulations
    public void reportResults() {
        System.out.println("Number of simulations was " + numSimulations + " using " + numDice + " dice.");
        results.forEach((score, count) -> {
            double frequency = (double) count / numSimulations;
            System.out.println(String.format("Total %d occurs %.2f occurred %.1f times.", score, frequency, (double) count));
        });
    }

    // Main method to run the simulation
    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        DiceGame game = new DiceGame(5, 10000);
        game.simulateResults();
        game.reportResults();
        long endTime = System.currentTimeMillis();
        System.out.println("Total simulation took to process the request " + (endTime - startTime) / 1000.0 + " seconds.");
    }
}
