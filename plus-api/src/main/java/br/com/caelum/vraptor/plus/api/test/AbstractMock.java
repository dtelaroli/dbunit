package br.com.caelum.vraptor.plus.api.test;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import br.com.caelum.vraptor.proxy.JavassistProxifier;
import br.com.caelum.vraptor.proxy.MethodInvocation;
import br.com.caelum.vraptor.proxy.Proxifier;
import br.com.caelum.vraptor.proxy.SuperMethod;

public abstract class AbstractMock {

	private final Proxifier proxifier;

	public AbstractMock() {
		this(new JavassistProxifier());
	}

	public AbstractMock(Proxifier proxifier) {
		this.proxifier = proxifier;
	}
	
	protected Proxifier getProxifier() {
		return proxifier;
	}
	
	protected <T> MethodInvocation<T> returnOnFinalMethods(final Class<T> database) {
		return new MethodInvocation<T>() {
			@SuppressWarnings({ "rawtypes", "unchecked" })
			@Override
			public Object intercept(T proxy, Method method, Object[] args, SuperMethod superMethod) {
				Class type = method.getReturnType();
				if (type == void.class || Modifier.isFinal(type.getModifiers())) {
					return null;
				}

				if (database.isAssignableFrom(type)) {
					return proxy;
				}

				if (args.length > 0 && args[0].equals(database)) {
					return proxifier.proxify((Class) args[0], returnOnFinalMethods(database));
				}
				return proxifier.proxify(type, returnOnFirstInvocation());
			}
		};
	}
	
	private <T> MethodInvocation<T> returnOnFirstInvocation() {
		return new MethodInvocation<T>() {
			@Override
			public Object intercept(Object proxy, Method method, Object[] args, SuperMethod superMethod) {
				return null;
			}
		};
	}
	
}
