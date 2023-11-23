package design_patterns_2.struct.templatemethod;

import design_patterns_2.struct.templatemethod.util.BitmapRequest;

public interface Loader {
    public void loadImage(BitmapRequest request);
}
