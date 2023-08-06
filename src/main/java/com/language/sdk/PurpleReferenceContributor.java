package com.language.sdk;

import com.intellij.openapi.util.TextRange;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.psi.*;
import com.intellij.util.ProcessingContext;
import org.jetbrains.annotations.NotNull;

import static com.language.sdk.PurpleAnnotator.PURPLE_PREFIX_STR;
import static com.language.sdk.PurpleAnnotator.PURPLE_SEPARATOR_STR;

public class PurpleReferenceContributor extends PsiReferenceContributor {

    @Override
    public void registerReferenceProviders(@NotNull PsiReferenceRegistrar registrar) {
        registrar.registerReferenceProvider(PlatformPatterns.psiElement(PsiLiteralExpression.class),
                new PsiReferenceProvider() {
                    @Override
                    public PsiReference @NotNull [] getReferencesByElement(@NotNull PsiElement element,
                                                                           @NotNull ProcessingContext context) {
                        PsiLiteralExpression literalExpression = (PsiLiteralExpression) element;
                        String value = literalExpression.getValue() instanceof String ?
                                (String) literalExpression.getValue() : null;
                        if ((value != null && value.startsWith(PURPLE_PREFIX_STR + PURPLE_SEPARATOR_STR))) {
                            TextRange property = new TextRange(PURPLE_PREFIX_STR.length() + PURPLE_SEPARATOR_STR.length() + 1,
                                    value.length() + 1);
                            return new PsiReference[]{new PurpleReference(element, property)};
                        }
                        return PsiReference.EMPTY_ARRAY;
                    }
                });
    }


}
