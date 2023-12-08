package org.lab3;

public interface Container {
    <T> T getComponent(Class<T> clazz);
}
