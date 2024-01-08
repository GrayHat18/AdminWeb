package utility;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class ContextDao {

    private static final Map<Class<?>, Object> daoInstances = new HashMap<>();

    public static <T> T getDao(Class<T> daoInterface) throws InstantiationException, IllegalAccessException, IllegalAccessException, InvocationTargetException, InvocationTargetException {
        try {
            T daoInstance = (T) daoInstances.get(daoInterface);

            if (daoInstance == null) {
                //Getting the class name of implementation from interface
                String implementationClassName = obtenerNombreClaseImplementacion(daoInterface);

                //If the instance not in the context, we create and store it
                Class<?> implementationClass = Class.forName(implementationClassName);

                daoInstance = (T) createDaoInstance(implementationClass);
                daoInstances.put(daoInterface, daoInstance);
            }

            return daoInstance;
        } catch (ClassNotFoundException | IllegalArgumentException e) {
            e.printStackTrace(System.out);
            throw new RuntimeException("Error al crear la instancia del Dao: " + daoInstances.getClass());
        }
    }

    private static <T> T createDaoInstance(Class<T> daoInterface) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        try {
            String implementationName = daoInterface.getName();

            //Getting the class name of implementation
            Class<?> implementationClass = Class.forName(implementationName);

            //We use reflection to obtain the no-argument constructor of the "Dao class"
            Constructor<?> constructor = implementationClass.getDeclaredConstructor();

            //We make the constructor accessible (if it is private)
            constructor.setAccessible(true);

            //We create the instance using the constructor without arguments
            T daoInstance = (T) constructor.newInstance();

            return daoInstance;
        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException e) {
            e.printStackTrace(System.out);
            throw new RuntimeException("Error al crear la instancia del Dao: " + e.getMessage());
        }
    }

    private static String obtenerNombreClaseImplementacion(Class<?> daoInterface) {
        //Gettint the interface name
        String interfaceName = daoInterface.getName();

        //We replace "service." with "repository." to get the name of the implementation class
        return interfaceName.replace("service.", "repository.") + "Impl";
    }
}
