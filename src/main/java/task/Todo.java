package task;

/**
 * Represents a to-do task.
 */
public class Todo extends Task {
    private String type;

    /**
     * Constructs a new Todo object with specified description, type and isDone.
     *
     * @param description String description of this Todo object.
     * @param type Type of this Todo object.
     * @param isDone Boolean indicating the (Todo) task is done or not.
     */
    public Todo(String description, String type, boolean isDone) {
        super(description, isDone);
        this.type = type;
    }

    /**
     * Converts this object to String representation (different format with toString()).
     *
     * @return String representation of this Todo object.
     */
    @Override
    public String convertTaskToString() {
        return this.type + "::" + super.isDone() + "::" + super.getDescription();
    }

    /**
     * Returns the type of this Todo object.
     *
     * @return String representation of the type of this Todo object.
     */
    @Override
    public String getType() {
        return this.type;
    }

    @Override
    public boolean isEqualWithoutStatus(Task task) {
        if (this == task) {
            return true;
        }

        if (task == null || getClass() != task.getClass()) {
            return false;
        }

        Todo todo = (Todo) task;
        boolean isTypeSame = this.type.equals(todo.type);
        boolean isDescriptionSame = super.getDescription().equals(todo.getDescription());

        return isTypeSame && isDescriptionSame;
    }

    /**
     * Compares two Todo objects and determines if they are equal.
     *
     * @param o Object to be compared.
     * @return True if both objects are of same reference or all attributes
     *     in both objects are the same, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Todo todo = (Todo) o;
        boolean isStatusSame = super.isDone() == todo.isDone();

        return isEqualWithoutStatus(todo) && isStatusSame;
    }
}
