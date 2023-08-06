package com.language.sdk;

import com.intellij.codeInsight.daemon.LineMarkerInfo;
import com.intellij.codeInsight.daemon.LineMarkerProvider;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiIdentifier;
import com.intellij.psi.PsiMethod;
import org.jetbrains.annotations.NotNull;

public class MyCorrectLineMarkerProvider implements LineMarkerProvider {
    TextRange range = new TextRange(1, 13);

    public LineMarkerInfo getLineMarkerInfo(@NotNull PsiElement element) {
        if (element instanceof PsiIdentifier &&
                element.getParent() instanceof PsiMethod) {
            return new LineMarkerInfo(element, range);
        }
        return null;
    }

}
