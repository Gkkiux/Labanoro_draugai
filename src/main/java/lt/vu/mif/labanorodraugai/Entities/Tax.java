/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.vu.mif.labanorodraugai.Entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Sarunas
 */
@Entity
@Table(name = "TAX")
@NamedQueries({
    @NamedQuery(name = "Tax.findAll", query = "SELECT t FROM Tax t"),
    @NamedQuery(name = "Tax.findByMemberId", query = "SELECT t FROM Tax t WHERE t.taxPK.memberId = :memberId"),
    @NamedQuery(name = "Tax.findByTax", query = "SELECT t FROM Tax t WHERE t.tax = :tax"),
    @NamedQuery(name = "Tax.findByDateFrom", query = "SELECT t FROM Tax t WHERE t.taxPK.dateFrom = :dateFrom"),
    @NamedQuery(name = "Tax.findByDateTo", query = "SELECT t FROM Tax t WHERE t.taxPK.dateTo = :dateTo")})
public class Tax implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TaxPK taxPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TAX")
    private int tax;
    @JoinColumn(name = "MEMBER_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Member member1;

    public Tax() {
    }

    public Tax(TaxPK taxPK) {
        this.taxPK = taxPK;
    }

    public Tax(TaxPK taxPK, int tax) {
        this.taxPK = taxPK;
        this.tax = tax;
    }

    public Tax(int memberId, Date dateFrom, Date dateTo) {
        this.taxPK = new TaxPK(memberId, dateFrom, dateTo);
    }

    public TaxPK getTaxPK() {
        return taxPK;
    }

    public void setTaxPK(TaxPK taxPK) {
        this.taxPK = taxPK;
    }

    public int getTax() {
        return tax;
    }

    public void setTax(int tax) {
        this.tax = tax;
    }

    public Member getMember1() {
        return member1;
    }

    public void setMember1(Member member1) {
        this.member1 = member1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (taxPK != null ? taxPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tax)) {
            return false;
        }
        Tax other = (Tax) object;
        if ((this.taxPK == null && other.taxPK != null) || (this.taxPK != null && !this.taxPK.equals(other.taxPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.Tax[ taxPK=" + taxPK + " ]";
    }
    
}
