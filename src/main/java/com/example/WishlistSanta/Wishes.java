package com.example.WishlistSanta;

import javax.persistence.*;

@Entity
public class Wishes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Id", nullable = false)
    private Long id;

    private  String wish;
    @ManyToOne
    @JoinColumn(name="user_Id")
    private User user;

    public Wishes(String wish, int i) {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Wishes() {
    }

    public String getWish() {
        return wish;
    }

    public void setWish(String wish) {
        this.wish = wish;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return wish;
    }
}
