package ru.web.app.controller;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import ru.web.app.logic.GenLogic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet("/generate")
public class GenerateServlet extends HttpServlet {
    private JSONParser parser = new JSONParser();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<String> resParams = Arrays.asList(req.getParameter("resParams").trim().split(";"));
        List<String> fieldNames = null;
        List<String> fieldTypes = null;
        List<String> fieldPrecisions = null;
        List<String> fieldPK = null;
        String tableName = req.getParameter("tableName").trim();

        try {
            JSONArray tmpFieldNames = (JSONArray) parser.parse(req.getParameter("fieldNames").trim());
            JSONArray tmpFieldTypes = (JSONArray) parser.parse(req.getParameter("fieldTypes").trim());
            JSONArray tmpFieldPrecisions = (JSONArray) parser.parse(req.getParameter("fieldPrecisions").trim());
            JSONArray tmpFieldPK = (JSONArray) parser.parse(req.getParameter("fieldPK").trim());

            fieldNames = (List<String>) tmpFieldNames.clone();
            fieldTypes = (List<String>) tmpFieldTypes.clone();
            fieldPrecisions = (List<String>) tmpFieldPrecisions.clone();
            fieldPK = (List<String>) tmpFieldPK.clone();

        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println(tableName);

        GenLogic logic = new GenLogic(resParams, fieldNames, fieldTypes, fieldPrecisions, fieldPK, tableName);
    }
}
