/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.vu.mif.labanorodraugai.Commands;

import java.util.Stack;

/**
 *
 * @author Dove
 */
public class CommandHandler {
    public Stack<Command> commands = new Stack<>();

    public void invoke(Command command) {
        command.execute();
        commands.push(command);
    }
    
    
}
