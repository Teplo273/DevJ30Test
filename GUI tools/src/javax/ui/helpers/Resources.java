package javax.ui.helpers;

import java.util.ResourceBundle;

public final class Resources {
    
    private static ResourceBundle strings;
    
    private Resources() {}
    
    public static void loadStringResource(String path) {
        strings = ResourceBundle.getBundle(path);
    }
    
    public static String stringResource(String name) {
        return strings != null ? strings.getString(name) : null;
    }
    
}
