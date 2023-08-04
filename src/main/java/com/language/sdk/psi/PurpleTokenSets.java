package com.language.sdk.psi;

import com.intellij.psi.tree.TokenSet;

public interface PurpleTokenSets {

    TokenSet IDENTIFIERS = TokenSet.create(PurpleTypes.KEY);

    TokenSet COMMENTS = TokenSet.create(PurpleTypes.COMMENT);

}
