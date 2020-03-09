package sps2plc.core.utils;

import java.util.*;

public class Graph {

    private final Map<String, List<String>> graph;
    private final Map<String, Integer> inDegree;
    private final List<String> sortedResult;
    private final List<List<String>> circles;

    // example: {1: 2, 3} means 2 and 3 are dependent on 1
    private final Map<String, List<String>> circularDependencyTable;
    private static final int MAX_LOOP = 200;

    public Graph() {
        graph = new HashMap<>();
        inDegree = new LinkedHashMap<>();
        sortedResult = new ArrayList<>();
        circles = new ArrayList<>();
        circularDependencyTable = new HashMap<>();
    }

    public List<String> getSortedResult() { return sortedResult; }

    public void addEdge(String src, String tar) {
        graph.putIfAbsent(src, new ArrayList<>());
        graph.get(src).add(tar);
        inDegree.putIfAbsent(src, 0);

        if (inDegree.get(tar) == null) {
            inDegree.put(tar, 1);
        } else {
            inDegree.replace(tar, inDegree.get(tar) + 1);
        }
    }

    public void addNode(String node) {
        graph.putIfAbsent(node, new ArrayList<>());
        inDegree.putIfAbsent(node, 0);
    }


    public void topologicalSort() {
        int safeCounter = 0;

        while (true) {
            safeCounter++;
            if (safeCounter > MAX_LOOP) throw new RuntimeException("Loop exceeds the limit.");

            boolean terminate = true;
            for (Map.Entry<String, Integer> entry: inDegree.entrySet()) {
                if (entry.getValue() == 0) {
                    terminate = false;
                    sortedResult.add(entry.getKey());
                    entry.setValue(-1);
                    if (graph.get(entry.getKey()) != null) {
                        for (String tar : graph.get(entry.getKey())) {
                            inDegree.replace(tar, inDegree.get(tar) - 1);
                        }
                    }
                }
            }
            if (terminate) break;
        }

    }

    public List<List<String>> getCircles() {
        topologicalSort();


        // visited：每一个节点对应的三种状态：null代表未访问;true代表第一次访问该节点;false代表该节点以及该节点的所有子节点都已访问
        Map<String, Boolean> visited = new HashMap<>();

        Map<String, String> father = new HashMap<>();
        for (Map.Entry<String, Integer> entry: inDegree.entrySet()) {
            if (entry.getValue() != -1 && visited.get(entry.getKey()) == null) {
                getCircleNodes(entry.getKey(), visited, father);
            }
        }

        return circles;
    }

    private void getCircleNodes(String node, Map<String, Boolean> visited, Map<String, String> father) {

        visited.put(node, true);
        if (graph.get(node) != null) {
            for (String child : graph.get(node)) {
                if (visited.get(child) != null && visited.get(child)) {
                    String tmp = node;
                    List<String> circle = new ArrayList<>();

                    while (!tmp.equals(child)) {
                        circle.add(tmp);
                        tmp = father.get(tmp);
                    }
                    circle.add(tmp);
                    circle.sort((a, b) -> Integer.parseInt(a) < Integer.parseInt(b) ? -1 : 1);
                    circles.add(circle);
                } else if (visited.get(child) == null) {
                    father.put(child, node);
                    getCircleNodes(child, visited, father);
                }
            }
        }
        visited.replace(node, false);
    }

    public Map<String, List<String>> getCircularDependencyTable() {
        for (List<String> circle: circles) {
            for (String node: circle) {
                for (String child: graph.get(node)) {
                    if (circle.contains(child)) {
                        if (circularDependencyTable.get(node) == null) {
                            circularDependencyTable.put(node, new ArrayList<>(Collections.singleton(child)));
                        } else if (!circularDependencyTable.get(node).contains(child)) {
                            circularDependencyTable.get(node).add(child);
                        }
                    }
                }
            }
        }

        return circularDependencyTable;
    }

}
