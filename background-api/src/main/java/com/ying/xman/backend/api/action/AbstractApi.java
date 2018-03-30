package com.ying.xman.backend.api.action;

import com.ying.xman.backend.api.framework.Api;
import com.ying.xman.backend.api.framework.ApiInfo;
import com.ying.xman.backend.api.framework.ApiRequest;
import com.ying.xman.backend.api.request.AbstractApiRequest;
import com.ying.xman.backend.api.response.ApiResult;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * Created by yingsy on 2018/3/28.
 */
public abstract class AbstractApi<N extends AbstractApiRequest, M extends ApiResult> implements Api<N,M> {

    @Override
    public ApiInfo getApiInfo() {
        return this.getClass().getAnnotation(ApiInfo.class);
    }

    //TODO
//    public Class<N> getRequestType(){
//        Type superClass = getGenericSuperclassWithRequestType(this.getClass());
//        Type[] typeArgs = ((ParameterizedType) superClass).getActualTypeArguments();
//        return (Class<N>) typeArgs[0];
//    }

    //TODO
//    private static Type getGenericSuperclassWithRequestType(Class<?> clazz) {
//        Type superClass = clazz.getGenericSuperclass();
//        if (superClass instanceof ParameterizedType) {
//            Type[] types = ((ParameterizedType) superClass).getActualTypeArguments();
//            if (types != null && types.length > 0) {
//                for (Type type : types) {
//                    if (type instanceof Class) {
//                        ApiRequest.class.isAssignableFrom((Class<?>) type);
//                        return superClass;
//                    }
//                }
//
//                return superClass;
//            }
//        }
//        return getGenericSuperclassWithRequestType(clazz.getSuperclass());
//    }
}
