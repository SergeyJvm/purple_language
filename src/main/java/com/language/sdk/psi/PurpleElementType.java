package com.language.sdk.psi;

import com.intellij.psi.tree.IElementType;
import com.language.sdk.PurpleLanguage;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class PurpleElementType extends IElementType {

  public PurpleElementType(@NotNull @NonNls String debugName) {
        super(debugName, PurpleLanguage.INSTANCE);
    }
}
