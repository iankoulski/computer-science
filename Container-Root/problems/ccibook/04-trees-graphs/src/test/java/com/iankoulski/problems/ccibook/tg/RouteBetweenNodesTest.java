package com.iankoulski.problems.ccibook.tg;

import com.iankoulski.problems.ccibook.tg.*;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class RouteBetweenNodesTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public RouteBetweenNodesTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( RouteBetweenNodesTest.class );
    }

    // test main
    public void testApp()
    {   
        System.out.println("App test:");
        com.iankoulski.problems.ccibook.tg.RouteBetweenNodes.main(null);
        assertTrue(true);
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

    public void testRouteExists()
    {
        Graph<Integer> g = getTestData();
        RouteBetweenNodes rbn = new RouteBetweenNodes();
        boolean pathExists = rbn.pathExists(g,g.nodes[0],g.nodes[8]);
        assertTrue(pathExists);
    }

    public void testNoRoute()
    {
        Graph<Integer> g = getTestData();
        RouteBetweenNodes rbn = new RouteBetweenNodes();
        boolean pathExists = rbn.pathExists(g,g.nodes[1],g.nodes[9]);
        assertFalse(pathExists);
    }

    public void testRouteOneSixExists(){
        Graph<Integer> g = getTestData();
        RouteBetweenNodes rbn = new RouteBetweenNodes();
        boolean pathExists = rbn.pathExists(g,g.nodes[1],g.nodes[6]);
        assertTrue(pathExists);
    }

}
