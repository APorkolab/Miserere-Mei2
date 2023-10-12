package com.mrprokey.misereremei2.model;

import java.io.Serializable;
import java.util.Objects;

public class PlayerInventoryId implements Serializable {

    private Long player;
    private Long item;

    public Long getPlayer() {
        return player;
    }

    public void setPlayer(Long player) {
        this.player = player;
    }

    public Long getItem() {
        return item;
    }

    public void setItem(Long item) {
        this.item = item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PlayerInventoryId)) return false;
        PlayerInventoryId that = (PlayerInventoryId) o;
        return Objects.equals(player, that.player) &&
                Objects.equals(item, that.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(player, item);
    }
}
