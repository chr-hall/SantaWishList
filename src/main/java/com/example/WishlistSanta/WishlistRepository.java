package com.example.WishlistSanta;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class WishlistRepository {
    ArrayList<User> lists;


    public WishlistRepository() {
        lists = new ArrayList<>();
        lists = wishGenerator();
        for (User wish : lists) {
            System.out.println("\nNamn: " + wish.getName() + "\nE-post: " + wish.getEmail() + "\nWishes: " + wish.getWishes());
        }
    }

    public ArrayList<User> getlists() {
        return lists;
    }

    public void addList(User wishlist) {
        lists.add(wishlist);
    }

    public ArrayList<User> wishGenerator() {

        //Arrays of names and possible wishes
        String[] names = new String[]{"Nils", "Erik", "Maja", "Max", "Elin"};
        String[] wishesArr = new String[]{"Nintendo Switch", "Pony", "Lego", "Gitarr", "Fotbollsskor", "Cykel", "Radiostyrd bil", "Skateboard",
                "Karaokemaskin", "Minecraft", "Målarbok", "Elsparkcykel", "Målarpennor", "Spider-man", "Frozen", "Pussel"};

        // List of numbers used to generate wishlists
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < wishesArr.length; i++) {
            numbers.add(i);
        }

        // Generate one wishlist per user and store in object
        for (int i = 0; i < names.length; i++) {
            ArrayList<String> wishes = new ArrayList<>();     // List to store wishes
            Collections.shuffle(numbers);   // Shuffle numbers to pick random wishes for each user

            User user = new User(names[i], names[i].toLowerCase() + "@epost.se");

            for (int j = 0; j < 5; j++) {
                Wishes wish = new Wishes();
                wish.setUser(user);
                wish.setWish(wishesArr[numbers.get(j)]);
                user.addWish(wish);

                wishes.add(wishesArr[numbers.get(j)]); // Get wish at (random) number and add to list
            }
            lists.add(user);    // Create object and add to lists array
        }

        return lists;
    }
    public User getWishList(String email) {
        for (User book : lists) {
            if (Objects.equals(book.getEmail(), email)) {
                return book;
            }
        }
        return null;
    }

}
