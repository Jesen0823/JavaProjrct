package zuoshensuanfa.bulong;

/**
 * 布隆过滤器
 * 使用条件：
 * ① 只读行为，类似查黑名单白名单
 * ② 允许一定的失误率P,与总样本量n无关
 *  布隆过滤器所需要空间 m = -(n*㏑P)/(㏑2)²
 *  所需哈希函数的个数 k = ㏑2 * m/n ≈ 0.7*m/n向上取整
 * ③ 如果提供的实际空间 > 理论空间m,则实际失误率会减小
 * */
public class BuLongFilter {


}
