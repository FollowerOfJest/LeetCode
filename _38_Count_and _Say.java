package LeetCode;


public class _38_Count_and_Say{

    public String countAndSay(int n) {
        String str = "1";
        for (int i = 2; i <= n; i++) {
            StringBuilder builder = new StringBuilder();
            char pre = str.charAt(0);
            int count = 1;
            //记录pre和出现的次数 11，那么pre=1，count=2，112到2的时候添加前边的21，然后重新开始计数2是12
            for (int j = 1; j < str.length(); j++) {
                char c = str.charAt(j);
                if (c == pre) {
                    count++;
                } else {
                    builder.append(count).append(pre);
                    pre = c;
                    count = 1;
                }
            }
            builder.append(count).append(pre);  //最后还要记得结束之后还有没添加的
            str = builder.toString();
        }

        return str;
    }
}