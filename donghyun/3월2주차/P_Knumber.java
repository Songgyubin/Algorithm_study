import java.util.Arrays;

class Knumber {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = {};
        answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            int[] temp = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2] - 1];
        }
        return answer;
    }
    /*
     * import java.util.Arrays;
     * class Solution {
     * public int[] solution(int[] array, int[][] commands) {
     * int[] answer = new int[commands.length];
     * int a = 0;
     * for(int[] info : commands){
     * int i = info[0];
     * int j = info[1];
     * int k = info[2];
     * 
     * int[] buf = Arrays.copyOfRange(array,i-1,j);
     * Arrays.sort(buf);
     * answer[a] = buf[k-1];
     * a++;
     * }
     * 
     * return answer;
     * }
     * }
     */
}