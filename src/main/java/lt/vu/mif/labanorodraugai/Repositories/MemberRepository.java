/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.vu.mif.labanorodraugai.Repositories;

import lt.vu.mif.labanorodraugai.Entities.Member;
import static java.util.Collections.list;
import java.util.List;
import javax.ejb.Stateless;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Sarunas
 */
@Named
@RequestScoped
public class MemberRepository {

    @PersistenceContext
    private EntityManager em;

    public List<Member> getAllMembers() {
        Query query = em.createNamedQuery("Member.findAll");
        return query.getResultList();
    }
}
