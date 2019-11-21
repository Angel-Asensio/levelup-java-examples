package com.levelup.java;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;

import java.util.Locale;

import org.hamcrest.core.IsSame;
import org.junit.Test;

public class LocaleConverter {

    @Test
    public void localeFromString() {
        Locale localeFromString = org.springframework.util.StringUtils.parseLocaleString("de");
        assertThat(Locale.GERMAN.getLanguage(), IsSame.sameInstance(localeFromString.getLanguage()));
    }

    @Test
    public void stringFromLocale() {
        assertThat("de", equalTo(Locale.GERMAN.toString()));
    }

}
