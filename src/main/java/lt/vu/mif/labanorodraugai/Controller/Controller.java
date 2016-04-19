/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.vu.mif.labanorodraugai.Controller;

import lt.vu.mif.labanorodraugai.Entities.Member;
import lt.vu.mif.labanorodraugai.Commands.CommandHandler;
import lt.vu.mif.labanorodraugai.Commands.Membership.PayMembership;

/**
 *
 * @author Dove
 */
public class Controller {
    CommandHandler commandHandler;	
    public Controller(CommandHandler commandHandler) {
	this.commandHandler = commandHandler;
	
}
    public void payMembership(int amount, Member member)
    {
        commandHandler.invoke(new PayMembership(amount, member));
    }
    //cia aprasomi veiksmu metodai, kuriuose iskvieciamas commandhandler
}
