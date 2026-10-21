# To-Do List Application (Maven)

A simple console-based To-Do List application built in Java and managed using **Apache Maven**. This project demonstrates how to structure a Java application following Maven's standard directory layout and build lifecycle.

## ✨ Features
- ✅ Add new tasks with descriptions
- ✅ List all tasks with completion status
- ✅ Mark tasks as complete
- ✅ Delete tasks
- ✅ Save and load tasks automatically using file handling (`tasks.txt`)
- ✅ Error handling for invalid inputs and corrupted files

## 🛠️ Technologies Used
- **Language:** Java (JDK 21)
- **Build Tool:** Apache Maven
- **IDE:** Eclipse
- **Data Structure:** `ArrayList<Task>`

## 📁 Project Structure (Maven Standard)
```text
ToDoListMaven/
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── amruta/
│   │               ├── Main.java
│   │               ├── Task.java
│   │               └── ToDoList.java
│   └── test/
│       └── java/
├── pom.xml
├── .gitignore
└── README.md
