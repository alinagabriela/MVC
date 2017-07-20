package ro.teamnet.zth.web;

import ro.teamnet.zth.api.annotations.MyController;
import ro.teamnet.zth.api.annotations.MyRequestMethod;
import ro.teamnet.zth.appl.controller.DepartmentController;
import ro.teamnet.zth.appl.controller.EmployeeController;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Alina.Petrescu on 7/20/2017.
 */
public class MyDispatcherServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //resp.getWriter().write("fds");
        dispatchReply(req, resp, "GET");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    private void dispatchReply(HttpServletRequest req, HttpServletResponse resp, String type) throws ServletException, IOException {
        try {
            Object resultToDispatch = dispatch(req);
            reply(resp, resultToDispatch);
        } catch (Exception e ){
            sendExceptionError();
        }
    }

    private void sendExceptionError() {
    }

    private Object dispatch (HttpServletRequest req) {
        EmployeeController employeeController = new EmployeeController();
        DepartmentController departmentController = new DepartmentController();

        MyController myController = req.getClass().getDeclaredAnnotation(MyController.class);

        String val = "";
        if (req.getRequestURI().contains("mvc/employees")) {
            val += employeeController.getAllEmployees();
            //val += employeeController.getClass().getDeclaredAnnotation(MyRequestMethod.class);
        } else {
            if (req.getRequestURI().contains("mvc/departments")) {
                val += departmentController.getAllDepartments();
            }
        }
        return val;

    }

    private void reply (HttpServletResponse resp, Object result) {
        try {
            System.out.println((String) result);
            resp.getWriter().write((String)result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
