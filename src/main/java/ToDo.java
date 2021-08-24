/** Represents a task without any time restrictions
 *  @auther mokdarren
 */
public class ToDo extends Task{

    /**
     *
     * @param description description of task
     */
    public ToDo(String description) {
        super(description);
    }

    /**
     * Overloaded constructor to specify if completed
     * @param isDone
     * @param description description of task
     */
    public ToDo(String description, boolean isDone) {
        super(description);
        this.isDone = isDone;
    }
    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}