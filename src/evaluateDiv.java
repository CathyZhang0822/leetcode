import java.util.*;
public class evaluateDiv {
    /*
    Example:
    Given a / b = 2.0, b / c = 3.0.
    queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
    return [6.0, 0.5, -1.0, 1.0, -1.0 ].

    equations = [ ["a", "b"], ["b", "c"] ],
    values = [2.0, 3.0],
    queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].
    * */
    /*
    有weight的有向图！
    Image a/b = k as a link between node a and b, the weight from a to b is k, t
    he reverse link is 1/k. Query is to find a path between two nodes.
    * */
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        double[] res = new double[queries.length];
        // build graph and edge weights
        Map<String, ArrayList<String>> pairs = new HashMap<>();
        Map<String, ArrayList<Double>> valuesPair = new HashMap<>();
        for(int i = 0; i < equations.length; i++){
            String[] equation = equations[i];
            if(!pairs.containsKey(equation[0])){
                pairs.put(equation[0], new ArrayList<>());
                valuesPair.put(equation[0], new ArrayList<>());
            }
            if(!pairs.containsKey(equation[1])){
                pairs.put(equation[1], new ArrayList<>());
                valuesPair.put(equation[1], new ArrayList<>());
            }

            pairs.get(equation[0]).add(equation[1]);
            pairs.get(equation[1]).add(equation[0]);
            valuesPair.get(equation[0]).add(values[i]);
            valuesPair.get(equation[1]).add(1/values[i]);
        }
        // for each query, use dfs to find path
        for(int i = 0; i < queries.length; i++){
            String[] query = queries[i];
            res[i] = dfs(pairs,valuesPair,new HashSet<>(),query[0], query[1]);
            if(res[i] == 0.0) res[i] = 1.0;
        }

        return res;
    }

    private double dfs(Map<String, ArrayList<String>> pairs, Map<String, ArrayList<Double>> valuesPair,
                       Set<String> visited, String start, String end){
        // base cases
        if(visited.contains(start)) return 0.0; // invalid circle in it
        if(!pairs.keySet().contains(start) || !pairs.keySet().contains(end)) return 0.0;
        if(start.equals(end)) return  1.0;

        visited.add(start);

        List<String> children = pairs.get(start);
        List<Double> weights = valuesPair.get(start);
        for(int i = 0; i < children.size(); i++){
            double next = dfs(pairs, valuesPair,visited, children.get(i), end);
            if(next != 0.0) return weights.get(i)*next;
        }

        visited.remove(start);

        return 0.0;
    }
}
