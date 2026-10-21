package com.amruta;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class ToDoList {
    private ArrayList<Task> tasks;
    private static final String FILE_NAME = "tasks.txt";

    public ToDoList() {
        tasks = new ArrayList<>();
    }

    public void addTask(String description) {
        if (description == null || description.trim().isEmpty()) {
            System.out.println("❌ Error: Task description cannot be empty.");
            return;
        }
        tasks.add(new Task(description.trim()));
        System.out.println("✔ Task added: " + description);
    }

    public void listTasks() {
        if (tasks.isEmpty()) {
            System.out.println("📭 No tasks found.");
            return;
        }
        System.out.println("\n--- Your Tasks (" + tasks.size() + ") ---");
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ". " + tasks.get(i));
        }
    }

    public void markComplete(int index) {
        if (index < 1 || index > tasks.size()) {
            System.out.println("❌ Error: Invalid task number.");
            return;
        }
        Task t = tasks.get(index - 1);
        if (t.isCompleted()) {
            System.out.println("ℹ Task already completed: " + t.getDescription());
        } else {
            t.markComplete();
            System.out.println("✔ Marked complete: " + t.getDescription());
        }
    }

    public void deleteTask(int index) {
        if (index < 1 || index > tasks.size()) {
            System.out.println("❌ Error: Invalid task number.");
            return;
        }
        Task removed = tasks.remove(index - 1);
        System.out.println("🗑 Deleted: " + removed.getDescription());
    }

    public void saveTasks() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Task t : tasks) {
                writer.write(t.isCompleted() + "|" + t.getDescription());
                writer.newLine();
            }
            System.out.println("✔ " + tasks.size() + " task(s) saved to " + FILE_NAME);
        } catch (IOException e) {
            System.out.println("❌ Error saving tasks: " + e.getMessage());
        }
    }

    public void loadTasks() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");
                if (parts.length == 2) {
                    boolean completed = Boolean.parseBoolean(parts[0].trim());
                    String desc = parts[1].trim();
                    tasks.add(new Task(desc, completed));
                }
            }
            System.out.println("✔ Loaded " + tasks.size() + " task(s) from file.");
        } catch (IOException e) {
            System.out.println("❌ Error loading tasks: " + e.getMessage());
        }
    }
}
