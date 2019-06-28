package com.iankoulski.problems.ccibook.tg;

import com.iankoulski.problems.ccibook.tg.*;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runners.model.TestClass;

/**
 * Unit test for simple App.
 */
public class RouteBetweenNodesTest extends TestClass
{
    public RouteBetweenNodesTest( )
    {
        super( RouteBetweenNodesTest.class );
    }

    // test main
    @Test
    public void testApp()
    {   
        System.out.println("App test:");
        com.iankoulski.problems.ccibook.tg.RouteBetweenNodes.main(null);
        Assert.assertTrue(true);
    }

    public Graph<Integer> getTestData(){
        /*
                   0
                 / | \
                1  2  3
               /\  |  /
              4  5-6 7
                    / \
                   8   9
        */
        GraphNode<Integer> root = new GraphNode<Integer>(0);
        GraphNode<Integer> one = new GraphNode<Integer>(1);
        GraphNode<Integer> two = new GraphNode<Integer>(2);
        GraphNode<Integer> three = new GraphNode<Integer>(3);
        GraphNode<Integer> four = new GraphNode<Integer>(4);
        GraphNode<Integer> five = new GraphNode<Integer>(5);
        GraphNode<Integer> six = new GraphNode<Integer>(6);
        GraphNode<Integer> seven = new GraphNode<Integer>(7);
        GraphNode<Integer> eight = new GraphNode<Integer>(8);
        GraphNode<Integer> nine = new GraphNode<Integer>(9);
        root.children = new GraphNode[] {one, two, three};
        one.children = new GraphNode[] {four, five};
        two.children = new GraphNode[] {six};
        three.children = new GraphNode[] {seven};
        five.children = new GraphNode[] {six};
        seven.children = new GraphNode[] {eight, nine};
        Graph<Integer> g = new Graph<Integer>();
        g.nodes = new GraphNode[] {root,one,two,three,four,five,six,seven,eight,nine};
        return g;        
    }

    @Test
    public void testRouteExists()
    {
        Graph<Integer> g = getTestData();
        RouteBetweenNodes rbn = new RouteBetweenNodes();
        boolean pathExists = rbn.pathExists(g,g.nodes[0],g.nodes[8]);
        Assert.assertTrue(pathExists);
    }

    @Test
    public void testNoRoute()
    {
        Graph<Integer> g = getTestData();
        RouteBetweenNodes rbn = new RouteBetweenNodes();
        boolean pathExists = rbn.pathExists(g,g.nodes[1],g.nodes[9]);
        Assert.assertFalse(pathExists);
    }

    @Test
    public void testRouteOneSixExists(){
        Graph<Integer> g = getTestData();
        RouteBetweenNodes rbn = new RouteBetweenNodes();
        boolean pathExists = rbn.pathExists(g,g.nodes[1],g.nodes[6]);
        Assert.assertTrue(pathExists);
    }

}
