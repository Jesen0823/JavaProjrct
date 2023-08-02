package design_patterns_2.create.builder.jv;
/**
 * 建造者模式
 * */
public class PaintJv {
    private Builder builder;

    private PaintJv(Builder builder){
        this.builder = builder;
    }
    public void draw(){
        System.out.println(builder.color+"色的，粗细为"+builder.stroke+"px, 是否带圆角？"+builder.round);
    }

    public static class Builder{
        private String color = "red";
        private float stroke = 1.f;
        private boolean round = false;

        public Builder color(String color){
            this.color = color;
            return this;
        }
        public Builder stroke(float stroke){
            this.stroke = stroke;
            return this;
        }
        public Builder round(boolean round){
            this.round = round;
            return this;
        }
        public PaintJv build(){
            return new PaintJv(this);
        }
    }

    public static void main(String[] args) {
        PaintJv paint = new Builder().round(false).stroke(2f).color("绿").build();
        paint.draw();
    }
}
