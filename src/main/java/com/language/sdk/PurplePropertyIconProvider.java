package com.language.sdk;

import com.intellij.ide.IconProvider;
import com.intellij.psi.PsiElement;
import com.language.psi.PurpleProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class PurplePropertyIconProvider extends IconProvider {
        @Override
        public @Nullable Icon getIcon(@NotNull PsiElement element, int flags) {
            return element instanceof PurpleProperty ? PurpleIcons.FILE : null;
        }
}
