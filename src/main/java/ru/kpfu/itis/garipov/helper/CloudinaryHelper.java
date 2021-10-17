package ru.kpfu.itis.garipov.helper;

import com.cloudinary.*;

import java.util.HashMap;
import java.util.Map;

public class CloudinaryHelper {
    private static Cloudinary cloudinary;

    public static Cloudinary getInstance() {
        if (cloudinary == null){
            Map configMap = new HashMap();
            configMap.put("cloud_name", "dfn48aqa5");
            configMap.put("api_key", "334675987975825");
            configMap.put("api_secret", "rA8exNW4MRqxtVYevpgWMqoDHlU");
            cloudinary = new Cloudinary(configMap);
        }
        return cloudinary;
    }
}
