package org.MustacheTeam.MagicTrade.corelogics.models;

import org.springframework.security.core.GrantedAuthority;

import java.util.Iterator;

public record Collection(
       Long userId,
       String cardId,
       String lang,
       String state
) implements java.util.Collection<GrantedAuthority> {
    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<GrantedAuthority> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(GrantedAuthority grantedAuthority) {
        return false;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(java.util.Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(java.util.Collection<? extends GrantedAuthority> c) {
        return false;
    }

    @Override
    public boolean removeAll(java.util.Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(java.util.Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }
}
