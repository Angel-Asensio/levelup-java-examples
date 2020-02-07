package com.levelup.java.i18n;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.springframework.util.StringUtils.parseLocaleString;

import java.util.Locale;

import org.hamcrest.core.IsSame;
import org.junit.Test;

public class I18nUtils {

    @Test
    public void localeFromString() {
        Locale localeFromString = parseLocaleString("de");
        assertThat(Locale.GERMAN.getLanguage(), IsSame.sameInstance(localeFromString.getLanguage()));
    }

    @Test
    public void stringFromLocale() {
        assertThat("de", equalTo(Locale.GERMAN.toString()));
    }

}
