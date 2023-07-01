package StackAndQueneClass;

import java.util.ArrayDeque;

/**
 * @author lzz
 * @version 1.0
 * @description: TODO
 * @date 2020/9/12 14:22
 */
public class TwoQueueImplementStack<T> {

    private ArrayDeque<T> queueOne = new ArrayDeque<>();
    private ArrayDeque<T> queueTwo = new ArrayDeque<>();

    private void push(T t) {
        queueOne.offer(t);
    }

    private T pop() {
        if (!queueOne.isEmpty() || !queueTwo.isEmpty()) {
            if (!queueOne.isEmpty()) {
                while (queueOne.size() > 1) {
                    queueTwo.offer(queueOne.poll());
                }
                return queueOne.poll();
            } else if (!queueTwo.isEmpty()) {
                while (queueTwo.size() > 1) {
                    queueOne.offer(queueTwo.poll());
                }
                return queueTwo.poll();
            }

        }
        return null;
    }

    private T top() {
        T top = null;
        if (!isEmpty()) {
            if (!queueOne.isEmpty()) {
                while (queueOne.size() > 1) {
                    queueTwo.offer(queueOne.poll());
                }
                top = queueOne.peek();
                queueTwo.offer(queueOne.poll());
            } else if (!queueTwo.isEmpty()) {
                while (queueTwo.size() > 1) {
                    queueOne.offer(queueTwo.poll());
                }
                top = queueTwo.peek();
                queueOne.offer(queueTwo.poll());
            }
            return top;

        }
        return null;
    }

    private boolean isEmpty() {
        return queueOne.isEmpty() && queueTwo.isEmpty();
    }


}
