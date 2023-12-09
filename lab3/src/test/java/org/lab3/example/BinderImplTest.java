package org.lab3.example;

import org.junit.Before;
import org.junit.Test;
import org.lab3.BinderImpl;


public class BinderImplTest {
    private BinderImpl binder;

    @Before
    public void setUp() {
        binder = new BinderImpl();
    }

    @Test(expected = IllegalStateException.class)
    public void shouldThrowIllegalStateException() {
        class TestClass {
            private TestClass(String str) {}
        }

        binder.get(TestClass.class);
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowIllegalAccessException() {
        class TestClass {
            private TestClass() {}
        }
        binder.bind(TestClass.class);
        binder.get(TestClass.class);
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowInvocationTargetExceptionOrInstantiationException() {
        class TestClass {
            TestClass() {
                throw new RuntimeException();
            }
        }
        binder.bind(TestClass.class);
        binder.get(TestClass.class);
    }
}