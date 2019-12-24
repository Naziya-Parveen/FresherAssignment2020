package Graph;

import java.util.*;

public class Node {
	 	int node_id;
	 	String node_name;
	    private List<Node> IncomingNodes = new ArrayList<>();
	    private List<Node> OutgoingNodes = new ArrayList<>();


		public int getNode_Id() {
			return node_id;
		}

		public void setNode_Id(int node_id) {
			this.node_id = node_id;
		}
		
		public String getNode_name() {
			return node_name;
		}

		public void setNode_name(String node_name) {
			this.node_name = node_name;
		}

	    public void addIncomingNode(Node node) {
	        IncomingNodes.add(node);
	    }

	    public List<Node> getIncomingNodes() {
	        return IncomingNodes;
	    }
	    
	    public void setIncomingNodes(List<Node> IncomingNodes) {
			this.IncomingNodes = IncomingNodes;
		}
	    
	    public void addOutgoingNode(Node node) {
	        OutgoingNodes.add(node);
	    }	   
	    
	    public List<Node> getOutgoingNodes() {
	        return OutgoingNodes;
	    }
	    
		public void setOutgoingNodes(List<Node> OutgoingNodes) {
			this.OutgoingNodes = OutgoingNodes;
		}		
		
}