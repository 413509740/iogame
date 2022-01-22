package com.iohao.game.collect;

import com.iohao.little.game.action.skeleton.annotation.ActionController;
import com.thoughtworks.qdox.JavaProjectBuilder;
import com.thoughtworks.qdox.model.JavaAnnotation;
import com.thoughtworks.qdox.model.JavaClass;
import com.thoughtworks.qdox.model.JavaMethod;
import lombok.extern.slf4j.Slf4j;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author 洛朱
 * @date 2022-01-22
 */
@Slf4j
public class GameDoc {
    public static void main(String[] args) throws IOException {


        // 创建 java 项目 builder 对象
        JavaProjectBuilder javaProjectBuilder = new JavaProjectBuilder();
        // 添加 java 源文件
//        javaProjectBuilder.addSource(new File("/Users/join/gitme/little-game-sun/game-collect/game-logic-tank/src/main/java/com/iohao/game/collect/tank/action/TankAction.java"));

//        javaProjectBuilder.addClassLoader(GameDoc.class.getClassLoader());
        javaProjectBuilder.addSourceTree(new File("/Users/join/gitme/little-game-sun/game-collect"));

        // 获得解析后的类
        Collection<JavaClass> classes = javaProjectBuilder.getClasses();
        for (JavaClass javaClass : classes) {
            List<JavaAnnotation> javaAnnotations = javaClass.getAnnotations();
//

            javaClass.getLineNumber();

            if (Objects.isNull(javaAnnotations) || javaAnnotations.isEmpty()) {
                continue;
            }

            if (javaClass.getName().equals("TankAction")) {
                log.info("{}", javaClass);
            }

            for (JavaAnnotation javaAnnotation : javaAnnotations) {
                if (javaAnnotation.getType().getName().equals(ActionController.class.getName())) {
                    log.info("{}", javaAnnotation);
                }
            }
//                    .stream()
//                    .filter(javaAnnotation -> ActionController.class.equals(javaAnnotation.getClass()))
//                    .toList();


            // 打印类相关信息
            System.out.println("类名:" + javaClass.getName());
            System.out.println("实现了哪些类：" + javaClass.getImplements());
            System.out.println("继承哪个类：" + javaClass.getSuperJavaClass());
            System.out.println("注释：" + javaClass.getComment());
            // 获得方法列表
            List<JavaMethod> methods = javaClass.getMethods();
            for (JavaMethod method : methods) {
                System.out.println("方法名是：" + method.getName());
                System.out.println("方法的 Tags 有哪些：" + method.getTags().stream().map(it -> it.getName() + "->" + it.getValue()).collect(Collectors.joining("\n")));
                System.out.println("方法的参数有哪些：" + method.getParameters());
                System.out.println("方法的返回值有哪些：" + method.getReturns());
            }
        }
    }
}
