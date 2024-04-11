package com.metamorph.spring.mysampleapp.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect     // optional: if only have pointcuts
public class AOPDeclarations {

    @Pointcut("execution(* com.metamorph.spring.mysampleapp.dao.*.*(..))")
    public void forDaoPackage() {}

    // create a pointcut for getter methods
    @Pointcut("execution(* com.metamorph.spring.mysampleapp.dao.*.get*(..))")
    public void getter() {}

    // create a pointcut for setter methods
    @Pointcut("execution(* com.metamorph.spring.mysampleapp.dao.*.set*(..))")
    public void setter() {}

    // create a pointcut for setter methods
    @Pointcut("execution(* com.metamorph.spring.mysampleapp.dao.*.find*(..))")
    public void forFindMethods() {}

    // create pointcut: include package ... exclude getter/setter methods
    @Pointcut("forDaoPackage() && !(getter() || setter())")
    public void forDaoPackageNoGetterSetter() {}

    // create pointcut: include package ... exclude find methods
    @Pointcut("forDaoPackage() && !forFindMethods()")
    public void forDaoPackageNoFind() {}

    @Pointcut("execution(* com.metamorph.spring.mysampleapp.dao.*.save(..)))")
    public void forSaveMethod() {}

}
