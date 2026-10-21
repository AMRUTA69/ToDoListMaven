package com.amruta;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ToDoList todo = new ToDoList();
        Scanner scanner = new Scanner(System.in);

        System.out.println("========================================");
        System.out.println("      📝 TO-DO LIST APPLICATION");
        System.out.println("========================================");
        
        todo.loadTasks();

        boolean running = true;
        while (running) {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Add Task");
            System.out.println("2. List Tasks");
            System.out.println("3. Mark Task Complete");
            System.out.println("4. Delete Task");
            System.out.println("5. Save Tasks");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    System.out.print("Enter task description: ");
                    todo.addTask(scanner.nextLine());
                    break;
                case "2":
                    todo.listTasks();
                    break;
                case "3":
                    todo.listTasks();
                    System.out.print("Enter task number to mark complete: ");
                    try {
                        todo.markComplete(Integer.parseInt(scanner.nextLine().trim()));
                    } catch (NumberFormatException e) {
                        System.out.println("❌ Invalid number.");
                    }
                    break;
                case "4":
                    todo.listTasks();
                    System.out.print("Enter task number to delete: ");
                    try {
                        todo.deleteTask(Integer.parseInt(scanner.nextLine().trim()));
                    } catch (NumberFormatException e) {
                        System.out.println("❌ Invalid number.");
                    }
                    break;
                case "5":
                    todo.saveTasks();
                    break;
                case "6":
                    todo.saveTasks();
                    running = false;
                    System.out.println("👋 Goodbye!");
                    break;
                default:
                    System.out.println("❌ Invalid choice.");
            }
        }
        scanner.close();
    }
}