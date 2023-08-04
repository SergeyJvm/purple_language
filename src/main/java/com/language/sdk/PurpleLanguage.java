package com.language.sdk;

import com.intellij.lang.Language;

public class PurpleLanguage extends Language {

    public static final PurpleLanguage INSTANCE = new PurpleLanguage();

    private PurpleLanguage() {
        super("Purple");
    }

}
