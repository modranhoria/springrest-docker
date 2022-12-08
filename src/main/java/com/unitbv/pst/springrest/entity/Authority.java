package com.unitbv.pst.springrest.entity;

import javax.persistence.*;

@Entity
@Table(name = "authorities")
@SequenceGenerator(name = "authority_seq", initialValue = 1, allocationSize = 100)
public class Authority {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "authority_seq")
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "username", referencedColumnName = "username")
    private User user;

    @Column(name = "authority")
    private String authority;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getAuthority() {
        return authority;
    }

    public void setAuthority(String authority) {
        this.authority = authority;
    }
}
