class Solution {
    public String largestNumber(int[] nums) {
        if (nums == null || nums.length == 0) {
        	return "";
        }
        String[] num_str = new String[nums.length];
        for (int i = 0; i < num_str.length; i++) {
        	num_str[i] = String.valueOf(nums[i]);
        }

        Comparator<String> comp = new Comparator<String>() {
        	public int compare(String str1, String str2) {
        		String s1 = str1 + str2;
        		String s2 = str2 + str1;
        		return s2.compareTo(s1);
        	}
        };

     	Arrays.sort(num_str, comp);

     	if(num_str[0].charAt(0) == '0')
        	return "0";
     	StringBuilder sb = new StringBuilder();
     	for (int i = 0; i < num_str.length; i++) {
     		sb.append(num_str[i]);
     	}
     	return sb.toString();
    }
}