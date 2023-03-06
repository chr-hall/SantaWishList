package com.example.WishlistSanta;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Long id;

    private String name;
    private String email;
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Wishes> wishes = new ArrayList<>();


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;

    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Wishes> getWishes() {
        return wishes;
    }

    public void setWishes(List<Wishes> wishes) {
        this.wishes = wishes;
    }

    public void addWish(Wishes wish) {
        this.wishes.add(wish);
    }
    public void deleteWish (int index) {
        this.wishes.remove(index);
    }




}
