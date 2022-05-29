package com.botscrew.testtaskuniversity;

import com.botscrew.testtaskuniversity.util.Helper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.Scanner;

@SpringBootApplication
public class TestTaskUniversityApplication {
    public static String POSSIBLE_COMMANDS =
            "Who is head of department {department name}\n" +
                    "Show {department name} statistics\n" +
                    "Show the average salary for the department {department name}\n" +
                    "Show count of employee for {department name}\n" +
                    "Global search by {template}";
    public static String HELPER_MESSAGE =
            "Helper commands:\n" +
                    "-> Show possible requests\n" +
                    "-> Exit";

    public static void main(String[] args) {

        ConfigurableApplicationContext applicationContext = SpringApplication.run(TestTaskUniversityApplication.class, args);
        Helper helper = applicationContext.getBean(Helper.class);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Hello there! Write a command here:");

        String input;
        while (true) {
            input = scanner.nextLine();

            if (input.equals("-h") || input.equals("--help")) {
                System.out.println(HELPER_MESSAGE);
                continue;
            }
            if (input.equalsIgnoreCase("Exit")) {
                break;
            }
            if (input.equalsIgnoreCase("Show possible requests")) {
                System.out.println(POSSIBLE_COMMANDS);
                continue;
            }

            helper.chooseRequest(input);
        }
        System.out.println("Bye! :)");
    }
}
