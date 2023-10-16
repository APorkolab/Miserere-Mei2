package com.mrprokey.misereremei2.model;

import lombok.Getter;

import java.io.Serializable;
import java.util.Objects;

@Getter
public class LocationInventoryId implements Serializable {

    private Long location;
    private Long item;

    public void setLocation(Long location) {
        this.location = location;
    }

    public void setItem(Long item) {
        this.item = item;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LocationInventoryId that)) return false;
        return Objects.equals(location, that.location) &&
                Objects.equals(item, that.item);
    }

    @Override
    public int hashCode() {
        return Objects.hash(location, item);
    }
}
