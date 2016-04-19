/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.vu.mif.labanorodraugai.Entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Sarunas
 */
@Entity
@Table(name = "GLOBAL_SETTINGS")
@NamedQueries({
    @NamedQuery(name = "GlobalSettings.findAll", query = "SELECT g FROM GlobalSettings g"),
    @NamedQuery(name = "GlobalSettings.findByMembers", query = "SELECT g FROM GlobalSettings g WHERE g.members = :members"),
    @NamedQuery(name = "GlobalSettings.findByTaxSize", query = "SELECT g FROM GlobalSettings g WHERE g.taxSize = :taxSize"),
    @NamedQuery(name = "GlobalSettings.findByGroups", query = "SELECT g FROM GlobalSettings g WHERE g.groups = :groups"),
    @NamedQuery(name = "GlobalSettings.findByConfirmations", query = "SELECT g FROM GlobalSettings g WHERE g.confirmations = :confirmations"),
    @NamedQuery(name = "GlobalSettings.findByRequestExpiringDays", query = "SELECT g FROM GlobalSettings g WHERE g.requestExpiringDays = :requestExpiringDays"),
    @NamedQuery(name = "GlobalSettings.findById", query = "SELECT g FROM GlobalSettings g WHERE g.id = :id")})
public class GlobalSettings implements Serializable {

    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "MEMBERS")
    private int members;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TAX_SIZE")
    private int taxSize;
    @Basic(optional = false)
    @NotNull
    @Column(name = "GROUPS")
    private int groups;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CONFIRMATIONS")
    private int confirmations;
    @Basic(optional = false)
    @NotNull
    @Column(name = "REQUEST_EXPIRING_DAYS")
    private int requestExpiringDays;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;

    public GlobalSettings() {
    }

    public GlobalSettings(Integer id) {
        this.id = id;
    }

    public GlobalSettings(Integer id, int members, int taxSize, int groups, int confirmations, int requestExpiringDays) {
        this.id = id;
        this.members = members;
        this.taxSize = taxSize;
        this.groups = groups;
        this.confirmations = confirmations;
        this.requestExpiringDays = requestExpiringDays;
    }

    public int getMembers() {
        return members;
    }

    public void setMembers(int members) {
        this.members = members;
    }

    public int getTaxSize() {
        return taxSize;
    }

    public void setTaxSize(int taxSize) {
        this.taxSize = taxSize;
    }

    public int getGroups() {
        return groups;
    }

    public void setGroups(int groups) {
        this.groups = groups;
    }

    public int getConfirmations() {
        return confirmations;
    }

    public void setConfirmations(int confirmations) {
        this.confirmations = confirmations;
    }

    public int getRequestExpiringDays() {
        return requestExpiringDays;
    }

    public void setRequestExpiringDays(int requestExpiringDays) {
        this.requestExpiringDays = requestExpiringDays;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
        if (!(object instanceof GlobalSettings)) {
            return false;
        }
        GlobalSettings other = (GlobalSettings) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.GlobalSettings[ id=" + id + " ]";
    }
    
}
