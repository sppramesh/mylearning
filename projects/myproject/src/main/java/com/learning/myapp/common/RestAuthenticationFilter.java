package com.learning.myapp.common;



import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.jersey.core.util.Base64;


/**
 * Authentication and Authorization filter for Phoenix's REST services
 * Date: 8/6/12
 *
 * @author jjacobs
 */

public class RestAuthenticationFilter implements Filter {

    public void sendResponseNeedsAuth(ServletResponse response) {
        try {
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            httpResponse.setHeader("WWW-Authenticate", "Basic realm=\"Phoenix\"");
            httpResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    

   
    
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        
        String authUsername = null;
        String authPassword = null;
        String authHttpMethod = null;
        Boolean isAuthenticated = false;
        String authUserId = null;

        HttpServletRequest httpRequest = null;

        try {
            httpRequest = (HttpServletRequest) request;
            authHttpMethod = httpRequest.getMethod();
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        //Check for GET Request shortcut (determine if auth is required)
        if (authHttpMethod.equals("GET")) {
            chain.doFilter(request, response);
            return;
        }

        
        // Retrieve the authentication credentials from the HTTP Basic Auth Header
        try {
            String httpAuthHeader = httpRequest.getHeader("authorization");
            if (httpAuthHeader != null && httpAuthHeader.startsWith("Basic ")) {
                String decoded = Base64.base64Decode(httpAuthHeader.substring(6));
                System.out.println("httpAuthHeader : "+httpAuthHeader);
                System.out.println("httpAuthHeader.substring(6):  "+httpAuthHeader.substring(6));
                System.out.println("decoded :  "+decoded);
                if (decoded.contains(":")) {
                    String[] credentials = decoded.split(":");
                    if (credentials.length == 2) {
                        authUsername = credentials[0];
                        authPassword = credentials[1];
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }

        if(authUsername!=null&& authUsername.equalsIgnoreCase("rest")&&authPassword!=null&&authPassword.equalsIgnoreCase("rest")){
        	System.out.println("<<<<< Valide Authentication >>>>>> ");
        	chain.doFilter(request, response);
        }else{
        	sendResponseNeedsAuth(response);
            return;
        }
       
    }

	public void destroy() {
		// TODO Auto-generated method stub
		
	}




	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

}
