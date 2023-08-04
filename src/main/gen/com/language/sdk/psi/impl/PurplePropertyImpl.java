// This is a generated file. Not intended for manual editing.
package com.language.sdk.psi.impl;

import java.util.List;

import com.language.sdk.PurpleNamedElementImpl;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.navigation.ItemPresentation;
import com.language.psi.*;

public class PurplePropertyImpl extends PurpleNamedElementImpl implements PurpleProperty {

  public PurplePropertyImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull PurpleVisitor visitor) {
    visitor.visitProperty(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof PurpleVisitor) accept((PurpleVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  public String getKey() {
    return PurplePsiImplUtil.getKey(this);
  }

  @Override
  public String getValue() {
    return PurplePsiImplUtil.getValue(this);
  }

  @Override
  public String getName() {
    return PurplePsiImplUtil.getName(this);
  }

  @Override
  public PsiElement setName(@NotNull String newName) {
    return PurplePsiImplUtil.setName(this, newName);
  }

  @Override
  public PsiElement getNameIdentifier() {
    return PurplePsiImplUtil.getNameIdentifier(this);
  }

  @Override
  public ItemPresentation getPresentation() {
    return PurplePsiImplUtil.getPresentation(this);
  }


}
