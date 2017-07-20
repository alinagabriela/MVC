package ro.teamnet.zth.appl.controller;

import ro.teamnet.zth.api.annotations.MyController;
import ro.teamnet.zth.api.annotations.MyRequestMethod;

/**
 * Created by Alina.Petrescu on 7/20/2017.
 */
@MyController(urlPath = "/departments")
public class DepartmentController {

    @MyRequestMethod(methodType = "GET", urlPath = "/all")
    public String getAllDepartments() {
        return "allDepartments";
    }

    @MyRequestMethod(methodType = "GET", urlPath = "/one")
    public String getOneDepartment() {
        return "oneDepartment";
    }
}
