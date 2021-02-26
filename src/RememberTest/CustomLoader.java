package RememberTest;

import java.net.URL;
import java.net.URLClassLoader;

public class CustomLoader extends URLClassLoader {

    public CustomLoader(URL[] urls, ClassLoader parent) {
        super(urls, parent);
    }

    public final Class<?> loadClass(String name, boolean resolve)
            throws ClassNotFoundException
    {
        // First check if we have permission to access the package. This
        // should go away once we've added support for exported packages.
        SecurityManager sm = System.getSecurityManager();
        if (sm != null) {
            int i = name.lastIndexOf('.');
            if (i != -1) {
                sm.checkPackageAccess(name.substring(0, i));
            }
        }
        System.out.println("name"+ name);
        return super.loadClass(name, resolve);
    }
}