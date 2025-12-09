package com.doku.my.trainingbesenangpay01.annotations.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.LinkedList;

/**
 * @author Daniel Joi Partogi Hutapea
 */
public class CrudRepositoryHandler implements InvocationHandler
{
    @Override
    public Object invoke(Object proxy, Method method, Object[] args)
    {
        var table = method.getDeclaringClass().getDeclaredAnnotation(Table.class);

        if(table == null)
        {
            throw new CrudRepositoryException("Table annotation is missing from '%s'.".formatted(proxy.getClass().getName()));
        }

        var tableName = table.value();
        var methodName = method.getName();
        var whereClauses = methodName.replace("findBy", "").split("And");

        var listOfWhereClauses = new LinkedList<String>();

        for(int i=0; i<whereClauses.length; i++)
        {
            listOfWhereClauses.add("%s = '%s'".formatted(whereClauses[i].toLowerCase(), args[i]));
        }

        var whereClausesCommand = String.join(" AND ", listOfWhereClauses);

        System.out.printf("SELECT * FROM %s WHERE %s%n", tableName, whereClausesCommand);

        return null;
    }

    @SuppressWarnings("unchecked")
    public static <T> T createProxy(Class<T> interfaceClass)
    {
        return (T) Proxy.newProxyInstance
        (
            CrudRepositoryHandler.class.getClassLoader(),
            new Class[] {interfaceClass},
            new CrudRepositoryHandler()
        );
    }
}
