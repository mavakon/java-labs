package org.lab3.example;

import org.lab3.Container;

public class DummyContainer implements Container {
    @Override
    public <T> T getComponent(Class<T> clazz) {
        if (clazz.equals(A.class)) {
            return (T) new A();
        }
        if (clazz.equals(B.class)) {
            return (T) new B();
        }
        return null;
    }
}
