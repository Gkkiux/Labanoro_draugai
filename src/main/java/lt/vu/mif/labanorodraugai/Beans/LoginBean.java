/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.vu.mif.labanorodraugai.Beans;

import lt.vu.mif.labanorodraugai.Entities.Member;
import java.util.Collection;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.transaction.UserTransaction;

/**
 *
 * @author Gkkiux
 */
@Stateful
@Named
@SessionScoped  

public class LoginBean {
    private String username;
    private String password;
    private Member member;
    
    @PersistenceContext
    EntityManager em;

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }
  public String getUsername() {
    return this.username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
 
  public String sayHi() {
      if (this.member == null) {
          if (this.username == null)
              this.username = "";
          if (this.password == null)
              this.password = "";
          return ("neprisijungęs: " + this.username + "/" + Integer.toString(this.password.hashCode()));
      } else {
          return "'sup " + Integer.toString(this.member.getId());
      }
  }


  public String login () {
    UserTransaction utx;    
    //initialization of entity manager..
//    utx.begin();
//    YourEntity entity = new YourEntity(); //your @Entity annotated class
//    entity.setSomeParam(someValue);
//    em.persist(entity);
//    utx.commit();

    Query queryMemberLogin = em.createNamedQuery("Member.findByLoginPassword");
    queryMemberLogin.setParameter("email", this.username);    
    queryMemberLogin.setParameter("password", Integer.toString(this.password.hashCode()));
    Collection members = queryMemberLogin.getResultList();
    if (!members.isEmpty()) {
        this.member = (Member)members.toArray()[0];
        return "index.html";
    } else {
        this.member = null;        
        System.out.println("Login failed with " + this.username + "/" + Integer.toString(this.password.hashCode()));
        return "login.html";
    }    
  }

  public String logout() {
    this.member = null;
        return "login.html";
  }
}
