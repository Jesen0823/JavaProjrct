package datastruct.linklist;

/**
 * 单链表节点
 */
public class SingleNode<T> {

        public SingleNode<T> next;
        public T data;

        public SingleNode(T data) {
            this.data = data;
        }

        public T getNextNodeData() {
            return next != null ? next.data : null;
        }

}
