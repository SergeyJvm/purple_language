package com.language.sdk;

import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import org.jetbrains.annotations.NotNull;

public abstract class PurpleNamedElementImpl extends ASTWrapperPsiElement implements PurpleNamedElement {

    public PurpleNamedElementImpl(@NotNull ASTNode node) {
        super(node);
    }

}
