package org.lab3;

public class EnvironmentImpl implements Environment {

    private final BinderImpl binder;

    public EnvironmentImpl() {
        this.binder = new BinderImpl();
    }

    @Override
    public Container configure(Configuration configuration) {
        configuration.configure(binder);
        return new ContainerImpl(binder);
    }
}