class Task {
    int taskId;
    String taskName;
    String status;

    Task(int taskId, String taskName, String status) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
    }

    @Override
    public String toString() {
        return "Task{" + "taskId=" + taskId + ", taskName='" + taskName + '\'' + ", status='" + status + '\'' + '}';
    }
}

class Node {
    Task task;
    Node next;

    Node(Task task) {
        this.task = task;
        this.next = null;
    }
}

class TaskManager {
    Node head;

    TaskManager() {
        head = null;
    }

    // Method to add a task
    void addTask(int taskId, String taskName, String status) {
        Task newTask = new Task(taskId, taskName, status);
        Node newNode = new Node(newTask);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    // Method to search for a task
    Task searchTask(int taskId) {
        Node temp = head;
        while (temp != null) {
            if (temp.task.taskId == taskId) {
                return temp.task;
            }
            temp = temp.next;
        }
        return null;
    }

    // Method to traverse tasks
    void traverseTasks() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.task);
            temp = temp.next;
        }
    }

    // Method to delete a task
    void deleteTask(int taskId) {
        if (head == null) {
            return;
        }
        if (head.task.taskId == taskId) {
            head = head.next;
            return;
        }
        Node temp = head;
        while (temp.next != null && temp.next.task.taskId != taskId) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
        }
    }
}

public class TaskManagementSystem {
    public static void main(String[] args) {
        TaskManager taskManager = new TaskManager();
        
        // Adding tasks
        taskManager.addTask(1, "Task 1", "Pending");
        taskManager.addTask(2, "Task 2", "Completed");
        taskManager.addTask(3, "Task 3", "In Progress");
        
        // Traversing tasks
        System.out.println("All Tasks:");
        taskManager.traverseTasks();
        
        // Searching for a task
        System.out.println("Search Task with ID 2:");
        Task searchResult = taskManager.searchTask(2);
        if (searchResult != null) {
            System.out.println(searchResult);
        } else {
            System.out.println("Task not found.");
        }
        
        // Deleting a task
        System.out.println("Deleting Task with ID 2");
        taskManager.deleteTask(2);
        
        // Traversing tasks after deletion
        System.out.println("All Tasks after deletion:");
        taskManager.traverseTasks();
    }
}
