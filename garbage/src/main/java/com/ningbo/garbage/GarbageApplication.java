package com.ningbo.garbage;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.HashMap;

@SpringBootApplication
@ComponentScan(basePackages = "com.ningbo.garbage")
public class GarbageApplication {
    public static HashMap<String, String> BASIC_CLASSIFICATION = new HashMap<String, String>() {
        {
            this.put("厨余垃圾", "厨房生活垃圾，主要包括剩饭剩菜与西餐糕点等食物残余、菜梗、菜叶、动物骨骼内脏、茶叶渣、水果残余、果壳瓜皮、盆景等植物的材质落叶、废弃食用油等。");
            this.put("可回收垃圾", "是指讲过加工可以成为生产原料或者经过整理可以再利用的物品，主要包括纸类、金属、玻璃、除塑料袋外的塑料制品、橡胶及橡胶制品、牛奶盒等利乐包装、饮料瓶等。");
            this.put("有害垃圾", "指对人体健康或者自然环境造成直接或者潜在危害的垃圾。主要包括单位办公区域产生的废旧电子产品、废旧打印机墨盒、硒鼓等危险物品");
            this.put("其他垃圾", "主要包括受污染与无法再生的纸张、不可回收的玻璃、塑料袋与其他受污染的塑料制品、废旧衣物与其他纺织品、破旧陶瓷制品、妇女卫生用品、一次性餐具、贝壳、烟头、灰土等。");
        }
    };

    public static void main(String[] args) {
        SpringApplication.run(GarbageApplication.class, args);
    }
}
