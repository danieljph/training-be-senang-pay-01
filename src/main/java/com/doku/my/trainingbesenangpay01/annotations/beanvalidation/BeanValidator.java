package com.doku.my.trainingbesenangpay01.annotations.beanvalidation;

/**
 * @author Daniel Joi Partogi Hutapea
 */
public class BeanValidator
{
    public void validate(Object bean)
    {
        try
        {
            var fields = bean.getClass().getDeclaredFields();

            for(var field : fields)
            {
                field.setAccessible(true);
                var fieldValue = field.get(bean);

                if(fieldValue == null)
                {
                    continue;
                }

                if(fieldValue instanceof String stringValue)
                {
                    var size = field.getAnnotation(Length.class);

                    if(size == null)
                    {
                        continue;
                    }

                    if(stringValue.length() > size.max())
                    {
                        throw new BeanValidationException("Field '%s' length must be equal or lower than %d characters.".formatted(field.getName(), size.max()));
                    }

                    if(stringValue.length() < size.min())
                    {
                        throw new BeanValidationException("Field '%s' length must be equal or greater than %d characters.".formatted(field.getName(), size.min()));
                    }
                }
            }
        }
        catch(BeanValidationException ex)
        {
            throw ex;
        }
        catch(Exception ex)
        {
            throw new RuntimeException("Bean validation failed.", ex);
        }
    }
}
