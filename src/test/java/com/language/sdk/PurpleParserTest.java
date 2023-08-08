package com.language.sdk;

import com.intellij.testFramework.ParsingTestCase;
import com.language.sdk.PurpleParserDefinition;

public class PurpleParserTest extends ParsingTestCase {

    public PurpleParserTest() {
        super("", "purple", new PurpleParserDefinition());
    }

    public void testParsingTestData() {
        doTest(true);
    }

    /**
     * @return path to test data file directory relative to root of this module.
     */
    @Override
    protected String getTestDataPath() {
        return "src/test/testData";
    }

    @Override
    protected boolean skipSpaces() {
        return false;
    }

    @Override
    protected boolean includeRanges() {
        return true;
    }

}