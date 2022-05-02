package leetcode.array;

public class LC26JAVA {
    int removeDuplicates(int[] nums) {
        int i = 1;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i - 1]) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 4, 4, 5};
        new LC26JAVA().removeDuplicates(nums);
        System.out.println(nums);
    }
}
