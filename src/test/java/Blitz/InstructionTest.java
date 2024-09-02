package blitz;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class InstructionTest {
    @Test
    public void checkIfGivenCommandExist_existingCommandInString_returnTrue() {
        assertTrue(Instruction.isCommandExist("bye"));
        assertTrue(Instruction.isCommandExist("todo"));
        assertTrue(Instruction.isCommandExist("deadline"));
        assertTrue(Instruction.isCommandExist("event"));
        assertTrue(Instruction.isCommandExist("list"));
        assertTrue(Instruction.isCommandExist("delete"));
        assertTrue(Instruction.isCommandExist("mark"));
        assertTrue(Instruction.isCommandExist("unmark"));
        assertTrue(Instruction.isCommandExist("find"));
    }

    @Test
    public void checkIfGivenCommandExist_nonexistingCommandInString_returnFalse() {
        assertFalse(Instruction.isCommandExist("gg"));
        assertFalse(Instruction.isCommandExist("how"));
        assertFalse(Instruction.isCommandExist("hello"));
        assertFalse(Instruction.isCommandExist("2103"));
        assertFalse(Instruction.isCommandExist("SWE"));
        assertFalse(Instruction.isCommandExist("help"));
        assertFalse(Instruction.isCommandExist("byee"));
        assertFalse(Instruction.isCommandExist("print"));
    }
}
