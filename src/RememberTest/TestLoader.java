package RememberTest;
import sun.misc.Launcher;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;


public class TestLoader{
    public static void main(String[] args) throws ClassNotFoundException, MalformedURLException {
        String classPath = System.getProperty("java.class.path");
        for (String path : classPath.split(";")) {
            System.out.println(path);
        }
        ClassLoader launcherClassLoader = Launcher.class.getClassLoader();
//        Class<Launcher> sh = Launcher.class;
//        sh.getClassLoader();
//
//        Launcher launcher = Launcher.getLauncher();
//        System.out.println(launcher.getClassLoader());
//        URLClassLoader loader_1 =
//                new URLClassLoader(new URL[]{new File("/home/mayansong/eclipse-workspace/Algorithm/").toURI().toURL()});
//
//        URLClassLoader loader_2 =
//                new URLClassLoader(new URL[]{new File("/home/mayansong/eclipse-workspace/Algorithm/").toURI().toURL()});
//        System.out.println(loader_1.getParent()==loader_2.getParent());
//        System.out.println(loader_1.getParent());
//        Class<?> clazz_1 = loader_1.loadClass("RememberTest.Test");
//        Class<?> clazz_2 = loader_2.loadClass("RememberTest.Test");
//        System.out.println(clazz_1.getClassLoader()==clazz_2.getClassLoader());
////        System.out.println(clazz_2.getParent()==loader_2.getParent());
//        CustomLoader customLoader = new CustomLoader(new URL[]{new File("/home/mayansong/eclipse-workspace/Algorithm/bin/").toURI().toURL()}, null);
//        System.out.println(customLoader.getParent());



        URLClassLoader loader_1 =
                new URLClassLoader(new URL[]{new File("/home/mayansong/java_test").toURI().toURL()});

        URLClassLoader loader_2 =
                new URLClassLoader(new URL[]{new File("/home/mayansong/java_test").toURI().toURL()});
        Class<?> clazz_1 = loader_1.loadClass("JavaTest");
        Class<?> clazz_2 = loader_2.loadClass("JavaTest");
        System.out.println(clazz_1.getClassLoader()==clazz_2.getClassLoader());
        System.out.println(clazz_1==clazz_2);

    }
}