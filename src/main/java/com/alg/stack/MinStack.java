package main.java.com.alg.stack;

import java.util.Stack;

/**
 * 题目描述：实现一个堆栈，能够pop、push、getMin
 * 时间复杂度要求O(1)
 */
public class MinStack {

	public static void main(String[] args) {
		MinStack_01 ms01 = new MinStack_01();
		ms01.push(1).push(2).push(3).push(4).push(5).push(6);
		while (ms01.isNotEmpty()) {
			System.out.println("min : " + ms01.getMin());
			System.out.println("pop : " + ms01.pop());
		}
	}
}

/**
 * 使用两个栈来实现getMin操作，main保存全部数据，slave保存最小数据
 * 1. pop操作：栈不为空，则两个栈都弹出，值取main栈；栈空则提示
 * 2. push操作：如果栈为空，直接插入两个栈；如果不为空，则比较栈顶元素，若比栈顶元素小，则直接插入栈，若比栈顶元素大，则再插入一遍栈顶元素
 * 3. getMin：栈空提示，不空返回slave顶端元素
 */
class MinStack_01 {
	private final Stack<Integer> mainStack;
	private final Stack<Integer> slaveStack;

	MinStack_01() {
		this.mainStack = new Stack<>();
		this.slaveStack = new Stack<>();
	}

	public Integer pop() {
		if (mainStack.isEmpty()) {
			throw new RuntimeException("栈为空！");
		}
		slaveStack.pop();
		return mainStack.pop();
	}

	public MinStack_01 push(Integer item) {
		mainStack.push(item);
		if (slaveStack.isEmpty() || item <= slaveStack.peek()) {
			slaveStack.push(item);
		} else {
			slaveStack.push(slaveStack.peek());
		}
		return this;
	}

	public Integer getMin() {
		if (slaveStack.isEmpty()) {
			throw new RuntimeException("栈为空！");
		}
		return slaveStack.peek();
	}

	public boolean isNotEmpty() {
		return !mainStack.isEmpty();
	}

}
