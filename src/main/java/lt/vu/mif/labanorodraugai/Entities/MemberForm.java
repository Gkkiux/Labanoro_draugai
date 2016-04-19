/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.vu.mif.labanorodraugai.Entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 *
 * @author Sarunas
 */
@Entity
@Table(name = "MEMBER_FORM")
@NamedQueries({
    @NamedQuery(name = "MemberForm.findAll", query = "SELECT m FROM MemberForm m"),
    @NamedQuery(name = "MemberForm.findByMemberId", query = "SELECT m FROM MemberForm m WHERE m.memberFormPK.memberId = :memberId"),
    @NamedQuery(name = "MemberForm.findByFieldId", query = "SELECT m FROM MemberForm m WHERE m.memberFormPK.fieldId = :fieldId"),
    @NamedQuery(name = "MemberForm.findByFieldValue", query = "SELECT m FROM MemberForm m WHERE m.fieldValue = :fieldValue")})
public class MemberForm implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected MemberFormPK memberFormPK;
    @Size(max = 50)
    @Column(name = "FIELD_VALUE")
    private String fieldValue;
    @JoinColumn(name = "MEMBER_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Member member1;
    @JoinColumn(name = "FIELD_ID", referencedColumnName = "ID", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private MemberFormConfig memberFormConfig;

    public MemberForm() {
    }

    public MemberForm(MemberFormPK memberFormPK) {
        this.memberFormPK = memberFormPK;
    }

    public MemberForm(int memberId, int fieldId) {
        this.memberFormPK = new MemberFormPK(memberId, fieldId);
    }

    public MemberFormPK getMemberFormPK() {
        return memberFormPK;
    }

    public void setMemberFormPK(MemberFormPK memberFormPK) {
        this.memberFormPK = memberFormPK;
    }

    public String getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }

    public Member getMember1() {
        return member1;
    }

    public void setMember1(Member member1) {
        this.member1 = member1;
    }

    public MemberFormConfig getMemberFormConfig() {
        return memberFormConfig;
    }

    public void setMemberFormConfig(MemberFormConfig memberFormConfig) {
        this.memberFormConfig = memberFormConfig;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (memberFormPK != null ? memberFormPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MemberForm)) {
            return false;
        }
        MemberForm other = (MemberForm) object;
        if ((this.memberFormPK == null && other.memberFormPK != null) || (this.memberFormPK != null && !this.memberFormPK.equals(other.memberFormPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entities.MemberForm[ memberFormPK=" + memberFormPK + " ]";
    }
    
}
