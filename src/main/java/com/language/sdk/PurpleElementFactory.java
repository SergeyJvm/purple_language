package com.language.sdk;

import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFileFactory;
import com.language.psi.PurpleProperty;
import com.language.sdk.psi.PurpleFile;

public class PurpleElementFactory {
    public static PurpleProperty createProperty(Project project, String name) {
        final PurpleFile file = createFile(project, name);
        return (PurpleProperty) file.getFirstChild();
    }

    public static PurpleFile createFile(Project project, String text) {
        String name = "dummy.simple";
        return (PurpleFile) PsiFileFactory.getInstance(project).createFileFromText(name, PurpleFileType.INSTANCE, text);
    }

    public static PurpleProperty createProperty(Project project, String name, String value) {
        final PurpleFile file = createFile(project, name + " = " + value);
        return (PurpleProperty) file.getFirstChild();
    }

    public static PsiElement createCRLF(Project project) {
        final PurpleFile file = createFile(project, "\n");
        return file.getFirstChild();
    }
}
