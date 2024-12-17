package com.example.stockmanagement.productservice.exception.utils;

import com.example.stockmanagement.productservice.enums.Language;
import com.example.stockmanagement.productservice.exception.enums.IFrinedlyMessageCode;
import lombok.experimental.UtilityClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

@UtilityClass
public class FrinedlyMessageUtils {

    private static final String RESOURCE_BUNDLE_NAME = "FrinedlyMessage";
    private static final String SPECIAL_CHARACTER = "__";
    private static final Logger log = LoggerFactory.getLogger(FrinedlyMessageUtils.class);

    public static String getFriendlyMessage(Language language, IFrinedlyMessageCode messageCode) {
        String message = null;
        try {
            Locale locale = new Locale(language.name());
            ResourceBundle resourceBundle = ResourceBundle.getBundle(RESOURCE_BUNDLE_NAME, locale);
            message = messageCode.getClass().getSimpleName() + SPECIAL_CHARACTER + messageCode;
            return resourceBundle.getString(message);
        } catch (MissingResourceException e) {
            log.error("Friendly message not found for key: {}", message);
            return null;
        }
    }
}
