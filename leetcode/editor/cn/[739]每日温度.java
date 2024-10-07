package editor.cn;

import java.util.LinkedList;

class Solution739{
    public static void main(String[] args) {
        Solution solution = new Solution739().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        //单调栈法
        return stack(temperatures);
        ////递归法(无返回值)
        //int n=temperatures.length;
        //int[] res = new int[n];
        //dfsVoid(temperatures,0,res);
        //
        ////递归法(有返回值)
        //dfsIntArray(temperatures,0,res);
        //return res;
    }


        private void dfsVoid(int[] temperatures, int start, int[] res) {
            if (start == temperatures.length) return;
            for (int i = start + 1; i < temperatures.length; i++) {
                if (temperatures[i] > temperatures[start]) {
                    res[start] = i - start;
                    break;
                }
            }
            dfsVoid(temperatures, start + 1, res);
        }


        private int[] dfsIntArray(int[] temperatures, int stast,int[] res) {
            if (stast==temperatures.length)return null;
            //递归就两个点，递归的填充res
            for (int i = stast; i <temperatures.length; i++) {
                if (temperatures[i]>temperatures[stast]){
                    res[stast]=i-stast;
                    break;
                }
            }
           return dfsIntArray(temperatures,stast+1,res);
        }


        private int[] stack(int[] temperatures) {
            int n=temperatures.length;
            int[] res = new int[n];
            LinkedList<Integer> integerStack = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                while (!integerStack.isEmpty()&&temperatures[integerStack.peek()]<temperatures[i]){
                    res[integerStack.peek()]=-integerStack.peek()+i;
                    integerStack.pop();
                }
                integerStack.push(i);
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}












