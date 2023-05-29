package 깊이너비우선탐색.여행경로;

import java.util.*;

//https://school.programmers.co.kr/learn/courses/30/lessons/43164
public class Main
{
    public static void main(String[] args)
    {
//        Solution.solution(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"},{"ATL", "ICN"}, {"ATL","SFO"}});
//        Solution.solution(new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}});
        Solution.solution(new String[][]{{"ICN", "COO"}, {"ICN", "BOO"},{"COO", "ICN"}, {"BOO", "DOO"}});
    }
}

class Solution {
    static Map<String, List<String>> map;
    static Map<String, List<Boolean>> checkMap;
    static List<String> answer = new ArrayList<>();

    public static String[] solution(String[][] tickets) {
        map = new HashMap<>();
        checkMap = new HashMap<>();

        for(int i=0; i<tickets.length; i++){

            List<String> ticketList = map.getOrDefault(tickets[i][0], new ArrayList<String>());
            ticketList.add(tickets[i][1]);

            List<Boolean> checkList = checkMap.getOrDefault(tickets[i][0], new ArrayList<Boolean>());
            checkList.add(false);


            map.put(tickets[i][0],ticketList);
            checkMap.put(tickets[i][0],checkList);
        }

        answer.add(tickets[0][0]);
        dfs(map.get("INC"));


        return answer.toArray(new String[0]);
    }

    private static void dfs(List<String> inc) {

    }
}