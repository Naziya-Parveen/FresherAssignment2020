package nuclei_assignment_3;

import java.util.*;

import Exception.NodeDoesNotExistException;
import Graph.Node;
import Graph.graph;



public class assignment_3 {
	
	static Scanner sc = new Scanner(System.in);
	static graph gra = new graph();
	
	public static void showMenu() {
		System.out.println("---Choose from the following menu---");
		System.out.println("1. Immediate Parents of a Node");
		System.out.println("2. Immediate Children of a Node");
		System.out.println("3. Ancestors of a Node");
		System.out.println("4. Descendants of a Node");
		System.out.println("5. Delete a Dependency");
		System.out.println("6. Delete a Node");
		System.out.println("7. Add a New Dependency");
		System.out.println("8. Add a new Node");
		System.out.println("9. See All Nodes ");
		System.out.println("10. Exit");
	}
	
	static void printList(List<Node> list) {
		System.out.println("[");
		for(Node node: list) {
			System.out.println(" " + node.getNode_Id()+ " ");
		}
		System.out.println("]");
	}
	
	private static void performAction(int option) {
		int id;
		switch(option) {
		case 1:
			System.out.println("Enter the id:");
			List<Node> immediateParents = null;
			id = sc.nextInt();
			try {
				immediateParents = graph.getImmediateParents(id);
			} catch (NodeDoesNotExistException e) {
				System.out.println("Node doesn't Exist");
			}
			if(immediateParents!=null)
			printList(immediateParents);
			break;
		case 2:
			System.out.println("Enter the id:");
			List<Node> immediateChildren = null;
			id = sc.nextInt();
			try {
				immediateChildren = graph.getImmediateParents(id);
			} catch (NodeDoesNotExistException e) {
				System.out.println("Node doesn't Exist");
			}
			if(immediateChildren!=null)
			printList(immediateChildren);
			break;
		case 3:
			System.out.println("Enter the id:");
			List<Node> ancestors = null;
			id = sc.nextInt();
			try {
				ancestors = graph.getAncestors(id);
			} catch (Exception e) {
				System.out.println("Node doesn't Exist");
			}
			if(ancestors!=null)
			printList(ancestors);
			break;
		case 4:
			System.out.println("Enter the id:");
			List<Node> decendants = null;
			id = sc.nextInt();
			try {
				decendants = graph.getAncestors(id);
			} catch (Exception e) {
				System.out.println("Node doesn't Exist");
			}
			if(decendants!=null)
			printList(decendants);
			break;
			
		case 5:
			System.out.println("Enter two ids");
			int id1 = sc.nextInt();
			int id2 = sc.nextInt();
			try {
				graph.deleteDependency(id1, id2);
			} catch (Exception e) {
				System.out.println("Node does not exist");
			}
			break;
			
		case 6:
			System.out.println("Enter the id");
			id = sc.nextInt();
			try {
				graph.deleteNode(id);
			} catch (Exception e) {
				System.out.println("Node does not exist");
			}
			break;
			
		case 7:
			System.out.println("Enter the 2 ids");
			id1 = sc.nextInt();
			id2 = sc.nextInt();
			try {
				graph.addDependency(id1, id2);
			} catch (Exception e) {
				System.out.println("Dependency already exist");
			}
			break;
			
		case 8:
			System.out.println("Enter node id : ");
			id = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter name of the node : ");
			String name = sc.nextLine();
			graph.createNode(id, name);
			break;
			
		case 9:
			List<String> allNodes= graph.getAllNodes();
			for(String node: allNodes) {
				System.out.println(node);
			}
			break;
			
		case 10:
			break;
			
		default:
			System.out.println("Invalid Choice Please Try Again");
		}
	}
	
	public static void main(String args[]) {
		while(true) {
			showMenu();
			int option = -1;
			try {
				option = sc.nextInt();
				performAction(option);
			} catch (Exception e) {
				System.out.println("Not an Integer");
			}
			if(option==10) break;
		}
	}
	
}
