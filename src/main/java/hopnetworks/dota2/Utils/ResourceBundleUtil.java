package hopnetworks.dota2.Utils;

import java.util.ResourceBundle;

/**
 * <P>Title: ppoiq</P>
 * <P>Description: 配置文件读取工具类</P>

 */
public class ResourceBundleUtil {
    //读取system配置文件中的值
    private final static ResourceBundle system = ResourceBundle.getBundle("system");

    public static String getSystemString(String key){
        return system.getString(key);
    }

    public static int getSystemInt(String key){
        return Integer.valueOf(system.getString(key));
    }


    public static long getSystemLong(String key){
        return Long.valueOf(system.getString(key));
    }

    public static String[] getSystemStringArray(String key){
        return system.getString(key).split(",");
    }
}
