import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import bobbybot.commands.DoneCommand;
import bobbybot.tasks.ToDo;
import bobbybot.util.Storage;
import bobbybot.util.TaskList;
import bobbybot.util.Ui;


public class DoneCommandTest {
    private static final String STORAGE_PATH = "test.txt";
    private final TaskList tasks = new TaskList(new ArrayList<>());
    private final Ui ui = new Ui();
    private final Storage storage = new Storage(STORAGE_PATH);

    @AfterAll
    public static void cleanUp() {
        File file = new File(STORAGE_PATH);
        file.delete();
    }

    @Test
    public void doneCommand_todo_success() {
        tasks.addTask(new ToDo("test"));
        DoneCommand c = new DoneCommand(1);
        c.execute(tasks, ui, storage);
        assertEquals("X", tasks.getTask(0).getStatus());
    }

    @Test
    public void doneCommand_lessThanZero_errorResponse() {
        DoneCommand c = new DoneCommand(-1);
        c.execute(tasks, ui, storage);
        String response = c.getResponse();
        assertEquals("You are trying to mark as done a task number < 1", response);
    }

    @Test
    public void doneCommand_moreThanSize_errorResponse() {
        DoneCommand c = new DoneCommand(1);
        c.execute(tasks, ui, storage);
        String response = c.getResponse();
        assertEquals("Task number you are trying to mark as done does not exist", response);
    }
}
