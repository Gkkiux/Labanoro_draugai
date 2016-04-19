/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.vu.mif.labanorodraugai.Entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Sarunas
 */
@Entity
@Table(name = "MEMBER_FORM_CONFIG")
@NamedQueries({
    @NamedQuery(name = "MemberFormConfig.findAll", query = "SELECT m FROM MemberFormConfig m"),
    @NamedQuery(name = "MemberFormConfig.findById", query = "SELECT m FROM MemberFormConfig m WHERE m.id = :id"),
    @NamedQuery(name = "MemberFormConfig.findByTitle", query = "SELECT m FROM MemberFormConfig m WHERE m.title = :title")})
public class MemberFormConfig implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "TITLE")
    private String title;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "memberFormConfig")
    private List<MemberForm> memberFormList;

    public MemberFormConfig() {
    }

    public MemberFormConfig(Integer id) {
        this.id = id;
    }

    public MemberFormConfig(Integer id, String title) {
        this.id = id;
        this.title = title;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<MemberForm> getMemberFormList() {
        return memberFormList;
    }

    public void setMemberFormList(List<MemberForm> memberFormList) {
        this.memberFormList = memberFormList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MemberFormConfig)) {
            return false;
        }
        MemberFormConfig other = (MemberFormConfig) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.MemberFormConfig[ id=" + id + " ]";
    }
    
}
