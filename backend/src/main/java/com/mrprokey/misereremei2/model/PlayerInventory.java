package com.mrprokey.misereremei2.model;

import jakarta.persistence.*;

    @Entity
    @IdClass(PlayerInventoryId.class)
    public class PlayerInventory {

        @Id
        @ManyToOne
        @JoinColumn(name = "user_id", referencedColumnName = "id")
        private User user;

        @Id
        @ManyToOne
        @JoinColumn(name = "item_id", referencedColumnName = "id")
        private Item item;

        private int quantity;

        public User getPlayer() {
            return user;
        }

        public Item getItem() {
            return item;
        }

        public void setItem(Item item) {
            this.item = item;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public void setPlayer(User user) {
            this.user = user;
        }
    }
