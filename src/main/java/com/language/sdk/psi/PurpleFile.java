package com.language.sdk.psi;

import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import com.language.sdk.PurpleFileType;
import com.language.sdk.PurpleLanguage;
import org.jetbrains.annotations.NotNull;

public class PurpleFile extends PsiFileBase {

    public PurpleFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, PurpleLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return PurpleFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "Purple File";
    }
}
