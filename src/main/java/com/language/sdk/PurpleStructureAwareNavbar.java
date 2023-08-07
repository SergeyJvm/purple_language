package com.language.sdk;

import com.intellij.icons.AllIcons;
import com.intellij.ide.navigationToolbar.StructureAwareNavBarModelExtension;
import com.intellij.lang.Language;
import com.language.psi.PurpleProperty;
import com.language.sdk.psi.PurpleFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class PurpleStructureAwareNavbar extends StructureAwareNavBarModelExtension {
    @NotNull
    @Override
    protected Language getLanguage() {
        return PurpleLanguage.INSTANCE;
    }

    @Override
    public @Nullable String getPresentableText(Object object) {
        if (object instanceof PurpleFile) {
            return ((PurpleFile) object).getName();
        }
        if (object instanceof PurpleProperty) {
            return ((PurpleProperty) object).getName();
        }

        return null;
    }

    @Override
    @Nullable
    public Icon getIcon(Object object) {
        if (object instanceof PurpleProperty) {
            return AllIcons.Nodes.Property;
        }

        return null;
    }

}
