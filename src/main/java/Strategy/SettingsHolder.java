package Strategy;

import java.util.HashMap;
import java.util.Map;

public class SettingsHolder {
    private static SettingsHolder instance = null;
    private Map<String, String> settings;


    private SettingsHolder() {
        settings = new HashMap<>();
        settings.put("txtExportPath", "studenti_export.txt");
        settings.put("xlsxExportPath", "studenti_export.xlsx");
    }


    public static SettingsHolder getInstance() {
        if (instance == null) {
            instance = new SettingsHolder();
        }
        return instance;
    }

    public String getSetting(String key) {
        return settings.get(key);
    }
}
