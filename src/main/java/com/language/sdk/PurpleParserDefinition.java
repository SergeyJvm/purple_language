package com.language.sdk;

import com.intellij.lang.ASTNode;
import com.intellij.lang.ParserDefinition;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.project.Project;
import com.intellij.psi.FileViewProvider;
import com.intellij.psi.tree.IFileElementType;
import com.language.sdk.psi.PurpleFile;
import com.language.sdk.psi.PurpleTokenSets;
import com.intellij.psi.PsiFile;
import com.intellij.psi.PsiElement;
import com.language.sdk.psi.PurpleTypes;
import org.jetbrains.annotations.NotNull;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;

public class PurpleParserDefinition implements ParserDefinition {

    public static final IFileElementType FILE = new IFileElementType(PurpleLanguage.INSTANCE);

    @NotNull
    @Override
    public Lexer createLexer(Project project) {
        return new PurpleLexerAdapter();
    }

    @NotNull
    @Override
    public TokenSet getCommentTokens() {
        return PurpleTokenSets.COMMENTS;
    }

    @NotNull
    @Override
    public TokenSet getStringLiteralElements() {
        return TokenSet.EMPTY;
    }

    @NotNull
    @Override
    public PsiParser createParser(final Project project) {
        return new PurpleParser();
    }

    @NotNull
    @Override
    public IFileElementType getFileNodeType() {
        return FILE;
    }

    @NotNull
    @Override
    public PsiFile createFile(@NotNull FileViewProvider viewProvider) {
        return new PurpleFile(viewProvider);
    }

    @NotNull
    @Override
    public PsiElement createElement(ASTNode node) {
        return PurpleTypes.Factory.createElement(node);
    }

}
