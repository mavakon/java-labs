package org.lab3.example;

import javax.inject.Inject;

public class UseA {
    private final A dependency;

    @Inject
    public UseA(A a) {
        this.dependency = a;
    }

    public A getDependency() {
        return dependency;
    }
}
