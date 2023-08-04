package com.language.sdk;

import com.intellij.openapi.fileTypes.LanguageFileType;
import com.intellij.openapi.util.NlsContexts;
import com.intellij.openapi.util.NlsSafe;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class PurpleFileType extends LanguageFileType {

    public static final PurpleFileType INSTANCE = new PurpleFileType();

    private PurpleFileType() {
        super(PurpleLanguage.INSTANCE);
    }

    @Override
    public @NonNls
    @NotNull String getName() {
        return "Purple Language";
    }

    @Override
    public @NlsContexts.Label
    @NotNull String getDescription() {
        return "Purple language file";
    }

    @Override
    public @NlsSafe
    @NotNull String getDefaultExtension() {
        return "purple";
    }

    @Override
    public @Nullable Icon getIcon() {
        return PurpleIcons.FILE;
    }
}
