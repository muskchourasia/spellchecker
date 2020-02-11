import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

class Graph {
    private Map<Vertex, List<Vertex>> adjVertices;

    Graph() {
        this.adjVertices = new HashMap<Vertex, List<Vertex>>();
    }

    void addVertex(String label) {
        adjVertices.putIfAbsent(new Vertex(label), new ArrayList<>());
    }


    void addEdge(String label1, String label2) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        adjVertices.get(v1).add(v2);
        adjVertices.get(v2).add(v1);
    }


    List<Vertex> getAdjVertices(String label) {
        return adjVertices.get(new Vertex(label));
    }
    
    class Vertex {
        String label;
        Vertex(String label) {
            this.label = label;
        }
        
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + getOuterType().hashCode();
            result = prime * result + ((label == null) ? 0 : label.hashCode());
            return result;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Vertex other = (Vertex) obj;
            if (!getOuterType().equals(other.getOuterType()))
                return false;
            if (label == null) {
                if (other.label != null)
                    return false;
            } else if (!label.equals(other.label))
                return false;
            return true;
        }

        @Override
        public String toString() {
            return label;
        }


        private Graph getOuterType() {
            return Graph.this;
        }
    }
    Set<String> dfs(Graph graph,String root){
        Set<String> visited = new LinkedHashSet<String>();
        Stack<String> stack = new Stack<String>();
        stack.push(root);
        while (!stack.isEmpty()) {
            String vertex = stack.pop();
            if (!visited.contains(vertex)) {
                visited.add(vertex);
                for (Vertex v : graph.getAdjVertices(vertex)) {              
                    stack.push(v.label);
                }
            }
        }
        return visited;
    }
    
    }

public class Graph1{
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Graph graph = new Graph();
        graph.addVertex("root");
        graph.addVertex("the");
        graph.addVertex("m");
        graph.addVertex("ir");
        graph.addVertex("y");
        graph.addVertex("re");
        graph.addVertex("box");
        graph.addVertex("ed");
        graph.addVertex("er");
        graph.addVertex("ing");
        graph.addVertex("es");
        graph.addVertex("any");
        graph.addVertex("way");
        graph.addVertex("ways");
        graph.addVertex("one");
        graph.addVertex("I");
        graph.addVertex("am");
        graph.addVertex("and");
        graph.addVertex("is");
        graph.addEdge("root", "I");
        graph.addEdge("root", "is");
        graph.addEdge("root", "and");
        graph.addEdge("root", "am");
        graph.addEdge("root", "the");
        graph.addEdge("root", "box");
        graph.addEdge("root", "any");
        graph.addEdge("the", "m");
        graph.addEdge("the", "ir");
        graph.addEdge("the", "y");
        graph.addEdge("the", "re");
        graph.addEdge("box", "ed");
        graph.addEdge("box", "er");
        graph.addEdge("box", "ing");
        graph.addEdge("box", "es");
        graph.addEdge("any", "ways");
        graph.addEdge("any", "way");
        graph.addEdge("any", "one");

        //graph.printGraph();
        int k=4;
        while(k>0){
            System.out.println("test case-"+(5-k));
            System.out.println("enter string");
            String str=sc.nextLine();
            String toSearch[]=str.split(" ");
            String n;
            int i=0,count=0;
            for(i=0;i<toSearch.length;i++){
                n=toSearch[i];
                //System.out.println(n);
                Set<String> s;
                String a="",r="";
                if(n.length()>2){
                    a=a+n.charAt(0)+n.charAt(1)+n.charAt(2);
                    if(n.length()==3){
                        s=graph.dfs(graph, "root");
                        if(!s.contains(a)){
                            System.out.println("Invalid word --> "+a);
                            count++;
                        }
                    }
                    else{  
                        s=graph.dfs(graph, "root");
                    if(!s.contains(a)){
                        System.out.println("Invalid word --> "+a+r);
                        count++;
                    }
                    else if(s.contains(a)){
                        for(int j=3;j<n.length();j++){
                            r=r+n.charAt(j);
                            
                        }
                        if(!s.contains(r)){
                            System.out.println("Invalid word -->"+a+r);
                            count++;
                        }
                    }
                    }
                    
            
                }
                
                else{
                    a=n;
                    s=graph.dfs(graph, "root");
                    if(!s.contains(a)){
                        System.out.println("Invalid word --> "+a);
                        count++;
                    }
                }
            }
           if(count==0){
               System.out.println("Valid sentence");
           } 
           k--;
        }
        
        
    }
}