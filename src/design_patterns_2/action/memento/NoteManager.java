package design_patterns_2.action.memento;

import java.util.ArrayList;
import java.util.List;

public class NoteManager {

    private static final int MAX = 30;

    List<Memoto> memotos = new ArrayList<Memoto>(MAX);
    int mIndex = 0;

    public void saveMemoto(Memoto memoto) {
        if (memotos.size() > MAX) {
            memotos.remove(0);
        }
        memotos.add(memoto);
        mIndex = memotos.size() - 1;
    }

    public Memoto getPreMemoto() {
        mIndex = mIndex > 0 ? --mIndex : mIndex;
        return memotos.get(mIndex);
    }

    public Memoto getNextMemoto() {
        mIndex = mIndex < memotos.size() - 1 ? ++mIndex : mIndex;
        return memotos.get(mIndex);
    }
}
