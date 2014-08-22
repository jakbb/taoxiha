package test.parser.html;

import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import junit.framework.TestCase;

import org.apache.xerces.parsers.AbstractSAXParser;
import org.apache.xerces.xni.Augmentations;
import org.apache.xerces.xni.QName;
import org.apache.xerces.xni.XMLAttributes;
import org.apache.xerces.xni.XMLString;
import org.apache.xerces.xni.XNIException;
import org.apache.xerces.xni.parser.XMLInputSource;
import org.xml.sax.SAXException;

import com.sun.org.apache.xerces.internal.util.XMLAttributesImpl;
import com.taoxiha.common.parser.html.HTMLConfiguration;
import com.taoxiha.common.parser.html.HTMLTagBalancingListener;
import com.taoxiha.common.utils.io.FileUtils;

/**
 * Unit tests for {@link HTMLTagBalancingListener}.
 * @author Marc Guillemot
 * @version $Id: HTMLTagBalancingListenerTest.java 320 2013-01-29 07:46:36Z mguillem $
 */
public class HTMLTagBalancingListenerTest extends TestCase {

   public void testIgnoredTags() throws Exception {
       String string = "<html><head><title>foo</title></head>"
           + "<body>"
           + "<body onload='alert(123)'>"
           + "<div>"
           + "<form action='foo'>"
           + "  <input name='text1'/>"
           + "</div>"
           + "</form>"
            + "</body></html>";
       
       final TestParser parser = new TestParser();
       final StringReader sr = new StringReader(string);
       final XMLInputSource in = new XMLInputSource(null, "foo", null, sr, null);

       parser.parse(in);
       
       final String[] expectedMessages = {"start HTML", "start HEAD", "start TITLE", "end TITLE", "end HEAD",
    		   "start BODY", "ignored start BODY", 
    		   "start DIV", "start FORM", "start INPUT", "end INPUT", "end FORM",
    		   "end DIV", "ignored end FORM",
    		   "end BODY", "end HTML"};
       
       assertEquals(Arrays.asList(expectedMessages).toString(), parser.messages.toString());
    }

   /**
    * HTMLTagBalancer field fSeenFramesetElement was not correctly reset as of 1.19.17  
    * @throws Exception
    */
   public void testReuse() throws Exception {
       String string = "<head><title>title</title></head><body><div>hello</div></body>";
       
       final TestParser parser = new TestParser();
       final StringReader sr = new StringReader(string);
       final XMLInputSource in = new XMLInputSource(null, "foo", null, sr, null);

       parser.parse(in);
       
       final String[] expectedMessages = {"start HTML", "start HEAD", "start TITLE", "end TITLE", "end HEAD",
    		   "start BODY", "start DIV", "end DIV", "end BODY", "end HTML"};
       
       assertEquals(Arrays.asList(expectedMessages).toString(), parser.messages.toString());
       
       parser.messages.clear();
       parser.parse(new XMLInputSource(null, "foo", null, new StringReader(string), null));
       assertEquals(Arrays.asList(expectedMessages).toString(), parser.messages.toString());
    }

public void getFile() throws Exception{
	String file="/data/crawl/baidu/14.html";
	String str=FileUtils.getContent(file,"utf-8");
	 final TestParser parser = new TestParser();
     parser.parse(new XMLInputSource(null, "foo", null, new StringReader(str), null));
     System.out.println(parser.messages);
	
}

public static void main(String[] args) throws Exception {
	String file="/data/crawl/baidu/14.html";
	String str=FileUtils.getContent(file,"utf-8");
	 final TestParser parser = new TestParser();
     parser.parse(new XMLInputSource(null, "baidu", null, new StringReader(str), null));
     System.out.println(parser.messages);
}

}

@SuppressWarnings({"unchecked", "rawtypes"})

class TestParser extends AbstractSAXParser implements HTMLTagBalancingListener
{
	final List messages = new ArrayList();
	TestParser() throws Exception
	{
		super(new HTMLConfiguration());
        setFeature("http://cyberneko.org/html/features/balance-tags/ignore-outside-content", true);
	}
	
	public void startElement(QName element, XMLAttributes attributes,
			Augmentations augs) throws XNIException {

		messages.add("start " + element.rawname);
		super.startElement(element, attributes, augs);
		System.out.println(element.toString()+"_"+attributes+"_"+augs);
		
	}
	public void ignoredEndElement(QName element, Augmentations augs) {
		messages.add("ignored end " + element.rawname);
	}
	public void ignoredStartElement(QName element, XMLAttributes attrs,
			Augmentations augs) {
		messages.add("ignored start " + element.rawname);
	}

	public void endElement(QName element, Augmentations augs) throws XNIException {
		messages.add("end " + element.rawname);
		super.endElement(element, augs);
	}
	  
}