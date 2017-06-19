package idv.will.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutation {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        Arrays.sort(nums);
        backtrack(list, new ArrayList<>(), nums);
        return list;
    }

    public void backtrack(List<List<Integer>> list, List<Integer> tmpList,  int[] nums) {
        if(tmpList.size() == nums.length) {
            list.add(new ArrayList<>(tmpList));
        } else {
            for(int i = 0; i < nums.length; i++) {
                if(tmpList.contains(nums[i])) {
                    continue;
                }
                tmpList.add(nums[i]);
                backtrack(list, tmpList, nums);
                tmpList.remove(tmpList.size() -1);
            }
        }
    }



    public static void main(String[] args) {
        Permutation permutation = new Permutation();
        System.out.println(permutation.permute(new int[]{1, 2, 3, 4}));
    }
}
