package interceptorji;

import Uprava.NakupovalniSeznamDto;

import javax.interceptor.AroundInvoke;
import javax.interceptor.InvocationContext;
import java.util.logging.Logger;

public class ValidirajNakupovalniSeznamDtoInterceptor {

    Logger log = Logger.getLogger(ValidirajNakupovalniSeznamDtoInterceptor.class.getName());

    @AroundInvoke
    public Object validirajNakupovalniSeznam(InvocationContext context) throws Exception {

        if(context.getParameters().length == 1 && context.getParameters()[0] instanceof NakupovalniSeznamDto){
            NakupovalniSeznamDto seznam= (NakupovalniSeznamDto) context.getParameters()[0];

            if(seznam.getNaziv()== null || seznam.getNaziv().isEmpty()){
                String msg = "Seznam ne vsebuje obveznih podatkov !!";
                log.severe(msg);
                //throw new NeveljavenNakupovalnISeznamDtoIzjema(msg);
            }
        }
        return context.proceed();

    }

}
