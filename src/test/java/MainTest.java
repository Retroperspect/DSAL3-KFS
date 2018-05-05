import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    Node node;
    ArrayList<Node> list = new ArrayList<Node>();

    @Test
    void main() throws Exception {
        node = new Node(10,"A");
        node.AddConnection("B");
        node.AddConnection("F");
        node.AddConnection("H");
        list.add(node);

        node = new Node(20,"B");
        node.AddConnection("C");
        list.add(node);

        node = new Node(5,"C");
        node.AddConnection("D");
        node.AddConnection("G");
        list.add(node);

        node = new Node(10,"D");
        node.AddConnection("E");
        list.add(node);

        node = new Node(20,"E");
        list.add(node);

        node = new Node(15,"F");
        node.AddConnection("G");
        list.add(node);

        node = new Node(5,"G");
        node.AddConnection("E");
        list.add(node);

        node = new Node(15,"H");
        node.AddConnection("E");
        list.add(node);

        //FIX LOGIC
        node = navigateGraph(list.get(0),"E");

        calculateEarly(list.get(list.indexOf(getNode("A"))),0);
        calculateLatest(list.get(list.indexOf(getNode("A"))));
        totalFloats();
        ArrayList<String> path = new ArrayList<String>();
        path = calculateCriticalPath(path,list.get(list.indexOf(getNode("A"))),"E");
        for (String item: path
             ) {
            System.out.print(item + "\n");
        }
        printGraph();
    }

    Node navigateGraph(Node start, String end) throws Exception {
        for (String item: start.connectedNodes
             ) {
            if (item == end)
            {
                System.out.print("FOUND IT from " + item + "\n");
                return getNode(item);
            }
            else
            {
                System.out.print("start node: " + start.name + ", TargetNode: " + item + "\n");
                navigateGraph(getNode(item), end);
            }
        }
        return start;
    }

    Node getNode(String node) throws Exception {
        for (Node item: list
             ) {
            if (item.name == node)
            {
                return item;
            }
        }
        throw new Exception();
    }

    void calculateEarly(Node start, int pf) throws Exception {
        if (start.earliestStart <= pf)
        {
            list.get(list.indexOf(start)).earliestStart = pf + 1;
            list.get(list.indexOf(start)).earliestFinish = pf + list.get(list.indexOf(start)).duration;
            for (String item: start.connectedNodes
                ) {
            calculateEarly(list.get(list.indexOf(getNode(item))),list.get(list.indexOf(start)).earliestFinish);
        }
        }
    }

    void calculateLatest(Node next) throws Exception {
        for (String item: next.connectedNodes
                ) {
            calculateLatest(list.get(list.indexOf(getNode(item))));
        }
        if (list.get(list.indexOf(next)).connectedNodes.size() == 0)
        {
            list.get(list.indexOf(next)).latestStart = list.get(list.indexOf(next)).earliestStart;
            list.get(list.indexOf(next)).latestFinish = list.get(list.indexOf(next)).earliestFinish;
        }
        else {
            int i = 100;
            for (String s: list.get(list.indexOf(next)).connectedNodes
                    ) {
                if (getNode(s).latestStart <= i)
                {
                    i = getNode(s).latestStart;
                }
            }
            list.get(list.indexOf(next)).latestFinish = i - 1;
            list.get(list.indexOf(next)).latestStart = list.get(list.indexOf(next)).latestFinish - list.get(list.indexOf(next)).duration + 1;
        }
    }

    void totalFloats()
    {
        for (Node item: list
             ) {
            item.totalFloat = item.latestStart - item.earliestStart;
        }
    }

    ArrayList<String> calculateCriticalPath(ArrayList<String> path, Node node, String target) throws Exception {
        ArrayList<String> path2 = new ArrayList<String>();
        path.add(node.name);
        for (String item: node.connectedNodes
             ) {
            if (list.get(list.indexOf(getNode(item))).totalFloat == 0)
            {
                //path.add(list.get(list.indexOf(getNode(item))).name);
                path2 = calculateCriticalPath(path,list.get(list.indexOf(getNode(item))),target);
            }

        }
        if (node.name == target)
        {
            return path;
        }
        else return path2;
    }

    void printGraph()
    {
        for (Node item: list
             ) {
            System.out.print("Name: " + item.name + ". Duration: " + item.duration + ". Earliest Start: " + item.earliestStart + ". Earliest Finish: " + item.earliestFinish
                    + ". Latest Start: " + item.latestStart + ". Latest Finish: " + item.latestFinish +
                    ". Connected nodes Size: " + item.connectedNodes.size() + ". Total Floats: " + item.totalFloat + "\n");
        }
    }
}