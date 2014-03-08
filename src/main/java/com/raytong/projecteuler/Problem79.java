package com.raytong.projecteuler;

import java.io.File;
import java.util.*;

public class Problem79 {
    public static void main(String[] args) throws Exception {
        Integer[] keyLogs = new Integer[50];
        int counter = 0;
        Scanner scanner = new Scanner(new File("keylog.txt"));
        while (scanner.hasNextInt()) {
            keyLogs[counter++] = scanner.nextInt();
        }
        scanner.close();
        List<Integer> keyList = Arrays.asList(keyLogs);
        Collections.sort(keyList);
        Integer lastKey = null;
        Map<Integer, Node> nodeMap = new HashMap<Integer, Node>(){{
           put(1, new Node(1)); 
           put(2, new Node(2));
           put(3, new Node(3));
           put(4, new Node(4));
           put(5, new Node(5));
           put(6, new Node(6));
           put(7, new Node(7));
           put(8, new Node(8));
           put(9, new Node(9));
           put(0, new Node(0));
        }};
        Node firstNode = null;
        for (int i=0; i<keyList.size(); i++) {
            Integer currentKey = keyList.get(i);
            if (currentKey.equals(lastKey)) {
                continue;
            }
            int key1 =  currentKey / 100;
            int key2 = (currentKey - key1 * 100) / 10;
            int key3 = currentKey % 10;
            
            Node key1Node = nodeMap.get(key1);
            Node key2Node = nodeMap.get(key2);
            Node key3Node = nodeMap.get(key3);
            
            if (currentKey == 316) {
                currentKey = 316;
            }
            
            // update the first key
            if (firstNode == null || firstNode == key2Node || firstNode == key3Node) {
                firstNode = key1Node;
            }
            // key2 not found in previous key1 descendant
            if (key1Node.getDescendantLevel(key2Node) == -1) {
                if (firstNode.getDescendantLevel(key2Node) != -1) {
                    firstNode.removeDescendant(key2Node);
                }
                key1Node.addChildNode(key2Node);
            }
            // key3 not found in previous key2 descendant
            if (key2Node.getDescendantLevel(key3Node) == -1) {
                // key3 not found in previous key1 descendant
                if (key1Node.getDescendantLevel(key3Node) == -1) {
                    key2Node.addChildNode(key3Node);
                } else {
                    int key3Level = key1Node.getDescendantLevel(key3Node);
                    if (key3Level < 3) {
                        key1Node.removeDescendant(key3Node);
                        key2Node.addChildNode(key3Node);                        
                    }
                }
            }
            
            lastKey = currentKey;
            //System.out.println(key1Node.getPath());
            System.out.print(currentKey + "->");
            firstNode.printChain();
        }
        /*
        int maxLength = -1;
        Node topNode = null;
        Set<Integer> nodeKeySet = nodeMap.keySet();
        Iterator<Integer> nodeKeyIterator = nodeKeySet.iterator();
        while (nodeKeyIterator.hasNext()) {
            Node node = nodeMap.get(nodeKeyIterator.next());
            int length = node.getLength();
            if (length > maxLength) {
                maxLength = length;
                topNode = node;
            }
        }
        */
        System.out.println(firstNode.getPath());
    }
}

class Node {
    int value;
    List<Node> childNodeList;
    Node(int value) {
        this.value = value;
        this.childNodeList = new ArrayList<Node>();
    }
    
    public int getValue() {
        return value;
    }
    public void setValue(int value) {
        this.value = value;
    }
    public List<Node> getChildNodeList() {
        return childNodeList;
    }
    public void setChildNodeList(List<Node> childNodeList) {
        this.childNodeList = childNodeList;
    }
    public void addChildNode(Node childNode) {
        this.childNodeList.add(childNode);
    }
    public void removeDescendant(Node node) {
        if (childNodeList.contains(node)) {
            childNodeList.remove(node);
        } else {
            for (Node childNode : childNodeList) {
                childNode.removeDescendant(node);
            }
        }
    }
    public List<Node> getDescendant() {
        List<Node> descendantList = new ArrayList<Node>();
        descendantList.addAll(childNodeList);
        for (Node childNode : childNodeList) {
            descendantList.addAll(childNode.getDescendant());
        }
        return descendantList;
    }
    
    public boolean hasDescendant(Node node) {
        return getDescendant().contains(node);
    }
    
    public int getDescendantLevel(Node node) {
        if (childNodeList.contains(node)) {
            return 1;
        }
        for (Node childNode : childNodeList) {
            int deepLevel = childNode.getDescendantLevel(node);
            if (deepLevel != -1) {
                return 2;
            }
        }
        return -1;
    }
    
    public int getLength() {
        int length = 1;
        length += getDescendant().size();
        return length;
    }
    
    public String getPath() {
        StringBuilder sb = new StringBuilder();
        sb.append("[").append(value).append("]");
        if (childNodeList.size() > 0) {
            sb.append("->");
            for (Node childNode : childNodeList) {
                sb.append(childNode.getPath()).append(",");
            }
        }
        return sb.toString();
    }
    
    public void printChain() {
        printChain("");
        System.out.println();
    }
    
    public void printChain(String prefix) {
        if (childNodeList.size() == 0) {
            System.out.print(prefix + value + ",");
        } else {
            for (Node childNode : childNodeList) {
                childNode.printChain(prefix+value);
            }
        }
    }
}
