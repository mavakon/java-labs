package org.lab3;

public class ContainerImpl implements Container {

    private final BinderImpl binder;

    public ContainerImpl(BinderImpl binder) {
        this.binder = binder;
    }

    @Override
    public <T> T getComponent(Class<T> clazz) {
        return this.binder.get(clazz);
    }
}