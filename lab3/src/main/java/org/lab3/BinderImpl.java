package org.lab3;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class BinderImpl implements Binder {
    private final Map<Class<?>, Class<?>> classToImpl = new HashMap<>();
    private final Map<Class<?>, Object> classToInstance = new HashMap<>();

    @Override
    public <T> void bind(Class<T> clazz) {
        classToImpl.put(clazz, null);
    }

    @Override
    public <T> void bind(Class<T> clazz, Class<? extends T> implementation) {
        classToImpl.put(clazz, implementation);
    }

    @Override
    public <T> void bind(Class<T> clazz, T instance) {
        classToInstance.put(clazz, instance);
    }

    public <T> T get(Class<T> clazz) {
        Class<?> clazzImpl = classToImpl.get(clazz);
        if (clazzImpl != null) return (T) get(clazzImpl);

        if (clazz.isAnnotationPresent(Singleton.class) || classToInstance.containsKey(clazz)) {
            return (T) classToInstance.get(clazz);
        }
        try {
            Constructor<T>[] constructors = (Constructor<T>[]) clazz.getConstructors();

            for (var constructor : constructors) {
                if (constructor.getParameterCount() == 0 || constructor.isAnnotationPresent(Inject.class)) {
                    return createInstanceOfClass(constructor);
                }
            }
            throw new IllegalStateException();
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }

    private <T> T createInstanceOfClass(Constructor<T> constructor) throws InstantiationException, IllegalAccessException, InvocationTargetException {
        Class<?>[] parameterTypes = constructor.getParameterTypes();
        Object[] injected = new Object[parameterTypes.length];
        Arrays.setAll(injected, i -> get(parameterTypes[i]));
        return constructor.newInstance(injected);
    }

}