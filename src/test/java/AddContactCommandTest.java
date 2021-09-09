import java.io.File;
import java.util.ArrayList;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;

import bobbybot.commands.AddContactCommand;
import bobbybot.person.Address;
import bobbybot.person.Email;
import bobbybot.person.Name;
import bobbybot.person.Person;
import bobbybot.person.Phone;
import bobbybot.util.PersonList;
import bobbybot.util.Storage;
import bobbybot.util.TaskList;
import bobbybot.util.Ui;

public class AddContactCommandTest {

    private static final String STORAGE_PATH = "test.txt";
    private final TaskList tasks = new TaskList(new ArrayList<>());
    private final Ui ui = new Ui();
    private final Storage storage = new Storage(STORAGE_PATH);
    private final PersonList contacts = new PersonList(new ArrayList<Person>());

    @AfterAll
    public static void cleanUp() {
        File file = new File(STORAGE_PATH);
        file.delete();
    }

    @Test
    public void addContactCommand_validInput_success() {
        Name name = new Name("Darren");
        Email email = new Email("mokkwd@gmail.com");
        Phone phone = new Phone("83821019");
        Address address = new Address("32 Phoenix Road");
        AddContactCommand c = new AddContactCommand(name, email, phone, address);
        c.execute(tasks, ui, storage, contacts);
        System.out.println(c.getResponse());
    }
}
