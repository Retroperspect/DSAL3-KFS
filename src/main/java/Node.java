import java.util.ArrayList;

public class Node {

    public ArrayList<String> connectedNodes;

    public String name;

    public int duration;

    public int earliestStart;

    public int earliestFinish;

    public int latestStart;

    public int latestFinish;

    public int totalFloat;

    public Node(int duration, String name)
    {
        connectedNodes = new ArrayList<String>();
        this.duration = duration;
        this.name = name;
    }

    public void AddConnection(String node)
    {
        connectedNodes.add(node);
    }
}
