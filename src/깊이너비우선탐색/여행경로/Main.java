package 깊이너비우선탐색.여행경로;

import java.util.*;

//https://school.programmers.co.kr/learn/courses/30/lessons/43164
public class Main
{
    public static void main(String[] args)
    {
//        Solution.solution(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"},{"ATL", "ICN"}, {"ATL","SFO"}});
//        Solution.solution(new String[][]{{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}});
        Solution.solution(new String[][]{{"ICN", "BOO"}, {"ICN", "COO"},{"COO", "ICN"}, {"BOO", "DOO"}});
        // -> ICN - BOO COO     ICN -> COO ICN
        // -> COO - ICN
        // -> BOO - DOO
    }
}
class Solution {
    static boolean[] visited;
    static ArrayList<String> allRoute;

    public static String[]  solution(String[][] tickets) {
        String[] answer = {};
        int cnt = 0;
        visited = new boolean[tickets.length];
        allRoute = new ArrayList<>();

        dfs("ICN", "ICN", tickets, cnt);

        Collections.sort(allRoute);
        answer = allRoute.get(0).split(" ");

        return answer;
    }

    // start : 출발  route : 경로
    public static void dfs(String start, String route, String[][] tickets, int cnt){
        if(cnt == tickets.length){ // 모든 티켓 사용
            allRoute.add(route); // 모든 경로 저장
            return;
        }

        for(int i=0; i<tickets.length; i++){ // 모든 티켓 순회
            if(start.equals(tickets[i][0]) && !visited[i]){ // start==목적지 && 방문 안했으면
                visited[i] = true;
                dfs(tickets[i][1], route+" "+tickets[i][1], tickets, cnt+1);//목적지 넣고, 현재 방문된 경로 넣고
                visited[i] = false;
            }
        }
    }

}
/*
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
}*/
