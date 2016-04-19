/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.vu.mif.labanorodraugai.Commands.Membership;

import lt.vu.mif.labanorodraugai.Entities.Member;
import lt.vu.mif.labanorodraugai.Commands.Command;

/**
 *
 * @author Dove
 */
public class PayMembership implements Command {

    int amount;
    Member member;

    public PayMembership(int amount, Member member) {
        this.amount = amount;
        this.member = member;
    }

    @Override
    public void execute() {
        
    }

}
