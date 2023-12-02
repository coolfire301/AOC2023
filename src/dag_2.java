import input.dag_2_input;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class dag_2 {

    //private String[] kleuren = {"green", "red", "blue"};

    public static void main(String[] args) {
        String data = dag_2_input.input;
        countCubes_part1(data);
        countCubes_part2(data);
    }

    private static void countCubes_part2(String data){
        int sum = 0;
        for (String game : data.split("\n")) {
            String[] opgesplits = game.split(":");

            int gameid = Integer.valueOf(opgesplits[0].split("Game ")[1]);

            Map<String, Integer> kleuren = new HashMap<>();
            kleuren.put("blue", 0);
            kleuren.put("red", 0);
            kleuren.put("green", 0);
            for (String mini_game : opgesplits[1].split(";")) {
                System.out.println(mini_game);
                for (String kubussen : mini_game.split(",")) {
                    if (kubussen.contains("blue")) {
                        if (kleuren.get("blue") < Integer.valueOf(kubussen.split(" blue")[0].trim())) {
                            kleuren.put("blue", Integer.valueOf(kubussen.split(" blue")[0].trim()));
                        }
                    } else if (kubussen.contains("red")) {
                        if (kleuren.get("red") < Integer.valueOf(kubussen.split(" red")[0].trim())) {
                            kleuren.put("red", Integer.valueOf(kubussen.split(" red")[0].trim()));
                        }
                    } else if (kubussen.contains("green")) {
                        if (kleuren.get("green") < Integer.valueOf(kubussen.split(" green")[0].trim())) {
                            kleuren.put("green", Integer.valueOf(kubussen.split(" green")[0].trim()));
                        }
                    }
                }

            }
            if (kleuren.get("red") == 100){
                kleuren.put("red", 0);
            }
            if (kleuren.get("blue") == 100){
                kleuren.put("blue", 0);
            }
            if (kleuren.get("green") == 100){
                kleuren.put("green", 0);
            }
            sum = sum + (kleuren.get("green") * kleuren.get("blue") * kleuren.get("red"));

            System.out.println(kleuren);
//            if (kleuren.get("red") < 13 && kleuren.get("green") < 14 && kleuren.get("blue") < 15){
//                sum = sum + gameid;
//            }
            System.out.println("\n");
        }
        System.out.println("part2: " + sum);
    }

    private static void countCubes_part1(String data) {
        int sum = 0;
        for (String game : data.split("\n")) {
            String[] opgesplits = game.split(":");

            int gameid = Integer.valueOf(opgesplits[0].split("Game ")[1]);

            Map<String, Integer> kleuren = new HashMap<>();
            kleuren.put("blue", 0);
            kleuren.put("red", 0);
            kleuren.put("green", 0);
            for (String mini_game : opgesplits[1].split(";")) {

                for (String kubussen : mini_game.split(",")) {
                    if (kubussen.contains("blue")) {
                        if (kleuren.get("blue") < Integer.valueOf(kubussen.split(" blue")[0].trim())) {
                            kleuren.put("blue", Integer.valueOf(kubussen.split(" blue")[0].trim()));
                        }
                    } else if (kubussen.contains("red")) {
                        if (kleuren.get("red") < Integer.valueOf(kubussen.split(" red")[0].trim())) {
                            kleuren.put("red", Integer.valueOf(kubussen.split(" red")[0].trim()));
                        }
                    } else if (kubussen.contains("green")) {
                        if (kleuren.get("green") < Integer.valueOf(kubussen.split(" green")[0].trim())) {
                            kleuren.put("green", Integer.valueOf(kubussen.split(" green")[0].trim()));
                        }
                    }
                }

            }
            if (kleuren.get("red") < 13 && kleuren.get("green") < 14 && kleuren.get("blue") < 15){
                sum = sum + gameid;
            }
        }
        System.out.println("part1: " + sum);
    }
}
