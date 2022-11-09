/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.eaustria.webcrawler;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;
import org.htmlparser.Parser;
import org.htmlparser.filters.NodeClassFilter;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;

/**
 *
 * @author bmayr
 */

// Recursive Action for forkJoinFramework from Java7

public class LinkFinderAction extends RecursiveAction {

    private String url;
    private ILinkHandler cr;
    /**
     * Used for statistics
     */
    private static final long t0 = System.nanoTime();

    public LinkFinderAction(String url, ILinkHandler cr) {
        this.cr = cr;
        this.url = url;
    }

    @Override
    public void compute() {
        // ToDo:
        // 1. if crawler has not visited url yet:
        // 2. Create new list of recursiveActions
        // 3. Parse url
        // 4. extract all links from url
        // 5. add new Action for each sublink
        // 6. if size of crawler exceeds 500 -> print elapsed time for statistics
        // -> Do not forget to call ìnvokeAll on the actions!

        if (cr.visited(url) == false)
        {
            try {
                List recursiveActions = new ArrayList();
                URL url1 = new URL(url);
                Parser parser = new Parser(url1.openConnection());
                NodeList list = parser.extractAllNodesThatMatch(new NodeClassFilter(LinkTag.class));
                for (int i = 0; i < list.size(); i++)
                {
                    LinkTag linktag = (LinkTag) list.elementAt(i);
                    if (linktag.extractLink().isEmpty() == false && cr.visited(linktag.extractLink())) {
                        recursiveActions.add(new LinkFinderAction(linktag.extractLink(), cr));
                    }
                }
                cr.addVisited(url);
                System.out.println(url);
                invokeAll(recursiveActions);
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            } catch (ParserException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

