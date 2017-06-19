package idv.will.algorithm;

import java.util.ArrayList;
import java.util.List;

public class EightQueensPuzzle {

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> list = new ArrayList<>();
        List<StringBuilder> tmpList = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < n; j++) {
                sb.append(".");
            }
            tmpList.add(sb);
        }
        backtrack(n, list, tmpList, new Integer[]{0, 0});
        return list;
    }

    public void backtrack(int n, List<List<String>> list, List<StringBuilder> tmpList, Integer[] position) {
        int queensAmount = 0;
        for(StringBuilder sb: tmpList) {
            for(int i = 0; i < sb.length(); i++) {
                if(sb.charAt(i) == 'Q') {
                    queensAmount++;
                }
            }
        }
        if(queensAmount == n) {
            List<String> result  = new ArrayList<>();
            for(int i = 0; i < tmpList.size(); i++) {
                result.add(tmpList.get(i).toString());
            }
            list.add(result);
        } else {
            while(position != null) {
                if(isAvailable(position, tmpList)) {
                    tmpList.get(position[0]).replace(position[1], position[1]+1, "Q");
                    backtrack(n, list, tmpList, next(n, position));
                    tmpList.get(position[0]).replace(position[1], position[1]+1, ".");
                }
                position = next(n, position);
            }
        }
    }

    private Integer[] next(int n, Integer[] position) {
        if(position[1] < n-1) {
            return new Integer[]{position[0], position[1]+1};
        } else if (position[0] < n-1) {
            return new Integer[]{position[0]+1, 0};
        } else {
            return null;
        }
    }

    private boolean isAvailable(Integer[] position, List<StringBuilder> occupiedList) {
        for(int i = 0; i < occupiedList.size(); i++) {
            StringBuilder sb = occupiedList.get(i);
            for(int j = 0; j < sb.length(); j++) {
                if(sb.charAt(j) == 'Q') {
                    if(i == position[0]) {
                        return false;
                    } else if(j == position[1]) {
                        return false;
                    } else if (i + j == position[0] + position[1]) {
                        return false;
                    } else if (i - j == position[0] - position[1]) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        EightQueensPuzzle qp = new EightQueensPuzzle();
        List<List<String>> points = qp.solveNQueens(8);
        System.out.println(points);
    }
}