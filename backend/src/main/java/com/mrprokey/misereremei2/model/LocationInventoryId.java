package com.mrprokey.misereremei2.model;

import java.io.Serializable;
import java.util.Objects;

public class LocationInventoryId implements Serializable {

    private Long location;
    private Long item;

    public Long getLocation() {
        return location;
    }

    public void setLocation(Long location) {
        this.location = location;
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
        if (!(o instanceof LocationInventoryId)) return false;
        LocationInventoryId that = (LocationInventoryId) o;
        return Objects.equals(location, that.location) &&
                Objects.equals(item, that.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location, item);
    }
}
