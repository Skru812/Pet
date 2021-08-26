package io.jmix.petclinic.app.authentication;

import com.vaadin.server.VaadinServletRequest;
import io.jmix.core.security.ClientDetails;
import io.jmix.security.model.SecurityScope;
import io.jmix.securityui.authentication.LoginScreenSupport;
import org.jetbrains.annotations.Nullable;
import org.springframework.context.annotation.Primary;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Locale;
import java.util.TimeZone;

// TODO: remove after https://github.com/Haulmont/jmix-security/issues/103 is fixed
@Primary
@Component("petclinic_LoginScreenSupport")
public class PetclinicLoginScreenSupport extends LoginScreenSupport {

    @Override
    protected Authentication createAuthenticationToken(String username, String password, @Nullable Locale locale, @Nullable TimeZone timeZone) {
        UsernamePasswordAuthenticationToken authenticationToken =
                new UsernamePasswordAuthenticationToken(username, password);
        VaadinServletRequest request = VaadinServletRequest.getCurrent();

        ClientDetails clientDetails = ClientDetails.builder()
                .locale(locale != null ? locale : getDefaultLocale())
                .scope(SecurityScope.UI)
                .sessionId(request.getSession().getId())
                .timeZone(timeZone == null ? getDeviceTimeZone() : timeZone)
                .build();

        authenticationToken.setDetails(clientDetails);

        return authenticationToken;
    }
}
