// This is a generated file. Not intended for manual editing.
package com.language.psi;

import com.language.sdk.PurpleNamedElement;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class PurpleVisitor extends PsiElementVisitor {

  public void visitProperty(@NotNull PurpleProperty o) {
    visitNamedElement(o);
  }

  public void visitNamedElement(@NotNull PurpleNamedElement o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
