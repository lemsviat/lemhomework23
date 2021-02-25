package model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "customers")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "acc_id")
    private Account account;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Fetch(FetchMode.JOIN)
    @JoinColumn(name = "customer_id")
    private Set<Specialty> specialties;

    public Customer() {
    }

    public Customer(String name, Set<Specialty> specialties, Account account) {
        this.name = name;
        this.specialties = specialties;
        this.account = account;
    }

    public Customer(String name) {
        this.name = name;
    }

    public Customer(String name, Account account) {
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

    public Set<Specialty> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(Set<Specialty> specialties) {
        this.specialties = specialties;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Customer {" +
                "name='" + name + '\'' +
                ", specialties=" + specialties +
                ", account=" + account +
                '}';
    }
}
