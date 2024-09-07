package command;

import java.util.ArrayList;

import blitz.Storage;
import blitz.TaskList;
import blitz.Ui;

import exception.BlitzEmptyTaskListException;
import exception.BlitzException;

import task.Task;

/**
 * Represents a "find" command in the Blitz application.
 */
public class CommandFind extends Command {
    private String parameters;

    /**
     * Constructs a new CommandFind object with specified command String and a parameter String.
     *
     * @param command Command String to be associated with this Command object.
     * @param param String containing the parameter for this command.
     */
    public CommandFind(String command, String param) {
        super(command);
        this.parameters = param;
    }

    /**
     * Executes the command.
     *
     * @param list TaskList to find the tasks containing the parameter.
     * @param ui Ui to print the required text.
     * @param storage Storage to be used if required.
     * @return Execution result of the command as String.
     * @throws BlitzException If TaskList is empty or no matching item found.
     */
    @Override
    public String execute(TaskList list, Ui ui, Storage storage) throws BlitzException {
        ArrayList<Task> allTasks = list.getAllTask();
        TaskList matchedTasks = new TaskList(new ArrayList<>());

        for (Task task : allTasks) {
            if (task.convertTaskToString().contains((this.parameters))) {
                matchedTasks.addTask(task);
            }
        }

        if (matchedTasks.getSize() == 0) {
            throw new BlitzEmptyTaskListException();
        }

        return ui.getStringForTasksMatched(matchedTasks);
    }
}
