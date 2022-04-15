package java_design_patterns.facade;

/**
 * 外观模式/门面模式
 * <p>
 * 构建一个有层次结构的子系统时，使用外观模式定义子系统中每层的入口点。如果子系统之间是相互依赖的，则可以让其通过外观接口进行通信，减少子系统之间的依赖关系。
 * 子系统往往会因为不断地重构演化而变得越来越复杂，大多数的模式使用时也会产生很多很小的类，这给外部调用它们的用户程序带来了使用上的困难。我们可以使用外观类提供一个简单的接口，对外隐藏子系统的具体实现并隔离变化。
 * <p>
 * 当维护一个遗留的大型系统时，可能这个系统已经非常难以维护和拓展；但因为它含有重要的功能，所以新的需求必须依赖于它，这时可以使用外观类，为设计粗糙或者复杂的遗留代码提供一个简单的接口，让新系统和外观类交互，而外观类负责与遗留的代码进行交互。
 * <p>
 * ・优点：
 * 减少系统的相互依赖，所有的依赖都是对外观类的依赖，与子系统无关。
 * <p>
 * 对用户隐藏了子系统的具体实现，减少用户对子系统的耦合。这样即使具体的子系统发生了变化，用户也不会感知到。
 * <p>
 * 加强了安全性，子系统中的方法如果不在外观类中开通，就无法访问到子系统中的方法。
 * <p>
 * ·缺点：不符合开放封闭原则。如果业务出现变更，则可能要直接修改外观类。
 */
public class TestFacade {

    public static void main(String[] args) {
        AppFun fun = new AppFun();

        System.out.println("----------------------");
        // 播放订购片源
        fun.playBuyVideo();

        System.out.println("----------------------");
        // 播放音乐
        fun.playMusic();

        System.out.println("----------------------");
        // 播放腾讯会员片
        fun.playTencentVideo();
    }
}