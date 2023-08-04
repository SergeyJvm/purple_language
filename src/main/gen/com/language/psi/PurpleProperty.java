// This is a generated file. Not intended for manual editing.
package com.language.psi;

import java.util.List;

import com.intellij.navigation.ItemPresentation;
import com.intellij.psi.PsiElement;
import com.language.sdk.PurpleNamedElement;
import org.jetbrains.annotations.NotNull;

public interface PurpleProperty extends PurpleNamedElement {

  String getKey();

  String getValue();

  String getName();

  PsiElement setName(@NotNull String newName);

  PsiElement getNameIdentifier();

  ItemPresentation getPresentation();

}
