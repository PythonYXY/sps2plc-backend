package sps2plc.core.utils;

import org.junit.jupiter.api.Test;

public class GraphTests {

    @Test
    public void testGetCircleDependency1() {
        Graph graph = new Graph();

        graph.addEdge("1", "2");
        graph.addEdge("1", "3");
        graph.addEdge("3", "4");
        graph.addEdge("4", "1");
        graph.addEdge("2", "5");

        System.out.println(graph.getCircles());
        System.out.println(graph.getCircularDependencyTable());
    }

    @Test
    public void testGetCircleDependency2() {
        Graph graph = new Graph();

        graph.addEdge("1", "2");
        graph.addEdge("1", "5");
        graph.addEdge("5", "3");
        graph.addEdge("3", "4");
        graph.addEdge("4", "1");

        graph.addEdge("6", "7");
        graph.addEdge("7", "6");

        System.out.println(graph.getCircles());
        System.out.println(graph.getCircularDependencyTable());
    }

    @Test
    public void testGetCircleDependency3() {
        Graph graph = new Graph();

        graph.addEdge("1", "2");
        graph.addEdge("2", "1");

        System.out.println(graph.getCircles());
        System.out.println(graph.getSortedResult());
        System.out.println(graph.getCircularDependencyTable());
    }

    @Test
    public void testCircleDependency4() {
        Graph graph = new Graph();

        graph.addEdge("18", "17");
        graph.addEdge("17", "18");
        graph.addEdge("20", "18");

        System.out.println(graph.getCircles());
        System.out.println(graph.getCircularDependencyTable());
    }

    @Test
    public void testCircleDependency5() {
        Graph graph = new Graph();

        graph.addEdge("7", "6");
        graph.addEdge("6", "7");
        graph.addEdge("13", "6");
        graph.addEdge("13", "7");
        graph.addEdge("17", "13");
        graph.addEdge("17", "18");
        graph.addEdge("18", "17");

        System.out.println(graph.getCircles());
        System.out.println(graph.getCircularDependencyTable());
    }

    @Test
    public void testNoCircleDependency() {
        Graph graph = new Graph();

        graph.addEdge("1", "2");
        graph.addEdge("1", "5");
        graph.addEdge("2", "3");
        graph.addEdge("5", "3");
        graph.addEdge("3", "4");

        System.out.println(graph.getCircles());
        System.out.println(graph.getSortedResult());
    }
}
