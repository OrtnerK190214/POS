/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.eaustria.webcrawler;

/**
 *
 * @author bmayr
 */
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import org.htmlparser.Parser;
import org.htmlparser.filters.NodeClassFilter;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LinkFinder implements Runnable {

    private String url;
    private ILinkHandler linkHandler;
    /**
     * Used fot statistics
     */
    private static final long t0 = System.nanoTime();

    public LinkFinder(String url, ILinkHandler handler) {
        this.url = url;
        this.linkHandler = handler;
    }

    @Override
    public void run() {
        try {
            getSimpleLinks(url);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void getSimpleLinks(String url) throws Exception {
        // ToDo: Implement
        // 1. if url not already visited, visit url with linkHandler
        // 2. get url and Parse Website
        // 3. extract all URLs and add url to list of urls which should be visited
        //    only if link is not empty and url has not been visited before
        // 4. If size of link handler equals 500 -> print time elapsed for statistics

        if (linkHandler.visited(url) == false)
        {
            try {
                URL url1 = new URL(url);
                Parser parser = new Parser(url1.openConnection());
                NodeList list = parser.extractAllNodesThatMatch(new NodeClassFilter(LinkTag.class));
                List shouldvisit = new ArrayList();
                for (int i = 0; i < list.size(); i++)
                {
                    if (linkHandler.visited(url) == false) {
                        shouldvisit.add(url1);
                    }
                }
                if (linkHandler.size() == 500)
                {
                    System.out.println(System.currentTimeMillis() - System.currentTimeMillis());
                }
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

