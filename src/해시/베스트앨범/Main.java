package 해시.베스트앨범;
//https://school.programmers.co.kr/learn/courses/30/lessons/42579?language=java

import java.util.*;
import java.util.stream.Collectors;


public class Main
{
    public static void main(String[] args) {
        Solution.solution(new String[] {"classic", "pop", "classic", "classic", "pop"}, new int[] {800, 600, 150, 800, 2500});
    }
}

class Solution {
    public static int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genreToTotalPlayMap = new HashMap<>();
        Map<String, List<int[]>> genreToSongsMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];

            genreToTotalPlayMap.put(genre, genreToTotalPlayMap.getOrDefault(genre, 0) + play);

            List<int[]> songs = genreToSongsMap.getOrDefault(genre, new ArrayList<>());
            songs.add(new int[] { i, play });
            genreToSongsMap.put(genre, songs);
        }

        List<String> genreList = new ArrayList<>(genreToTotalPlayMap.keySet());
        genreList.sort((g1, g2) -> genreToTotalPlayMap.get(g2) - genreToTotalPlayMap.get(g1));

        List<Integer> answerList = new ArrayList<>();
        for (String genre : genreList) {
            List<int[]> songs = genreToSongsMap.get(genre);
            songs.sort((s1, s2) -> s2[1] - s1[1]);

            int count = 0;
            for (int[] song : songs) {
                answerList.add(song[0]);
                count++;
                if (count == 2) {
                    break;
                }
            }
        }

        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }

        return answer;
    }
}
