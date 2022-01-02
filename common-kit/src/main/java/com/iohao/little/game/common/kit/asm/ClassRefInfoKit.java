package com.iohao.little.game.common.kit.asm;

import com.esotericsoftware.reflectasm.ConstructorAccess;
import com.esotericsoftware.reflectasm.MethodAccess;
import lombok.experimental.UtilityClass;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 类信息工具
 * <pre>
 *     包含了反射等信息
 * </pre>
 *
 * @author 洛朱
 * @date 2022-01-02
 */
@UtilityClass
public class ClassRefInfoKit {
    /**
     * key: 类信息
     * value: 类反射信息
     */
    private final Map<Class<?>, ClassRefInfo> classRefInfoMap = new ConcurrentHashMap<>();

    /**
     * 获取类信息
     *
     * @param clazz class
     * @return 类信息
     */
    public ClassRefInfo getClassRefInfo(Class<?> clazz) {
        ClassRefInfo classRefInfo = classRefInfoMap.get(clazz);

        if (Objects.isNull(classRefInfo)) {
            classRefInfo = createClassRefInfo(clazz);
            classRefInfoMap.putIfAbsent(clazz, classRefInfo);
        }

        return classRefInfo;
    }

    /**
     * 创建类的反射信息
     *
     * @param clazz 类信息
     * @return 类反射信息
     */
    private ClassRefInfo createClassRefInfo(Class<?> clazz) {
        // 构造函数访问器
        ConstructorAccess<?> constructorAccess = ConstructorAccess.get(clazz);
        // 方法访问器
        MethodAccess methodAccess = MethodAccess.get(clazz);

        return ClassRefInfo.newBuilder()
                .setClazz(clazz)
                .setConstructorAccess(constructorAccess)
                .setMethodAccess(methodAccess)
                .build();
    }
}