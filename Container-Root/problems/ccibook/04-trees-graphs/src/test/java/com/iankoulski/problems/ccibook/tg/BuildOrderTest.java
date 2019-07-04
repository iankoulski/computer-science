package com.iankoulski.problems.ccibook.tg;

import com.iankoulski.problems.ccibook.tg.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runners.model.TestClass;

/**
 * Unit test for simple App.
 */
public class BuildOrderTest extends TestClass
{
    public BuildOrderTest( )
    {
        super( BuildOrderTest.class );
    }

    // test main
    @Test
    public void testApp()
    {   
        System.out.println("App test:");
        com.iankoulski.problems.ccibook.tg.BuildOrder.main(null);
        Assert.assertTrue(true);
    }

    public Graph<String> getTestGraph(boolean loop){
        /*
        loop = false
                   a    k  l
                 / | \ /   |
                b  c  d    m
               /\  |  /
              e  f-g h
                    / \
                   i   j

        loop = true
                   a    k  l
                 / | \ /   |
                b  c  d    m
               /\  |  /
              e  f-g h
                    / \
                  i <-> j
        */
        
        String[] projects = new String[] {"a","b","c","d","e","f","g","h","i","j","k","l","m"};
        String[][] dependencies = null;

        if (loop==false){
            dependencies = new String[][] {{"a","b"},{"a","c"},{"a","d"},{"b","e"},
                                           {"b","f"},{"f","g"},{"c","g"},{"k","d"},
                                           {"l","m"},{"d","h"},{"h","i"},{"h","j"}};
        }else{
            dependencies = new String[][] {{"a","b"},{"a","c"},{"a","d"},{"b","e"},
                                           {"b","f"},{"f","g"},{"c","g"},{"k","d"},
                                           {"l","m"},{"d","h"},{"h","i"},{"h","j"},
                                           {"i","j"},{"j","i"}};
        }
        
        BuildOrder bo = new BuildOrder();

        Graph<String> graph = bo.buildGraph(projects,dependencies);

        return graph;        
    }

    @Test
    public void testNoLoopByRoot()
    {
        //Graph<String> g = getTestData(false);
        BuildOrder bo = new BuildOrder();
        Graph<String> g = getTestGraph(false);
        Queue<String> buildOrder = bo.getBuildOrderByRoot(g);
        Assert.assertEquals("a<-k<-l<-b<-c<-d<-m<-e<-f<-h<-g<-i<-j",buildOrder.getString());
    }

    @Test
    public void testLoopByRoot()
    {
        Graph<String> g = getTestGraph(true);
        BuildOrder bo = new BuildOrder();
        Queue<String> buildOrder = bo.getBuildOrderByRoot(g);
        Assert.assertNull(buildOrder);
    }

    @Test
    public void testNoLoopByDFS()
    {
        Graph<String> g = getTestGraph(false);
        BuildOrder bo = new BuildOrder();
        Stack<String> buildOrder = bo.getBuildOrderByDFS(g);
        Assert.assertEquals("l->m->k->a->d->h->j->i->c->b->f->g->e",buildOrder.getString());
    }

    @Test
    public void testLoopByDFS()
    {
        Graph<String> g = getTestGraph(true);
        BuildOrder bo = new BuildOrder();
        Stack<String> buildOrder = bo.getBuildOrderByDFS(g);
        Assert.assertNull(buildOrder);
    }
}
