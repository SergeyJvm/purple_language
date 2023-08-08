package com.language.sdk;

import com.intellij.lang.documentation.AbstractDocumentationProvider;
import com.intellij.lang.documentation.DocumentationMarkup;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.*;
import com.intellij.psi.presentation.java.SymbolPresentationUtil;
import com.intellij.psi.util.PsiTreeUtil;
import com.language.psi.PurpleProperty;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PurpleDocumentationProvider extends AbstractDocumentationProvider {


    @Override
    public @Nullable @Nls String generateHoverDoc(@NotNull PsiElement element, @Nullable PsiElement originalElement) {
        return super.generateHoverDoc(element, originalElement);
    }

    @Override
    public @Nullable @Nls String getQuickNavigateInfo(PsiElement element, PsiElement originalElement) {
        if(element instanceof PurpleProperty) {
            final String key = ((PurpleProperty) element).getKey();
            final String file = SymbolPresentationUtil.getFilePathPresentation(element.getContainingFile());

            return "\"" + key + "\" in" + file;
        }
        return null;
    }

    @Override
    public String generateDoc(PsiElement element, @Nullable PsiElement originPsiElement) {
        if(element instanceof PurpleProperty) {
            final String key = ((PurpleProperty) element).getKey();
            final String value = ((PurpleProperty) element).getValue();
            final String file = SymbolPresentationUtil.getFilePathPresentation(element.getContainingFile());
            final String docComment = PurpleUtil.findDocumentationComment((PurpleProperty) element);

            return renderFullDocs(key, value, file, docComment);
        }
        return super.generateDoc(element, originPsiElement);
    }

    private String renderFullDocs(String key, String value, String file, String docComment) {
        StringBuilder sb = new StringBuilder();
        sb.append(DocumentationMarkup.DEFINITION_START);
        sb.append("Purple Property");
        sb.append(DocumentationMarkup.DEFINITION_END);
        sb.append(DocumentationMarkup.CONTENT_START);
        sb.append(value);
        sb.append(DocumentationMarkup.CONTENT_END);
        sb.append(DocumentationMarkup.SECTION_START);
        assKeyValueSection("Key: ", key, sb);
        assKeyValueSection("Value: ", value, sb);
        assKeyValueSection("File: ", file, sb);
        assKeyValueSection("Comment: ", docComment, sb);
        sb.append(DocumentationMarkup.SECTION_END);

        return sb.toString();
    }

    private void assKeyValueSection(String key, String value, StringBuilder sb) {
        sb.append(DocumentationMarkup.SECTION_HEADER_START);
        sb.append(key);
        sb.append(DocumentationMarkup.SECTION_SEPARATOR);
        sb.append("<p>");
        sb.append(value);
        sb.append(DocumentationMarkup.SECTION_END);
    }

    @Override
    public @Nullable PsiDocCommentBase findDocComment(@NotNull PsiFile file, @NotNull TextRange range) {
        return super.findDocComment(file, range);
    }

    @Override
    public @Nullable PsiElement getCustomDocumentationElement(@NotNull Editor editor,
                                                              @NotNull PsiFile file,
                                                              @Nullable PsiElement contextElement,
                                                              int targetOffset) {
        if (contextElement != null){
            //In this part the PurpleProperty element
            // is extracted from inside a Java string
            if(contextElement instanceof PsiJavaToken &&
            ((PsiJavaToken) contextElement).getTokenType().equals(JavaTokenType.STRING_LITERAL)) {
                PsiElement parent = contextElement.getParent();
                PsiReference[] references = parent.getReferences();
                for(PsiReference ref : references) {
                    if(ref instanceof PurpleReference) {
                        PsiElement property = ref.resolve();
                        if(property instanceof PurpleProperty) {
                            return property;
                        }
                    }
                }
            }
            //In this part the PurpleProperty element is extracted
            //when inside of a .purple file
            else if(contextElement.getLanguage() == PurpleLanguage.INSTANCE) {
                PsiElement property =
                        PsiTreeUtil.getParentOfType(contextElement, PurpleProperty.class);
                if(property != null) {
                    return property;
                }
            }
        }
        return super.getCustomDocumentationElement(
                editor, file, contextElement, targetOffset);
    }

}
