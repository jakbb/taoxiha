/* 
 * Copyright 2002-2009 Andy Clark, Marc Guillemot
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package test.parser.html.sample;

import org.apache.html.dom.HTMLDocumentImpl;
import org.junit.Test;
import org.w3c.dom.DocumentFragment;
import org.w3c.dom.Node;
import org.w3c.dom.html.HTMLDocument;

import com.taoxiha.common.parser.html.parsers.DOMFragmentParser;
import com.taoxiha.common.parser.html.parsers.DOMParser;
import com.taoxiha.common.utils.io.FileUtils;

/**
 * This program tests the NekoHTML parser's use of the HTML DOM
 * implementation by printing the class names of all the nodes in
 * the parsed document.
 *
 * @author Andy Clark
 *
 * @version $Id: TestHTMLDOM.java,v 1.3 2004/02/19 20:00:17 andyc Exp $
 */
public class TestHTMLDOM {

    //
    // MAIN
    //

    /** Main. */
    public static void main(String[] argv) throws Exception {
        DOMParser parser = new DOMParser();
        for (int i = 0; i < argv.length; i++) {
            parser.parse(argv[i]);
            print(parser.getDocument(), "");
        }
    } // main(String[])

    @Test
    public void domParser() throws Exception{
    	String file="/data/crawl/baidu/14.html";
    	String str=FileUtils.getContent(file,"utf-8");
//    	 DOMParser parser = new DOMParser();
        DOMFragmentParser parser = new DOMFragmentParser();
         HTMLDocument document = new HTMLDocumentImpl();
         DocumentFragment fragment = document.createDocumentFragment();

    	 parser.parse(str,fragment);
    	  print(fragment, "");
    }
    
    //
    // Public static methods
    //

    /** Prints a node's class name. */
    public static void print(Node node, String indent) {
        System.out.println(indent+node.getClass().getName());
        Node child = node.getFirstChild();
        while (child != null) {
            print(child, indent+" ");
            child = child.getNextSibling();
        }
    } // print(Node)

} // class TestHTMLDOM
