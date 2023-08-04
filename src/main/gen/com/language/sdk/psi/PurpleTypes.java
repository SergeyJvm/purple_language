// This is a generated file. Not intended for manual editing.
package com.language.sdk.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.language.sdk.psi.impl.*;

public interface PurpleTypes {

  IElementType PROPERTY = new PurpleElementType("PROPERTY");

  IElementType COMMENT = new PurpleTokenType("COMMENT");
  IElementType CRLF = new PurpleTokenType("CRLF");
  IElementType KEY = new PurpleTokenType("KEY");
  IElementType SEPARATOR = new PurpleTokenType("SEPARATOR");
  IElementType VALUE = new PurpleTokenType("VALUE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == PROPERTY) {
        return new PurplePropertyImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
