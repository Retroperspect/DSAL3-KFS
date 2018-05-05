import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class Main {

    Node node;


    public Main()
    {
        /*
        node = new Node(10,"A");
        node.AddConnection(new Node(20,"B"));
        node.connectedNodes.get(0).AddConnection(new Node(5,"C"));
        node.connectedNodes.get(0).connectedNodes.get(0).AddConnection(new Node(10,"D"));
        node.connectedNodes.get(0).connectedNodes.get(0).connectedNodes.get(0).AddConnection(new Node(20,"E"));
        node.AddConnection(new Node(15,"F"));
        node.connectedNodes.get(1).AddConnection(new Node(5,"G"));
        node.connectedNodes.get(0).connectedNodes.get(0).AddConnection(node.connectedNodes.get(1).connectedNodes.get(0));
        node.connectedNodes.get(1).connectedNodes.get(0).AddConnection(node.connectedNodes.get(0).connectedNodes.get(0).connectedNodes.get(0).connectedNodes.get(0));
        node.AddConnection(new Node(15,"H"));
        node.connectedNodes.get(2).AddConnection(node.connectedNodes.get(0).connectedNodes.get(0).connectedNodes.get(0).connectedNodes.get(0));
        CalculateEarlyTime(node);
        PrintGraph(node);
    }

    public void CalculateEarlyTime(Node node)
    {
        node.earliestFinish += node.duration + node.earliestStart;
        node.earliestStart += node.earliestFinish - node.duration + 1;
        for (Node item: node.connectedNodes) {
            CalculateEarlyTime(item);
        }
    }

    public void PrintGraph(Node node)
    {
        System.out.print("Name: " + node.name + ". Duration: " + node.duration + ". Earliest Start: " + node.earliestStart + ". Earliest Finish: " + node.earliestFinish
                + ". Latest Start: " + node.latestStart + ". Latest Finish: " + node.latestFinish + ". Connected nodes Size: " + node.connectedNodes.size());
        for (Node item: node.connectedNodes
             ) {
            System.out.print("Name: " + item.name + ". Duration: " + item.duration + ". Earliest Start: " + item.earliestStart + ". Earliest Finish: " + item.earliestFinish
                    + ". Latest Start: " + item.latestStart + ". Latest Finish: " + item.latestFinish + ". Connected nodes Size: " + item.connectedNodes.size());
        }
        */
    }
}
