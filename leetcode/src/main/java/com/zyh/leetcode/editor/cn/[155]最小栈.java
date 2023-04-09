import java.util.Stack;

//leetcode submit region begin(Prohibit modification and deletion)
class MinStack {
    private Stack<Integer> stack;
    private Stack<Integer> minStack;//栈顶永远只保留最小的元素

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        //栈顶永远为最新的最小的元素
        if (minStack.empty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }

    public void pop() {
        int pop = stack.pop();
        //当出栈的元素为最小元素是，最小栈也得出栈
        if (pop == minStack.peek()) {
            minStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
//leetcode submit region end(Prohibit modification and deletion)
