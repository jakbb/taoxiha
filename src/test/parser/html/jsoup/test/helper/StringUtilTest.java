package test.parser.html.jsoup.test.helper;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;

import org.junit.Test;

import com.taoxiha.common.parser.html.jsoup.Jsoup;
import com.taoxiha.common.parser.html.jsoup.helper.StringUtil;

public class StringUtilTest {

    @Test public void join() {
        assertEquals("", StringUtil.join(Arrays.<String>asList(""), " "));
        assertEquals("one", StringUtil.join(Arrays.<String>asList("one"), " "));
        assertEquals("one two three", StringUtil.join(Arrays.<String>asList("one", "two", "three"), " "));
    }

    @Test public void padding() {
        assertEquals("", StringUtil.padding(0));
        assertEquals(" ", StringUtil.padding(1));
        assertEquals("  ", StringUtil.padding(2));
        assertEquals("               ", StringUtil.padding(15));
    }

    @Test public void isBlank() {
        assertTrue(StringUtil.isBlank(null));
        assertTrue(StringUtil.isBlank(""));
        assertTrue(StringUtil.isBlank("      "));
        assertTrue(StringUtil.isBlank("   \r\n  "));

        assertFalse(StringUtil.isBlank("hello"));
        assertFalse(StringUtil.isBlank("   hello   "));
    }

    @Test public void isNumeric() {
        assertFalse(StringUtil.isNumeric(null));
        assertFalse(StringUtil.isNumeric(" "));
        assertFalse(StringUtil.isNumeric("123 546"));
        assertFalse(StringUtil.isNumeric("hello"));
        assertFalse(StringUtil.isNumeric("123.334"));

        assertTrue(StringUtil.isNumeric("1"));
        assertTrue(StringUtil.isNumeric("1234"));
    }

    @Test public void isWhitespace() {
        assertTrue(StringUtil.isWhitespace('\t'));
        assertTrue(StringUtil.isWhitespace('\n'));
        assertTrue(StringUtil.isWhitespace('\r'));
        assertTrue(StringUtil.isWhitespace('\f'));
        assertTrue(StringUtil.isWhitespace(' '));
        
        assertFalse(StringUtil.isWhitespace('\u00a0'));
        assertFalse(StringUtil.isWhitespace('\u2000'));
        assertFalse(StringUtil.isWhitespace('\u3000'));
    }

    @Test public void normaliseWhiteSpace() {
        assertEquals(" ", StringUtil.normaliseWhitespace("    \r \n \r\n"));
        assertEquals(" hello there ", StringUtil.normaliseWhitespace("   hello   \r \n  there    \n"));
        assertEquals("hello", StringUtil.normaliseWhitespace("hello"));
        assertEquals("hello there", StringUtil.normaliseWhitespace("hello\nthere"));
    }

    @Test public void normaliseWhiteSpaceModified() {
        String check1 = "Hello there";
        String check2 = "Hello\nthere";
        String check3 = "Hello  there";

        // does not create new string no mods done
        assertTrue(check1 == StringUtil.normaliseWhitespace(check1));
        assertTrue(check2 != StringUtil.normaliseWhitespace(check2));
        assertTrue(check3 != StringUtil.normaliseWhitespace(check3));
    }

    @Test public void normaliseWhiteSpaceHandlesHighSurrogates() {
        String test71540chars = "\ud869\udeb2\u304b\u309a  1";
        String test71540charsExpectedSingleWhitespace = "\ud869\udeb2\u304b\u309a 1";

        assertEquals(test71540charsExpectedSingleWhitespace, StringUtil.normaliseWhitespace(test71540chars));
        String extractedText = Jsoup.parse(test71540chars).text();
        assertEquals(test71540charsExpectedSingleWhitespace, extractedText);
    }
}
