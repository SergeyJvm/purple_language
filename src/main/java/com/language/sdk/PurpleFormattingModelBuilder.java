package com.language.sdk;

import com.intellij.formatting.*;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.language.sdk.psi.PurpleTypes;
import org.jetbrains.annotations.NotNull;

public class PurpleFormattingModelBuilder implements FormattingModelBuilder {

        private static SpacingBuilder createSpaceBuilder(CodeStyleSettings settings) {
            return new SpacingBuilder(settings, PurpleLanguage.INSTANCE)
                    .around(PurpleTypes.SEPARATOR)
                    .spaceIf(settings.getCommonSettings(PurpleLanguage.INSTANCE.getID()).SPACE_AROUND_ASSIGNMENT_OPERATORS)
                    .before(PurpleTypes.PROPERTY)
                    .none();
        }

        @Override
        public @NotNull FormattingModel createModel(@NotNull FormattingContext formattingContext) {
            final CodeStyleSettings codeStyleSettings = formattingContext.getCodeStyleSettings();
            return FormattingModelProvider
                    .createFormattingModelForPsiFile(formattingContext.getContainingFile(),
                            new PurpleBlock(formattingContext.getNode(),
                                    Wrap.createWrap(WrapType.NONE, false),
                                    Alignment.createAlignment(),
                                    createSpaceBuilder(codeStyleSettings)),
                            codeStyleSettings);
        }

}
