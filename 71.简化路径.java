import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=71 lang=java
 *
 * [71] 简化路径
 */
class Solution {

    public String simplifyPath(String path) {
        Stack<String> s = new Stack<>();
        for (String p : path.split("/")) {
            if (p.isEmpty() || ".".equals(p)) continue;
            if ("..".equals(p)) {
                if (!s.isEmpty()) s.pop();
            } else s.push(p);
        }
        return "/" + String.join("/", s);
    }
    //cannot cover /... case  --> /...  
    //i dont know
    public String simplifyPath_1(String path) {
        List<String> list = new LinkedList<>();
        for (int index = 0; index < path.length(); index++) {
            if (path.charAt(index) != '/') {
                if (path.charAt(index) == '.') {
                    if (index + 1 != path.length() && path.charAt(index + 1) == '.') {// ..
                        if (!list.isEmpty()) {
                            list.remove(list.size() - 1);
                        }
                    }
                } else {//not . or /
                    int begin=index;
                    index++;
                    while(index!=path.length()&&path.charAt(index)!='.'&&path.charAt(index)!='/'){
                        index++;
                    }
                    String temp=path.substring(begin,index);
                    list.add(temp);
                }
            }
        }

        StringBuffer result = new StringBuffer();
        for (int i = 0; i < list.size(); i++) {
            result.append("/");
            result.append(list.get(i));
        }
        if (result.toString().equals("")) {
            result.append("/");
        }
        return result.toString();
    }
}
