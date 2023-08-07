package com.language.sdk;

import com.intellij.lang.documentation.AbstractDocumentationProvider;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.Nullable;

public class PurpleDocumentationProvider extends AbstractDocumentationProvider {

    @Override
    public String generateDoc(PsiElement element, @Nullable PsiElement originPsiElement) {
        return super.generateDoc(element, originPsiElement);
    }

}
