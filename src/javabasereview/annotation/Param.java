package javabasereview.annotation;

enum  Param {
  /*  HD,
    BLUE_REY,
    REY_4K,
    HDR;*/
    HD("高清"),BLUE_REY("蓝光"),REY_4K("4k"),HDR("HDR");
    private String name;

    Param(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
