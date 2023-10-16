package com.mrprokey.misereremei2.model;

import java.io.Serializable;
import java.util.Objects;

public class PlayerInventoryId implements Serializable {
    private User user;
    private Item item;

    public PlayerInventoryId() {}

    public PlayerInventoryId(User user, Item item) {
        this.user = user;
        this.item = item;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlayerInventoryId that = (PlayerInventoryId) o;
        return Objects.equals(user, that.user) && Objects.equals(item, that.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, item);
    }
}
