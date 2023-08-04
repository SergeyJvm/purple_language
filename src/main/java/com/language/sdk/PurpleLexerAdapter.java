package com.language.sdk;

import com.intellij.lexer.FlexAdapter;

public class PurpleLexerAdapter extends FlexAdapter {

    public PurpleLexerAdapter() {
        super(new PurpleLexer(null));
    }
}
