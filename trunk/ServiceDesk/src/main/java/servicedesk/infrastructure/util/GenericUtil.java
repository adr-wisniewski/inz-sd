/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servicedesk.infrastructure.util;

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
    
    public static <T> Class<?> getTypeArgument(Class<T> baseClass, Class<? extends T> childClass, int ordinal) {
        ParameterizedType type = getParameterizedType(baseClass, childClass);
        return resolveArgument(type, ordinal);
    }

    protected static <T> ParameterizedType getParameterizedType(Class<T> baseClass, Class<? extends T> childClass) {

        if(logger.isDebugEnabled()) {
            logger.debug("finding ancestor " + baseClass + " of " + childClass );
        }

        return getParameterizedTypeRecurisive(baseClass, childClass);
    }
    
    protected static ParameterizedType getParameterizedTypeRecurisive(Class<?> target, Type type) {
        Type raw;
        
        if(type == null)
            return null;
        
        // check current type
        if(type instanceof ParameterizedType) {
            ParameterizedType parametrized = (ParameterizedType)type;
            
            raw = parametrized.getRawType();
            
            if(raw.equals(target))
                return parametrized;
            
        } else if(type instanceof Class) {
            raw = type;
        } else {
            return null;
        }
        
        // go deeper for classes
        if(raw instanceof Class) {
            Class<?> clazz = (Class<?>)raw;
            
            for(Type t: clazz.getGenericInterfaces()) {
                ParameterizedType parametrized = getParameterizedTypeRecurisive(target, t);
                if(parametrized != null)
                    return parametrized;
            }
            
            return getParameterizedTypeRecurisive(target, clazz.getGenericSuperclass());         
        } 
        
        return null;
    }

    /*public static Type getRaw(Type type) {

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
    }*/
    
    public static Class<?> resolveArgument(ParameterizedType type, int ordinal) {
        Type[] arguments = type.getActualTypeArguments();
        Type resultType = arguments[ordinal];
        
        if(logger.isDebugEnabled()) {
            logger.debug("Resolving type " + resultType );
        }
        
        if(resultType instanceof ParameterizedType) {
            ParameterizedType pt = (ParameterizedType)resultType;
            resultType = pt.getRawType();
        } 
        
        if(resultType instanceof Class) {
            Class<?> result = (Class<?>)resultType;
        
            if(logger.isDebugEnabled()) {
                logger.debug("Resolved to " + result );
            }

            return result;
        } 
        
        throw new IllegalArgumentException("Resolve argument error: Type " + resultType + " is not Class or ParametrizedType");
    }

    private GenericUtil() {
    }

}
