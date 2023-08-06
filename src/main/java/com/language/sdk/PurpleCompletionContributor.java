package com.language.sdk;

import com.intellij.codeInsight.completion.*;
import com.intellij.codeInsight.lookup.LookupElementBuilder;
import com.intellij.patterns.PlatformPatterns;
import com.intellij.util.ProcessingContext;
import com.language.sdk.psi.PurpleTypes;
import org.jetbrains.annotations.NotNull;

public class PurpleCompletionContributor extends CompletionContributor {
    public PurpleCompletionContributor() {
        extend(CompletionType.BASIC, PlatformPatterns.psiElement(PurpleTypes.VALUE),
                new CompletionProvider<>() {
                    public void addCompletions(@NotNull CompletionParameters parameters,
                                               @NotNull ProcessingContext context,
                                               @NotNull CompletionResultSet resultSet) {
                        resultSet.addElement(LookupElementBuilder.create("Hello"));
                    }
                }
        );
    }

}
