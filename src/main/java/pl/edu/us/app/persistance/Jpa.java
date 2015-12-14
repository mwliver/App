package pl.edu.us.app.persistance;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Root;

public class Jpa {
    public static <T> Path<T> nestedPath(Root<?> root, String property) {
        Path<?> nestedRoot = root;
        for (String pathSegment : property.split("\\.")) {
            nestedRoot = nestedRoot.get(pathSegment);
        }
        return (Path<T>) nestedRoot;
    }
}
