package interceptorji;

import Zrna.BelezenjeKlicevZrno;
import anotacije.BeleziKlice;

import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
@Interceptor
@BeleziKlice
public class BeleziKliceInterceptor {

    @Inject
    private BelezenjeKlicevZrno belezenjeKlicevZrno;

    @AroundInvoke
    public Object Belezenje(InvocationContext context) throws Exception {
        belezenjeKlicevZrno.zgodilKlic();
        //System.out.println("delam !");
        return context.proceed();
    }
}
