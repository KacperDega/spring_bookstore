package com.example.springprojekt.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CartItem> items = new ArrayList<>();
    @OneToOne(mappedBy = "cart")
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<CartItem> getItems() {
        return items;
    }

    public void setItems(List<CartItem> items) {
        this.items = items;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void addItem(Book book, int quantity) {
        for (CartItem item : this.items) {
            if (item.getBook().getId() == book.getId()) {
                item.setQuantity(item.getQuantity() + quantity);
                return;
            }
        }
        this.items.add(new CartItem(this, book, quantity));
    }

    public void removeItem(Book book) {
        for (CartItem item : this.items) {
            if (item.getBook().getId() == book.getId()) {
                if (item.getQuantity() < 2) {
                    this.items.remove(item);
                    return;
                } else {
                    item.setQuantity(item.getQuantity() - 1);
                }
            }
        }
    }
}
