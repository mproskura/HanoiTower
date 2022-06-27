import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter number of towers:");
        byte numberOfTowers = scanner.nextByte();
        System.out.println("Enter number of disks:");
        int numberOfDisks = scanner.nextInt();

        //create initial scenarios
        List<Tower> towers = new ArrayList<>();
        for (byte i = 0; i < numberOfTowers; i++) {
            towers.add(new Tower(i));
        }

        //place all disks on first tower
        for (int i = numberOfDisks - 1; i >= 0; i--) {
            Tower sourceTower = towers.get(0);
            sourceTower.putDisk(new Disk((byte)i));
        }

        List<Scenario> scenarioList = new ArrayList<>();
        scenarioList.add(new Scenario(towers));
        boolean gameWon = false;
        //keep analyzing next moves until game is won
        int moveNumber =0;
        while (!gameWon ) {
            moveNumber++;
            System.out.println("Executing move " + moveNumber);
            List<Scenario> newScenarios = new ArrayList<>();
            for (Scenario scenario : scenarioList) {
                ScenarioAnalysis scenarioAnalysis = new ScenarioAnalysis(scenario);
                newScenarios.addAll(scenarioAnalysis.analyze());
            }
            scenarioList = newScenarios;
            System.out.println("Analyzing " + scenarioList.size() + " scenarios");

            for (Scenario scenario : newScenarios) {
                if (scenario.isGameWon()) gameWon = true;
            }

        }

        //print winning scenario(s)
        for (Scenario scenario : scenarioList) {
            if (scenario.isGameWon()) {
                scenario.print();
            }
        }
    }
}