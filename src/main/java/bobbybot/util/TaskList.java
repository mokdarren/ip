package bobbybot.util;

import java.util.List;

import bobbybot.tasks.Task;

/**
 * Represents a task list
 */
public class TaskList {
    private final List<Task> tasks;
    public TaskList(List<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Getter for task
     * @param i task number to get, index starts from 0
     * @return task chosen
     */
    public Task getTask(int i) {
        return tasks.get(i);
    }

    /**
     * Adds a task to task list
     * @param task
     */
    public void addTask(Task task) {
        tasks.add(task);
    }
    /**
     * Getter for List of tasks
     * @return List of task
     */
    public List<Task> getTasks() {
        return tasks;
    }

    /**
     * Mark a task as done
     * @param taskNo bobbybot Task Number (starting from index 1)
     */
    public void markAsDone(int taskNo) {
        Task taskCompleted = getTask(taskNo - 1);
        taskCompleted.markAsDone();
    }

    /**
     * Delete a task
     * @param taskNo bobbybot.tasks.Task Number (starting from index 1)
     */
    public void deleteTask(int taskNo) {
        Task taskToDelete = tasks.get(taskNo - 1);
        System.out.println("Noted. I've removed this task:");
        System.out.println("  " + taskToDelete);
        tasks.remove(taskToDelete);
    }
}
