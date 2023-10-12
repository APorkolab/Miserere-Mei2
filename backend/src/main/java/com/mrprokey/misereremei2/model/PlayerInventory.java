package com.mrprokey.misereremei2.model;

import javax.persistence.*;

@Entity
public class PlayerInventory {

    @Entity
    @IdClass(PlayerInventoryId.class)
    public class PlayerInventory {

        @Id
        @ManyToOne
        @JoinColumn(name = "player_id", referencedColumnName = "id")
        private Player player;

        @Id
        @ManyToOne
        @JoinColumn(name = "item_id", referencedColumnName = "id")
        private Item item;

        private int quantity;

    public Player getPlayer() {
        return player;
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

        public void setPlayer(Player player) {
        this.player = player;
    }
}
