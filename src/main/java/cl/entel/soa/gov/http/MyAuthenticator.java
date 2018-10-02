package cl.entel.soa.gov.http;

import java.net.Authenticator;
import java.net.InetAddress;
import java.net.PasswordAuthentication;

public class MyAuthenticator extends Authenticator {

    private final PasswordAuthentication authentication;

    public MyAuthenticator() {
        String userName = "MURTADO";
        String password = "Carajo2.0";
        authentication = new PasswordAuthentication(userName, password.toCharArray());
    }

    protected PasswordAuthentication getPasswordAuthentication() {
        return authentication;
    }
}