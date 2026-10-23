package com.qianchang.ae2lt_api.internal.compat;

import static org.junit.jupiter.api.Assertions.assertSame;
import org.junit.jupiter.api.Test;

class AE2LTReflectionTest {
    private static final Object SERVICE = new Object();

    interface GridContract {
        default Object getStorageService() { return SERVICE; }
    }

    static final class InheritedGrid implements GridContract { }

    static final class InternalHost {
        private Object privateHook() { return SERVICE; }
    }

    @Test
    void resolvesInheritedInterfaceDefaultsAndCachesTheCorrectMethod() {
        var host = new InheritedGrid();
        assertSame(SERVICE, AE2LTReflection.invoke(host, "getStorageService", new Class<?>[0]));
        assertSame(SERVICE, AE2LTReflection.invoke(host, "getStorageService", new Class<?>[0]));
    }

    @Test
    void retainsAccessToInternalCompatibilityHooks() {
        assertSame(SERVICE, AE2LTReflection.invoke(new InternalHost(), "privateHook", new Class<?>[0]));
    }
}
