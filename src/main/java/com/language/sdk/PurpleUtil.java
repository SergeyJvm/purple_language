package com.language.sdk;

import com.google.common.collect.Lists;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiComment;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiManager;
import com.intellij.psi.PsiWhiteSpace;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.util.PsiTreeUtil;
import com.language.psi.PurpleProperty;
import com.language.sdk.psi.PurpleFile;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class PurpleUtil {

    /**
     * Searches the entire project for Simple language files with instances of the Simple property with the given key.
     *
     * @param project current project
     * @param key     to check
     * @return matching properties
     */
    public static List<PurpleProperty> findProperties(Project project, String key) {
        List<PurpleProperty> result = new ArrayList<>();
        Collection<VirtualFile> virtualFiles =
                FileTypeIndex.getFiles(PurpleFileType.INSTANCE, GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            PurpleFile purpleFile = (PurpleFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (purpleFile != null) {
                PurpleProperty[] properties = PsiTreeUtil.getChildrenOfType(purpleFile, PurpleProperty.class);
                if (properties != null) {
                    for (PurpleProperty property : properties) {
                        if (key.equals(property.getKey())) {
                            result.add(property);
                        }
                    }
                }
            }
        }
        return result;
    }

    public static List<PurpleProperty> findProperties(Project project) {
        List<PurpleProperty> result = new ArrayList<>();
        Collection<VirtualFile> virtualFiles =
                FileTypeIndex.getFiles(PurpleFileType.INSTANCE, GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            PurpleFile simpleFile = (PurpleFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (simpleFile != null) {
                PurpleProperty[] properties = PsiTreeUtil.getChildrenOfType(simpleFile, PurpleProperty.class);
                if (properties != null) {
                    Collections.addAll(result, properties);
                }
            }
        }
        return result;
    }

    /**
     * Attempts to collect any comment elements above the Simple key/value pair.
     */
    public static @NotNull
    String findDocumentationComment(PurpleProperty property) {
        List<String> result = new LinkedList<>();
        PsiElement element = property.getPrevSibling();
        while (element instanceof PsiComment || element instanceof PsiWhiteSpace) {
            if (element instanceof PsiComment) {
                String commentText = element.getText().replaceFirst("[!# ]+", "");
                result.add(commentText);
            }
            element = element.getPrevSibling();
        }
        return StringUtil.join(Lists.reverse(result), "\n ");
    }

}

