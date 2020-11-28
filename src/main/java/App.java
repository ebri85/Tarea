import com.rest.Recetas;

import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;
public class App extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        HashSet<Class<?>> classes = new HashSet<Class<?>>();
        classes.add(com.rest.Recetas.class);

        return classes;
    }
}