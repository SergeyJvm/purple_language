package com.language.sdk.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.language.psi.PurpleProperty;
import com.language.sdk.PurpleElementFactory;
import com.language.sdk.psi.PurpleTypes;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class PurplePsiImplUtil {

    public static String getKey(PurpleProperty element) {
        ASTNode keyNode = element.getNode().findChildByType(PurpleTypes.KEY);
        if (keyNode != null) {
            // IMPORTANT: Convert embedded escaped spaces to simple spaces
            return keyNode.getText().replaceAll("\\\\ ", " ");
        } else {
            return null;
        }
    }

    public static String getValue(PurpleProperty element) {
        ASTNode valueNode = element.getNode().findChildByType(PurpleTypes.VALUE);
        if (valueNode != null) {
            return valueNode.getText();
        } else {
            return null;
        }
    }

    public static String getName(PurpleProperty element) {
        return getKey(element);
    }

    public static PsiElement setName(PurpleProperty element, String newName) {
        ASTNode keyNode = element.getNode().findChildByType(PurpleTypes.KEY);
        if (keyNode != null) {
            PurpleProperty property = PurpleElementFactory.createProperty(element.getProject(), newName);
            ASTNode newKeyNode = property.getFirstChild().getNode();
            element.getNode().replaceChild(keyNode, newKeyNode);
        }
        return element;
    }

    public static PsiElement getNameIdentifier(PurpleProperty element) {
        ASTNode keyNode = element.getNode().findChildByType(PurpleTypes.KEY);
        if (keyNode != null) {
            return keyNode.getPsi();
        } else {
            return null;
        }
    }

    public static ItemPresentation getPresentation(final PurpleProperty element) {
        return new ItemPresentation() {
            @Nullable
            @Override
            public String getPresentableText() {
                return element.getKey();
            }

            @Nullable
            @Override
            public String getLocationString() {
                PsiFile containingFile = element.getContainingFile();
                return containingFile == null ? null : containingFile.getName();
            }

            @Override
            public Icon getIcon(boolean unused) {
                return element.getIcon(0);
            }
        };
    }

}
