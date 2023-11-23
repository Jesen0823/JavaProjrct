package design_patterns_2.action.memento;

import design_patterns_2.action.memento.android.EditText;

public class NoteEditText extends EditText {

    public Memoto createMemoto(){
        Memoto noteMemoto = new Memoto();
        noteMemoto.text = getText().toString();
        noteMemoto.cursor = getSelectionStart();
        return noteMemoto;
    }

    public void restore(Memoto memoto){
        setText(memoto.text);
        setSelection(memoto.cursor);
    }
}
