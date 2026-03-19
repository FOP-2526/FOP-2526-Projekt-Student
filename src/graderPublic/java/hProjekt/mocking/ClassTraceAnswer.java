package hProjekt.mocking;

import java.lang.reflect.Method;
import java.util.function.Predicate;

import org.apache.commons.lang3.function.TriConsumer;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

public class ClassTraceAnswer implements Answer<Object> {

    private Object originalLambda;
    private Predicate<Method> methodFilter;
    private TriConsumer<Object, Method, Invocation> methodCallConsumer;

    public ClassTraceAnswer(Object originalLambda, Predicate<Method> methodFilter,
            TriConsumer<Object, Method, Invocation> methodCallConsumer) {
        this.originalLambda = originalLambda;
        this.methodFilter = methodFilter;
        this.methodCallConsumer = methodCallConsumer;
    }

    @Override
    public Object answer(InvocationOnMock invocationOnMock) throws Throwable {
        Method calledMethod = invocationOnMock.getMethod();

        Object returnValue;
        if (ReflectionUtilsP.isLambda(invocationOnMock.getMock().getClass())) {
            returnValue = calledMethod.invoke(originalLambda, invocationOnMock.getArguments());
        } else {
            returnValue = invocationOnMock.callRealMethod();
        }

        if (methodFilter.test(calledMethod)) {
            return returnValue;
        }
        methodCallConsumer.accept(invocationOnMock.getMock(),
                calledMethod,
                new Invocation(invocationOnMock.getArguments(), returnValue));

        return returnValue;
    }
}
