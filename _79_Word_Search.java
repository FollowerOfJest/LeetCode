package LeetCode;

/**
 * Created by 54359 on 2017/7/11.
 */
public class _79_Word_Search {
    //写了好多遍
    public static boolean exist(char[][] board, String word) {
        int hang=board.length;
        if(hang==0) return false;
        int lie=board[0].length;
        if(lie==0) return false;
        char[] temp=word.toCharArray();
        int word_length=temp.length;
        int cnt;
        int[][] zhanju=new int[hang][lie];

        for(int x=0;x<hang;x++){
            for (int y=0;y<lie;y++){
                if(board[x][y]==temp[0]){   //这里你要考虑，如果这里不是的话，那在最后要把这个zhanju清0
                    cnt=1;
                    zhanju[x][y]=1;
                    if(cnt==word_length){
                        return true;//字符串长度为1
                    }else{
                        if(x>0 && board[x-1][y]==temp[1]){//上
                            zhanju[x-1][y]=1;
                            cnt=recursion(board,temp,x-1,y,word_length,2,zhanju,hang,lie);
                            if(cnt==word_length) return true;
                            else zhanju[x-1][y]=0;  //这里你要考虑，如果这里不是的话，那在最后要把这个zhanju清0
                        }
                        if(x<hang-1 &&board[x+1][y]==temp[1]){//下
                            zhanju[x+1][y]=1;
                            cnt=recursion(board,temp,x+1,y,word_length,2,zhanju,hang,lie);
                            if(cnt==word_length) return true;
                            else zhanju[x+1][y]=0;  //这里你要考虑，如果这里不是的话，那在最后要把这个zhanju清0
                        }
                        if(y>0 && board[x][y-1]==temp[1]){//左
                            zhanju[x][y-1]=1;
                            cnt=recursion(board,temp,x,y-1,word_length,2,zhanju,hang,lie);
                            if(cnt==word_length) return true;
                            else zhanju[x][y-1]=0;  //这里你要考虑，如果这里不是的话，那在最后要把这个zhanju清0
                        }
                        if(y<lie-1 && board[x][y+1]==temp[1]){//右
                            zhanju[x][y+1]=1;
                            cnt=recursion(board,temp,x,y+1,word_length,2,zhanju,hang,lie);
                            if(cnt==word_length) return true;
                            else zhanju[x][y+1]=0;  //这里你要考虑，如果这里不是的话，那在最后要把这个zhanju清0
                        }
                    }
                    zhanju[x][y]=0; //zhanju清0
                }
            }
        }

        return false;
    }

    public static int recursion(char[][] board,char[] temp,int x,int y,int word_length,int cnt,int[][] zhanju,int hang,int lie){
        int cnt_temp=cnt;
        if(cnt_temp==word_length) return cnt_temp;
        if(x>0 && board[x-1][y]==temp[cnt] && zhanju[x-1][y]!=1){
            zhanju[x-1][y]=1;
            cnt_temp=recursion(board,temp,x-1,y,word_length,cnt+1,zhanju,hang,lie);
            if(cnt_temp==word_length) return cnt_temp;
            else zhanju[x-1][y]=0;  //如果沿着某条路径最开始走得通，但是后来走不通了，说明要把这些路径的zhanju都恢复0，那判断依据就是cnt_temp
        }
        if(x<hang-1 && board[x+1][y]==temp[cnt] && zhanju[x+1][y]!=1){
            zhanju[x+1][y]=1;
            cnt_temp=recursion(board,temp,x+1,y,word_length,cnt+1,zhanju,hang,lie);
            if(cnt_temp==word_length) return cnt_temp;
            else zhanju[x+1][y]=0;  //如果沿着某条路径最开始走得通，但是后来走不通了，说明要把这些路径的zhanju都恢复0，那判断依据就是cnt_temp
        }
        if(y>0 && board[x][y-1]==temp[cnt] && zhanju[x][y-1]!=1){
            zhanju[x][y-1]=1;
            cnt_temp=recursion(board,temp,x,y-1,word_length,cnt+1,zhanju,hang,lie);
            if(cnt_temp==word_length) return cnt_temp;
            else zhanju[x][y-1]=0;  //如果沿着某条路径最开始走得通，但是后来走不通了，说明要把这些路径的zhanju都恢复0，那判断依据就是cnt_temp
        }
        if(y<lie-1 && board[x][y+1]==temp[cnt] && zhanju[x][y+1]!=1){
            zhanju[x][y+1]=1;
            cnt_temp=recursion(board,temp,x,y+1,word_length,cnt+1,zhanju,hang,lie);
            if(cnt_temp==word_length) return cnt_temp;
            else zhanju[x][y+1]=0;  //如果沿着某条路径最开始走得通，但是后来走不通了，说明要把这些路径的zhanju都恢复0，那判断依据就是cnt_temp
        }
        return cnt_temp;
    }

    /*  跟我的想法一样，但是简略了好多
    static boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if((word.charAt(0) == board[i][j]) && search(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean search(char[][]board, String word, int i, int j, int index){
        if(index == word.length()){
            return true;
        }
        if(i >= board.length || i < 0 || j >= board[i].length || j < 0 || board[i][j] != word.charAt(index) || visited[i][j]){
            return false;
        }
        visited[i][j] = true;
        //这里写的很不错
        if(search(board, word, i-1, j, index+1) ||
           search(board, word, i+1, j, index+1) ||
           search(board, word, i, j-1, index+1) ||
           search(board, word, i, j+1, index+1)){
            return true;
        }
        visited[i][j] = false;
        return false;
    }
     */

    /*  有个超快的，省了存储空间我能想明白，为什么快了呢？因为异或操作比较快？？
    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) {
            return true;
        }
        char[] chs = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(dfs(board, chs, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, char[] words, int idx, int x, int y) {
        if (idx == words.length) {
            return true;
        }
        if (x < 0 || x == board.length || y < 0 || y == board[0].length) {
            return false;
        }
        if (board[x][y] != words[idx]) {
            return false;
        }
        board[x][y] ^= 256; //字符是1bytes，8位，表示范围0-255，或256之后肯定比256大，用这种方式代表访问过了，这样就不需要额外的存储空间放置访问信息
        boolean exist = dfs(board, words, idx + 1, x, y + 1) ||
        dfs(board, words, idx + 1, x, y - 1) || dfs(board, words, idx + 1, x + 1, y) ||
        dfs(board, words, idx + 1, x - 1, y) ;
        board[x][y] ^= 256;
        return exist;
    }
    */

}
