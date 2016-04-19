/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lt.vu.mif.labanorodraugai.Entities;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
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
@Table(name = "HOUSE")
@NamedQueries({
    @NamedQuery(name = "House.findAll", query = "SELECT h FROM House h"),
    @NamedQuery(name = "House.findById", query = "SELECT h FROM House h WHERE h.id = :id"),
    @NamedQuery(name = "House.findByName", query = "SELECT h FROM House h WHERE h.name = :name"),
    @NamedQuery(name = "House.findByPrice", query = "SELECT h FROM House h WHERE h.price = :price"),
    @NamedQuery(name = "House.findByBedCapacity", query = "SELECT h FROM House h WHERE h.bedCapacity = :bedCapacity"),
    @NamedQuery(name = "House.findByNumber", query = "SELECT h FROM House h WHERE h.number = :number")})
public class House implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NAME")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRICE")
    private int price;
    @Basic(optional = false)
    @NotNull
    @Column(name = "BED_CAPACITY")
    private int bedCapacity;
    @Column(name = "NUMBER")
    private Integer number;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "house")
    private List<Reservation> reservationList;

    public House() {
    }

    public House(Integer id) {
        this.id = id;
    }

    public House(Integer id, String name, int price, int bedCapacity) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.bedCapacity = bedCapacity;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getBedCapacity() {
        return bedCapacity;
    }

    public void setBedCapacity(int bedCapacity) {
        this.bedCapacity = bedCapacity;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.number);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final House other = (House) obj;
        return Objects.equals(this.number, other.number);
    }

    @Override
    public String toString() {
        return "Entities.House[ id=" + id + " ]";
    }
    
}
