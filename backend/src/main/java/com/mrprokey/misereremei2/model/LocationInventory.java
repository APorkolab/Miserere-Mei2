package com.mrprokey.misereremei2.model;

import jakarta.persistence.*;

@Entity
@IdClass(LocationInventoryId.class)
public class LocationInventory {

    @Id
    @ManyToOne
    @JoinColumn(name = "location_id", referencedColumnName = "id")
    private Location location;

    @Id
    @ManyToOne
    @JoinColumn(name = "item_id", referencedColumnName = "id")
    private Item item;

    private int quantity;

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Item getItem() {
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
