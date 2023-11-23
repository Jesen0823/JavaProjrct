package design_patterns_2.action.memento;
/**
 * 备忘录模式
 * （1）需要保存一个对象在某一个时刻的状态或部分状态。
 * （2)如果用一个接口来让其他对象得到这些状态，将会暴露对象的实现细节并破坏对象的封装
 * 性，一个对象不希望外界直接访问其内部状态，通过中间对象可以间接访问其内部状态。
 *
 * 在Android开发中,状态模式应用是Activity中的状态保存,也就是里面的onSaveInstanceState
 * 和onRestorelnstanceState。
 *
 * 备忘录模式是在不破坏封装的条件下，通过备忘录对象（Memoto）存储另外一个对象内部状态的快照，在将来合适的时候把这个对象还原到存储起来的状态。
 */
public class MementoTest {

    public static void main(String[] args) {
        NoteManager manager = new NoteManager();

        // 模拟输入：
        NoteEditText editText = new NoteEditText();
        editText.setText("hello");

        System.out.println("初始："+editText.getText());
        // 保存
        manager.saveMemoto(editText.createMemoto());
        // 重新编辑
        editText.setText("world");
        manager.saveMemoto(editText.createMemoto());
        // 重新编辑
        editText.setText("2008");
        manager.saveMemoto(editText.createMemoto());
        System.out.println("修改为，world，2008，且已经保存。这时候："+editText.getText());
        // 撤销
        editText.restore(manager.getPreMemoto());
        System.out.println("撤销后："+editText.getText());
        // 恢复
        editText.restore(manager.getNextMemoto());
        System.out.println("恢复后："+editText.getText());
    }
}
