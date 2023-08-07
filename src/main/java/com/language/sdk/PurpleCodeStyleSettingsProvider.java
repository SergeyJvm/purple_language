package com.language.sdk;

import com.intellij.application.options.CodeStyleAbstractConfigurable;
import com.intellij.application.options.CodeStyleAbstractPanel;
import com.intellij.application.options.TabbedLanguageCodeStylePanel;
import com.intellij.psi.codeStyle.CodeStyleConfigurable;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.codeStyle.CodeStyleSettingsProvider;
import com.intellij.psi.codeStyle.CustomCodeStyleSettings;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PurpleCodeStyleSettingsProvider extends CodeStyleSettingsProvider {

    @Override
    public CustomCodeStyleSettings createCustomSettings(@NotNull CodeStyleSettings settings) {
        return new PurpleCodeStyleSettings(settings);
    }

    @Nullable
    @Override
    public String getConfigurableDisplayName() {
        return "Purple";
    }

    @NotNull
    public CodeStyleConfigurable createConfigurable(@NotNull CodeStyleSettings settings,
                                                    @NotNull CodeStyleSettings modelSettings) {
        return new CodeStyleAbstractConfigurable(settings, modelSettings, this.getConfigurableDisplayName()) {
            @Override
            protected @NotNull CodeStyleAbstractPanel createPanel(@NotNull CodeStyleSettings settings) {
                return new PurpleCodeStyleMainPanel(getCurrentSettings(), settings);
            }
        };
    }

    private static class PurpleCodeStyleMainPanel extends TabbedLanguageCodeStylePanel {

        public PurpleCodeStyleMainPanel(CodeStyleSettings currentSettings, CodeStyleSettings settings) {
            super(PurpleLanguage.INSTANCE, currentSettings, settings);
        }

    }

}
