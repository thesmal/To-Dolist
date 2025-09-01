package com.github.thesmal;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {
        // Make the tasks list.
        Path dataLocation = Path.of("data.txt");
        ArrayList<String> tasks =  new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(dataLocation);
            tasks.clear();
            tasks.addAll(lines);
        }
        catch (Exception e) {
            Utils.println("Error: " + e.getMessage());
        }

        //Make a running variable.
        boolean Running = true;

        //While loop for the program to run until Running is false.
        while (Running) {
            // Fall back incase invalid option.
            int option = 3;

            // Print the menu.
            Utils.println("-------------------------\nTo-Do List V2.5\n-------------------------");
            Utils.println("1, Add task.\n2, Remove task.\n3, List task.\n4, Clear all tasks.\n5, Mark task as Completed.\n6, Mark task as Incomplete.\n7, Exit.");
            Utils.println("Enter option:");

            // Attempt to get user's option number.
            try {
                option = Utils.inputInt();
            }

            // If incorrect integer fallback to 3.
            catch (NumberFormatException e) {
                Utils.println("That's not a valid option, Resuming with option 3.");
            }

            // Actions
            switch (option) {
                // User picks to add a task.
                case 1:  {
                    Utils.println("Enter task name:");
                    tasks.add(Utils.input().trim());
                    tasks.set(tasks.size()-1, tasks.get(tasks.size()-1) + " - Incomplete.");
                    break;
                }

                // User picks to remove a task.
                case 2:  {
                    // Try to get task index.
                    try {
                        Utils.println("Enter task index:");
                        tasks.remove(Utils.inputInt());
                    }
                    // Ditch if incorrect value
                    catch (Exception e) {
                        Utils.println("Invalid index cuz: " + e.getMessage());
                    }
                    break;
                }

                // List all tasks.
                case 3:  {
                    // List
                    if (!tasks.isEmpty()) {
                        for (int task = 0; task < tasks.size(); task++) {
                            Utils.println("Index: " + task + " | \"" + tasks.get(task) + "\"\n");
                        }
                    }
                    // Tell user if it's empty.
                    else {
                        Utils.println("No tasks inside your list.");
                    }
                    // Ask user to press enter to continue.
                    Utils.print("Press enter to return to MENU.");
                    Utils.input();
                    break;
                }
                // Clear all entries in list.
                case 4: {
                    tasks.clear();
                    Utils.println("Your task list has been cleared.");
                    break;
                }
                // Complete task
                case 5: {
                    try {
                        Utils.println("Enter task index: ");
                        int index = Utils.inputInt();
                        tasks.set(index, tasks.get(index).replace(" - Incomplete.", " - Completed."));
                    }
                    catch (Exception e) {
                        Utils.println("Invalid index cuz: " + e.getMessage());
                    }
                    break;
                }
                // Incomplete task
                case 6: {
                    try {
                        Utils.println("Enter task index: ");
                        int index = Utils.inputInt();
                        String task = tasks.get(index);
                        tasks.set(index, task.replace(" - Completed.", " - Incomplete."));
                    }
                    catch (Exception e) {
                        Utils.println("Invalid index cuz: " + e.getMessage());
                    }
                    break;
                }
                // Set Running to false and hence exit the program.
                case 7:  {
                    String content = String.join("\n", tasks);
                    Files.write(dataLocation, content.getBytes());
                    Running = false;
                    break;
                }
                // If an incorrect option slips tell them.
                default:  {
                    Utils.println("Invalid option.");
                    break;
                }
            }

            // Print a new line to make it clean.
            Utils.println("");
        }
    }
}