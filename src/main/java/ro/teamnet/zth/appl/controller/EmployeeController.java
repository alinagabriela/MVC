package ro.teamnet.zth.appl.controller;

import ro.teamnet.zth.api.annotations.MyController;
import ro.teamnet.zth.api.annotations.MyRequestMethod;

/**
 * Created by Alina.Petrescu on 7/20/2017.
 */
@MyController(urlPath = "/employees")
public class EmployeeController {

    @MyRequestMethod(urlPath = "/employees/all", methodType = "GET")
    public String getAllEmployees() {
        return "allEmployees";
    }
}
