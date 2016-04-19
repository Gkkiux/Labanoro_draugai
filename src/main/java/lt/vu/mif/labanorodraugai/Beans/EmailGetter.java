/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.vu.mif.labanorodraugai.Beans;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Sarunas
 */
@Named
@SessionScoped
@Stateful
public class EmailGetter {

    @Inject
    private EmailSender emailSender;

    List<String> emails;

    private String email;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    @PostConstruct
    public void initilize() {
        emails = new ArrayList<>();
    }

    //public void addRecipient(String email) {
        //emails.add(email);
    //}

    public void sendToRecipient() {
        emails.add(email);
        emailSender.setEmailTo(emails);
        emailSender.sendEmail();
        emails.clear();
    }
}
