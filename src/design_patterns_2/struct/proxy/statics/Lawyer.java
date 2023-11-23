package design_patterns_2.struct.proxy.statics;

import design_patterns_2.struct.proxy.statics.ILawsuit;

public class Lawyer implements ILawsuit {
    private String mName;
    private ILawsuit mLawsuit;

    public Lawyer(ILawsuit lawsuit,String name){
        mLawsuit = lawsuit;
        this.mName = name;
    }

    @Override
    public String getName() {
        return mName;
    }

    @Override
    public void submit() {
        System.out.println(mName+" 代理发起诉讼");
        mLawsuit.submit();
    }

    @Override
    public void burden() {
        System.out.println(mName+" 代理举证");
        mLawsuit.burden();
    }

    @Override
    public void defend() {
        System.out.println(mName+" 代理辩护");
        mLawsuit.defend();
    }

    @Override
    public void finish() {
        System.out.println(mName+" 代理诉讼结束");
        mLawsuit.finish();
    }
}
