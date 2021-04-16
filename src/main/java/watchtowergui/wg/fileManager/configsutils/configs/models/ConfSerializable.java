package watchtowergui.wg.fileManager.configsutils.configs.models;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE})
@Retention(RetentionPolicy.SOURCE)
public @interface ConfSerializable {

    @Target({ElementType.ANNOTATION_TYPE, ElementType.TYPE})
    @Retention(RetentionPolicy.SOURCE)
    @interface List{
         ConfSerializable[] value();
    }
}
