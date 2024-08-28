package command;

/* My import */
import blitz.Storage;
import blitz.TaskList;
import blitz.Ui;
import exception.BlitzException;

public abstract class Command {
    private String command;

    /**
     * Constructs a new Command object with specified command String.
     *
     * @param command Command String to be associated with this Command object.
     */
    public Command(String command) {
        this.command = command;
    }

    /**
     * Executes the command.
     *
     * @param list TaskList to be used if required.
     * @param ui Ui to be used if required.
     * @param storage Storage to be used if required.
     * @throws BlitzException If error occurs.
     */
    public abstract void execute(TaskList list, Ui ui, Storage storage) throws BlitzException;

    /**
     * Checks if this Command object's command is "bye".
     *
     * @return True if the command is "bye", false otherwise.
     */
    public boolean isExit() {
        return this.command.equalsIgnoreCase("bye");
    }

    /**
     * Compares two Command objects and determines if they are equal.
     *
     * @param o Object to be compared.
     * @return True if both objects are of same reference or both objects have the same command String, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Command c = (Command) o;
        return this.command.equals((c.command));
    }
}
