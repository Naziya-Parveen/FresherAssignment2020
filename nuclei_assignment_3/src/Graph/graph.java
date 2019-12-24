package Graph;
import java.util.*; 

import java.util.StringJoiner;

import Exception.NodeDoesNotExistException;

final public class graph {
	
	static HashMap<Integer, Node> nodes = new HashMap<Integer, Node>();
		
	
    public static void addDependency(int nodeId1, int nodeId2) {
        Node firstNode = null;
        Node afterNode = null;
        if (nodes.containsKey(nodeId1)) {
            firstNode = nodes.get(nodeId1);
        } else {
        	System.out.println("Node does not exist");          
        }
        
        if (nodes.containsKey(nodeId2)) {
            afterNode = nodes.get(nodeId2);
        } else {
        	System.out.println("Node does not exist");           
        }
        
        List<Node> descendants = getDescendants(nodeId1);
        for(Node d: descendants) {
        	if(d.getNode_Id()==nodeId2) 
        		System.out.println("Dependencies already exist. The Graph will become Cyclic!");
        }
        
        firstNode.addOutgoingNode(afterNode);
        afterNode.addIncomingNode(firstNode);
    }

    public static List<Node> getImmediateParents(int nodeId) throws NodeDoesNotExistException{
    	Node node = null;
    	node = nodes.get(nodeId);
    	if(node!=null) return node.getIncomingNodes();
    	else {
    		throw new NodeDoesNotExistException("node does not exist");
    	}
    }
    
    public List<Node> getImmediateChildren(int nodeId) throws NodeDoesNotExistException {
    	Node node = null;
    	node = nodes.get(nodeId);
    	if(node!=null) return node.getOutgoingNodes();
    	else {
    		throw new NodeDoesNotExistException("node does not exist");
    	}
    }
    
    public static List<Node> getAncestors(int nodeId){
    	Node node = null;
    	List<Node> ancestors = new ArrayList<>();;
    	node = nodes.get(nodeId);
    	if(node==null) {} 
    	Queue<Node> q = new LinkedList<>();
    	q.add(node);
    	while(!q.isEmpty()){
    		Node tempNode = q.peek(); 
    		q.remove();
    		if(tempNode.getIncomingNodes().size()!=0) {
    			ancestors.addAll(tempNode.getIncomingNodes());
    			q.addAll(tempNode.getIncomingNodes());
    		}
    	}
    	return ancestors;
    }
    
    public static List<Node> getDescendants(int nodeId){
    	Node node = null;
    	List<Node> descendants = new ArrayList<>();;
    	node = nodes.get(nodeId);
    	if(node==null) {} 
    	Queue<Node> q = new LinkedList<>();
    	q.add(node);
    	while(!q.isEmpty()){
    		Node tempNode = q.peek(); 
    		q.remove();
    		if(tempNode.getOutgoingNodes().size()!=0) {
    			descendants.addAll(tempNode.getOutgoingNodes());
    			q.addAll(tempNode.getOutgoingNodes());
    		}
    	}
    	return descendants;
    }
    
    public static void deleteDependency(int nodeId1, int nodeId2) {
    	Node node1 = null;
    	node1 = nodes.get(nodeId1);
    	Node node2 = null;
    	node2 =	nodes.get(nodeId2);
    	if(node1==null || node2 ==null) {
    		System.out.println("Enter valid node id");
    	}
    	node1.getOutgoingNodes().remove(nodeId2);
    	node2.getIncomingNodes().remove(nodeId1);
    }
    
    public static Node createNode(int node_id, String node_name) {
        Node node = new Node();
        node.node_name = node_name;
        node.node_id = node_id;
        nodes.put(node_id, node);
        return node;
    }
    
    public static void deleteNode(int nodeId) {
    	Node node = null;
    	node = nodes.get(nodeId);
    	if(node==null) {}
    	else {
    		for(Integer key: nodes.keySet()) {
    			Node tempNode = nodes.get(key);
    			
    			List<Node> IncomingNodes = tempNode.getIncomingNodes();
    			if(IncomingNodes!=null && IncomingNodes.contains(node)) IncomingNodes.remove(node);
    			tempNode.setIncomingNodes(IncomingNodes);
    			
    			List<Node> OutgoingNodes = tempNode.getOutgoingNodes();
    			if(OutgoingNodes!=null &&  OutgoingNodes.contains(node)) OutgoingNodes.remove(node);
    			tempNode.setIncomingNodes(OutgoingNodes);
    		}
    		nodes.remove(nodeId, node);
    	}
    }
    
    public static List<String> getAllNodes(){
		 List<String> allNodes = new ArrayList<>();
	   	 nodes.entrySet().forEach(entry->{
	   		    allNodes.add(entry.getKey() + "  [" + getListString(entry.getValue().getIncomingNodes()) + "]   ["
	   		    		+ getListString(entry.getValue().getOutgoingNodes()) + "]");  
	   		 });
	   	 return allNodes;
	    }
	   
	    public static String getListString(List<Node> list){
	    	StringJoiner joiner = new StringJoiner(",");
	    	for (Node item : list) {
	    		joiner.add(item.getNode_name().toString());
	    	}
	    	return joiner.toString();
	    }
	   
}