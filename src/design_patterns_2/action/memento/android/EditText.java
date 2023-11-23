package design_patterns_2.action.memento.android;

public class EditText {
    private String text;
    private int start = 0;

    public String getText(){
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getSelectionStart(){
        return start;
    }

    public void setSelection(int index){
        this.start = index;
    }
}
