package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        printStartLine(req);
        printHeaders(req);
        printHeaderUtils(req);
        printEtc(req);

        resp.getWriter().write("OK");
    }

    private void printEtc(HttpServletRequest req) {
        System.out.println("---- 기타 조회 start ----");
        System.out.println("[Remote 정보]");
        System.out.println("request.getRemoteHost()="+req.getRemoteHost());
        System.out.println("request.getRemoteAddr()="+req.getRemoteAddr());
        System.out.println("request.getRemotePort()="+req.getRemotePort());
        System.out.println();

        System.out.println("[Local 젇보]");
        System.out.println("request.getLocalName()="+req.getLocalName());
        System.out.println("request.getLocalAddr()="+req.getLocalAddr());
        System.out.println("request.getLocalPort()="+req.getLocalPort());

        System.out.println("---- 기타 조회 end ----");
    }

    private void printHeaderUtils(HttpServletRequest req) {
        System.out.println("---- Header 편의 조희 start ----");
        System.out.println("[Host 편의 조회]");
        System.out.println("request.getServerName()="+req.getServerName());
        System.out.println("request.getServerPort()="+req.getServerPort());
        System.out.println();

        System.out.println("[Accept-Language 편의 조회]");
        req.getLocales().asIterator()
                .forEachRemaining(local ->
                        System.out.println("local="+local));
        System.out.println("request.getLocal()"+req.getLocale());
        System.out.println();

        System.out.println("[cookie 편의 조회]");
        if (req.getCookies() != null) {
            for (Cookie cookie : req.getCookies()) {
                System.out.println(cookie.getName()+":"+cookie.getValue());
            }
        }
        System.out.println();

        System.out.println("[Content 편의 조희]");
        System.out.println("request.getContentType()="+req
                .getContentType());
        System.out.println("request.getContentLength()="+req.getContentLength());
        System.out.println("request.getCharacterEncoding()"+req.getCharacterEncoding());

        System.out.println("---- Header 편의 조희 end ----");
        System.out.println();
    }

    private void printHeaders(HttpServletRequest req) {
        System.out.println("--- Headers - start ----");

        req.getHeaderNames().asIterator()
                .forEachRemaining(headerName -> System.out.println(headerName + " "
                        + req.getHeader(headerName)));
        System.out.println("--- Headers -- end ----");
        System.out.println();
    }

    private void printStartLine(HttpServletRequest req) {
        System.out.println("---- REQUEST-LINE - start ----");

        System.out.println("request.getMethod()="+req.getMethod());
        System.out.println("request.getProtocol()="+req.getProtocol());
        System.out.println("request.getScheme()="+req.getScheme());
        System.out.println("request.getRequestURL()="+req.getRequestURL());
        System.out.println("request.getRequestURI()="+req.getRequestURI());
        System.out.println("request.getQueryString()="+req.getQueryString());
        System.out.println("request.isSecure()="+req.isSecure());
        System.out.println("---- REQUEST-LINE - END ----");
        System.out.println();
    }
}
