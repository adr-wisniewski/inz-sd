/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sd.infrastructure.util;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
/**
 *
 * @author Adrian
 */
public abstract class GenericUtil {

    protected final static Log logger = LogFactory.getLog(GenericUtil.class);

    public static <T> Type getTypeArgument(Class<T> baseClass, Class<? extends T> childClass, int ordinal) {
        Type type = getType(baseClass, childClass);
        Type[] arguments = ((ParameterizedType)type).getActualTypeArguments();

        if(logger.isDebugEnabled()) {
            logger.debug("type resolved to " + arguments[ordinal] );
        }

        return arguments[ordinal];
    }

    protected static <T> Type getType(Class<T> baseClass, Class<? extends T> childClass) {

        if(logger.isDebugEnabled()) {
            logger.debug("finding subclass " + baseClass + " of " + childClass );
        }

        // navigate to specified base
        Type type = childClass;
        Type raw = getRaw(childClass);
        while(!raw.equals(baseClass)) {
            type = ((Class)raw).getGenericSuperclass();
            raw = getRaw(type);
        }

        return type;
    }

    public static Type getRaw(Type type) {

        if(logger.isDebugEnabled()) {
            logger.debug("getting raw type from " + type );
        }

        if (type instanceof Class) {
            return type;
        } else if (type instanceof ParameterizedType) {
            return ((ParameterizedType)type).getRawType();
        } else {
            throw new IllegalArgumentException("Type " + type + " is not Class or ParametrizedType");
        }
    }

}
