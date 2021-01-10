import java.util.List;

import java.util.ArrayList;

/**
 * @program: 全排列
 * @description:
 * @author: Mr.Huang
 * @create: 2020-11-07 22:16
 **/
public class Solution {

    public static void main(String[] args) {
        new Solution().permute(new int[]{1, 2, 3});
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null) {
            return null;
        }
        if (nums.length == 0) {
            result.add(new ArrayList<Integer>());
            return result;
        }
        ArrayList<Integer> list = new ArrayList<>();
        dfs(result, nums, list);
        return result;
    }

    private void dfs(List<List<Integer>> result, int[] nums, ArrayList<Integer> list) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (list.contains(nums[i])) {
                continue;
            }
            list.add(nums[i]);
            dfs(result, nums, list);
            list.remove(list.size() - 1);
        }
    }
}
