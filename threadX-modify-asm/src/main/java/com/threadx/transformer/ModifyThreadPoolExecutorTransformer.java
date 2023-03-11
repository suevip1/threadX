package com.threadx.transformer;

import com.threadx.visit.ModifyThreadPoolExecutorClassVisitor;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;

import java.lang.instrument.ClassFileTransformer;
import java.security.ProtectionDomain;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 待修改的线程池的变换操作
 *
 * @author huangfukexing
 * @date 2023/3/9 10:30
 */
public class ModifyThreadPoolExecutorTransformer implements ClassFileTransformer {
    private static final String THREAD_POOL_NAME = ThreadPoolExecutor.class.getName().replace(".", "/");

    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) {
        try {
            if (THREAD_POOL_NAME.equals(className)) {
                System.out.println("modify " + className);
                //创建一个字节码读取器
                ClassReader cr = new ClassReader(classfileBuffer);
                // 创建一个字节码写出器
                ClassWriter cw = new ClassWriter(ClassWriter.COMPUTE_MAXS | ClassWriter.COMPUTE_FRAMES);
                //将写出器委托给类修改器，以便与类修改器将类修改完毕之后，将修改后的字节码字节写入到这个写出器缓冲
                ModifyThreadPoolExecutorClassVisitor mcv = new ModifyThreadPoolExecutorClassVisitor(cw);
                System.out.println("start visit: " + className);
                //委托入口，读取器将读取到的字节码，委托给类修改器
                cr.accept(mcv, ClassReader.EXPAND_FRAMES);
                //将类修改器修改后写入写出器缓冲区的字节写出去
                return cw.toByteArray();
            }
        } catch (Throwable w) {
            w.printStackTrace();
            System.out.println(w.getMessage());
            throw new RuntimeException(w);
        }

        return classfileBuffer;
    }
}
