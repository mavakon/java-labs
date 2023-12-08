package org.lab3.example;

import org.lab3.Configuration;
import org.lab3.Container;
import org.lab3.Environment;

public class DummyEnvironment implements Environment {

    @Override
    public Container configure(Configuration configuration) {
        return new DummyContainer();
    }
}
